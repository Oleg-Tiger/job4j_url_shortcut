package ru.job4j.url.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.url.model.Account;

import java.util.Optional;

/**
 * Реализация хранилища аккаунтов с помощью Spring Data
 */
public interface DataAccountRepository extends CrudRepository<Account, Integer> {

    /**
     * Поиск аккаунта по домену
     * @param site - строка содержащая домен сайта
     * @return Optional найденного объекта Account или пустой Optional
     */
    Optional<Account> findBySite(String site);

}
