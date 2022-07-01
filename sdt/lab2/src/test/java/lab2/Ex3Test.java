package lab2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class Ex3Test {

    Ex3 ex3;
    String[] array1 = new String[]{"15.5", "-44", "18.3", "12.1", "0.", "-1", "-78.23"};

    @BeforeEach
    void setUp() {
        ex3 = new Ex3(array1);
    }

    @AfterEach
    void tearDown() {
        System.err.println("Correct!");
    }

    @Test
    void printArray() {
        int expected = ex3.printArray(array1); // те, що очікується від виконання методу
        int actual = 0; // актуальне/дійсне значення
        assertTrue(expected == actual); // процес порівняння
    }

    @Test
    void array1Check() {
        boolean expected = ex3.array1Check(array1);
        boolean actual = true; // очікуване значення, яке ми можемо передбачити
        assertTrue(expected==actual);
    }

    @Test
    void growingCheck() {
        boolean expected = ex3.growingCheck();
        boolean actual = true; // очікуване значення, яке ми можемо передбачити
        assertNotNull(expected==actual);
    }

    @Test
    void decreasingCheck() {
        boolean expected = ex3.decreasingCheck();
        boolean actual = true; // очікуване значення, яке ми можемо передбачити
        assertNotNull(expected==actual);
    }

}