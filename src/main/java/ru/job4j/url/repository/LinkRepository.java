package ru.job4j.url.repository;

import ru.job4j.url.model.Link;
import java.util.List;
import java.util.Optional;

/**
 * Интерфейс, описывающий хранилище ссылок. Описывает CRUD-операции
 */
public interface LinkRepository {

    List<Link> findAll();

    public Optional<Link> findByUrl(String url);

    Link add(Link link);

    Optional<Link> findById(Link link);

    Optional<Link> update(Link link);

    boolean delete(Link link);
}

