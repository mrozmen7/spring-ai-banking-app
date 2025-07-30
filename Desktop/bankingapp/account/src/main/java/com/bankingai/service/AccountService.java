package com.bankingai.service;

import com.bankingai.dto.AccountDto;
import com.bankingai.dto.AccountDtoIU;

import java.util.List;

public interface AccountService {

    AccountDto create(AccountDtoIU dto);

    AccountDto getByAccountNumber(String accountNumber);

    List<AccountDto> getByCustomerName(String customerName);

    void deleteByAccountNumber(String accountNumber);

    AccountDto update(String accountNumber, AccountDtoIU dto);

    List<AccountDto> getAll();

    void delete(String accountNumber);

}
