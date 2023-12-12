package ru.job4j.url.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * Модель данных описывающая ссылки
 */
@Entity
@Table(name = "links")
@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Link {

    /**
     * id объекта, генерируется БД
     */
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Значение ссылки
     */
    private String link;

    /**
     * Ключ - преобразованное сервисом значение, соответствующее ссылке
     */
    @Column(name = "key_link")
    private String key;

    /**
     * Количество обращений к данной ссылке
     */
    @Column(name = "number_requests")
    private AtomicInteger numberRequests = new AtomicInteger(0);

}
