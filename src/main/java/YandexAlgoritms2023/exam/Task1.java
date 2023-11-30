package YandexAlgoritms2023.exam;

import java.util.Scanner;
import java.util.TreeSet;

public class Task1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        if (n == 1) {
//            System.out.println(1);
//            return;
//        }

        TreeSet<Long> res = fill(n);
//        Collections.sort(res);
//        System.out.println("final = " + res);
        System.out.println(res.last());
//        System.out.println(res.get(n - 1));
//        long[] a = fillA(n);
//        long[] b = fillB(n);
//        ArrayList<Long> result = sortMerge(a, b, n);
//        System.out.println(result.get(n - 1));

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


    //
    static TreeSet<Long> fill(int n) {
        TreeSet<Long> res = new TreeSet<>();
        long countSquare = 1;
        long countTriple = 1;
        res.add(countSquare);
//        countSquare++;
//        countTriple++;
        int length = 1;
        while (length <= n) {
            long square = countSquare * countSquare;
            long triple = countTriple * countTriple * countTriple;
//            System.out.println("res = " + res + "   count 2= " + countSquare*countSquare + "  count 3 = " + countTriple*countTriple*countTriple);
            if (square <= triple) {
                res.add(square);
//                System.out.println("added square ");
                countSquare++;
                length++;
                continue;
            }
            if (triple < square) {
                if (triple == res.last()) {
                    countTriple++;
                    continue;
                }
//                System.out.println("add triple " + countTriple*countTriple*countTriple);
                res.add(triple);
                countTriple++;
                length++;
                continue;
            }

        }

        return res;
    }
}

//    static ArrayList<Long> sortMerge(long[] n, long[] m, int k) {
//
//        int size = n.length + m.length;
//        ArrayList<Long> nums = new ArrayList<>();
//        int nCount = 0;
//        int mCount = 0;
//        int i = 0;
//        while (true) {
////            if (i == k + 1) {
////                break;
////            }
//            if (i == k) {
//                break;
//            }
////            if (nCount == n.length) {
////                for (int j = i; j < size; j++) {
////                    nums.add(m[mCount]);
////                    mCount++;
////                    i++;
////                }
////                break;
////            }
////            if (mCount == m.length) {
////                for (int j = i; j < size; j++) {
////                    nums.add(n[nCount]);
////                    nCount++;
////                    i++;
////                }
////                break;
////            }
//
//            if (n[nCount] == m[mCount]) {
//                nums.add(n[nCount]);
//                nCount++;
//                mCount++;
//                i++;
//            }
////            if (bigInteger.compareTo(BigInteger.ZERO) > 0) {
//            if (n[nCount] < m[mCount]) {
//                nums.add(n[nCount]);
//                nCount++;
//                i++;
//
//            } else {
//                nums.add(m[mCount]);
//                mCount++;
//                i++;
//            }
//        }
//
//        return nums;
//    }

//
//    static long[] fillA(int n) {
//        long[] res = new long[n];
//        for (int i = 1; i <= n; i++) {
//            res[i - 1] = (i * i);
//        }
//        return res;
//    }
//
//    static long[] fillB(int n) {
//        long[] res = new long[n];
//        for (int i = 1; i <= n; i++) {
//            res[i - 1] = (i * i * i);
//        }
//        return res;
//    }
//}

//    static ArrayList<BigInteger> sortMerge(BigInteger[] n, BigInteger[] m, int lenght) {
//
//        int size = n.length + m.length;
//        ArrayList<BigInteger> nums = new ArrayList<>();
//        int nCount = 0;
//        int mCount = 0;
//        int i = 0;
//        while (true) {
//            if (i == (lenght + 1)) {
//                break;
//            }
//
//            if (nCount == n.length) {
//                for (int j = i; j < size; j++) {
//                    nums.add(m[mCount]);
//                    mCount++;
//                    i++;
//                }
//                break;
//            }
//            if (mCount == m.length) {
//                for (int j = i; j < size; j++) {
//                    nums.add(n[nCount]);
//                    nCount++;
//                    i++;
//                }
//                break;
//            }
//
//            if (n[nCount] == m[mCount]) {
//                nums.add(n[nCount]);
//                nCount++;
//                mCount++;
//                i++;
//            }
////            if (bigInteger.compareTo(BigInteger.ZERO) > 0) {
//            if (n[nCount] < m[mCount]) {
//                nums.add(n[nCount]);
//                nCount++;
//                i++;
//
//            } else {
//                nums.add(m[mCount]);
//                mCount++;
//                i++;
//            }
//
//        }
//        return nums;
//    }

