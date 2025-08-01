package com.bankingai.service;

import com.bankingai.dto.TransactionRequest;
import com.bankingai.dto.TransactionResponse;
import java.util.List;

public interface TransactionService {
    TransactionResponse createTransaction(TransactionRequest request);
    List<TransactionResponse> getTransactionsByAccountId(Long accountId);
}