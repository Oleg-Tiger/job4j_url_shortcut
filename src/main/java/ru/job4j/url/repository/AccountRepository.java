package ru.job4j.url.repository;

import ru.job4j.url.model.Account;
import java.util.List;
import java.util.Optional;

/**
 * Интерфейс, описывающий хранилище аккаунтов. Описывает CRUD-операции
 */
public interface AccountRepository {

List<Account> findAll();

Optional<Account> findBySite(String site);

Account add(Account account);

Optional<Account> findById(Account account);

Optional<Account> update(Account account);

boolean delete(Account account);
}
