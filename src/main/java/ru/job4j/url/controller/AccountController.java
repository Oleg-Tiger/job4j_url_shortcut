package ru.job4j.url.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.url.model.Account;
import ru.job4j.url.service.HibernateAccountService;
import ru.job4j.url.util.RandomGeneration;

/**
 * Класс-контроллер аккаунтов для взаимодействия с пользователем
 */
@AllArgsConstructor
@RestController
public class AccountController {

    private final HibernateAccountService service;
    private BCryptPasswordEncoder encoder;

}
