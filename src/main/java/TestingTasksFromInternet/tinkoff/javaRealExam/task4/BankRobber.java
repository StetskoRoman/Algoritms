package TestingTasksFromInternet.tinkoff.javaRealExam.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankRobber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[m * 2];
        for (int i = 0; i < a.length; i += 2) {
            a[i] = scanner.nextInt();
            a[i + 1] = a[i];
        }

        List<Integer> initialList = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            initialList.add(a[i]);
        }

        if (countSumOfArray(initialList) < n) {
            System.out.println(-1);
            return;
        }

        List<Integer> resultList = new ArrayList<>();
        int delta = 0;
        int right = initialList.size() - 1;
        int left = 0;

        while (countSumOfArray(resultList) != n) {

            delta = n - countSumOfArray(resultList);

            if (initialList.contains(delta)) {
                System.out.println("vihoju");
                resultList.add(delta);
                System.out.println(countSumOfArray(resultList));
                printResultList(resultList);
                return;
            }

//            while ()
            if (countSumOfArray(resultList) < n) {
                resultList.add(initialList.get(right));
            }


        }

        System.out.println(countSumOfArray(initialList));
    }

    public static int countSumOfArray(List<Integer> list) {
        return list.stream().mapToInt(m->m).sum();
    }

    public static void printResultList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}


// if (initialList.contains(2)) {
//         initialList.remove(2);
//         }
//         System.out.println(initialList);