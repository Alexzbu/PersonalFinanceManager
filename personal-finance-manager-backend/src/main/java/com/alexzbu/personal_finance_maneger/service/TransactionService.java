package com.alexzbu.personal_finance_maneger.service;

import com.alexzbu.personal_finance_maneger.model.Transaction;
import com.alexzbu.personal_finance_maneger.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    public List<Transaction> findAll(){
        return repository.findAll();
    }

    public Transaction save(Transaction transaction){
        return repository.save(transaction);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
