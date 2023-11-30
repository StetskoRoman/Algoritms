package TestingTasksFromInternet.tinkoff.fakeExamen;

import java.util.Scanner;

public class Sum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int sum = a + b;
        System.out.println(sum);

        System.out.println(sum(5,7));
    }

    public int summa(int a, int b) {
        return a + b;
    }

    public static int sum(int a, int b) {
        Sum sum = new Sum();
        return sum.summa(a, b);
    }
}
