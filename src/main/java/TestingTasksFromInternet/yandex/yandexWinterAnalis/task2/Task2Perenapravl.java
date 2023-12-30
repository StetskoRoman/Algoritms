package TestingTasksFromInternet.yandex.yandexWinterAnalis.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//WA 10
public class Task2Perenapravl {

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

//        System.out.println(Arrays.toString(nums));
        System.out.println(solution(nums));

    }

    static String solution(int[] nums) {

        if (nums[0] == -1) {
            return "NO";
        }

        int k = 0;

        while (k < nums.length) {
            if (k == 0) {
                for (int i = 1; i < nums.length; i++) {
                    if (nums[k] == nums[i]) {
                        return "YES";
                    }
                }
                k++;
                continue;
            }
//            System.out.println("k = " + k + "   nums[k] = " + nums[k]);
            if (nums[k] == -1) {
//                System.out.println("here continue ");
                k++;
                continue;
            }
//            int tempI = k;
            for (int i = k+1; i < nums.length; i++) {
//                System.out.println("check nums[k] = " + nums[k] + "   s nums[i] = " + nums[i] + "  i = " + i);
//                if (i == k) {
//                    continue;
//                }

                if (k == nums[i] && nums[k] == i) {

                    return "YES";
                }
            }
            k++;
        }

        return "NO";
    }
}
