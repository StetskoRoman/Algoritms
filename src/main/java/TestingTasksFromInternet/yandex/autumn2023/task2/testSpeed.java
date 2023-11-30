package TestingTasksFromInternet.yandex.autumn2023.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Integer - 3600-4600 Long the same
//String - 3600
public class testSpeed {

    public static void main(String[] args) {

        long startTime = System.nanoTime();

        List<String> integers = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            integers.add(String.valueOf(i));
        }
        System.out.println(integers);



        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000;
        System.out.println("sout dur " + duration);
    }


//    1800 - 2400
//    public static void main(String[] args) {
//
//        long startTime = System.nanoTime();
//
//        int [] integers = new int[1000];
//        for (int i = 0; i < integers.length; i++) {
//            integers[i] = i;
//        }
//        System.out.println(Arrays.toString(integers));
//
//
//
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime)/1000;
//        System.out.println("sout dur " + duration);
//    }
}
