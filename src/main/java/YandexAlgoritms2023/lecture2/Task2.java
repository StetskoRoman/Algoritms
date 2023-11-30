package YandexAlgoritms2023.lecture2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task2 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();
        bufferedReader.close();

        System.out.println(establishment(str));
    }

    public static List<long[]> hash(String str) {

        List<long[]> resultList = new ArrayList<>();

        int n = str.length();
        long p = 1000000037l;
        long x = 257l;
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
        long p = 1000000037l;
        long[] hMatrix = hashes.get(0);
        long[] xMatrix = hashes.get(1);
        from1++;
        from2++;

        if ((hMatrix[from1 + len - 1] + (hMatrix[from2 - 1] * xMatrix[len])) % p ==
                (hMatrix[from2 + len - 1] + (hMatrix[from1 - 1] * xMatrix[len])) % p) {

            return true;
        }
        return false;
    }

    public static int establishment(String str) {

        List<long[]> hashes = hash(str);

        int n = str.length();
        int point = n - 2;
        int k = 0;
        str = str + str;

        for (int i = point; i >= 0; i--) {

            if (isEqual(hashes, 0, n - i - 1, i + 1)) {
                k = n - (i + 1);

                return k;
            }
        }

        return n;
    }
}


//System.out.println(isEqual(hashes, 0, n - i - 1, i + 1));