package TestingTasksFromInternet.tinkoff.Summer2023;

import java.util.Scanner;

public class SeniorJun2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        double temp = (double) n * k / m;
        System.out.println(temp);
        int res = (int) Math.ceil(temp);
        System.out.println(res);

    }
//    наверно вернее
//     if (n*k % m == 0){
//        result = (n * k)/m;
//    }else {
//        result = (n * k)/m + 1;
//    }
//        System.out.println(result);
}
