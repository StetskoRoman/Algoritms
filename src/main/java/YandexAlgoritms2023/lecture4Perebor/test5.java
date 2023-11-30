package YandexAlgoritms2023.lecture4Perebor;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class test5 {

    public static void main(String[] args) {

        Deque<Integer> queue = new ArrayDeque<>();
        queue.push(3);
        queue.push(5);
        queue.push(1);
        System.out.println(queue);
        System.out.println(queue.pop());
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
    }
}
