package TestingTasksFromInternet.yandex.autumn2023.task2;

import java.util.ArrayList;
import java.util.List;

public class TestArray {

    public static void main(String[] args) {

        List<Integer> A = new ArrayList<>();

        A.add(2);
        A.add(4);
        A.add(6);

        Integer b = 3;

        System.out.println(A);

        A.remove(b);
        System.out.println(A);
    }
}
