package lab2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Task1Test {

    Task1 task1;
    String[] originalArray = new String[]{"1", "2.", "3", "0.", "-3.4", "-17", "0", "1e24", "0", "-45"};

    @BeforeEach // метод, який буде виконуватись перед кожним наступним тестом
     void setUp() {
        task1 = new Task1(originalArray);
    }

    @AfterEach // метод з анотацією AfterEach після кожного тесту
    void tearDown() {
        System.err.println("OK!");
    }

    @Test // безпосередньо самі тести для кожного з методів, які є в задачі
    void printArray() { // шаблони (пропонуються пусті)
        // в кожному методі оцінюються 2 величини
        int expected = task1.printArray(originalArray); // те, що очікується від виконання методу
        int actual = 0; // актуальне/дійсне значення
        assertTrue(expected == actual); // процес порівняння
    }
    // не дуже зручний для аналізу, тому що має тип void
    // найбільш зручними для використання юніт-тестів є методи, які повертають якесь значення
    // якщо метод нічого не повертає, то протестувати його складно, але можна
    // які є виходи?
    // 1) можна звести тип void до типу, який буде повертати якесь значення
    // 2) можна методи типу void взагалі не тестувати

    @Test
    void originalArrayIsNumeric() {
        boolean expected = task1.originalArrayIsNumeric(originalArray);
        boolean actual = true; // очікуване значення, яке ми можемо передбачити
        assertTrue(expected==actual);
    }

    @Test
    void getFinalArray() {
        boolean flag = true;
        String[] expected = task1.getFinalArray();
        String[] actual = new String[] {"-3.4", "-17", "-45", "0.", "0", "0", "1", "2.", "3", "1e24"};

        for (int i=0; i<expected.length; i++) {
            if (expected[i].equals(actual[i])) {
                continue;
            } else {
                flag = false;
            }
        }
        assertTrue(flag);
    }
}