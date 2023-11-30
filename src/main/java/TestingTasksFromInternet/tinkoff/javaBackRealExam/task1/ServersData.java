package TestingTasksFromInternet.tinkoff.javaBackRealExam.task1;

import java.util.Scanner;

public class ServersData {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextByte();
        int n = scanner.nextInt();
        scanner.close();
        int[] a = new int[s];
        for (int i = 0; i < s; i++) {
            a[i] = i + 1;
        }

        System.out.println(flowsByHands(n, a));
    }

    public static int flowsByHands(int n, int[] a) {
        while (n > 0) {
            for (int i = a.length - 1; i >= 0; i--) {
                if (n == 0) {
                    return 0;
                }
                if (a[i] > n) {
                    return n;
                }
                if (a[i] <= n) {
                    n -= a[i];
                }

            }
        }

        return n;
    }
}
