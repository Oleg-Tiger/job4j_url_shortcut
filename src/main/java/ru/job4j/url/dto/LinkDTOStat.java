package ru.job4j.url.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель данных ссылки DTO с полями url и total
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkDTOStat {

    private String url;
    private int total;
}
