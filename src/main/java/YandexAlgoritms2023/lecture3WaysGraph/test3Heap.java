package YandexAlgoritms2023.lecture3WaysGraph;

import java.util.*;

public class test3Heap {

    public static void main(String[] args) {

        Queue<Integer> list = new PriorityQueue<>();

        list.add(2);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(1);
        System.out.println(list);
        System.out.println(list.peek());
        System.out.println(list);

        list.add(6);

        int n = 5;
//        Queue<List<Integer>> queueMatrix = new PriorityQueue<>();
//        for (int i = 0; i < n; i++) {
//            List<Integer> list1 = new ArrayList<>();
//            list.add(Integer.MAX_VALUE);
//            list.add(i);
//
//            queueMatrix.add(list1);
//        }

        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(2);
        queue.add(3);
        queue.add(5);
        queue.add(3);
        queue.add(1);
        System.out.println(queue);
        long startTime1 = System.nanoTime();



        System.out.println(queue.peek());
        long endTime1 = System.nanoTime();
        long duration = (endTime1 - startTime1);
        System.out.println("sout dur " + duration);
        System.out.println(queue);

        queue.remove(1);
        System.out.println(queue);


    }
}
