package YandexAlgoritms2023.lecture1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Task1 {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        long[] nums = new long[0];
        long x = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;


            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    nums = new long[n];
                    countLine++;
                    continue;
                }

                if (countLine == 1) {
                    for (int i = 0; i < n; i++) {
                        nums[i] = Long.parseLong(tokens[i]);
                    }
                    countLine++;
                    continue;
                }

                if (countLine == 2) {
                    x = Long.parseLong(tokens[0]);
                    break;
                }
            }
        }

        int left = sortPartition(x, nums);
        int ost = nums.length - left;

        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println(left);
        printWriter.println(ost);
        printWriter.flush();

    }

    static int sortPartition(long x, long[] nums) {

        int left = 0;
        int right = nums.length - 1;

        int predicate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                predicate = i;
                break;
            }
        }
        long[] resultNums = new long[nums.length];
        resultNums[0] = nums[predicate];

        for (int i = 0; i < resultNums.length; i++) {

            if (nums[i] < x) {
                resultNums[left + 1] = x;
                resultNums[left] = nums[i];
                left++;
                continue;
            }
            if (nums[i] > x) {
                resultNums[right] = nums[i];
                right--;

            }
        }

        return left;
    }
}
