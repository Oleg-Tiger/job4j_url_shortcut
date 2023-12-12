package ru.job4j.url.service;

import ru.job4j.url.model.Link;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс, описывающий сервис для работы со ссылками
 */
public interface LinkService {

    List<Link> findAll();

    Optional<Link> add(Link link);

    Optional<Link> findById(Link link);

    Optional<Link> update(Link link);

    boolean delete(Link link);
}
