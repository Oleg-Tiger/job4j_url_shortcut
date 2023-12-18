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

    public Optional<Link> findByKey(String key);

    Link add(Link link);
}

