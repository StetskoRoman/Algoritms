package YandexAlgoritms2023.lecture2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task4 {

    static final long p = 1000000037l;
    static final long x = 257l;

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int m = 0;
        int n = 0;
        int[] matrix = new int[0];

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    m = Integer.parseInt(tokens[1]);
                    matrix = new int[n];
                    countLine++;
                    continue;
                }
                if (countLine == 1) {
                    for (int i = 0; i < n; i++) {
                        matrix[i] = Integer.parseInt(tokens[i]);
                    }
                    break;
                }
            }
        }

//        System.out.println(" n m " + n + "   " + m);
//        System.out.println(Arrays.toString(matrix));
        PrintWriter printWriter = new PrintWriter(System.out);
        List<Integer> res = countCubs(matrix);
        for (Integer integer : res) {
            printWriter.print(integer + " ");
        }
        printWriter.flush();
//        System.out.println(res);
    }

    public static List<Integer> countCubs(int[] matrix) {

        StringBuilder sbRight = new StringBuilder();
//        (int j=0, k=1; (j < bmarray[i].length && k < arraybeta.length); j++, k++)
        for (int i = 0; i < matrix.length; i++) {
            sbRight.append(matrix[i]);

        }
        String strRight = String.valueOf(sbRight);
        String strReverse = reverseString(strRight);
//        System.out.println(strRight);
//        System.out.println(strReverse);

        int n = matrix.length;
        System.out.println(n);
        List<long[]> hashes = hash(strRight);
        List<Integer> list = new ArrayList<>();


        boolean check = isEqual(hashes, 0, 0, 1);
        System.out.println("check = " + check);

        for (int i = 1; i <= n / 2; i++) {
            System.out.println("AI");
            if (isEqual(hashes, 0, (n - (2 * i)), i)) {
                System.out.println("here was ");
                list.add(n - i);
            }
        }
        list.add(n);
        Collections.sort(list);

        return list;
    }

    public static List<long[]> hash(String str1) {

        String str2 = reverseString(str1);
        List<long[]> resultList = new ArrayList<>();

        int n1 = str1.length();
        int n2 = str2.length();
        long p = 1000000037l;
        long x = 257l;
        long[] hMatrix = new long[n1 + 1];
        long[] xMatrix = new long[n1 + 1];
        long[] hMatrix2 = new long[n2 + 1];
        long[] xMatrix2 = new long[n2 + 1];
        String s1 = ' ' + str1;
        String s2 = ' ' + str2;
        xMatrix[0] = 1;
        hMatrix[0] = 0;
        xMatrix2[0] = 1;
        hMatrix2[0] = 0;

        for (int i = 1; i < n1 + 1; i++) {
            hMatrix[i] = (hMatrix[i - 1] * x + (int) s1.charAt(i)) % p;
            xMatrix[i] = (xMatrix[i - 1] * x) % p;
            hMatrix2[i] = (hMatrix2[i - 1] * x + (int) s2.charAt(i)) % p;
            xMatrix2[i] = (xMatrix2[i - 1] * x) % p;
        }

        resultList.add(hMatrix);
        resultList.add(xMatrix);
        resultList.add(hMatrix2);
        resultList.add(xMatrix2);

        return resultList;
    }

    //    переделать под сравнение двух строк?
    public static boolean isEqual(List<long[]> hashes, int from1, int from2, int len) {
        long p = 1000000037l;
        long[] hMatrix = hashes.get(0);
        long[] xMatrix = hashes.get(1);
        long[] hMatrix2 = hashes.get(2);
        long[] xMatrix2 = hashes.get(3);
        System.out.println(Arrays.toString(hMatrix));
        System.out.println(Arrays.toString(hMatrix2));

        from1++;
        from2++;
        if ((hMatrix[from1 + len - 1] + (hMatrix2[from2 - 1] * xMatrix2[len])) % p ==
                (hMatrix2[from2 + len - 1] + (hMatrix[from1 - 1] * xMatrix[len])) % p) {

            return true;
        }

        return false;
    }

    static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        String resString = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        resString = String.valueOf(sb);
        return resString;
    }

}


//        StringBuilder sbRight = new StringBuilder();
//        StringBuilder sbReverse = new StringBuilder();
//        sbReverse.append(matrix[j]);