package com.alexzbu.personal_finance_maneger.repository;

import com.alexzbu.personal_finance_maneger.model.BudgetPlanner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetPlannerRepository extends JpaRepository<BudgetPlanner, Long> {
}
