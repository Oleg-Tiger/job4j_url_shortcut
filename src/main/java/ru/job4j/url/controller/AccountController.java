package ru.job4j.url.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.url.service.HibernateAccountService;

/**
 * Класс-контроллер аккаунтов для взаимодействия с пользователем
 */
@AllArgsConstructor
@RestController
public class AccountController {

    private final HibernateAccountService service;

}
