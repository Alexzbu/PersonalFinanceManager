package com.alexzbu.personal_finance_maneger.DTO;

public record TransactionReadDto(Long id,
                                 String description,
                                 Double amount) {
}
