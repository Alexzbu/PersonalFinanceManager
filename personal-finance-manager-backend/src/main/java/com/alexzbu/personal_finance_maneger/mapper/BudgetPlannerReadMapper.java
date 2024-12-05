package com.alexzbu.personal_finance_maneger.mapper;

import com.alexzbu.personal_finance_maneger.DTO.BudgetPlannerReadDto;
import com.alexzbu.personal_finance_maneger.model.BudgetPlanner;
import org.springframework.stereotype.Component;

@Component
public class BudgetPlannerReadMapper implements Mapper<BudgetPlanner, BudgetPlannerReadDto> {

    @Override
    public BudgetPlannerReadDto map(BudgetPlanner object) {
        return new BudgetPlannerReadDto(
                object.getId(),
                object.getName(),
                object.getAmount()
        );
    }
}