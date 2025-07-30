package com.bankingai.repository;

import com.bankingai.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByAccountNumber(String accountNumber);
    List<Account> findByCustomerNameContainingIgnoreCase(String customerName);

    // Belirli bir para birimiyle tüm hesapları listele
    List<Account> findByCurrency(String currency);

    // Bakiye aralığına göre sorgulama
    List<Account> findByBalanceBetween(BigDecimal min, BigDecimal max);

    // Belirli müşteri adına ve döviz cinsine göre
    List<Account> findByCustomerNameAndCurrency(String name, String currency);

}
