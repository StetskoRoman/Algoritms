package YandexAlgoritms5.lecture3Set;
/**
 * Требуется определить, повторялась ли какое-либо число, причём расстояние между повторами не превосходило k.
 * 6 2
 * 1 2 3 1 2 3
 * Otv NO
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task4Repeat {

    public static void main(String[] args) throws IOException {
        int countLine = 0;
        int n = 0;
        int k = 0;
        int[] a = new int[0];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String[] tokens = line.split(" ");

            if (countLine == 0) {
                n = Integer.parseInt(tokens[0]);
                k = Integer.parseInt(tokens[1]);
                a = new int[n];
                countLine++;
                continue;
            }

            if (countLine == 1) {

                for (int i = 0; i < n; i++) {
                    a[i] = (Integer.valueOf(tokens[i]));
                }

                countLine++;
                if (countLine == 2) {
                    break;
                }
                continue;
            }
        }
        bufferedReader.close();

        System.out.println(solution(a, k));
    }

    static String solution(int[] a, int k) {
        int point = 0;
        if (k > a.length) {
            k = a.length - 1;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++) {
            if (!set.contains(a[i])) {
                set.add(a[i]);
            } else return "YES";
        }

        while (point < a.length-k) {
            if (!set.contains(a[point + k])) {
                set.remove(a[point]);
                set.add(a[point + k]);
            } else return "YES";
            point++;
        }

        return "NO";
    }
}
//    static String solution(int[] a, int k) {
//
//        Deque<Integer> deque = new ArrayDeque<>();
//        for (int i = 0; i < k; i++) {
//            if (!deque.contains(a[i])) {
//                deque.addLast(a[i]);
//            } else return "YES";
//
//        }
//
//        int pos = 0;
//        for (int i = 0; i < a.length - k; i++) {
//
////            System.out.println("a[i] = " + a[i] + "   k = " + k);
//
//            if (!deque.contains(a[i + k])) {
//                deque.addLast(a[i + k]);
//                deque.removeFirst();
//            } else return "YES";
//        }
//        return "NO";
//
//    }

