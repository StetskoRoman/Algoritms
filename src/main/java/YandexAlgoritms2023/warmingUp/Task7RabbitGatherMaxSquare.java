package YandexAlgoritms2023.warmingUp;
//квадраты, сложно...


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task7RabbitGatherMaxSquare {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int m = 0;
        int n = 0;
        int[][] matrix = new int[0][0];

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    m = Integer.parseInt(tokens[1]);
                    matrix = new int[n][m];
                    countLine++;
                    continue;
                }
                if (countLine <= n) {
                    for (int j = 0; j < matrix[countLine - 1].length; j++) {
                        matrix[countLine - 1][j] = Integer.parseInt(tokens[j]);
                    }
                    countLine++;
                    if (countLine == n + 1) {
                        break;
                    }
                }
            }
        }

//        for (int i = 0; i < matrix.length; i++) {
//            System.out.println();
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j] + "  ");
//            }
//        }

        int res = countMaxSquare(matrix);
        System.out.println(res);
    }

    public static int countMaxSquare(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                int top = matrix[i - 1][j];
                int diag = matrix[i - 1][j - 1];
                int left = matrix[i][j - 1];
                if (matrix[i][j] != 0)
                {
                    matrix[i][j] = min(top, diag, left) + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }

            }
        }
        return max;
    }

    public static int min(int a, int b, int c) {
        int min = 0;
        if (a < b){
            min = a;
        }else{
            min = b;
        }

        if (min > c){
            min = c;
        }

        return min;
    }
}


//
//        for (int i = 0; i < matrix.length; i++) {
//        System.out.println();
//        for (int j = 0; j < matrix[i].length; j++) {
//        System.out.print(matrix[i][j] + "  ");
//        }
//        }
