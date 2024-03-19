package YandexAlgoritms5.lecture2LineanSearch;

/**
 * Из шахматной доски по границам клеток выпилили связную (не распадающуюся на части) фигуру без дыр. Требуется определить ее периметр.
 * 3
 * 1 1
 * 1 2
 * 2 1
 *
 * суть: добавить -1 по краям (увеличив размерность на 2), затем отметить каждую точку 1, а потом проверить скок 1 вокруг (верх низ лево право) - посчитать
 * итоговая сумма = n*4 - sum посчитанных
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task4CutOutChessDesk {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        List<int[]> list = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String[] tokens = line.split(" ");

            if (countLine == 0) {
                n = Integer.parseInt(tokens[0]);
                countLine++;
                continue;
            }

            if (countLine < n + 1) {
                int[]a = new int[2];
                for (int i = 0; i < 2; i++) {
                    a[i] = Integer.parseInt(tokens[i]);
                }
                list.add(a);
                countLine++;
                if (countLine == n + 1) {
                    break;
                }
            }
        }
        bufferedReader.close();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(Arrays.toString(list.get(i)));
//        }

        int res = countPer(list);
        System.out.println(res);
    }

    public static int countPer(List<int[]> list) {

        int countPeaces = 0;
        int[][] desk = new int[10][10];
        for (int i = 0; i < list.size(); i++) {
            desk[list.get(i)[0]][list.get(i)[1]] = 1;
            countPeaces++;
        }
        for (int i = 0; i < desk.length; i++) {
            for (int j = 0; j < desk[i].length; j++) {
                if (i == 0 || j == 0 || i == 9 || j == 9) {
                    desk[i][j] = -1;
                    continue;
                }
                if (desk[i][j] == 1) {
                    continue;
                }
                desk[i][j] = 0;
            }
        }

        int maxTotalSides = countPeaces * 4;
        int countTotalNumbers = 0;
        for (int i = 1; i < desk.length - 1; i++) {
            for (int j = 1; j < desk[i].length - 1; j++) {
                if (desk[i][j] == 1) {
                    countTotalNumbers += countNeighbours(desk, i, j);
                }
            }
        }

        return maxTotalSides - countTotalNumbers;
    }

    private static int countNeighbours(int[][] desk, int i, int j) {
        int res = 0;
        if (desk[i + 1][j] == 1) {
            res++;
        }
        if (desk[i - 1][j] == 1) {
            res++;
        }
        if (desk[i][j - 1] == 1) {
            res++;
        }
        if (desk[i][j + 1] == 1) {
            res++;
        }
        return res;
    }

}




//    static int goRight(int[][] desk, int maxI, int maxJ) {
//bullshit
//        int resAdd = 0;
//        if (desk[maxI][maxJ + 1] == 1) {
//            int countTop = 0;
//            while (desk[maxI + countTop][maxJ + 1] == 1) {
//                resAdd++;
//                countTop++;
//            }
//        } else {
//
//            int countBot = 0;
//            while (desk[maxI - countBot][maxJ + 1] == 0 && desk[maxI - countBot][maxJ] == 1) {
//                resAdd++;
//                countBot++;
//            }
//            if (desk[maxI - countBot][maxJ + 1] == 1) {
//                resAdd++;
//            }
//        }
//
//
//
//        return 0;
//    }
