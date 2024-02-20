package TestingTasksFromInternet.realInterviewTasks;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static TestingTasksFromInternet.realInterviewTasks.BiggestPodStroka.*;

public class BiggestPodStrokaTest {

    @Test
    void testSameLiterals() {
        Assertions.assertEquals(1, biggestSubstring("aaaaaaaa"));
    }

    @Test
    void testAllDifferentLiterals() {
        Assertions.assertEquals(10, biggestSubstring("abcdefghij"));
    }

    @Test
    void testRandomString1() {
        Assertions.assertEquals(6, biggestSubstring("abcabcqwe"));
    }

    @Test
    void exceptionEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, ()->biggestSubstring(""));
    }
}