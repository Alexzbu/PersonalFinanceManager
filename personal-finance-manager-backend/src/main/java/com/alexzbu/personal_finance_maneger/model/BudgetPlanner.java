package com.alexzbu.personal_finance_maneger.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BudgetPlanner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double amount;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
