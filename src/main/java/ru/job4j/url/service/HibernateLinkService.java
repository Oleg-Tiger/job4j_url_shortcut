package ru.job4j.url.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.url.model.Link;
import ru.job4j.url.model.LinkDTO;
import ru.job4j.url.model.LinkDTOStat;
import ru.job4j.url.repository.HibernateLinkRepository;
import ru.job4j.url.util.RandomGeneration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Класс - реализация сервиса для работы с Link с использованием Hibernate
 */
@Service
@AllArgsConstructor
public class HibernateLinkService implements LinkService {

    private final HibernateLinkRepository repository;

    /**
     * Найти все ссылки. Получает все ссылки из репозитория, преобразует их в DTO-модель возвращает в
     * виде списка
     */
    @Override
    public List<LinkDTOStat> findAll() {
        List<LinkDTOStat> result = new ArrayList<>();
        return repository.findAll().stream()
                .map(link -> new LinkDTOStat(link.getUrl(), link.getTotal()))
                .collect(Collectors.toList());
    }

    /**
     * Поиск Link по key - зашифрованной ссылке
     * @param key - строка содержащая зашифрованную ссылку объекта Link
     * @return Optional найденного объекта Link или пустой Optional
     */

    @Override
    public Optional<Link> findByKey(String key) {
        return repository.findByKey(key);
    }

    /**
     * Добавить ссылку
     * @param linkDTO - объект, содержащий url
     * @return если объект с таким значением url уже есть в БД, то будет возвращен его Optional
     * Если нет - то будет создан новый объект, сгенерирован уникальный ключ для него, и возвращен
     * Optional этого объекта
     */
    @Override
    public Optional<Link> add(LinkDTO linkDTO) {
        Optional<Link> inDB = repository.findByUrl(linkDTO.getUrl());
        if (inDB.isPresent()) {
            return inDB;
        }
        String key = RandomGeneration.generateRandomSequence(8, RandomGeneration.LOWER_UPPER_NUMBERS);
        Link link = new Link(linkDTO.getUrl(), key);
        Link linkWithId = repository.add(link);
        return Optional.of(linkWithId);
    }
}
