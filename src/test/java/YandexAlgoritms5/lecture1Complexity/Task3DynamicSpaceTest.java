package YandexAlgoritms5.lecture1Complexity;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static YandexAlgoritms5.lecture1Complexity.Task3DynamicSpace.*;

public class Task3DynamicSpaceTest extends TestCase {

    private static int[] db = {0, 1, 2, 2, 1};
    @Test
    public void test1() {
        Assertions.assertEquals(8, findMinMotions(new int[]{1,4,12,9,0},db));
    }
    @Test
    public void test0() {
        Assertions.assertEquals(0, findMinMotions(new int[]{0},db));
    }
    @Test
    public void testMany0() {
        Assertions.assertEquals(0, findMinMotions(new int[]{0,0,0,0,0},db));
    }
    @Test
    public void testAllCases() {
        Assertions.assertEquals(8, findMinMotions(new int[]{0,1,2,3,4,5},db));
    }



    public void testCountMotion() {
    }
}