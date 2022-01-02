package lab2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Ex1Test {

    Ex1 ex1;
    String[] array1 = new String[]{"1", "2.", "3", "0.", "-3.4", "-17", "0", "1024", "0", "-45"};

    @BeforeEach
    void setUp() {
        ex1 = new Ex1(array1);
    }

    @AfterEach
    void tearDown() {
        System.err.println("Correct!");
    }

    @Test
    void printArray() {
        int expected = ex1.printArray(array1); // те, що очікується від виконання методу
        int actual = 0; // актуальне/дійсне значення
        assertTrue(expected == actual); // процес порівняння
    }

    @Test
    void array1Check() {
        boolean expected = ex1.array1Check(array1);
        boolean actual = true; // очікуване значення, яке ми можемо передбачити
        assertTrue(expected==actual);
    }

    @Test
    void getArray2() {
        Double[] expected = ex1.getArray2();
        for (int i=0; i<expected.length; i++) {
            assertNotNull(expected[i]);
        }
    }

    @Test
    void getIndexes() {
        Integer[] expected = ex1.getIndexes();
        boolean actual = true;
        for (int i=0; i<array1.length; i++) {
            if (expected[i] > array1.length) {
                actual = false;
            }
        }
        assertTrue(actual);
    }

    @Test
    void printArray2() {
        int expected = ex1.printArray(array1); // те, що очікується від виконання методу
        int actual = 0; // актуальне/дійсне значення
        assertTrue(expected == actual); // процес порівняння
    }
}