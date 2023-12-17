package ru.job4j.url.util;

import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Утилитный класс с методами для генерации случайных последовательности символов
 */
public class RandomGeneration {

    public static final String LOWER_UPPER_NUMBERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    /**
     * Метод для генерации последовательности. В качестве аргументов принимает длину строки, которая должна получиться
     * на выходе, а также строку с набором символов
     */
    public static String generateRandomSequence(int length, String chars) {
        SecureRandom random = new SecureRandom();
        return IntStream.range(0, length)
                .map(i -> random.nextInt(chars.length()))
                .mapToObj(randomIndex -> String.valueOf(chars.charAt(randomIndex)))
                .collect(Collectors.joining());
    }
}
