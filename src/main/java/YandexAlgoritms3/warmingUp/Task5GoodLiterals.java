package YandexAlgoritms3.warmingUp;

//Столбики букв, дано количество каждой буквы, хорошесть - значит идущая следом буква будет следующей по алфавиту

import java.util.Scanner;

public class Task5GoodLiterals {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

//        System.out.println(Arrays.toString(nums));
        System.out.println(findMaxGoodness(nums));
    }

    static long findMaxGoodness(int[] nums) {

        long res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] >= nums[i]) {
                res += nums[i];
            } else {
                res += nums[i + 1];
            }

        }
        return res;
    }
}
