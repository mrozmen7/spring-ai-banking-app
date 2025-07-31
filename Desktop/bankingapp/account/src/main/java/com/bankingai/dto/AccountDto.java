package com.bankingai.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor

@AllArgsConstructor
public class AccountDto {

    private Long id;
    private String customerName;
    private String accountNumber;
    private String accountType;
    private BigDecimal balance;
    private String currency;
    private LocalDateTime createdAt;
    private boolean active;

    private Long customerId; // sadece ID tutulu
;

}

// kullaniciya verilen degerler