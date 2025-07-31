package com.bankingai.core.service;
import com.bankingai.core.dto.DtoCustomer;
import com.bankingai.core.dto.DtoCustomerIU;

import java.util.List;

public interface CustomerService {

    DtoCustomer saveCustomer(DtoCustomerIU dto);

    List<DtoCustomer> getAllCustomers();

    DtoCustomer getCustomerById(Long id);

    DtoCustomer updateCustomer(Long id, DtoCustomerIU dto);

    void deleteCustomer(Long id);

    boolean existsById(Long id);  // Bu AccountService'ten çağırılacak
}