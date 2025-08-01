package com.bankingai.core.repository;

import com.bankingai.core.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    boolean existsByEmail(String email);

    Customer findByEmail(String email);

//    boolean existsById(Long id);

}
