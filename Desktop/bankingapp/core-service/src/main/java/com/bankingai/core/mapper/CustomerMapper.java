package com.bankingai.core.mapper;

import com.bankingai.core.customer.Customer;
import com.bankingai.core.dto.DtoCustomer;
import com.bankingai.core.dto.DtoCustomerIU;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {



    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    // Dışarıdan gelen DTO -> Entity (veritabanı için)
    Customer toEntity(DtoCustomerIU dto);

    // Veritabanından gelen Entity -> DTO (dış dünya için)
    DtoCustomer toDto(Customer entity);

}
