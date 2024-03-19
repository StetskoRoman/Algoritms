package YandexAlgoritms5.lecture3Set;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static YandexAlgoritms5.lecture3Set.Task3DeletingNums.*;

class Task3DeletingNumsTest {

    @Test
    void test2() {
        assertEquals(4, solution(new int[]{1, 1, 2, 3, 5, 5, 2, 2, 1, 5}));
    }
    @Test
    void test3() {
        assertEquals(0,solution(new int[]{33292}));
    }

    @Test
    void test1_3_5() {
        assertEquals(2,solution(new int[]{1,3,5}));
    }

    @Test
    void test1_2() {
        assertEquals(0,solution(new int[]{1,2}));
    }

//    @Test
//    void test8() {
//        assertEquals(900,solution(new int[]{1,2}));
//    }



}