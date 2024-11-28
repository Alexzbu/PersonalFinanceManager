package com.alexzbu.personal_finance_maneger.repository;

import com.alexzbu.personal_finance_maneger.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
