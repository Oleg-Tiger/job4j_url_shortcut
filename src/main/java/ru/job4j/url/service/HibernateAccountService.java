package ru.job4j.url.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.job4j.url.model.Account;
import ru.job4j.url.model.AccountDTO;
import ru.job4j.url.repository.HibernateAccountRepository;
import ru.job4j.url.util.RandomGeneration;
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
    private BCryptPasswordEncoder encoder;
    private static final Logger LOG = LoggerFactory.getLogger(HibernateAccountService.class.getName());

    /**
     * Поиск всех аккаунтов
     */
    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }

    /**
     * Добавить аккаунт. Прежде чем добавить аккаунт проверяет, нет ли аккаунта с таким доменом в БД
     * @Param модель Account DTO
     * @return пустой Optional, если сайт с таким доменом уже есть в БД, если нет - добавляет и возвращает
     * Optional добавленного Account со сгенерированным id
     */
    @Override
    public Optional<Account> add(AccountDTO accountDTO) {
        if (repository.findBySite(accountDTO.getSite()).isPresent()) {
            LOG.error(String.format("%s - this site already registered", accountDTO.getSite()));
            return Optional.empty();
        }
        String password = RandomGeneration.generateRandomSequence(10, RandomGeneration.LOWER_UPPER_NUMBERS);
        Account account = new Account(0, accountDTO.getSite(), accountDTO.getSite(), encoder.encode(password));
        Account accountWithId = repository.add(account);
        accountWithId.setPassword(password);
        return Optional.of(accountWithId);
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
