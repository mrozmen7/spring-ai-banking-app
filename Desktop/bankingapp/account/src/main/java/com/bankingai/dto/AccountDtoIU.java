package com.bankingai.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDtoIU {
    private String customerName;
    private String accountNumber;
    private String accountType;
    private String currency;
    private BigDecimal balance;
    private boolean active;
}


// Kullanicidan alinan degerler