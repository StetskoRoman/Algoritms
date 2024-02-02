package TestingTasksFromInternet.tinkoff.winter2024;

import java.util.ArrayList;
import java.util.Collections;

public class PerestInt {
    private static final int SUM = 14;
    private static final int[] a = {2, 5, 3, 1, 5, 4, 20, 7, 10};
    private static final int m = a.length;
    private static int[] pole = new int[m];
    private static ArrayList<ArrayList<Integer>> summs = new ArrayList<ArrayList<Integer>>();
    private static int s = 0;
    private static ArrayList<Integer> v = new ArrayList<Integer>();

    public static void perest(int n, int[] r) {
        int[] r1 = new int[m];
        if (s == SUM) {
            sum();
        }

        for (int i = 0; i < m - n; i++) {
            pole[n] = r[i];
            if (s < SUM && !v.contains(pole[i])) {
                s += pole[n];
                v.add(pole[n]);
                Collections.sort(v);

                int k = 0;
                for (int j = 0; j < m - n; j++) {
                    if (j != i) {
                        r1[k] = r[j];
                        k++;
                    }
                }
                perest(n + 1, r1);
                s = 0;
                v.clear();
            }
        }
    }

    private static void sum() {
        if (!summs.contains(v)) {
            summs.add(new ArrayList<Integer>(v));
            v.clear();
        }
    }

    public static void main(String[] args) {
        perest(0, a);
        for(ArrayList<Integer> v : summs) {
            System.out.println(v);
        }
    }
}
