package ru.job4j.url.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Модель данных аккаунта DTO с единственным полем site
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    @NotBlank(message = "Site must be not empty")
    private String site;
}
