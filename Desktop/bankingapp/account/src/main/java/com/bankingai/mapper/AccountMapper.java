package com.bankingai.mapper;


import com.bankingai.dto.AccountDto;
import com.bankingai.dto.AccountDtoIU;
import com.bankingai.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    Account toEntity(AccountDtoIU dto);
    AccountDto toDto(Account entity);
}
