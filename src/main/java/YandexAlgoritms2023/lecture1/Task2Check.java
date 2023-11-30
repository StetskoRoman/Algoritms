package YandexAlgoritms2023.lecture1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class Task2Check {

    public static void main(String[] args) throws IOException {
        int countLine = 0;
        int n = 0;
        int[] nums = new int[0];
        long x = 0;


        PrintWriter printWriter = new PrintWriter(System.out);


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

        int [] res = Arrays.stream(nums).sorted().toArray();

        for (int i = 0; i < nums.length; i++) {
            printWriter.print(res[i] + " ");

        }
        printWriter.flush();
    }
}
