package TestingTasksFromInternet.yandex.yandexWinterAnalis.task2;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class test1 {

    public static void main(String[] args) {

        Set<Integer> set = new LinkedHashSet<>();
        String abba = "abba";
        for (int i = 0; i < abba.length(); i++) {

        }
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {

        }
        Integer[] arr2 = new Integer[5];
        for (int i = 0; i < arr2.length; i++) {

        }
        set.add(1);
        set.add(5);
        set.add(3);
        System.out.println(set);
        set.add(3);
        System.out.println(set);
        System.out.println(set.contains(3));

        Set<Integer> set2 = new HashSet<>();
        set2.add(12);
        set2.add(16);
        set2.add(21);
        System.out.println(set2);
        System.out.println(set2.contains(16));
    }
}
