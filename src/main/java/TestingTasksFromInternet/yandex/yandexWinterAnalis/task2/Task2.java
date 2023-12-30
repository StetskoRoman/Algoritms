package TestingTasksFromInternet.yandex.yandexWinterAnalis.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task2 {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        int[] nums = new int[0];
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
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
                    break;
                }
            }
        }

        System.out.println(solution(nums));

    }


    static String solution(int[] nums) {
        if (nums[0] == -1) {
            return "NO";
        }
        Set<Integer> set = new LinkedHashSet<>();
        set.add(0);
        int k = 0;
        int count = 0;
        List<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            visited.add(i, false);
        }
        visited.set(0, true);
        int countCicle = 0;
        while (true) {
            countCicle++;
            System.out.println(countCicle);
//            System.out.println("visited = " + visited +"   k = " + k);
//            System.out.println("set = " + set);

            if (count == nums.length) {
                break;
            }

            if (nums[k] == -1) {
                set.clear();
                for (int i = 0; i < visited.size(); i++) {
                    if (visited.get(i) == false) {
                        k = i;
                        visited.set(k, true);
                        set.add(k);
                        count++;
                        break;
                    }
                }
                continue;
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[k] == i) {

                    if (set.contains(i)) {
                        return "YES";
                    }
                    set.add(i);
                    visited.set(i, true);
                    count++;
                    k = i;
                    break;
                }
            }
        }

        return "NO";
    }
}

// for (int i = 0; i < nums.length; i++) {
//        if (set.contains(nums[k])) {
//        return "YES";
//        }
//        if (nums[i] == nums[k]) {
//        k = nums[i];
//        set.add(k);
//        }
//
//        }

//            set.add(i);
//            if (set.contains(nums[i]) && set.contains(i)) {
//
//                return "YES";
//            }
//            if (nums[i] == -1) {
//                continue;
//            }