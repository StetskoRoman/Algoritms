package YandexAlgoritms2023.lecture2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task4Сlear {

    static final long p = 1000000037l;
    static final long x = 1000007;

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

        int n = matrix.length;

        List<long[]> hashes = hash(matrix);
        List<Integer> list = new ArrayList<>();
//        boolean check = isEqual(hashes, 0, 0, 1);
//        System.out.println("check = " + check);

        for (int i = 1; i <= n / 2; i++) {
            if (isEqual(hashes, 0, (n - (2 * i)), i)) {
                list.add(n - i);
            }
        }
        list.add(n);
        Collections.sort(list);

        return list;
    }

    public static List<long[]> hash(int [] matrix) {

        int[] reverseMatrix = reverseString(matrix);
        List<long[]> resultList = new ArrayList<>();

        int n1 = matrix.length;
        int n2 = reverseMatrix.length;

        long[] hMatrix = new long[n1 + 1];
        long[] xMatrix = new long[n1 + 1];
        long[] hMatrix2 = new long[n2 + 1];
        long[] xMatrix2 = new long[n2 + 1];

        int[] workMatrix = new int[n1 + 1];
        int[] workReverseMatrix = new int[n2 + 1];
        for (int i = 1; i < n1; i++) {
            workMatrix[i] = matrix[i - 1];
            workReverseMatrix[i] = reverseMatrix[i - 1];
        }
        workMatrix[0] = 0;
        workReverseMatrix[0] = 0;

//        System.out.println(Arrays.toString(workMatrix));
//        System.out.println(Arrays.toString(workReverseMatrix));
        xMatrix[0] = 1;
        hMatrix[0] = 0;
        xMatrix2[0] = 1;
        hMatrix2[0] = 0;

        for (int i = 1; i < n1 + 1; i++) {
            hMatrix[i] = (hMatrix[i - 1] * x + (int) workMatrix[i]) % p;
            xMatrix[i] = (xMatrix[i - 1] * x) % p;
            hMatrix2[i] = (hMatrix2[i - 1] * x + (int) workReverseMatrix[i]) % p;
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

        long[] hMatrix = hashes.get(0);
        long[] xMatrix = hashes.get(1);
        long[] hMatrix2 = hashes.get(2);
        long[] xMatrix2 = hashes.get(3);
//        System.out.println(Arrays.toString(hMatrix));
//        System.out.println(Arrays.toString(hMatrix2));

        from1++;
        from2++;
        if ((hMatrix[from1 + len - 1] + (hMatrix2[from2 - 1] * xMatrix2[len])) % p ==
                (hMatrix2[from2 + len - 1] + (hMatrix[from1 - 1] * xMatrix[len])) % p) {

            return true;
        }

        return false;
    }

    static int[] reverseString(int[] matrix) {
        int n = matrix.length;
        int[] reverseMatrix = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            reverseMatrix[n - i - 1] = matrix[i];
        }

        return reverseMatrix;
    }

}


//        StringBuilder sbRight = new StringBuilder();
//        StringBuilder sbReverse = new StringBuilder();
//        sbReverse.append(matrix[j]);