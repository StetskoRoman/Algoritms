package YandexAlgoritms3.Lect3DinamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task21Clear {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        int res = solution(n);
        System.out.println(res);

    }

    static int solution(int n) {
        double step = (double) 1 / 3;
        int totalElements = (int) (Math.pow(n, step) + 1);
        List<Integer> kList = new ArrayList<>();

        int[] dp = new int[totalElements + 1];

        for (int i = 0; i <= totalElements; i++) {
            kList.add(i * i * i);
        }

        int currentNumber = n;

        while (currentNumber >= 0) {

            double best;
            int posToAdd = 0;
            double lastBest = Double.MAX_VALUE;
            for (int i = 1; i < kList.size(); i++) {
                best = (double) currentNumber / (double) kList.get(i);
                if (best < lastBest && best >= 1) {
                    lastBest = best;
                    posToAdd = i;
                }
            }

            currentNumber = currentNumber - kList.get(posToAdd) * (int) lastBest;
            dp[posToAdd] += lastBest;

            if (currentNumber == 0) {
                break;
            }
        }

        int sum = Arrays.stream(dp).sum();

        return sum;
    }
}
