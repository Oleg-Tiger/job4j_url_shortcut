package ru.job4j.url.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.url.service.HibernateLinkService;

/**
 * Класс-контроллер ссылок для взаимодействия с пользователем
 */
@RestController
@AllArgsConstructor
@RequestMapping("/link")
public class LinkController {

    private final HibernateLinkService service;

}
