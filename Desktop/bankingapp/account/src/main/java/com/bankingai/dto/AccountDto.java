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
    private String accountNumber;
    private String accountType;
    private BigDecimal balance;
    private LocalDateTime createdAt;
}

// kullaniciya verilen degerler