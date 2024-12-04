package com.alexzbu.personal_finance_maneger.service;

import com.alexzbu.personal_finance_maneger.model.BudgetPlanner;
import com.alexzbu.personal_finance_maneger.model.User;
import com.alexzbu.personal_finance_maneger.repository.BudgetPlannerRepository;
import com.alexzbu.personal_finance_maneger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetPlannerService {

    @Autowired
    private BudgetPlannerRepository budgetPlannerRepository;

    @Autowired
    private UserRepository userRepository;

    public List<BudgetPlanner> getUserBudgets() {
        String username = getCurrentUsername();
        User user = userRepository.findByUsername(username);
        return budgetPlannerRepository.findByUser(user);
    }

    public void addBudget(BudgetPlanner budgetPlanner) {
        String username = getCurrentUsername();
        User user = userRepository.findByUsername(username);
        budgetPlanner.setUser(user);
        budgetPlannerRepository.save(budgetPlanner);
    }

    private String getCurrentUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString();
        }
    }

    public void delete(Long id) {
        budgetPlannerRepository.deleteById(id);
    }
}
