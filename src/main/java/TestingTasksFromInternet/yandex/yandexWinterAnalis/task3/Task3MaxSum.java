package TestingTasksFromInternet.yandex.yandexWinterAnalis.task3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Task3MaxSum {


    // Function to find maximum sum rectangular
    // submatrix
    private static long maxSumRectangle(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int preSum[][] = new int[m + 1][n];

        for (int i = 0; i < m; i++) {
            System.out.println(" presum ");
            for (int j = 0; j < n; j++) {
                preSum[i + 1][j] = preSum[i][j] + mat[i][j];
                System.out.print(preSum[i+1][j] + " ");
            }
        }


        int maxSum = -1;
        int minSum = Integer.MIN_VALUE;
        int negRow = 0, negCol = 0;
        int rStart = 0, rEnd = 0, cStart = 0, cEnd = 0;
        for (int rowStart = 0; rowStart < m; rowStart++) {
            for (int row = rowStart; row < m; row++) {
                int sum = 0;
                int curColStart = 0;
                for (int col = 0; col < n; col++) {
                    sum += preSum[row + 1][col]
                            - preSum[rowStart][col];
                    if (sum < 0) {
                        if (minSum < sum) {
                            minSum = sum;
                            negRow = row;
                            negCol = col;
                        }
                        sum = 0;
                        curColStart = col + 1;
                    } else if (maxSum < sum) {
                        maxSum = sum;
                        rStart = rowStart;
                        rEnd = row;
                        cStart = curColStart;
                        cEnd = col;
                    }
                }
            }
        }

        // Printing final values
//        if (maxSum == -1) {
//            System.out.println("from row - " + negRow
//                    + " to row - " + negRow);
//            System.out.println("from col - " + negCol
//                    + " to col - " + negCol);
//        } else {
//            System.out.println("from row - " + rStart
//                    + " to row - " + rEnd);
//            System.out.println("from col - " + cStart
//                    + " to col - " + cEnd);
//        }
        return (long) maxSum == -1 ? minSum : maxSum;
    }

    // Driver Code
    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        int m = 0;
        int[][] nums = new int[0][0];

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    m = Integer.parseInt(tokens[1]);
                    nums = new int[n][m];
                    countLine++;
                    continue;
                }

                if (countLine <= n) {

                    for (int i = 0; i < n; i++) {
                        nums[countLine-1][i] = Integer.parseInt(tokens[i]);
                    }
                    countLine++;

                    if (countLine == n+1) {
                        break;
                    }
                }

            }
        }

//        for (int i = 0; i < nums.length; i++) {
//            System.out.println();
//            for (int j = 0; j < nums[i].length; j++) {
//                System.out.print(nums[i][j] + " ");
//            }
//        }

//        int arr[][] = new int[][]{{1, 2, -1, -4, -20},
//                {-8, -3, 4, 2, 1},
//                {3, 8, 10, 1, 3},
//                {-4, -1, 1, 7, -6}};

        // Function call
        System.out.println(maxSumRectangle(nums));
    }
}
