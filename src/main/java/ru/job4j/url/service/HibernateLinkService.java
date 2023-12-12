package ru.job4j.url.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.url.model.Link;
import ru.job4j.url.repository.HibernateLinkRepository;

import java.util.List;
import java.util.Optional;

/**
 * Класс - реализация сервиса для работы с Link с использованием Hibernate
 */
@Service
@AllArgsConstructor
public class HibernateLinkService implements LinkService {

    private final HibernateLinkRepository repository;

    /**
     * Найти все ссылки
     */
    @Override
    public List<Link> findAll() {
        return repository.findAll();
    }

    /**
     * Добавить ссылку
     */
    @Override
    public Optional<Link> add(Link link) {
        return repository.add(link);
    }

    /**
     * Найти ссылку по id
     */
    @Override
    public Optional<Link> findById(Link link) {
        return repository.findById(link);
    }

    /**
     * Обновить ссылку
     */
    @Override
    public Optional<Link> update(Link link) {
        return repository.update(link);
    }

    /**
     * Удалить ссылку
     */
    @Override
    public boolean delete(Link link) {
        return repository.delete(link);
    }
}
