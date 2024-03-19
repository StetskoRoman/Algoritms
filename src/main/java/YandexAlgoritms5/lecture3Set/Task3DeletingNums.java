package YandexAlgoritms5.lecture3Set;
/**
 * Найдите минимальное количество чисел, после удаления которых попарная разность оставшихся чисел по модулю не будет превышать
 * то есть после удаления ни одно число не должно отличаться от какого-либо другого более чем на
 * 10
 * 1 1 2 3 5 5 2 2 1 5
 * otvet 4
 * 2 HashSet надо, если TreeSet 1 сделать то не прокатывает + BufferedReader ввод тоже обязательно
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task3DeletingNums {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        int k = 0;
        int[] nums = new int[0];

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String[] tokens = line.split(" ");

            if (countLine == 0) {
                n = Integer.parseInt(tokens[0]);
                nums = new int[n];
                countLine++;
                continue;
            }

            if (countLine == 1) {
                for (int i = 0; i < n; i++) {
                    nums[i] = Integer.parseInt(tokens[i]);
                }
                countLine++;
                if (countLine == 2) {
                    break;
                }
            }

        }
        bufferedReader.close();

        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {

        Map<Integer, Integer> map1 = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer x = nums[i];
            if (map1.containsKey(x)) {
                map1.put(x, map1.get(x) + 1);
            } else {
                map1.put(x, 1);
            }
        }
//        System.out.println("map1 = " + map1);

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
//            System.out.println(entry + "  next Value " + map1.get(entry.getKey() + 1));
            if (entry.getValue() > count) {
                count = entry.getValue();
            }

            if (map1.get(entry.getKey() + 1) != null) {

                    if (entry.getValue() + map1.get(entry.getKey() + 1) > count) {
                        count = entry.getValue() + map1.get(entry.getKey() + 1);
                        map.put(entry.getKey(), entry.getValue() + map1.get(entry.getKey() + 1));

                    } else {
                        map.put(entry.getKey(), entry.getValue());
                        continue;
                    }

            } else map.put(entry.getKey(), entry.getValue());

        }
//        System.out.println(map + " flag = " + flag);

        return nums.length - count;
    }
}
