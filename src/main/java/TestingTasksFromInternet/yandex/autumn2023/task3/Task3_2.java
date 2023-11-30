package TestingTasksFromInternet.yandex.autumn2023.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task3_2 {

    public static void main(String[] args) throws IOException {

        int countQ = 0;
        int countN = 0;
        int countS = 0;
        int q = 0;
        int n = 0;
        int m = 0;
        String[][] terms = new String[0][];
        String[] columns = new String[0];
        long[][] matrix = new long[0][];

        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in)) {

            String line;

            while ((line = buffer.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countS == 0) {
                    n = Integer.parseInt(tokens[0]);
                    m = Integer.parseInt(tokens[1]);
                    q = Integer.parseInt(tokens[2]);
                    countS++;
                    matrix = new long[n][m];
                    columns = new String[m];
                    terms = new String[q][3];

                    continue;
                }
                if (countS == 1) {
                    for (int i = 0; i < m; i++) {
                        columns[i] = tokens[i];
                    }
                    countS++;
                    continue;
                }

                if (countN < n) {
                    for (int i = countN; i < n;) {

                        for (int j = 0; j < m; j++) {
                            matrix[i][j] = Long.parseLong(tokens[j]);
                        }
                        countN++;

                        break;
                    }
                    continue;
                }

                if (countQ < q) {
                    for (int i = countQ; i < q; ) {

                        for (int j = 0; j < 3; j++) {
                            terms[i][j] = tokens[j];
                        }
                        countQ++;
                        break;
                    }

                    if (countQ == q) {
                        break;
                    }

                }

            }
        }

        transformMatrix(matrix, columns, terms);
        long result = calculateSum(matrix);
        System.out.println(result);
    }

    public static void transformMatrix(long[][] matrix, String[] columns, String[][] terms) {

        for (int t = 0; t < terms.length; t++) {
            for (int c = 0; c < columns.length; c++) {
                if (terms[t][0].equals(columns[c])) {

                    if (terms[t][1].equals("<")) {
                        for (int i = 0; i < matrix.length; i++) {
                            long number = matrix[i][c];
                            if (number >= Long.valueOf(terms[t][2])) {
                                for (int j = 0; j < matrix[i].length; j++) {
                                    matrix[i][j] = 0;
                                }
                            }
                        }
                    } else {
                        for (int i = 0; i < matrix.length; i++) {
                            long number = matrix[i][c];
                            if (number <= Long.valueOf(terms[t][2])) {
                                for (int j = 0; j < matrix[i].length; j++) {
                                    matrix[i][j] = 0;
                                }
                            }
                        }
                    }

                }
            }
        }
    }

    public static long calculateSum(long[][] matrix) {
        long sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}