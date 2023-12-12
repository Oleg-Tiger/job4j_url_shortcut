package ru.job4j.url.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Модель данных аккаунта. Пользователь отправляет в сервис доменный адрес сайта, сервис регистрирует сайт
 *  и отправляет в ответ сгенерированные логин и пароль. Вся информация инкапсулируется в данной модели.
 */
@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Account {

    /**
     * Идентификатор аккаунта. Будет генерироваться при добавлении в БД
     */
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Домен сайта, полученный от пользователя. На уровне БД есть ограничение UNIQUE, так как повторное зарегистрировать
     * один и тот же сайт нельзя
     */
    private String site;

    /**
     * Логин, сгенерированный сервисом
     */
    private String login;

    /**
     * Пароль, сгенерированный сервисом
     */
    private String password;
}
