package ru.job4j.url.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;

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
