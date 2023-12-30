package TestingTasksFromInternet.yandex.yandexWinterAnalis.task2;

import java.util.Scanner;

public class testEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(-1);
                break;
            }
            nums[i] = i + 1;
            System.out.print(nums[i] + " ");
        }
    }
}
