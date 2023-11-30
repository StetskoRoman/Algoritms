package YandexAlgoritms2023.warmingUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Task5 {

    public static void main(String[] args) throws IOException {

        int n = 0;
        int[] nums = new int[0];
        int[] result = new int[0];

        int countLine = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    countLine++;
                    continue;
                }

                if (countLine == 1) {
                    nums = new int[n];

                    for (int i = 0; i < n; i++) {
                        nums[i] = Integer.parseInt(tokens[i]);
                    }
                }
                break;
            }
        }

        result = solution(nums);
        PrintWriter printWriter = new PrintWriter(System.out);
        for (int i = 0; i < result.length; i++) {
            printWriter.print(result[i] + " ");
        }
        printWriter.flush();
    }
//скорость 2N суть
    public static int[] solution(int[] nums) {
        int counting = 0;
        int[] result = new int[nums.length];
        int sum = 0;
        int delta = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += Math.abs(nums[0] - nums[i]);
        }
        result[0] = sum;

        for (int i = 1; i < nums.length; i++) {
            delta = nums[i] - nums[i - 1];
            result[i] = sum + (delta * (i - 1)) - (delta * (nums.length - 1 - i));
            sum = result[i];
        }

        return result;
    }
}


//N*N сложность, слишком долго
//while (counting < nums.length) {
//
//        for (int i = 0; i < nums.length; i++) {
//        result[counting] += Math.abs(nums[counting] - nums[i]);
//        }
//        counting++;
//        }