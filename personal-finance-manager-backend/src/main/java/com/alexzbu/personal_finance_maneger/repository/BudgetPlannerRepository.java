package com.alexzbu.personal_finance_maneger.repository;

import com.alexzbu.personal_finance_maneger.model.BudgetPlanner;
import com.alexzbu.personal_finance_maneger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BudgetPlannerRepository extends JpaRepository<BudgetPlanner, Long> {
    List<BudgetPlanner> findByUser(User user);
}
