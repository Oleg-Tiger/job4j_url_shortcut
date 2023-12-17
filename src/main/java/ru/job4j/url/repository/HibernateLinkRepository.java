package ru.job4j.url.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.url.model.Link;
import java.util.List;
import java.util.Map;
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
    private final CrudRepository crudRepository;

    /**
     * Поиск всех ссылок
     */
    @Override
    public List<Link> findAll() {
        return null;
    }

    /**
     * Поиск Link по url
     * @param url - строка содержащая url объекта Link
     * @return Optional найденного объекта Link или пустой Optional
     */
    @Override
    public Optional<Link> findByUrl(String url) {
        return crudRepository.optional("from Link as l where l.url = :fUrl", Link.class,
                Map.of("fUrl", url));
    }

    /**
     * Добавить аккаунт.
     * @param link - объект Link
     * @return объект Link с присвоенным сгенерированным id
     */
    @Override
    public Link add(Link link) {
        crudRepository.run(session -> session.persist(link));
        return link;
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
