package ru.job4j.url.repository;

import lombok.AllArgsConstructor;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;
import ru.job4j.url.model.Account;
import java.util.List;
import java.util.Map;
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
    private final CrudRepository crudRepository;

    /**
     * Поиск всех аккаунтов
     */
    @Override
    public List<Account> findAll() {
        return null;
    }

    /**
     * Поиск аккаунта по домену
     * @param site - строка содержащая домен сайта
     * @return Optional найденного объекта Account или пустой Optional
     */
    @Override
    public Optional<Account> findBySite(String site) {
        return crudRepository.optional("from Account as a where a.site = :fSite", Account.class,
                Map.of("fSite", site));
    }

    /**
     * Добавить аккаунт.
     * @param account - объект Account
     * @return объект Account с присвоенным сгенерированным id
     */
    @Override
    public Account add(Account account) {
        crudRepository.run(session -> session.persist(account));
        return account;
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
