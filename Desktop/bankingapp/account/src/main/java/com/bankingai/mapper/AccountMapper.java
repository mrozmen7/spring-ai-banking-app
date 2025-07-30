package com.bankingai.mapper;


import com.bankingai.dto.AccountDto;
import com.bankingai.dto.AccountDtoIU;
import com.bankingai.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDto toDto(Account account);
    Account toEntity(AccountDtoIU accountIU);
}
