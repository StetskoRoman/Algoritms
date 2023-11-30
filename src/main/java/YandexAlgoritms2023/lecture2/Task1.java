package YandexAlgoritms2023.lecture2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        int q = 0;
        String str = "";
        int [][] terms = new int[0][3];


        PrintWriter printWriter = new PrintWriter(System.out);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                if (countLine == 0) {
                    str = line;
                    countLine++;
                    continue;
                }
                String[] tokens = line.split(" ");

                if (countLine == 1) {
                    q = Integer.parseInt(tokens[0]);
                    terms = new int[q][3];
                    countLine++;
                    continue;
                }

                if (countLine <= q + 1) {
                    for (int i = 0; i < tokens.length; i++) {
                        terms[countLine - 2][i] = Integer.parseInt(tokens[i]);
                    }
                    countLine++;
                    if (countLine == q + 2) {
                        break;
                    }
                }
            }
        }

        List<long[]> hashes = hash(str);

        for (int i = 0; i < terms.length; i++) {
            String strInResult = isEqual(hashes, terms[i][1], terms[i][2], terms[i][0]);
            printWriter.println(strInResult);
        }
        printWriter.flush();

    }

    public static List<long[]> hash(String str) {

        List<long[]> resultList = new ArrayList<>();

        int n = str.length();
        long p = 1000000037l;
        long x = 271l;
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

    public static String isEqual(List<long[]> hashes, int from1, int from2, int len) {
        long p = 1000000037l;
        long[] hMatrix = hashes.get(0);
        long[] xMatrix = hashes.get(1);
        from1++;
        from2++;

        if ((hMatrix[from1 + len - 1] + (hMatrix[from2 - 1] * xMatrix[len])) % p ==
                (hMatrix[from2 + len - 1] + (hMatrix[from1 - 1] * xMatrix[len])) % p) {

            return "yes";
        }
        return "no";
    }

}



//System.out.println("heshes = " + Arrays.toString(hMatrix));
//        System.out.println("x = " + Arrays.toString(xMatrix));
//        System.out.println(Arrays.toString(longs));

// System.out.println(str);
//        for (int i = 0; i < terms.length; i++) {
//            System.out.println();
//            for (int j = 0; j < terms[i].length; j++) {
//                System.out.print(terms[i][j] + "  ");
//            }
//        }