package com.alexzbu.personal_finance_maneger.DTO;

import lombok.Data;

@Data
public class TransactionDTO {
    private Long id;
    private String description;
    private Double amount;
}
