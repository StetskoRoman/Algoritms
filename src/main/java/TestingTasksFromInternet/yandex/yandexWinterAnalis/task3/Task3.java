package TestingTasksFromInternet.yandex.yandexWinterAnalis.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task3 {

    public static void main(String[] args) throws IOException {
        int countLine = 0;
        int n = 0;
        int m = 0;
//        long[][] nums = new long[0][0];
        int[][] nums = new int[0][0];
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    m = Integer.parseInt(tokens[1]);
//                    nums = new long[n][m];
                    nums = new int[n][m];
                    countLine++;
                    continue;
                }

                if (countLine <= n) {

                    for (int i = 0; i < m; i++) {
//                        nums[countLine - 1][i] = Long.parseLong(tokens[i]);
                        nums[countLine - 1][i] = Integer.parseInt(tokens[i]);
                    }
                    countLine++;

                    if (countLine == n + 1) {
                        bufferedReader.close();
                        break;
                    }
                }


            }
        }

        long res = solution(nums, n, m);
        System.out.println(res);
    }

    static long solution(int[][] nums, int n, int m) {

        long[][] preSum = new long[n+1][m];

        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n+1; i++) {
                preSum[i][j] = preSum[i - 1][j] + nums[i - 1][j];
            }
        }

        long maxSum = -1;
        long minSum = Long.MIN_VALUE;

        for (int rowStart = 1; rowStart < n+1; rowStart++) {
            for (int row = rowStart; row < n+1; row++) {
                int sum = 0;
                for (int col = 0; col < n; col++) {
                    sum += preSum[row][col]
                            - preSum[rowStart - 1][col];
                    if (sum < 0) {
                        if (minSum < sum) {
                            minSum = sum;

                        }
                        sum = 0;
                    } else if (maxSum < sum) {
                        maxSum = sum;

                    }
                }
            }
        }

        if (maxSum == -1) {

            maxSum = 0;
        }

        return maxSum;
    }
}

//        System.out.println("before final ");
//        for (int i = 0; i < n; i++) {
//            System.out.println();
//            for (int j = 0; j < m; j++) {
//                System.out.print(nums[i][j]+" ");
//            }
//        }


// for (int i = 0; i < n+1; i++) {
//        System.out.println();
//        for (int j = 0; j < m; j++) {
//        System.out.print(preSum[i][j]+ " ");
//
//        }
//        }

//        long[] tempSum = new long[n + 1];
//        for (int i = 0; i < tempSum.length; i++) {
//            for (int j = 0; j < m; j++) {
//                tempSum[i] += preSum[i][j];
//            }
//        }
//
//        System.out.println("temp sum = " + Arrays.toString(tempSum));
//        OptionalLong result = Arrays.stream(tempSum).max();
//        System.out.println(result);
