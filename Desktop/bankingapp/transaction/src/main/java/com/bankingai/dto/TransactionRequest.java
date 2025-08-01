package com.bankingai.dto;

import com.bankingai.entity.TransactionType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionRequest {
    private Long accountId;
    private BigDecimal amount;
    private TransactionType type;
}
