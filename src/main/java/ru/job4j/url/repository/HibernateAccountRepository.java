package ru.job4j.url.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.url.model.Account;

import java.util.List;
import java.util.Optional;

/**
 * Реализация хранилища аккаунтов с помощью Hibernate
 */
@Repository
@AllArgsConstructor
public class HibernateAccountRepository implements AccountRepository {

    /**
     * На данный объект мы будем делегировать выполнение команд, передавая в аргументы его методов
     * необходимые запросы и параметры
     */
    private final CrudRepository repository;

    /**
     * Поиск всех аккаунтов
     */
    @Override
    public List<Account> findAll() {
        return null;
    }

    /**
     * Добавить аккаунт
     */
    @Override
    public Optional<Account> add(Account account) {
        return Optional.empty();
    }

    /**
     * Поиск аккаунта по id
     */
    @Override
    public Optional<Account> findById(Account account) {
        return Optional.empty();
    }

    /**
     * Обновление аккаунта
     */
    @Override
    public Optional<Account> update(Account account) {
        return Optional.empty();
    }

    /**
     * Удалить аккаунт
     */
    @Override
    public boolean delete(Account account) {
        return false;
    }
}
