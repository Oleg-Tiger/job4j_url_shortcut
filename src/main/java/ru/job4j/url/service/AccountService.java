package ru.job4j.url.service;

import ru.job4j.url.model.Account;
import ru.job4j.url.model.AccountDTO;
import java.util.Optional;

/**
 * Интерфейс, описывающий сервис для работы с аккаунтами
 */
public interface AccountService {

    Optional<Account> add(AccountDTO accountDTO);
}
