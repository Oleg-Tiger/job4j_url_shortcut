package ru.job4j.url.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

/**
 * Модель данных ссылки DTO с единственным полем link
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinkDTO {

    @NotBlank(message = "Url must be not empty")
    private String url;
}
