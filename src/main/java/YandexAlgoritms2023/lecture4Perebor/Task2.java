package YandexAlgoritms2023.lecture4Perebor;

import java.util.*;

public class Task2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = 0;
            }
        }

        ArrayList<Integer> list = nQueen(mat, 0, new ArrayList<>());
        System.out.println(list.size());


    }

    private static boolean isSafe(int[][] mat, int k, int c)
    {
        for (int i = 0; i < k; i++) {
            if (mat[i][c] == 1) {
                return false;
            }
        }

        for (int i = k, j = c; i >= 0 && j >= 0; i--, j--) {
            if (mat[i][j] == 1) {
                return false;
            }
        }

        for (int i = k, j = c; i >= 0 && j < mat.length; i--, j++) {
            if (mat[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private static ArrayList<Integer> nQueen(int[][] mat, int k, ArrayList<Integer> res)
    {
        if (k == mat.length) {
            return res;
        }

        for (int i = 0; i < mat.length; i++) {
            if (isSafe(mat, k, i)) {
                mat[k][i] = 1;
                if (k == mat.length - 1) {
                    res.add(1);
                }

                nQueen(mat, k + 1, res);
//                 возвращаемся
                mat[k][i] = 0;
            }
        }
        return res;
    }
}
