package TestingTasksFromInternet.tinkoff.javaBackRealExam.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ErrorsCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[][] sections = new int[m][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                sections[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        List<String> strings = new ArrayList<>();

        int k = 0;
        while (k < sections.length) {

            if (sections[k][1] - sections[k][0] < 2) {
                strings.add("Yes");
                k++;
                continue;
            }

            int bendPoint = 0;
            for (int i = sections[k][0]; i < (sections[k][1] - 1); i++) {
                if (a[i] > a[i - 1]) {
                    continue;
                }
                if (a[i] < a[i - 1]) {
                    bendPoint = i - 1;
                    break;
                }
            }

            boolean isFailure = true;
            for (int i = (bendPoint + 1); i < sections[k][1]; i++) {

                if (a[i] < a[i - 1]) {
                    isFailure = true;
                }
                if (a[i] > a[i - 1]) {
                    isFailure = false;

                }
            }

            if (isFailure) {
                strings.add("Yes");
                k++;
            } else {
                strings.add("No");
                k++;
            }
        }

        printResultList(strings);
    }

    public static void printResultList(List<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
    }
}

//System.out.println(strings);
//
//        System.out.println();
//        System.out.println(n);
//        System.out.println(Arrays.toString(a));
//        System.out.println(m);
//        for (int i = 0; i < sections.length; i++) {
//        for (int j = 0; j < 2; j++) {
////                System.out.println(sections[i][j]);


//            System.out.println("k at the beginning = " + k);