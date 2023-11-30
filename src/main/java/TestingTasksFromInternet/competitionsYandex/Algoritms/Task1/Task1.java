package TestingTasksFromInternet.competitionsYandex.Algoritms.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) throws IOException {

        int countS = 0;
        int n = 0;
        int[] nums = new int[0];

        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in)) {

            String line;

            while ((line = buffer.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countS == 0) {
                    n = Integer.parseInt(tokens[0]);
                    countS++;
                    continue;
                }

                nums = new int[n];
                for (int i = 0; i < tokens.length; i++) {
                    nums[i] = Integer.parseInt(tokens[i]);
                }
                break;
            }
        }

        System.out.println(n);
        System.out.println(Arrays.toString(nums));
    }

    public static int countBeauty(int[] nums) {

        int current = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == current) {

            }
        }

        return 0;
    }

}
