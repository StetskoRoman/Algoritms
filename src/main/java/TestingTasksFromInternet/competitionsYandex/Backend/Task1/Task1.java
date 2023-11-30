package TestingTasksFromInternet.competitionsYandex.Backend.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

//less fast and   better memory  -24 tests
public class Task1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string1 = br.readLine();
        String string2 = br.readLine();
        br.close();

        String[] str1 = string1.split(" ");
        String[] str2 = string2.split(" ");
        int n = Integer.parseInt(str1[0]);
        int m = Integer.parseInt(str1[1]);
        int[] nums = new int[str2.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(str2[i]);
        }

        long result = solution(nums);

        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.print(result);
        printWriter.flush();
    }

    public static long solution(int[] nums) {

        long sum = 0L;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                sum += nums[i] * nums[i];
                if (i + 1 < nums.length) {
                    int count = 0;
                    for (int j = i + 1; j < nums.length; j++) {
                        if (count < nums[i] && nums[j] != 0) {
                            sum += nums[j];
                            count++;

                        }
                    }
                }
            }
        }

        return sum;
    }
}
