package com.alexzbu.personal_finance_maneger.service;

import com.alexzbu.personal_finance_maneger.DTO.TransactionReadDto;
import com.alexzbu.personal_finance_maneger.mapper.TransactionReadMapper;
import com.alexzbu.personal_finance_maneger.model.Transaction;
import com.alexzbu.personal_finance_maneger.model.User;
import com.alexzbu.personal_finance_maneger.repository.TransactionRepository;
import com.alexzbu.personal_finance_maneger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private TransactionReadMapper transactionReadMapper;

    @Autowired
    private UserRepository userRepository;


    public List<TransactionReadDto> getUserTransactions() {
        String username = getCurrentUsername();
        User user = userRepository.findByUsername(username);
        return transactionRepository.findByUser(user).stream()
                .map(transactionReadMapper::map).toList();
    }

    public void addTransaction(Transaction transaction) {
        String username = getCurrentUsername();
        User user = userRepository.findByUsername(username);
        transaction.setUser(user);
        transactionRepository.save(transaction);
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
        transactionRepository.deleteById(id);
    }
}
