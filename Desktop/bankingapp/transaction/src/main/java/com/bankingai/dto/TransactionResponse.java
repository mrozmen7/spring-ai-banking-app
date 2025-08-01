package com.bankingai.dto;

import com.bankingai.entity.TransactionType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponse {
    private Long id;
    private Long accountId;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
    private TransactionType type;
}
