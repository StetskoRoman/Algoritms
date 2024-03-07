package YandexAlgoritms5.lecture1Complexity;

import org.junit.jupiter.api.Test;

import static YandexAlgoritms5.lecture1Complexity.Task7Strategy.*;
import static org.junit.jupiter.api.Assertions.*;

class Task7StrategyTest {

    @Test
    void test13() {
        assertEquals(6, giveResult(250,500,0,218,0));
    }

    @Test
    void test39() {
        assertEquals(101, giveResult(250,500,0,249,0));
    }
    @Test
    void test15() {
        assertEquals(7, giveResult(250,500,0,225,0));
    }
    @Test
    void test8() {
        assertEquals(4, giveResult(250,500,0,126,0));
    }
    @Test
    void test9() {
        assertEquals(4, giveResult(250,500,0,187,0));
    }

}
