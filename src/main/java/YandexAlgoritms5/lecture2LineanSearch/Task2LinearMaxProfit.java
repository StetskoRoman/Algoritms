package YandexAlgoritms5.lecture2LineanSearch;

/**
 * Вася решил заняться торговлей рыбой. С помощью методов машинного обучения он предсказал цены на рыбу на N дней вперёд. Он решил, что в один день он купит рыбу,
 * а в один из следующих дней — продаст (то есть совершит или ровно одну покупку и продажу или вообще не совершит покупок и продаж, если это не принесёт ему прибыли). К сожалению, рыба — товар скоропортящийся и разница между номером дня продажи и номером дня покупки не должна превышать K.
 * Определите, какую максимальную прибыль получит Вася.
 * По сути просто определить максимум на каждом из отрезков
 * 5 2
 * 1 2 3 4 5
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.OptionalInt;


public class Task2LinearMaxProfit {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        int k = 0;
        int[] a = new int[0];

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String[] tokens = line.split(" ");

            if (countLine == 0) {
                n = Integer.parseInt(tokens[0]);
                k = Integer.parseInt(tokens[1]);
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

        int res = solution(a, k);
        System.out.println(res);

    }

    static int solution(int[] a, int k) {

        int maxDelta = 0;
        int[] delta = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            int pos = 1;
            maxDelta = 0;
            while (i + pos <= i + k && i + pos < a.length) {
                if (a[i + pos] - a[i] > maxDelta) {
                    maxDelta = a[i + pos] - a[i];
                }
                pos++;
            }
            delta[i] = maxDelta;
        }

        OptionalInt res = Arrays.stream(delta).max();
        return res.orElse(0);
    }
}
