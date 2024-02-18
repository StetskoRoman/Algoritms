package YandexAlgoritms3.Lect3DinamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task21SumKub {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        System.out.println(n);
        double step =  (double) 1 / 3;
        double resultDouble = Math.pow(n, step);
        int result = (int) Math.pow(n, step);
        System.out.println(result + "   " + resultDouble + "  step = " + step);

        int res = solution(n);
        System.out.println(res);


//        9
    }

    static int solution(int n) {
        double step =  (double) 1 / 3;
        int totalElements = (int) (Math.pow(n, step) + 1);
        List<Integer> kList = new ArrayList<>();

        int[] dp = new int[totalElements + 1];


//        for (int i = 0; i <= dp.length; i++) {
//            dp[i] = 0;
//        }

        int[] actualNumber = new int[totalElements + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 0;
            actualNumber[i] = n;
        }

        for (int i = 0; i <= totalElements; i++) {
            kList.add(i * i * i);
        }
        System.out.println(dp.length + "   " + kList.size());


        int currentNumber = n;
        int actNumber = n;

        while (currentNumber >= 0) {

            double best = Double.MAX_VALUE;
            int posToAdd = 0;
            double lastBest = Double.MAX_VALUE;
            for (int i = 1; i < kList.size(); i++) {


                    best = (double) currentNumber /(double) kList.get(i);
                System.out.println("currNumber = " + currentNumber + "  getI = " + kList.get(i) + " best = " + best + "  lastbest " + lastBest + "  klistLast = " );
                    if (best < lastBest && best >= 1 ) {
                        lastBest = best;
                        posToAdd = i;
                    }


            }

            currentNumber = currentNumber - kList.get(posToAdd) * (int)lastBest;

//            actualNumber[posToAdd] = actualNumber[posToAdd] - (kList.get(posToAdd) * lastBest);
            System.out.println(actualNumber[posToAdd] + "   " + Arrays.toString(actualNumber));
//            currentNumber = actualNumber[posToAdd];
            actNumber = currentNumber;
            dp[posToAdd] += lastBest;
            System.out.println("dp " + Arrays.toString(dp) + "  actualNumber" + Arrays.toString(actualNumber) + "   posoADd = " + posToAdd +
                    "   " + kList + " curr numb = " + currentNumber);

            if (currentNumber == 0) {
                break;
            }
        }

        int sum = Arrays.stream(dp).sum();



        return sum;
    }
}

// System.out.println(n);
//        double step =  (double) 1 / 3;
//        double resultDouble = Math.pow(n, step);
//        int result = (int) Math.pow(n, step);
//        System.out.println(result + "   " + resultDouble + "  step = " + step);