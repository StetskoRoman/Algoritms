package TestingTasksFromInternet.tinkoff.probnie;

import java.util.Objects;
import java.util.Scanner;

public class Task5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong();
        long r = scanner.nextLong();
        scanner.close();

        long result = solution(l, r);
        System.out.println(result);


    }



    static long solution(long l, long r) {
        long res = 0;

        if (l > r) {
            return 0;
        }

        int lLength = Objects.toString(l).length();
        int rLength = Objects.toString(r).length();
        long leftCount = ((long) (l / Math.pow(10, lLength - 1))) % 10;
        long rightCount = ((long) (r / Math.pow(10, rLength - 1))) % 10;
        char[] lChars = Objects.toString(l).toCharArray();
        char[] rChars = Objects.toString(r).toCharArray();

        for (int i = 1; i < lChars.length; i++) {
            long current = Long.parseLong(String.valueOf(lChars[i]));
            if (current == leftCount) {
                continue;
            }
            if (current > leftCount) {
                leftCount++;
                break;
            }
            if (current < leftCount) {
//                leftCount++;
                break;
            }
        }
        leftCount = 10 - leftCount;
//        System.out.println("left count = " + leftCount);

        for (int i = 1; i < rChars.length; i++) {
            long current = Long.parseLong(String.valueOf(rChars[i]));
            if (current == rLength) {
                continue;
            }
            if (current > rightCount) {
                break;
            }
            if (current < rightCount) {
                rightCount--;
                break;
            }
        }
//        System.out.println("right count = " + rightCount);

        res = (leftCount + rightCount) + (9 * (rLength - lLength - 1));

        return res;
    }

}

//плохая идея, долго считает в циклах

//    static long solution(long l, long r) {
//        long res = 0;
//
//        int lLength = Objects.toString(l).length();
//        int rLength = Objects.toString(r).length();
//
//        for (long i = l; i < Math.pow(10, lLength); i++) {
//            if (i % divider(lLength) == 0) {
////                System.out.println("add l " + res);
//                res++;
//            }
//        }
//
//        for (long i = r; i > Math.pow(10, rLength - 1); i--) {
//            if (i % divider(rLength) == 0) {
////                System.out.println("add r " + res);
//                res++;
//                i-= Math.pow(10, rLength - 1);
//            }
//        }
//
//        res += 9 * (rLength - lLength - 1);
//        return res;
//    }
//
//    static long divider(int k) {
//        String num = "";
//
//        while (k > 0) {
//            num += 1;
//            k--;
//        }
//        return Long.parseLong(num);
//    }

