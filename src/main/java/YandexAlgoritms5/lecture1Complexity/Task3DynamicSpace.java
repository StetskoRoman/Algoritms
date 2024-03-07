package YandexAlgoritms5.lecture1Complexity;
/**
 * +1 +4 или -1, посчитать мин. кол-во действий
 * 5 - n сколько строк
 * 1 - сколько пробелов
 * 4
 * 12
 * 9
 * 0
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task3DynamicSpace {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        int[] a = new int[0];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String[] tokens = line.split("[:\\s]");

            if (countLine == 0) {
                n = Integer.parseInt(tokens[0]);
                a = new int[n];
                countLine++;
                continue;
            }
            if (countLine <= n) {
                a[countLine - 1] = Integer.parseInt(tokens[0]);

                countLine++;
                if (countLine == n + 1) {
                    break;
                }
            }
        }
        bufferedReader.close();

        int[] db = {0, 1, 2, 2, 1};

        System.out.println(findMinMotions(a, db));
    }

    static long findMinMotions(int[] a, int[] db) {

        long count = 0l;
        for (int i = 0; i < a.length; i++) {
            count += countMotion(a[i], db);
        }

        return count;
    }

    static long countMotion(int a, int[] db) {

        long resWhole = (long) a / 4;
        int resOst = a % 4;
        long count = 0l;
        for (int i = 0; i < db.length; i++) {
            if (i == resOst) {
                count = (long)db[resOst];
            }
        }
        return resWhole + count;

    }
}
