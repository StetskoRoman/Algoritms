package TestingTasksFromInternet.yandex.yandexWinterAnalis.task6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int t = scanner.nextInt();
        String str = scanner.next();
        double p = Double.parseDouble(str);

        System.out.println(" terms = " + n + "  " + k + "  " + t + "  " + p);

        System.out.println(solution(n,  k,  t,  p,  1,   0,1,  1, 1));
    }

//    int nPosle,
    public static double solution(int n, int dolg, int t, double p, int currentN, int nPred, int currentT, double currP, double prevP) {

        while (currentT <= t) {
            double[] pArr = new double[n];
            int[] dolgArr = new int[n];
            currentN = 1;

            while (currentN <= n) {
                currP = (Math.pow((1 - p), currentN) * Math.pow(p, (n - currentN))) * (factorial(n) / (factorial(n - currentN) * factorial(currentN)));
                int nPosle = (n - currentN);
                if (currentN + dolg > n) {
                    dolgArr[currentN - 1] = currentN + dolg - n;
                } else {
                    dolgArr[currentN - 1] = 0;
                }
                pArr[currentN - 1] = prevP * currP;
                System.out.println(" before  recurs  currP=" + currP + "  nPosle = " + nPosle + " currN=" + currentN + "   currentT = " + currentT);
                solution(n, (dolgArr[currentN - 1] + nPosle + currentN - n), t, p, currentN, currentN, currentT, pArr[currentN-1], currP);



                currentN++;
            }
            currentT++;

            if (currentT > t) {
                System.out.println("in final = " + Arrays.toString(pArr) + "  dolg = " + Arrays.toString(dolgArr));
                return findMatExpect(pArr, dolgArr);
            }
        }

        return 0;
    }



    public static double findMatExpect(double[] P, int[] dolg) {
        double M = 0;
        for (int i = 0; i < P.length; i++) {
            if (dolg[i] <= 0) {
                continue;
            }
            M += P[i] * dolg[i];
        }

        return M;
    }

    public static int factorial(int n) {
        int result = 1;
        if (n == 1 || n == 0) {
            return result;
        }
        result = n * factorial(n - 1);
        return result;
    }

//
//    static double solution(int n, int k, int t, double p, int currentN, int currentK, int currentT, double currP, double prevP, double M) {
//
//        if (currentT > t) {
//            return M;
//        }
//
//        while (currentK > 0) {
//            M = 0;
//            currP = prevP * Math.pow((1 - p), currentN);
//            M += currentK * currP;
//            solution(n, k, t, p, currentN--, currentK--, currentT, currP, prevP, M);
//            currentK--;
//
//        }
//
//
//
//
//        return 0;
//    }

//    static double solution(int n, int k, int t, double p) {
//        int countK = k;
//        int countT = 1;
//        double M = 0;
//
//        Map<Integer, Double> map = new HashMap<>();
//        for (int i = 1; i <= k; i++) {
//            map.put(i, 0.0);
//        }
//
//        double currentP = 1;
//        double promP = 1;
//        while (countT <= t) {
//            int currN = n;
//            countK = k;
//            M = 0;
//            System.out.println(countT);
//
//            while (countK > 0) {
//                currentP = Math.pow((1 - 0.125), n);
//                map.put(countK, currentP*promP);
//                M += countK * currentP;
//                System.out.println("cur P = " + currentP + "  M = " + M + "  map = " + map + "   M = " + M + "   promP = " + promP);
//                countK--;
//                n--;
//            }
//            countT++;
//            promP = currentP;
//        }
//
//        System.out.println();
//
//        return M;
//    }

}
