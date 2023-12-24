package ru.job4j.url.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.url.model.Account;
import ru.job4j.url.dto.AccountDTO;
import ru.job4j.url.service.DataAccountService;
import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Класс-контроллер аккаунтов для взаимодействия с пользователем
 */
@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final DataAccountService service;

    /**
     * Метод регистрации нового сайта.
     * В случае успешной регистрации - возвращает ответ с информацией об успешной регистрации,
     * а также с информацией о логине и пароле.
     * В случае, если такой сайт уже есть в системе - возвращает информацию о неудачной регистрации
     * и статус Conflict
     */
    @PostMapping("/sign-up")
    public ResponseEntity<Map<String, String>> registration(@Valid @RequestBody AccountDTO accountDTO) {
        Optional<Account> result = service.add(accountDTO);
        if (result.isEmpty()) {
            return new ResponseEntity<>(Map.of("registration", "false"), HttpStatus.CONFLICT);
        }
        Map response = generateResp(result.get());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Метод генерации тела ответа в случае успешной регистрации сайта
     */
    private Map<String, String> generateResp(Account account) {
        Map<String, String> map = new LinkedHashMap();
        map.put("registration", "true");
        map.put("login", account.getLogin());
        map.put("password", account.getPassword());
        return map;
    }
}
