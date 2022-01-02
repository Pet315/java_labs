package lab3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class Ex1Test {

    @BeforeEach
    void setUp() {
        System.err.println("Correct!");
    }

    @AfterEach
    void tearDown() {
        System.err.println("Correct!");
    }
}