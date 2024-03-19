package YandexAlgoritms5.lecture2LineanSearch;
/**
 * На столе лежали две одинаковые верёвочки целой положительной длины.
 * Петя разрезал одну из верёвочек на N частей, каждая из которых имеет целую положительную длину, так что на столе стало N+1 верёвочек. Затем в комнату зашла
 * Маша и взяла одну из лежащих на столе верёвочек. По длинам оставшихся на столе N верёвочек определите, какую наименьшую длину может иметь верёвочка, взятая Машей.
 * 4
 * 5 12 4 3   ->24
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task3CutLine {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        int[] a = new int[0];

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String[] tokens = line.split(" ");

            if (countLine == 0) {
                n = Integer.parseInt(tokens[0]);
                countLine++;
                continue;
            }

            if (countLine == 1) {
                a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = Integer.parseInt(tokens[i]);
                }
                break;

            }
        }
        bufferedReader.close();

        int res = solution(a);
        System.out.println(res);

    }

    public static int solution(int[] a) {

        int res = 0;
        int sum = Arrays.stream(a).sum();
        int max = Arrays.stream(a).max().orElse(0);

        if (max > sum - max) {
            res = max * 2 - sum;
        } else {
            res = sum;
        }

        return res;
    }
}
