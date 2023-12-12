package ru.job4j.url.repository;

import ru.job4j.url.model.Account;
import ru.job4j.url.model.Link;
import java.util.List;
import java.util.Optional;

/**
 * Интерфейс, описывающий хранилище ссылок. Описывает CRUD-операции
 */
public interface LinkRepository {

    List<Link> findAll();

    Optional<Link> add(Link link);

    Optional<Link> findById(Link link);

    Optional<Link> update(Link link);

    boolean delete(Link link);
}

