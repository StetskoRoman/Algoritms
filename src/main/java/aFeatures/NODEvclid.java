package aFeatures;

import java.util.Scanner;

public class NODEvclid {
    public static int nokCounting(int m, int n) {
        int big; int low;
        if (m > n) {
            big = m;
            low = n;
        } else {
            big = n;
            low = m;
        }

        int nok = 1;
        int remainder = -1;
        while (remainder != 0) {

            remainder = big % low;
            if (remainder == 0) {
                nok = low;
                return nok;
            } else {
                big = low;
                low = remainder;
            }
        }

        return 1;
    }

    public static void main(String[] args) {

//        System.out.println(nokCounting(451, 287));

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        System.out.println("m and n = " + m + "   " + n);
        System.out.println(nokCounting(m, n));
    }
}
