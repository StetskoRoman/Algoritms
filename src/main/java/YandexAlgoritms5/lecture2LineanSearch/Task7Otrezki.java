package YandexAlgoritms5.lecture2LineanSearch;
/**
 * Переборыч, [13.03.2024 22:44]
 * Нужно порезать массив на кусочки без изменения порядка. При этом единички могут впихнуться только в кусочек единичной длины. Двойка в кусочек длиной 2 и т.п.
 * А вот число 100500 может жить в любом меньшем кусочке.
 *
 * Переборыч, [13.03.2024 22:45]
 * Задача: разрезать на как можно меньше таких кусочков (сделать их максимально возможной длины), и чтобы все влезли.
 * Ответы в примере соответствуют разбиениям:
 *
 * {[1], [3, 3], [3, 2]}
 *
 * {[1], [9, 8, 7, 6, 7, 8], [9, 9, 9, 9, 9, 9, 9, 9, 9]}
 *
 * {[7, 2], [3, 4, 3], [2, 7]}
 *
 * В первом наборе тестовых данных набор длин {1, 3, 1}, соответствующий разбиению {[1], [3, 3, 3], [2]}, также был бы корректным.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Task7Otrezki {
    public static void main(String[] args) throws IOException {

        int countLine = 1;
        int t = 0;
        List<int[]> list = new ArrayList<>();
        int[] a = new int[0];
        int n = 0;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String[] tokens = line.split(" ");

            if (countLine == 1) {
                t = Integer.parseInt(tokens[0]);
                countLine++;
                continue;
            }

            if (countLine % 2 == 0) {
                n = Integer.parseInt(tokens[0]);
                countLine++;
                continue;

            }

            if (countLine % 2 == 1) {
                a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = Integer.parseInt(tokens[i]);
                }
                list.add(a);
                countLine++;
                if (countLine == t * 2 + 2) {
                    break;
                }
                continue;
            }

        }
        bufferedReader.close();

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(Arrays.toString(list.get(i)));
//        }

        List<List<Integer>> res = solution(list);
        PrintWriter printWriter = new PrintWriter(System.out);
        for (int i = 0; i < res.size(); i++) {
            printWriter.println(res.get(i).size());
            for (int j = 0; j < res.get(i).size(); j++) {
                printWriter.print(res.get(i).get(j) + " ");
            }
            printWriter.println();
        }
        printWriter.flush();

    }

    static List<Integer> countArray(int[] array) {
        List<Integer> list = new ArrayList<>();

        int pos = 0;
        int willAddToArray = 0;
        int countOtrez = 0;
        int min = 0;
        while (pos < array.length) {
            if (willAddToArray == 0) {
                min = array[pos];
            }

            if (array[pos] > willAddToArray && array[pos] <= min && min > willAddToArray) {
                min = array[pos];
                willAddToArray++;
                pos++;
                continue;
            }

            if (array[pos] > willAddToArray && min > willAddToArray) {
                willAddToArray++;
                pos++;
                continue;
            }

            list.add(willAddToArray);
            willAddToArray = 0;
        }

        list.add(willAddToArray);

//        System.out.println(list);

        return list;
    }

    static List<List<Integer>> solution(List<int[]> list) {

        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            resList.add(countArray(list.get(i)));
        }
        return resList;
    }
}
