package TestingTasksFromInternet.tinkoff.AlgoritmTrainingTestIn;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.println(solution(nums));
    }

    public static double solution(int[] nums) {

        double curMedium = 0;
        double sum = 0;

        for (int i = 1; i < nums.length; i++) {
            curMedium = (double)(nums[i - 1] + nums[i]) / 2;
            sum += curMedium;
        }

        double res = sum / (nums.length - 1);
        return res;
    }
}


//  System.out.println("cur medium = " + curMedium);