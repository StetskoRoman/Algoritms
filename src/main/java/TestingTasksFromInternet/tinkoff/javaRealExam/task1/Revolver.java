package TestingTasksFromInternet.tinkoff.javaRealExam.task1;

import java.util.Arrays;
import java.util.Scanner;

public class Revolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(findMaxPriceYouCanBuy(a, s));
    }

    public static int findMaxPriceYouCanBuy(int[] a, int s) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= s && a[i] > result) {
                result = a[i];
            }
        }
        return result;
    }
}
