package TestingTasksFromInternet.yandex.yandexWinterAnalis.task3;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < m; j++) {
                nums[i][j] = (int) ((-i - j) + Math.random() * 2*(i + j) + 1);
                System.out.print(nums[i][j] + " ");
            }

        }
    }
}
