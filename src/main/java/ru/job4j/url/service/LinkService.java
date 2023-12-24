package ru.job4j.url.service;

import ru.job4j.url.model.Link;
import ru.job4j.url.dto.LinkDTO;
import ru.job4j.url.dto.LinkDTOStat;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс, описывающий сервис для работы со ссылками
 */
public interface LinkService {

    List<LinkDTOStat> findAll();

    Optional<Link> findByKey(String key);

    Optional<Link> add(LinkDTO linkDTO);
}
