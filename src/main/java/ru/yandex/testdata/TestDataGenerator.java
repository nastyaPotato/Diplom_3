package ru.yandex.testdata;

import java.util.Random;

public class TestDataGenerator {

    public static String getRandomEmail() {
        return "test" + new Random().nextInt(100000) + "@yandex.ru";
    }
}
