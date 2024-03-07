package YandexAlgoritms5.lecture1Complexity;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static YandexAlgoritms5.lecture1Complexity.Task2Football.countGoalsNeed;
public class Task2FootballTest extends TestCase {

    @Test
    public void test1() {
        Assertions.assertEquals(1, countGoalsNeed(0, 0, 0, 0, 1));
    }
    @Test
    public void test2() {
        Assertions.assertEquals(5, countGoalsNeed(0, 2, 0, 3, 1));
    }
    @Test
    public void test3() {
        Assertions.assertEquals(6, countGoalsNeed(0, 2, 0, 3, 2));
    }

    @Test
    public void test5() {
        Assertions.assertEquals(0, countGoalsNeed(2,2,1,1,2));
    }

    @Test
    public void test20() {
        Assertions.assertEquals(0, countGoalsNeed(2,2,1,1,2));
    }

    @Test
    public void testRand1() {
        Assertions.assertEquals(3, countGoalsNeed(1,3,2,3,1));
    }

    @Test
    public void testRand2() {
        Assertions.assertEquals(2, countGoalsNeed(3,0,1,5,1));
    }

    @Test
    public void testRand22() {
        Assertions.assertEquals(2, countGoalsNeed(3,0,1,5,2));
    }

    @Test
    public void test51() {
        Assertions.assertEquals(2, countGoalsNeed(4,3,0,3,2));
    }


}