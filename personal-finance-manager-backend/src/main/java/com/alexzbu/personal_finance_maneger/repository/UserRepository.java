package com.alexzbu.personal_finance_maneger.repository;

import com.alexzbu.personal_finance_maneger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
