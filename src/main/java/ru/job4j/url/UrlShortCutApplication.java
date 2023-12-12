package ru.job4j.url;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Главный класс приложения с методом main
 */
@SpringBootApplication
public class UrlShortCutApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrlShortCutApplication.class, args);
	}

	/**
	 * Метод, создающий и возвращающий бин кодировщика паролей
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
