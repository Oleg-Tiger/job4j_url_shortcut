package ru.job4j.url.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.url.model.Link;
import ru.job4j.url.dto.LinkDTO;
import ru.job4j.url.dto.LinkDTOStat;
import ru.job4j.url.service.DataLinkService;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Класс-контроллер ссылок для взаимодействия с пользователем
 */
@RestController
@AllArgsConstructor
@RequestMapping("/link")
public class LinkController {

    private final DataLinkService service;

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

    /**
     * Метод для получения ссылки по ключу.
     * Если ссылка с таким ключом не найдена, возвращает статус NOT_FOUND
     * Если найдена - возвращает статус FOUND, ассоциированный адрес в теле метода
     */
    @GetMapping("/redirect/{key}")
    public ResponseEntity redirect(@PathVariable String key) {
        Optional<Link> result = service.findByKey(key);
        if (result.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("HTTP CODE", "302 REDIRECT URL")
                .body(Map.of("url", result.get().getUrl()));
    }

    /**
     * Метод для получения статистики обращения к ссылкам.
     * Возвращает список всех ссылок и количество обращений к ним
     */

    @GetMapping("/statistic")
    public ResponseEntity<List<LinkDTOStat>> stat() {
        return ResponseEntity.ok(service.findAll());
    }
}
