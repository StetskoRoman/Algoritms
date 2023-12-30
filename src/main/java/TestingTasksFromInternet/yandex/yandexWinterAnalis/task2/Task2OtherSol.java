package TestingTasksFromInternet.yandex.yandexWinterAnalis.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2OtherSol {

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

    public static String solution(int[] nums) {

        if (nums[0] == -1) {
            return "NO";
        }

        int k = 0;
        while (k < nums.length) {
            for (int i = 0; i < nums.length; i++) {
                if (k == i) {
                    continue;
                }
                if (nums[k] == i && nums[i] == k) {
                    return "YES";
                }
            }
            k++;
        }

        return "NO";
    }
}
