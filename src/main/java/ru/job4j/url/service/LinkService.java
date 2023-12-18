package ru.job4j.url.service;

import ru.job4j.url.model.Link;
import ru.job4j.url.model.LinkDTO;
import java.util.List;
import java.util.Optional;

/**
 * Интерфейс, описывающий сервис для работы со ссылками
 */
public interface LinkService {

    List<Link> findAll();

    Optional<Link> findByKey(String key);

    Optional<Link> add(LinkDTO linkDTO);
}
