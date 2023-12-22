package ru.job4j.url.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.job4j.url.model.Link;
import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Класс - реализация репозитория Link с использованием Spring Data
 */
public interface DataLinkRepository extends CrudRepository<Link, Integer> {

    /**
     * Поиск Link по url
     * @param url - строка содержащая url объекта Link
     * @return Optional найденного объекта Link или пустой Optional
     */
    Optional<Link> findByUrl(String url);

    /**
     * Поиск Link по key - зашифрованной ссылке
     * @param key - строка содержащая зашифрованную ссылку объекта Link
     * @return Optional найденного объекта Link или пустой Optional
     */
    Optional<Link> findByKey(String key);

    /**
     * Инкрементировать счётчик ссылки.
     * @param id - id ссылки
     */
    @Transactional
    @Modifying
    @Query("update Link l set l.total = l.total + 1 where id = :id")
    void updateTotal(@Param("id") int id);
}
