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
    private BudgetPlannerService budgetPlannerService;

    @GetMapping
    public List<BudgetPlanner> getUserBudgets() {
        return budgetPlannerService.getUserBudgets();
    }

    @PostMapping
    public void addBudget(@RequestBody BudgetPlanner budgetPlanner) {
        budgetPlannerService.addBudget(budgetPlanner);
    }

    @DeleteMapping("/{id}")
    public void deleteBudgetPlanner(@PathVariable Long id){
        budgetPlannerService.delete(id);
    }
}
