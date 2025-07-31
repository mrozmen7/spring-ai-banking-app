package com.bankingai.service;

import com.bankingai.client.CustomerServiceClient;
import com.bankingai.dto.AccountDto;
import com.bankingai.dto.AccountDtoIU;
import com.bankingai.mapper.AccountMapper;
import com.bankingai.model.Account;
import com.bankingai.repository.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {


    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    private final CustomerServiceClient customerServiceClient;
    @Override
    public AccountDto create(AccountDtoIU dto) {
        // 1. customerId gerçekten var mı kontrolü
        if (!customerServiceClient.existsById(dto.getCustomerId())) {
            throw new EntityNotFoundException("Customer not found: " + dto.getCustomerId());
        }

        // 2. Entity dönüşümü ve kayıt
        Account entity = accountMapper.toEntity(dto);
        Account saved = accountRepository.save(entity);
        return accountMapper.toDto(saved);
    }

    @Override
    public List<AccountDto> getAll() {
        return accountRepository.findAll()
                .stream()
                .map(accountMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto getByAccountNumber(String accountNumber) {
        Account entity = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new EntityNotFoundException("Account not found: " + accountNumber));
        return accountMapper.toDto(entity);
    }

    @Override
    public List<AccountDto> getByCustomerName(String customerName) {
        return accountRepository.findByCustomerNameContainingIgnoreCase(customerName)
                .stream()
                .map(accountMapper::toDto)
                .toList();
    }

    @Override
    public void deleteByAccountNumber(String accountNumber) {
        Account entity = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new EntityNotFoundException("Account not found: " + accountNumber));
        accountRepository.delete(entity);
    }

    @Override
    public AccountDto update(String accountNumber, AccountDtoIU dto) {
        Account existing = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new EntityNotFoundException("Account not found: " + accountNumber));

        existing.setCustomerName(dto.getCustomerName());
        existing.setCurrency(dto.getCurrency());
        existing.setBalance(dto.getBalance());
        existing.setActive(dto.isActive());

        // Müşteri değişimi varsa kontrol
        if (!Objects.equals(existing.getCustomerId(), dto.getCustomerId())) {
            if (!customerServiceClient.existsById(dto.getCustomerId())) {
                throw new EntityNotFoundException("Customer not found: " + dto.getCustomerId());
            }
            existing.setCustomerId(dto.getCustomerId());
        }

        Account updated = accountRepository.save(existing);
        return accountMapper.toDto(updated);
    }
}