package com.alexzbu.personal_finance_maneger.repository;

import com.alexzbu.personal_finance_maneger.model.Transaction;
import com.alexzbu.personal_finance_maneger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUser(User user);
}
