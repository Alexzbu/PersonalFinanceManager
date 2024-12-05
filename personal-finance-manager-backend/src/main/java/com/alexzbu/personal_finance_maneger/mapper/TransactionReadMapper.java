package com.alexzbu.personal_finance_maneger.mapper;

import com.alexzbu.personal_finance_maneger.DTO.TransactionReadDto;
import com.alexzbu.personal_finance_maneger.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionReadMapper implements Mapper<Transaction, TransactionReadDto> {

    @Override
    public TransactionReadDto map(Transaction object) {
        return new TransactionReadDto(
                object.getId(),
                object.getDescription(),
                object.getAmount()
        );
    }
}