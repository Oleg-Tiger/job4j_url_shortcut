package ru.job4j.url.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.job4j.url.model.Account;
import ru.job4j.url.repository.AccountRepository;
import java.util.Optional;

import static java.util.Collections.emptyList;

/**
 * Этот класс-сервис загружает в SecurityHolder детали авторизованного пользователя.
 */
@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private AccountRepository accounts;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Account> account = accounts.findBySite(login);
        if (account.isEmpty()) {
            throw new UsernameNotFoundException(login);
        }
        return new User(account.get().getLogin(), account.get().getPassword(), emptyList());
    }
}