package TestingTasksFromInternet.tinkoff.AlgoritmTrainingTestIn;

import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        double a = Double.parseDouble(str1);
        String str2 = scanner.next();
        double b = Double.parseDouble(str2);
        String str3 = scanner.next();
        double c = Double.parseDouble(str3);
        String str4 = scanner.next();
        double d = Double.parseDouble(str4);
        String str5 = scanner.next();
        double e = Double.parseDouble(str5);
        String str6 = scanner.next();
        double f = Double.parseDouble(str6);

        int firstRes = solution(a, b);
        int second = solution(c, d);
        int third = solution(e, f);

        System.out.println(firstRes + second + third);


    }

    public static int solution(double a, double b) {

        double r = Math.sqrt((a * a) + (b * b));
        if (r <= 0.1) {
            return 3;
        }
        if (r > 0.1 && r <= 0.8) {
            return 2;
        }
        if (r > 0.8 && r <= 1) {
            return 1;
        }

        return 0;
    }
}
