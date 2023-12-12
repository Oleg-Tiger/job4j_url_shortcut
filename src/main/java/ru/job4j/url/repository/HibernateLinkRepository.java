package ru.job4j.url.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.url.model.Link;
import java.util.List;
import java.util.Optional;

/**
 * Класс - реализация репозитория Link с использованием Hibernate
 */
@Repository
@AllArgsConstructor
public class HibernateLinkRepository implements LinkRepository {

    /**
     * На данный объект мы будем делегировать выполнение команд, передавая в аргументы его методов
     * необходимые запросы и параметры
     */
    private final CrudRepository repository;

    /**
     * Поиск всех ссылок
     */
    @Override
    public List<Link> findAll() {
        return null;
    }

    /**
     * Добавить ссылку
     */
    @Override
    public Optional<Link> add(Link link) {
        return Optional.empty();
    }

    /**
     * Найти ссылку по id
     */
    @Override
    public Optional<Link> findById(Link link) {
        return Optional.empty();
    }

    /**
     * Обновить ссылку
     */
    @Override
    public Optional<Link> update(Link link) {
        return Optional.empty();
    }

    /**
     * Удалить ссылку
     */
    @Override
    public boolean delete(Link link) {
        return false;
    }
}
