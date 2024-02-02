package TestingTasksFromInternet.yandex.coderun;

import java.util.Arrays;
import java.util.Scanner;

public class Task5Cafe {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        int result = solution(nums);
        System.out.println(result);
    }

    private static int solution(int[] nums) {

        int[] dinners = new int[nums.length];
        System.arraycopy(nums, 0, dinners, 0, nums.length);

        int talons = 0;
        int amountForTalon = 100;
        int currentPos = 0;
        int currSumForTalon = 0;
        int usedTalons = 0;


        while (currentPos < nums.length) {

            currSumForTalon += dinners[currentPos];

            if (currSumForTalon >= amountForTalon) {
                talons += currSumForTalon/amountForTalon;
                if (currentPos + 1 < dinners.length) {
                    while (talons > 0) {
                        if (currentPos + 1 < dinners.length) {
                            int mostExpensiveDinnerPos = findMaxInPart(dinners, currentPos + 1);
                            dinners[mostExpensiveDinnerPos] = 0;
                            currSumForTalon -= amountForTalon;
                            talons--;
                            currentPos++;
                            usedTalons++;
                        }
                    }
                }
            }
            currentPos++;
        }

        int sumDinners = Arrays.stream(dinners).sum();

        return sumDinners;
    }

    private static int findMaxInPart(int[] nums, int pos) {

        int max = Integer.MIN_VALUE;
        int maxPos = 0;
        for (int i = pos; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxPos = i;
            }
        }

        return maxPos;
    }
}

//     System.out.println(Arrays.toString(nums));

//    int[] res = new int[2];