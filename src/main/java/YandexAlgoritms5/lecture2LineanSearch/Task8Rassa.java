package YandexAlgoritms5.lecture2LineanSearch;
/**
 * 3 4
 * 1 3 5 7
 * 9 11 2 4
 * 6 8 10 12
 *
 * найти какие столбец и строки лучше вычеркнуть чтобы оставить мин число в массиве
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task8Rassa {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        int m = 0;
        List<int[]> list = new ArrayList<>();
        int[][] array = new int[0][0];

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String[] tokens = line.split(" ");

            if (countLine == 0) {
                n = Integer.parseInt(tokens[0]);
                m = Integer.parseInt(tokens[1]);
                array = new int[n + 1][m + 1];
                countLine++;
                continue;
            }

            if (countLine < n + 1) {

                for (int i = 1; i < array[countLine].length; i++) {
                    array[countLine][i] = Integer.parseInt(tokens[i-1]);
                }

                countLine++;
                if (countLine == n + 1) {
                    break;
                }
                continue;
            }
        }
        bufferedReader.close();

//        for (int i = 0; i < array.length; i++) {
//            System.out.println();
//            for (int j = 0; j < array[i].length; j++) {
//                System.out.print(array[i][j] + " ");
//            }
//        }

        int [] res1 = solutionHorizon(array);
        int [] res2 = solutionHeight(array);
        if (res1[2] < res2[2]) {
            System.out.println(res1[0] + " " + res1[1]);
        } else {
            System.out.println(res2[0] + " " + res2[1]);
        }

    }

    static int[] solutionHorizon(int[][] array) {

        int n = array.length - 1;
        int m = array[0].length - 1;
//        int[][] workArray = new int[n][m];
        int[][] workArray = Arrays.stream(array).map(int[]::clone).toArray(int[][]::new);

        int max = 0;
        int maxI = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (workArray[i][j] > max) {
                    max = workArray[i][j];
                    maxI = i;
                }
            }
        }

        //0 v maxI
        for (int i = 1; i <= n; i++) {
            if (i == maxI) {
                for (int j = 1; j <= m; j++) {
                    workArray[i][j] = 0;
                }
            }
        }

        int maxJ = 0;
        max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (workArray[i][j] > max) {
                    max = workArray[i][j];
                    maxJ = j;
                }
            }
        }

        // po j max = 0
        for (int j = 1; j <= m; j++) {
            if (j == maxJ) {
                for (int i = 1; i <= n; i++) {
                    workArray[i][j] = 0;
                }
            }
        }

        int lastMax = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (workArray[i][j] > lastMax) {
                    lastMax = workArray[i][j];
                }
            }
        }

        int[] res = new int[3];
        res[0] = maxI;
        res[1] = maxJ;
        res[2] = lastMax;
//        System.out.println(Arrays.toString(res));
//
//        for (int i = 0; i < workArray.length; i++) {
//            System.out.println();
//            for (int j = 0; j < workArray[i].length; j++) {
//                System.out.print(workArray[i][j] + " ");
//            }
//        }
        return res;

    }

    static int[] solutionHeight(int[][] array) {
        int[][] workArray = Arrays.stream(array).map(int[]::clone).toArray(int[][]::new);
        int n = array.length - 1;
        int m = array[0].length - 1;

        int maxJ = 0;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (workArray[i][j] > max) {
                    max = workArray[i][j];
                    maxJ = j;
                }
            }
        }

        // po j max = 0
        for (int j = 1; j <= m; j++) {
            if (j == maxJ) {
                for (int i = 1; i <= n; i++) {
                    workArray[i][j] = 0;
                }
            }
        }

        max = 0;
        int maxI = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (workArray[i][j] > max) {
                    max = workArray[i][j];
                    maxI = i;
                }
            }
        }

        //0 v maxI
        for (int i = 1; i <= n; i++) {
            if (i == maxI) {
                for (int j = 1; j <= m; j++) {
                    workArray[i][j] = 0;
                }
            }
        }



        int lastMax = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (workArray[i][j] > lastMax) {
                    lastMax = workArray[i][j];
                }
            }
        }

        int[] res = new int[3];
        res[0] = maxI;
        res[1] = maxJ;
        res[2] = lastMax;
//        System.out.println(Arrays.toString(res));
//        for (int i = 0; i < workArray.length; i++) {
//            System.out.println();
//            for (int j = 0; j < workArray[i].length; j++) {
//                System.out.print(workArray[i][j] + " ");
//            }
//        }
        return res;

    }
}
