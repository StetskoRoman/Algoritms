package YandexAlgoritms5.lecture2LineanSearch;

/**
 * Вверх-вниз (первое число вверх, потом вниз, надо залезть как можно выше)
 * 3
 * 1 5
 * 8 2
 * 4 4
 * ответ
 * 10
 * 2 3 1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Task5Ulitka {

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
                int[] a = new int[2];
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

        if (list.size() == 1) {
            System.out.println(list.get(0)[0]);
            System.out.println("1");
            return;

        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i)));
        }

        sequence(list);
    }

    static long[] sequence(List<int[]> list) {

        int n = list.size();
        int[] array = new int[n];
        long[] dp = new long[n];
        int[] prev = new int[n];

        dp[0] = list.get(0)[0];
        prev[0] = -2;

        for (int i = 1; i < list.size(); i++) {
            dp[i] = findMaxDp(list, dp, prev, i);

        }

        System.out.println("dp = " + Arrays.toString(dp));
        System.out.println("prev = " + Arrays.toString(prev));

        return dp;
    }

    static long findMaxDp(List<int[]> list, long[] dp, int[] prev, int pos) {

        long maxBefore = 0;
        int beforeI = 0;

        for (int i = 0; i < pos; i++) {
            if (dp[i] > maxBefore) {
                maxBefore = dp[i];
                beforeI = i;
            }
        }
//&& list.get(pos)[0] - list.get(pos)[1] < list.get(beforeI)[0] - list.get(beforeI)[1]
        if (list.get(pos)[0] > maxBefore - list.get(beforeI)[1] ) {
            System.out.println("int 1-t if");
            for (int i = 0; i <= pos; i++) {
                if (prev[i] == -2) {
                    prev[i] = -1;
                }
            }
            prev[pos] = -2;
            dp[pos] = list.get(pos)[0];
            return dp[pos];
        }
        if (list.get(pos)[0] - list.get(pos)[1] > list.get(beforeI)[0] - list.get(beforeI)[1] && dp[beforeI] != -1 && pos == dp.length-1) {
            System.out.println("in 2-d if");
            for (int i = 0; i <= pos; i++) {
                if (prev[i] == -2) {
                    prev[i] = -1;
                }
            }
            prev[pos] = -2;
            dp[pos] = list.get(pos)[0] - list.get(pos)[1] + maxBefore;
            return dp[pos];

        } else {
            System.out.println("int last if");
            prev[pos] = beforeI;
            dp[pos] = maxBefore - list.get(beforeI)[1] + list.get(pos)[0];
            return dp[pos];
        }


    }
}
