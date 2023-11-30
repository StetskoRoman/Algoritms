package aFeatures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Task3HashZFunction {


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();
        bufferedReader.close();


//        int n = str.length();
//                List<long[]> hashes = hash(str);
//        long[] hMatrix = hashes.get(0);
//        long[] xMatrix = hashes.get(1);
//        System.out.println(isEqual(hashes, 0, 2, 899994));


//        List<long[]> hashes = hash(str);
//        long[] hMatrix = hashes.get(0);
//        long[] xMatrix = hashes.get(1);
//
//        PrintWriter printWriter = new PrintWriter(System.out);
//
//        List<Long> hList = new ArrayList<>();
//        for (int i = 0; i < hMatrix.length; i++) {
//            printWriter.print(hMatrix[i] + " ");
//            hList.add(hMatrix[i]);
//        }
//        printWriter.flush();
//        printWriter.println();
//
//        for (int i = 0; i < hMatrix.length; i++) {
//
//            printWriter.print(xMatrix[i] + " ");
//        }
//        printWriter.flush();
//
//        long n = hMatrix.length;
//        long count = 0;
//        System.out.println("length = " + n);
//        System.out.println("ListSize = " + hList.size());
//        for (int i = 0; i < n; i++) {
//            if (hList.contains(hMatrix[i])) {
//                count++;
//            }
//        }
//        System.out.println("list = " + count);


        int[] resultZ = zFunction(str);
//
        PrintWriter printWriter = new PrintWriter(System.out);
        for (int i = 0; i < resultZ.length; i++) {
            printWriter.print(resultZ[i] + " ");

        }
        printWriter.flush();

    }

    public static List<long[]> hash(String str) {

        final List<long[]> resultList = new ArrayList<>();

        int n = str.length();
        final long p = 1000000037l;
        final long x = 257l;
        long[] hMatrix = new long[n + 1];
        long[] xMatrix = new long[n + 1];
        String s = ' ' + str;
        xMatrix[0] = 1;
        hMatrix[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            hMatrix[i] = (hMatrix[i - 1] * x + (int) s.charAt(i)) % p;
            xMatrix[i] = (xMatrix[i - 1] * x) % p;
        }

        resultList.add(hMatrix);
        resultList.add(xMatrix);

        return resultList;
    }

    public static boolean isEqual(List<long[]> hashes, int from1, int from2, int len) {
        final long p = 1000000037l;
        final long[] hMatrix = hashes.get(0);
        final long[] xMatrix = hashes.get(1);
        from1++;
        from2++;

        if ((hMatrix[from1 + len - 1] + (hMatrix[from2 - 1] * xMatrix[len])) % p ==
                (hMatrix[from2 + len - 1] + (hMatrix[from1 - 1] * xMatrix[len])) % p) {

            return true;
        }
        return false;
    }

   // from two sides in the same time
    public static int[] zFunction(String str) {

        List<long[]> hashes = hash(str);
        int n = str.length();

        int[] zMatrix = new int[n];

        for (int i = n - 1; i >= 0; i--) {

            int len = 1;
            int point = n - i;

            while (len <= point + 1) {

                if (isEqual(hashes, 0, i, len)) {
                    len++;
                } else {
                    zMatrix[i] = len - 1;
                    break;
                }


                if (isEqual(hashes, 0, i, point)) {

                    zMatrix[i] = point;
                    break;
                }else {
                    point--;
                }
            }
        }
        zMatrix[0] = 0;

        return zMatrix;
    }
}


//                    System.out.println("here");


//    TL 84
//    public static int[] zFunction(String str) {
//
//        List<long[]> hashes = hash(str);
//        int n = str.length();
////        System.out.println("length = " + n);
//
//        int[] zMatrix = new int[n];
//
//        for (int i = n - 1; i >= 0; i--) {
//            int len = n - i;
//            int z = len;
//            while (len > 0) {
//                if (!isEqual(hashes, 0, i, len)) {
//                    z--;
//                    len--;
//                } else {
//                    zMatrix[i] = z;
//                    break;
//                }
//                if (len == 0) {
//                    zMatrix[i] = z;
//                }
//
//            }
//        }
//        zMatrix[0] = 0;
//
//        return zMatrix;
//    }
//}


//TL 92 test
//    public static int[] zFunction(String str) {
//
//        List<long[]> hashes = hash(str);
//        int n = str.length();
////        System.out.println("length = " + n);
//
//        int[] zMatrix = new int[n];
//
//        for (int i = n - 1; i >= 0; i--) {
//            int z = 0;
//            int len = 1;
//            while (len <= n - i) {
//                if (isEqual(hashes, 0, i, len)) {
//                    z++;
//                    len++;
//                } else {
//                    zMatrix[i] = z;
//                    break;
//                }
//                zMatrix[i] = z;
//            }
//        }
//        zMatrix[0] = 0;
//
//        return zMatrix;
//    }
//}

//плохой вариант, просто с конца len считать
//    public static List<Integer> zFunction(String str) {
//
//        List<long[]> hashes = hash(str);
//        int n = str.length();
//        System.out.println("length = " + n);
////        List<Integer> list = new ArrayList<>(1000000);
//        List<Integer> list = new ArrayList<>(List.of(new Integer[1000000]));
//        System.out.println(list.size());
////        int[] zMatrix = new int[n];
//
//        for (int i = 0; i <n; i++) {
//            int z = 0;
//            int len = 1;
//            while (len <= n - i) {
//                if (isEqual(hashes, 0, n-i-1, len)) {
//                    z++;
//                    len++;
////                    continue;
//                } else {
//                    list.add(z);
//                    break;
//                }
//                list.set(i, z);
//            }
//        }
//        list.set(0, 0);
//
//        return list;
//    }
//}

//System.out.println(Arrays.toString(zMatrix));

//        System.out.println(isEqual(hashes, 0, 7, 4));
//                System.out.println(isEqual(hashes, 0, 10, 1));
//                System.out.println(isEqual(hashes, 2, 9, 2));
//        isEqual(hashes, 0, 7, 4);