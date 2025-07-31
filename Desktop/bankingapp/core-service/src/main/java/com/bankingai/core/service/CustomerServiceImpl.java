package com.bankingai.core.service;


import com.bankingai.core.customer.Customer;
import com.bankingai.core.dto.DtoCustomer;
import com.bankingai.core.dto.DtoCustomerIU;
import com.bankingai.core.mapper.CustomerMapper;
import com.bankingai.core.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public DtoCustomer saveCustomer(DtoCustomerIU dto) {
        Customer customer = customerMapper.toEntity(dto);
        Customer saved = customerRepository.save(customer);
        return customerMapper.toDto(saved);
    }

    @Override
    public List<DtoCustomer> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public DtoCustomer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    @Override
    public DtoCustomer updateCustomer(Long id, DtoCustomerIU dto) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

        customer.setFirstName(dto.getFirstName());
        customer.setEmail(dto.getEmail());

        Customer updated = customerRepository.save(customer);
        return customerMapper.toDto(updated);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return customerRepository.existsById(id);
    }
}