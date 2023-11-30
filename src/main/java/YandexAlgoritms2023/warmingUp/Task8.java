package YandexAlgoritms2023.warmingUp;

import java.util.Scanner;

public class Task8 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.close();

        System.out.println(solution(a, b, n));
    }

    public static String solution(int a, int b, int n) {

        double minB = (double) b / (double) n;
        int roundB = (int) Math.ceil(minB);

        if (a > roundB) {
            return "Yes";
        } else {
            return "No";
        }

    }
}
