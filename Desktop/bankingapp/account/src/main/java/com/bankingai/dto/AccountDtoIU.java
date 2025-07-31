package com.bankingai.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDtoIU {

    @NotBlank
    private String customerName;

    @NotBlank
    private String accountNumber;

    private String accountType;

    private BigDecimal balance;

    private String currency;

    private boolean active;

    @NotNull
    private Long customerId; // kullanıcıdan ID alıyoruz
}


// Kullanicidan alinan degerler