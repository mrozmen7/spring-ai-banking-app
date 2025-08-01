package com.bankingai.mapper;

import com.bankingai.dto.TransactionRequest;
import com.bankingai.dto.TransactionResponse;
import com.bankingai.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    Transaction toTransaction(TransactionRequest request);
    TransactionResponse toResponse(Transaction transaction);
}