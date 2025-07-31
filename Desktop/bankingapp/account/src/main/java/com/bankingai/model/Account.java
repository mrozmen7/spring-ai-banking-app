package com.bankingai.model;

import com.bankingai.core.customer.Customer;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "account_number", nullable = false, unique = true)
    private String accountNumber;

    @Column(name = "account_type")
    private String accountType;

    private BigDecimal balance;

    private String currency;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "is_active")
    private boolean active;

    @Column(name = "customer_id", nullable = false)
    private Long customerId; // FOREIGN KEY DEĞİL — sadece ID bilgisi


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + customerName + '\'' +
                ", department=" + customerId +
                '}';
    }
}