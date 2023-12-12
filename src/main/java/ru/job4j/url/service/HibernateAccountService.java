package ru.job4j.url.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.url.model.Account;
import ru.job4j.url.repository.HibernateAccountRepository;
import java.util.List;
import java.util.Optional;

/**
 * Реализация сервиса для работы с аккаунтами с помощью Hibernate
 */
@Service
@AllArgsConstructor
public class HibernateAccountService implements AccountService {

    /**
     * Объект для работы с хранилищем, на который будет делегироваться операции по работе с хранилищем
     */
    private final HibernateAccountRepository repository;

    /**
     * Поиск всех аккаунтов
     */
    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }

    /**
     * Добавить аккаунт
     */
    @Override
    public Optional<Account> add(Account account) {
        return repository.add(account);
    }

    /**
     * Поиск аккаунта по id
     */
    @Override
    public Optional<Account> findById(Account account) {
        return repository.findById(account);
    }

    /**
     * Обновление аккаунта
     */
    @Override
    public Optional<Account> update(Account account) {
        return repository.update(account);
    }

    /**
     * Удалить аккаунт
     */
    @Override
    public boolean delete(Account account) {
        return repository.delete(account);
    }
}
