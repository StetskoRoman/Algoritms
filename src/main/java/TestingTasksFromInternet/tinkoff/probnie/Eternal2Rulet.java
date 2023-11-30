package TestingTasksFromInternet.tinkoff.probnie;
//
//Ваня принес на кухню рулет, который он хочет разделить с коллегами. Для этого он хочет разрезать рулет на ﻿
//        N﻿ равных частей. Разумеется, рулет можно резать только поперек. Соотвественно, Костя сделает ﻿
//        N−1﻿ разрез ножом через равные промежутки.
//System.out.println(log2x);
//        if (log2x <= 4) {
//        System.out.println(true);
//        }
//        if (log2x >= 4) {
//        System.out.println(false);
//        }
//        if (log2x == 4) {
//        System.out.println("111");
//        }

import java.util.Scanner;

public class Eternal2Rulet {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        double log2x = log2(n);
        long res = (long) log2x;

        if (res < log2x) {
            System.out.println(res + 1);
        }
        else {
            System.out.println(res);
        }
    }
    public static double log2(long x) {
        return Math.log(x) / Math.log(2);
    }

}
