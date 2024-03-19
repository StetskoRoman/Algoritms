package YandexAlgoritms5.lecture3Set;

/**
 * Найти все песни которые у каждого члена любимые
 * 2
 * 2
 * Love Life
 * 2
 * Life GoodDay
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class Task1 {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        int k = 0;
        int[] a = new int[0];
        List<List<String>> list = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String[] tokens = line.split(" ");

            if (countLine == 0) {
                n = Integer.parseInt(tokens[0]);
                countLine++;
                continue;
            }

            if (countLine % 2 == 1) {
                k = Integer.parseInt(tokens[0]);
                countLine++;
                continue;
            }
            if (countLine % 2 == 0) {
                List<String> stringList = new ArrayList<>();
                for (int i = 0; i < k; i++) {
                    stringList.add(tokens[i]);
                }
                list.add(stringList);
                countLine++;
                if (countLine == n * 2 + 1) {
                    break;
                }
                continue;
            }
        }
        bufferedReader.close();

        Set<String> res = solution(list);
        System.out.println(res.size());
        PrintWriter printWriter = new PrintWriter(System.out);
        for (String str : res) {
            printWriter.print(str + " ");
        }
        printWriter.flush();

    }

    public static Set<String> solution(List<List<String>> list) {

        Set<String> res = new TreeSet<>();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                String x = list.get(i).get(j);
                if (map.containsKey(x)) {
                    map.put(x, map.get(x) + 1);
                } else {
                    map.put(x, 1);
                }
            }
        }

        int size = list.size();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == size) {
                res.add(entry.getKey());
                continue;
            }
        }

        return res;
    }
}
