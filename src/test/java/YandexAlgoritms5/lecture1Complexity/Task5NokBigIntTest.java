package YandexAlgoritms5.lecture1Complexity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static YandexAlgoritms5.lecture1Complexity.Task5NokBigInt.*;

class Task5NokBigIntTest {

    @Test
    void countEarnTest1() {
        StringBuilder stringBuilder = countEarn(21, 108, 1);
        StringBuilder res = new StringBuilder("216");
        Assertions.assertEquals(res.toString(), stringBuilder.toString() );
    }

    @Test
    void countEarnTest2() {
        StringBuilder stringBuilder = countEarn(5, 12, 4);
        StringBuilder res = new StringBuilder("-1");
        Assertions.assertEquals(res.toString(), stringBuilder.toString() );
    }

    @Test
    void countEarnTest4() {
        StringBuilder stringBuilder = countEarn(2, 1, 3);
        StringBuilder res = new StringBuilder("2000");
        Assertions.assertEquals(res.toString(), stringBuilder.toString() );
    }
}