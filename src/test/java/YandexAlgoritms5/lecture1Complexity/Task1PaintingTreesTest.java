package YandexAlgoritms5.lecture1Complexity;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static YandexAlgoritms5.lecture1Complexity.Task1PaintingTrees.countIntersection;
public class Task1PaintingTreesTest extends TestCase {

    @Test
    public void testCountIntersection1() {
        Assertions.assertEquals(25, countIntersection(0,7,12,5));
    }

    @Test
    public void testCountIntersection0() {
        Assertions.assertEquals(1, countIntersection(0,0,0,0));
    }

    @Test
    public void testCountIntersectionWithoutIntersection() {
        Assertions.assertEquals(26, countIntersection(0,7,112,5));
    }

    @Test
    public void test1_2() {
        Assertions.assertEquals(2, countIntersection(0,0,1,1));
    }

    @Test
    public void testNegativeOnly() {
        Assertions.assertEquals(6, countIntersection(-5,2,-1,0));
    }

    @Test
    public void testNegativeAndPositiveEqual() {
        Assertions.assertEquals(5, countIntersection(1,1,-1,1));
    }

    @Test
    public void testNegativeAndPositiveEqual2() {
        Assertions.assertEquals(5, countIntersection(-1,1, 1, 1));
    }
}