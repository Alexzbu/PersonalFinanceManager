package com.alexzbu.personal_finance_maneger.controller;

import com.alexzbu.personal_finance_maneger.model.Transaction;
import com.alexzbu.personal_finance_maneger.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getUserTransactions() {
        return transactionService.getUserTransactions();
    }

    @PostMapping
    public void addTransaction(@RequestBody Transaction transaction) {
        transactionService.addTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id){
        transactionService.delete(id);
    }
}
