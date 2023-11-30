package YandexAlgoritms2023.lecture3WaysGraph;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class test1Stac {

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println();

        int[] array = {5, 4, -25, 2, 1, 5, 7, 2, 3, 5, 12, 6, -1, 15, 120, 25, -5};
        long startTime1 = System.nanoTime();
        OptionalInt min = Arrays.stream(array).min();


        int minValue = findMinIdx(array);
        System.out.println("min number is = " + minValue);
        long endTime1 = System.nanoTime();
        long duration = (endTime1 - startTime1);
        System.out.println("sout dur " + duration);

        System.out.println(min);
        long startTime2 = System.nanoTime();
        int minimum = Integer.MAX_VALUE;
        int minimumI = 0;
        int currentNumber = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minimum) {
                minimum = array[i];
                minimumI = i;
                currentNumber = array[i];
            }
        }
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime2);
        System.out.println("sout dur 2 " + duration2);



        System.out.println(min);


        System.out.println(min.getAsInt());

//        List <Integer>


    }

    public static int findMinIdx(int[] numbers) {
        OptionalInt minimun = IntStream.of(numbers).min();
        return   IntStream.of(numbers).boxed().collect(toList()).indexOf(minimun.getAsInt());
    }
}
