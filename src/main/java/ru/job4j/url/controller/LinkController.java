package ru.job4j.url.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.url.model.Link;
import ru.job4j.url.model.LinkDTO;
import ru.job4j.url.service.HibernateLinkService;
import javax.validation.Valid;
import java.util.Map;
import java.util.Optional;

/**
 * Класс-контроллер ссылок для взаимодействия с пользователем
 */
@RestController
@AllArgsConstructor
@RequestMapping("/link")
public class LinkController {

    private final HibernateLinkService service;

    /**
     * Метод для конвертации ссылки.
     * Собирает из json-объекта модель linkDTO, содержащую ссылку
     * Возвращает уникальный ключ, связанный со ссылкой
     */
    @PostMapping("/convert")
    public ResponseEntity<Map<String, String>> convert(@Valid @RequestBody LinkDTO linkDTO) {
        Optional<Link> result = service.add(linkDTO);
        return ResponseEntity.ok(Map.of("code", result.get().getKey()));
    }
}
