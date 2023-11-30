package TestingTasksFromInternet.tinkoff.probnie;

//System.out.println(n + " " + t);
//        System.out.println(Arrays.toString(floors));
//        System.out.println(k);
//System.out.println("floors k-1   " + floors[k - 1] + "  floors n-1 " + floors[n - 1] + " t = " + t);

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Eternal3Kate {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int[] floors = new int[n];
        for (int i = 0; i < n; i++) {
            floors[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int sum = 0;

        if ((t >= floors[k - 1] - floors[0]) || (t >= floors[n - 1] - floors[k - 1])) {
            sum = floors[n - 1] - floors[0];

        } else {
            if ((floors[k - 1] - floors[0]) <= (floors[n - 1] - floors[k - 1])) {
                sum = (floors[k - 1] - floors[0]) + (floors[n - 1] - floors[0]);
            } else {
                sum = (floors[n - 1] - floors[k - 1]) + (floors[n - 1] - floors[0]);

            }
        }
        System.out.println(sum);

    }
}
