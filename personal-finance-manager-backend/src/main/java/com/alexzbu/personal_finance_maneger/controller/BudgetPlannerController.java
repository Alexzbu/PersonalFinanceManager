package com.alexzbu.personal_finance_maneger.controller;

import com.alexzbu.personal_finance_maneger.model.BudgetPlanner;
import com.alexzbu.personal_finance_maneger.service.BudgetPlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budget")
public class BudgetPlannerController {

    @Autowired
    private BudgetPlannerService service;

    @GetMapping
    public List<BudgetPlanner> getAllBudgets(){
        return service.findAll();
    }

    @PostMapping
    public BudgetPlanner createBudgetPlanner(@RequestBody BudgetPlanner budgetPlanner){
        return service.save(budgetPlanner);
    }

    @DeleteMapping("/{id}")
    public void deleteBudgetPlanner(@PathVariable Long id){
        service.delete(id);
    }
}
