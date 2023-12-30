package TestingTasksFromInternet.yandex.yandexWinterAnalis.task4;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task4SimpleNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        System.out.println(solution(n));

    }



    static List<Integer> eratosphenMethod(int n) {
        boolean[] nums = new boolean[n+1];
        List<Integer> result = new ArrayList<>();
        nums[0] = false;
        nums[1] = false;
        for (int i = 2; i < nums.length; i++) {
            nums[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (nums[i] == true) {
                for (int j = i * i; j <= n; j += i) {
                    nums[j] = false;
                }
            }
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == true) {
                result.add(i);
            }
        }

        return result;
    }

    static BigDecimal solution(int n) {

        double totalSimple = eratosphenMethod(n).size();
        double totalNotSimple = n - totalSimple;
        double probabilitySimple = totalSimple / n;
        double notSimpleProbability = totalNotSimple / n;

        int countTakesCard = 0;
        int totalCards = n;
        while (notSimpleProbability > probabilitySimple) {
            countTakesCard++;
            totalNotSimple--;
            totalCards--;
            notSimpleProbability *= (totalNotSimple / totalCards);
        }
//        System.out.println("probability not simple at the end " + notSimpleProbability + "   and total countedTakesCard = " + countTakesCard + "  totalNotSimple = " + totalNotSimple
//                + "  totalSimple= " + totalSimple);
//        double result = totalSimple / (n - countTakesCard);
        double result = totalSimple / n;
//        System.out.println("result before okr = " + result );

        BigDecimal res = new BigDecimal(result);
        BigDecimal finRes = res.setScale(2, RoundingMode.HALF_UP);

        return finRes;
    }

}

//        System.out.println("res = " + finRes);

//       System.out.println("probability not simple at the end " + notSimpleProbability);
//
//        System.out.println(result);



//        double number = 651.5176515121351;
//        number = Math.round(number * 100);
//        number = number/100;

// Слишком медленное
//    static int countSimpleNumbers(int n) {
//        int count;
//        int k = 6;
//        int notSimpleCount = 2;
//        while (k <= n) {
//
//            if (k % 2 != 0 || k % 3 != 0 || k % 5 != 0) {
//                for (int i = 2; i <= (k / 2) + 1; i++) {
//                    if (k % i == 0) {
////                    System.out.println("chislo k = " + k + " ne prostoe  pri delenii na i = " + i);
//                        notSimpleCount++;
//                        break;
//                    }
//
//                }
//            }
//
//
//
//            k++;
//        }
//
////        System.out.println("counted not simple  " + notSimpleCount);
//        count = n - notSimpleCount;
//        return count;
//    }
