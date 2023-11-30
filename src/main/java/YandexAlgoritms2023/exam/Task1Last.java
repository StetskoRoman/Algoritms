package YandexAlgoritms2023.exam;

import java.util.ArrayList;
import java.util.Scanner;

public class Task1Last {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println(1);
            return;
        }

        long[] a = fillA(n);
        long[] b = fillB(n);
        ArrayList<Long> result = sortMerge(a, b, n);
        System.out.println(result.get(n - 1));

//        double size = n * 0.9;
//        if (n > 10000) {
//            int iSize = (int) size;
//            int bSize = (int)((n - iSize));
////            System.out.println(iSize);
//            BigInteger[]a = fillA(n);
//            BigInteger []b = fillB(bSize);
//            ArrayList<Long> res = sortMerge(a, b);
//
//            System.out.println(res.get(n - 1));
//        } else {
//            BigInteger[] a = fillA(n);
//            BigInteger []b = fillB(n);
//            ArrayList<Long> res = sortMerge(a, b);
//            System.out.println(res.get(n - 1));
//        }
    }

    static ArrayList<Long> sortMerge(long[] n, long[] m, int k) {

        int size = n.length + m.length;
        ArrayList<Long> nums = new ArrayList<>();
        int nCount = 0;
        int mCount = 0;
        int i = 0;
        while (true) {
            if (i == k) {
                break;
            }
            if (nCount == n.length) {
                for (int j = i; j < size; j++) {
                    nums.add(m[mCount]);
                    mCount++;
                    i++;
                }
                break;
            }
            if (mCount == m.length) {
                for (int j = i; j < size; j++) {
                    nums.add(n[nCount]);
                    nCount++;
                    i++;
                }
                break;
            }

            if (n[nCount] == m[mCount]) {
                nums.add(n[nCount]);
                nCount++;
                mCount++;
                i++;
            }
//            if (bigInteger.compareTo(BigInteger.ZERO) > 0) {
            if (n[nCount] < m[mCount]) {
                nums.add(n[nCount]);
                nCount++;
                i++;

            } else {
                nums.add(m[mCount]);
                mCount++;
                i++;
            }

        }
        return nums;
    }

    static long[] fillA(int n) {
        long[] res = new long[n];
        for (int i = 1; i <= n; i++) {
            res[i - 1] = (i * i);
        }
        return res;
    }

    static long[] fillB(int n) {
        long[] res = new long[n];
        for (int i = 1; i <= n; i++) {
            res[i - 1] = (i * i * i);
        }
        return res;
    }
}
