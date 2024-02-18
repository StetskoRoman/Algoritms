package TestingTasksFromInternet.realInterviewTasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static TestingTasksFromInternet.realInterviewTasks.CoinsTask.minCoinsCounter;

public class CoinsTaskTest {


    @Test
    public void count1() {
        Assertions.assertEquals(4, minCoinsCounter(new int[]{1,3, 12}, 10));
    }

    @Test
    public void countPodvoh() {
        Assertions.assertEquals(3, minCoinsCounter(new int[]{1,4, 5}, 13));
    }

}