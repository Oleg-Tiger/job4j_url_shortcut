package ru.job4j.url.service;

import ru.job4j.url.model.Account;
import ru.job4j.url.model.AccountDTO;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс, описывающий сервис для работы с аккаунтами
 */
public interface AccountService {

    List<Account> findAll();

    Optional<Account> add(AccountDTO accountDTO);

    Optional<Account> findById(Account account);

    Optional<Account> update(Account account);

    boolean delete(Account account);
}
