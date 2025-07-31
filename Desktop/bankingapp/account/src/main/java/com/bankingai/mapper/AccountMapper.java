package com.bankingai.mapper;


import com.bankingai.dto.AccountDto;
import com.bankingai.dto.AccountDtoIU;
import com.bankingai.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Account toEntity(AccountDtoIU dto);

    AccountDto toDto(Account account);

    List<AccountDto> toDtoList(List<Account> accounts);

}
