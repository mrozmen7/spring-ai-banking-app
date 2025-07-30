package com.bankingai.service;

import com.bankingai.dto.AccountDto;
import com.bankingai.dto.AccountDtoIU;
import com.bankingai.mapper.AccountMapper;
import com.bankingai.model.Account;
import com.bankingai.repository.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    @Override
    public AccountDto create(AccountDtoIU dto) {
        Account entity = accountMapper.toEntity(dto);
        Account saved = accountRepository.save(entity);
        return accountMapper.toDto(saved);
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

        Account updated = accountRepository.save(existing);
        return accountMapper.toDto(updated);
    }
}