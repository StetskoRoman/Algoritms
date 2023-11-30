package TestingTasksFromInternet.tinkoff.Summer2023;

import java.util.Scanner;

public class Rost1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] h = new int[4];
        for (int i = 0; i < h.length; i++) {
            h[i] = scanner.nextInt();
        }
        boolean res = isRightOrder(h);

        if (res) System.out.println("YES");
        else System.out.println("NO");
    }

    public static boolean isRightOrder(int[] nums) {
        boolean result = false;
        int deltaPlus = 0;
        int deltaMinus = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i - 1] > nums[i]) {
                deltaPlus = nums[i - 1] - nums[i];
            } else if (nums[i - 1] < nums[i]) {
                deltaMinus = nums[i - 1] - nums[i];
            }
        }
        if (deltaPlus != 0 && deltaMinus != 0) {
            return false;
        }
        return true;
    }
}
