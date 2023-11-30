package YandexAlgoritms2023.lecture2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task5 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();
        bufferedReader.close();

        System.out.println(reverseString(str));
        System.out.println(countPal(str));
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

    static long countPal(String str) {
        List<long[]> hashes = hash(str);
        String reversStr = reverseString(str);
        System.out.println(str.length());

        long sum = 0;
        for (int i = 0; i < str.length()-1; i++) {
            int k = 2;
            int p = str.length() - i;
            while (k <= p) {
                if (isEqual(hashes, i, i, k)) {
                    System.out.println(" i = " + i);
                    sum++;
                    k++;
                } else {
                    k++;
                }
            }
        }
        sum += str.length();

        return sum;
    }

    static String reverseString(String str) {
        String resString = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            resString += str.charAt(i);
        }
        return resString;
    }
}
