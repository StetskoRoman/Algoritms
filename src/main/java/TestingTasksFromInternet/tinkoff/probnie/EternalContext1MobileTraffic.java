package TestingTasksFromInternet.tinkoff.probnie;

import java.util.Scanner;

public class EternalContext1MobileTraffic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int sum = 0;

        if (d <= b) {
            sum = a;
            System.out.println(sum);
        } else {
            sum = a + (d - b) * c;
            System.out.println(sum);
        }
    }
}


