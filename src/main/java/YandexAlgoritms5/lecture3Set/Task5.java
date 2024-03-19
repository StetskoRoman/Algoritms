package YandexAlgoritms5.lecture3Set;
/**
 * Вам даны три списка чисел. Найдите все числа, которые встречаются хотя бы в двух из трёх списков.
 * 2
 * 3 1
 * 2
 * 1 3
 * 2
 * 1 2
 * otvet 1 3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Task5 {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;

        List<Set<Integer>> list = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String[] tokens = line.split(" ");

            if (countLine %2 == 0) {
                n = Integer.parseInt(tokens[0]);
                countLine++;
                continue;
            }

            if (countLine % 2 == 1) {
                Set<Integer> set = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    set.add(Integer.valueOf(tokens[i]));
                }
                list.add(set);
                countLine++;
                if (countLine == 6) {
                    break;
                }
                continue;
            }
        }
        bufferedReader.close();

//        System.out.println(list);

        PrintWriter printWriter = new PrintWriter(System.out);
        Set<Integer> res = solution(list);
        for (Integer integer : res) {
            printWriter.print(integer + " ");
        }
        printWriter.flush();
    }

    public static Set<Integer> solution(List<Set<Integer>> list) {

        Set<Integer> set1_2 = new HashSet<>();
        for (Integer integer : list.get(1)) {
            if (list.get(0).contains(integer)) {
                set1_2.add(integer);
            }
        }

        Set<Integer> set1_3 = new HashSet<>();
        for (Integer integer : list.get(2)) {
            if (list.get(0).contains(integer)) {
                set1_3.add(integer);
            }
        }

        Set<Integer> set2_3 = new HashSet<>();
        for (Integer integer : list.get(2)) {
            if (list.get(1).contains(integer)) {
                set2_3.add(integer);
            }
        }

        Set<Integer> resSet = new TreeSet<>();
        resSet.addAll(set1_2);
        resSet.addAll(set1_3);
        resSet.addAll(set2_3);

        return resSet;
    }
}
