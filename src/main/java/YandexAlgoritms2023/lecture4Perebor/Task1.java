package YandexAlgoritms2023.lecture4Perebor;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int[] matrix = inMatrix(num);

//        System.out.println(iterations(matrix));
        List<Long> resultList = iterations(matrix);
        PrintWriter printWriter = new PrintWriter(System.out);
        for (Long number : resultList) {
            printWriter.println(number);
        }
        printWriter.flush();
    }

    static List<Long> iterations(int[] matrix) {

        List<Long> list = new ArrayList<>();

        int n = matrix.length;
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = 0;
        }

        list.add(convertToNumber(matrix));

        int i = 0;
        while (i < n) {
            if (indexes[i] < i) {
                swap(matrix, i % 2 == 0 ? 0 : indexes[i], i);
                list.add(convertToNumber(matrix));
                indexes[i]++;
                i = 0;
            } else {
                indexes[i] = 0;
                i++;
            }
        }
        Collections.sort(list);
        return list;
    }

    static int fact(int n) {
        int resFact = 1;
        for (int i = n; i > 0; i--) {
            resFact = resFact * i;
        }
        return resFact;
    }

    static int[] inMatrix(int n) {
        int[] matrix = new int[n];
        for (int i = 0; i < n; i++) {
            matrix[i] = i + 1;
        }
        return matrix;
    }

    private static void swap(int[] matrix, int a, int b) {
        int tmp = matrix[a];
        matrix[a] = matrix[b];
        matrix[b] = tmp;
    }

    private static long convertToNumber(int[] matrix) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < matrix.length; i++) {
            stringBuilder.append(matrix[i]);
        }
        String str = String.valueOf(stringBuilder);
        long res = Long.parseLong(str);

        return res;
    }
}

//развернуть надо
//    static void iterations(int[] matrix) {
//        int n = matrix.length;
//        int[] indexes = new int[n];
//        for (int i = 0; i < n; i++) {
//            indexes[i] = 0;
//        }
//
//        printArray(matrix);
//
//        int i = 0;
//        while (i < n) {
//            if (indexes[i] < i) {
//                swap(matrix, i % 2 == 0 ?  0: indexes[i], i);
//                printArray(matrix);
//                indexes[i]++;
//                i = 0;
//            }
//            else {
//                indexes[i] = 0;
//                i++;
//            }
//        }
//    }