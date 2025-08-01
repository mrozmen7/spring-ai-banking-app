package com.bankingai.service;

import com.bankingai.dto.TransactionRequest;
import com.bankingai.dto.TransactionResponse;
import com.bankingai.entity.Transaction;
import com.bankingai.mapper.TransactionMapper;
import com.bankingai.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final TransactionMapper mapper;

    @Override
    public TransactionResponse createTransaction(TransactionRequest request) {
        Transaction transaction = mapper.toTransaction(request);
        transaction.setTransactionDate(LocalDateTime.now());
        Transaction saved = repository.save(transaction);
        return mapper.toResponse(saved);
    }

    @Override
    public List<TransactionResponse> getTransactionsByAccountId(Long accountId) {
        return repository.findByAccountId(accountId)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}