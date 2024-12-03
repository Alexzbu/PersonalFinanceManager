package com.alexzbu.personal_finance_maneger.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests(auth -> auth
                        .requestMatchers("/api/auth/*", "/login").permitAll() // Відкриті сторінки
                        .anyRequest().authenticated() // Усі інші запити вимагають автентифікації
                )
                .formLogin(form -> form
                        .loginPage("/login") // Кастомна сторінка входу
                        .defaultSuccessUrl("/api/auth/login", true) // Успішний вхід
                        .failureUrl("/login?error=true") // Невдалий вхід
                        .permitAll() // Дозволити доступ до сторінки входу
                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout=true") // Успішний вихід
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll() // Дозволити вихід із системи
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
