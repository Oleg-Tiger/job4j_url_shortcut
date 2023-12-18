package ru.job4j.url.model;

import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    private String url;

    /**
     * Ключ - преобразованное сервисом значение, соответствующее ссылке
     */
    @Column(name = "key_link")
    private String key;

    /**
     * Количество обращений к данной ссылке
     */
    private int total;

    public Link(String url, String key) {
        this.url = url;
        this.key = key;
        this.id = 0;
        this.total = 0;
    }
}
