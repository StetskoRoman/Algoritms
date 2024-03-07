package YandexAlgoritms5.lecture1Complexity;
/**
 * R******R
 * ********
 * ******B*
 * ********
 * **R*****
 * *******R
 * ********
 * B******R
 * R - ладьи
 * В - слоны
 * Посчитать безопасные клетки
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task4SloniLadyi {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        String[][] a = new String[8][8];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] tokens = line.split("");
            if (countLine < 9) {
                for (int i = 0; i < 8; i++) {
                    a[countLine][i] = tokens[i];
                }
                countLine++;
                if (countLine == 8) {
                    break;
                }
            }
        }
        bufferedReader.close();

        int[][] desk = stringArrayToInt(a);

        List<int[]> elephants = new ArrayList<>();
        List<int[]> castles = new ArrayList<>();
        findAllFigures(desk, elephants, castles);


        findAllDangerForElephant(desk, elephants);
        findAllDangerCastles(desk,castles);


        int res = countSafePlaces(desk);
        System.out.println(res);
    }

    static int countSafePlaces(int[][] desk) {
        int res = 0;
        for (int i = 0; i < desk.length; i++) {
            for (int j = 0; j < desk[i].length; j++) {
                if (desk[i][j] == 0) {
                    res++;
                }
            }

        }
        return res;
    }

    static void findAllDangerCastles(int[][] desk, List<int[]> castles) {

        for (int k = 0; k < castles.size(); k++) {
            int high = castles.get(k)[0];
            int wide = castles.get(k)[1];

            int up = high - 1;
            while (up >= 0) {
                if (desk[up][wide] <= 0) {
                    desk[up][wide] = -1;
                    up--;
                    continue;
                }
                if (desk[up][wide] > 0) {
                    break;
                }
            }

            int down = high + 1;
            while (down < desk.length) {
                if (desk[down][wide] <= 0) {
                    desk[down][wide] = -1;
                    down++;
                    continue;
                }
                if (desk[down][wide] > 0) {
                    break;
                }
            }

            int left = wide - 1;
            while (left >= 0) {
                if (desk[high][left] <= 0) {
                    desk[high][left] = -1;
                    left--;
                    continue;
                }
                if (desk[high][left] > 0) {
                    break;
                }
            }

            int right = wide + 1;
            while (right < desk.length) {
                if (desk[high][right] <= 0) {
                    desk[high][right] = -1;
                    right++;
                    continue;
                }
                if (desk[high][right] > 0) {
                    break;
                }
            }
        }
    }


    static void findAllDangerForElephant(int[][] desk, List<int[]> elephants) {

        for (int k = 0; k < elephants.size(); k++) {
            int up = elephants.get(k)[0];
            int right = elephants.get(k)[1];
            int down = up;
            int left = right;

            right++;
            up--;
            while (right < desk.length && up >= 0) {
                if (desk[up][right] <= 0) {
                    desk[up][right] = -1;
                    right++;
                    up--;
                    continue;
                }
                if (desk[up][right] > 0) {
                    break;
                }
            }

            right = elephants.get(k)[1]+1;
            down = elephants.get(k)[0]+1;
            while (right < desk.length && down < desk.length) {
                if (desk[down][right] <= 0) {
                    desk[down][right] = -1;
                    right++;
                    down++;
                    continue;
                }
                if (desk[down][right] > 0) {
                    break;
                }
            }

            up = elephants.get(k)[0] - 1;
            left = elephants.get(k)[1] - 1;
            while (left >= 0 && up >= 0) {
                if (desk[up][left] <= 0) {
                    desk[up][left] = -1;
                    --left;
                    --up;
                    continue;
                }
                if (desk[up][left] > 0) {
                    break;
                }
            }

            down = elephants.get(k)[0] + 1;
            left = elephants.get(k)[1] - 1;
            while (down < desk.length && left >= 0) {
                if (desk[down][left] <= 0) {
                    desk[down][left] = -1;
                    left--;
                    down++;
                    continue;
                }
                if (desk[down][left] > 0) {
                    break;
                }
            }
        }
    }

    static void findAllFigures(int[][] desk, List<int[]> elephants1, List<int[]> castles2) {

        for (int i = 0; i < desk.length; i++) {
            for (int j = 0; j < desk[i].length; j++) {
                if (desk[i][j] == 1) {
                    int[] elephant = new int[2];
                    elephant[0] = i;
                    elephant[1] = j;
                    elephants1.add(elephant);
                }
                if (desk[i][j] == 2) {
                    int[] castle = new int[2];
                    castle[0] = i;
                    castle[1] = j;
                    castles2.add(castle);
                }
            }
        }
    }

    static int[][] stringArrayToInt(String[][] a) {
        int[][] desk = new int[8][8];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {

                if (a[i][j].equals("*")) {

                    desk[i][j] = 0;
                }
                if (a[i][j].equals("B")) {
                    desk[i][j] = 1;
                }
                if (a[i][j].equals("R")) {
                    desk[i][j] = 2;
                }
            }
        }
        return desk;
    }
}


//        for (int i = 0; i < desk.length; i++) {
//            System.out.println();
//            for (int j = 0; j < desk[i].length; j++) {
//                System.out.print(desk[i][j] + " ");
//            }
//        }


//for (int i = high; i < desk.length; i++) {
//        for (int j = wide; j < desk.length; j++) {
//        if (i == high) {
//        for (int c = 0; c < desk.length; c++) {
//
//        }
//        }
//        }
//        }


//                    System.out.println("break + up = " + up + "  left =" + left);
//                    for (int i = 0; i < desk.length; i++) {
//                        System.out.println();
//                        for (int j = 0; j < desk[i].length; j++) {
//                            System.out.print(desk[i][j] + " ");
//                        }
//                    }