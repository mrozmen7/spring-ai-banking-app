package com.bankingai.controller;

import com.bankingai.dto.AccountDto;
import com.bankingai.dto.AccountDtoIU;
import com.bankingai.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {


    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> create(@RequestBody @Valid AccountDtoIU dto) {

        AccountDto created = accountService.create(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // ✅ Tüm hesapları listeleme
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAll() {
        List<AccountDto> accounts = accountService.getAll();
        return ResponseEntity.ok(accounts);
    }

    // ✅ Belirli bir hesabı accountNumber ile bulma
    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountDto> getByAccountNumber(@PathVariable String accountNumber) {
        AccountDto account = accountService.getByAccountNumber(accountNumber);
        return ResponseEntity.ok(account);
    }

    // ✅ Hesap bilgilerini güncelleme
    @PutMapping("/{accountNumber}")
    public ResponseEntity<AccountDto> update(@PathVariable String accountNumber, @RequestBody @Valid AccountDtoIU dto) {
        AccountDto updated = accountService.update(accountNumber, dto);
        return ResponseEntity.ok(updated);
    }

    // ✅ Hesabı silme (ileride aktiflik yerine yumuşak silme yapılabilir)
    @DeleteMapping("/{accountNumber}")
    public ResponseEntity<Void> delete(@PathVariable String accountNumber) {
        accountService.deleteByAccountNumber(accountNumber);
        return ResponseEntity.noContent().build();
    }
}
