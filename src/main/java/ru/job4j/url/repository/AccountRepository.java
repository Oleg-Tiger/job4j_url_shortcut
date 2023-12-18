package ru.job4j.url.repository;

import ru.job4j.url.model.Account;
import java.util.Optional;

/**
 * Интерфейс, описывающий хранилище аккаунтов. Описывает CRUD-операции
 */
public interface AccountRepository {

Optional<Account> findBySite(String site);

Account add(Account account);
}
