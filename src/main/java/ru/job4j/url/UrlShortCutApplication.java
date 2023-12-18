package ru.job4j.url;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * Главный класс приложения с методом main
 */
@SpringBootApplication
public class UrlShortCutApplication {

	/**
	 * Метод, создающий и возвращающий бин кодировщика паролей
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Метод, считывающий настройки Liquibase
	 */
	@Bean
	public SpringLiquibase liquibase(DataSource ds) {
		SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setChangeLog("classpath:liquibase-changeLog.xml");
		liquibase.setDataSource(ds);
		return liquibase;
	}

	public static void main(String[] args) {
		SpringApplication.run(UrlShortCutApplication.class, args);
	}
}
