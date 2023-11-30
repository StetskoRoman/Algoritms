package TestingTasksFromInternet.tinkoff.Summer2023;

import java.util.Arrays;
import java.util.Scanner;

public class RasumOtrezki5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }



        System.out.println(n);
        System.out.println(Arrays.toString(numbers));
    }
}
