package YandexAlgoritms5.lecture2LineanSearch;
/**
 * На клетчатой плоскости закрашено K клеток. Требуется найти минимальный по площади прямоугольник,
 * со сторонами, параллельными линиям сетки, покрывающий все закрашенные клетки.
 * 4
 * 1 3
 * 3 1
 * 3 5
 * 6 3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task1MaxSquarePr9mougolnik {


    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int k = 0;
        List<int[]> list = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String[] tokens = line.split(" ");

            if (countLine == 0) {
                k = Integer.parseInt(tokens[0]);
                countLine++;
                continue;
            }

            if (countLine < k + 1) {

                int[] point = new int[2];
                point[0] = Integer.parseInt(tokens[0]);
                point[1] = Integer.parseInt(tokens[1]);
                list.add(point);
                countLine++;
                if (countLine == k+1) {
                    break;
                }
            }
        }
        bufferedReader.close();

        int[] res = solution(list);
        for (int num : res) {
            System.out.print(num + " ");
        }

    }

    static int[] solution(List<int[]> list) {

        int iMin = Integer.MAX_VALUE;
        int iMax = Integer.MIN_VALUE;
        int jMin = Integer.MAX_VALUE;
        int jMax = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] < iMin) {
                iMin = list.get(i)[0];
            }
            if (list.get(i)[0] > iMax) {
                iMax = list.get(i)[0];
            }
            if (list.get(i)[1] < jMin) {
                jMin = list.get(i)[1];
            }
            if (list.get(i)[1] > jMax) {
                jMax = list.get(i)[1];
            }
        }

        int[] res = new int[4];
        res[0] = iMin;
        res[1] = jMin;
        res[2] = iMax;
        res[3] = jMax;
//        System.out.println("i min = " + iMin + "  iMax =" + iMax + " jmin = " + jMin + "  jMax =" + jMax);

        return res;
    }
}
