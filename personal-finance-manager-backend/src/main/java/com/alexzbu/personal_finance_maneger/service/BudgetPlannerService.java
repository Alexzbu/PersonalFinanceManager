package com.alexzbu.personal_finance_maneger.service;

import com.alexzbu.personal_finance_maneger.model.BudgetPlanner;
import com.alexzbu.personal_finance_maneger.repository.BudgetPlannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetPlannerService {

    @Autowired
    private BudgetPlannerRepository repository;

    public List<BudgetPlanner> findAll(){
        return repository.findAll();
    }

    public BudgetPlanner save(BudgetPlanner budgetPlanner){
        return repository.save(budgetPlanner);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


}
