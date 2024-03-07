package YandexAlgoritms5.lecture1Complexity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static YandexAlgoritms5.lecture1Complexity.Task6VowelTemplate.*;

class Task6VowelTemplateTest {



    @Test
    void test1() {
        long[] arr = {5, 7, 2};
        assertEquals(0,posWhereX(arr));
    }

}