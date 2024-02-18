package TestingTasksFromInternet.realInterviewTasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinsTask {

//    дано количество номиналов монет, список монет, сумма которую нужно набрать за наименьшее количество монет   https://www.youtube.com/watch?v=Hdr64lKQ3e4&list=LL&index=3
//    O(M * k) - M - сумма которую найти, К - количество монет
    public static void main(String[] args) {


//        int [] coins = new int[]{1,4,5,15,25, 50, 100};
        int[] coins = new int[]{1, 4, 5, 8};
        int sum = 87;
        minCoinsCounter(coins, sum);

        howManyWaysWithoutRecursion(coins, sum);


    }

    // what is the minimum number of coin
    static long minCoinsCounter(int[] coins, int sum) {

        List<Integer> resList = new ArrayList<>();
        long[] dp = new long[sum + 1];
        int[] prev = new int[sum + 1];
        prev[0] = 0;
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                int delta = i - coins[j];
                if (delta < 0) {
                    break;  // если по порядку все монеты, то можно break и сократить, хотя монеты должны быть по порядку!!! иначе снизу скрашится и будет перезаписано dp[i]
                }
                dp[i] = minBetweenAAndB(dp[i], dp[delta] + 1);
            }
        }
                System.out.println("\n " + "db = " + Arrays.toString(dp) + "    " + dp[sum]);
        return dp[sum];
    }

    static long howManyWaysWithoutRecursion(int[] coins, int sum) {
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < sum + 1; i++) {
            list.add(0l);
        }
        list.set(0, 1l);
        for (int i = 1; i < sum + 1; i++) {

            for (int j = 0; j < coins.length; j++) {
                int delta = i - coins[j];
                if (delta < 0) {
                    break;
                }
                System.out.println("list.get(i) = " + list.get(i) + " i = " + i + "   list.get(delta) = " + list.get(delta) + "  delta = " + delta);
                long insertInList = list.get(i) + list.get(delta);
                list.set(i, insertInList);
            }
        }
        System.out.println(list);
        return list.get(sum);

    }

    static long minBetweenAAndB(long a, long b) {
// сравнение с нулем важно для первых значений dp, например при  i = 2 dp[2] == 0, и сравнивать будем с db[delta = 2 - 1] + 1, т.е. в результате будет опять таки 2
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        if (a <= b) {
            return a;
        } else return b;
    }

}

//        монеты записать бы, но пока не получается
//                     dp[i] = minBetweenAAndB(dp[i], dp[delta] + 1);
//                if (i == 1) {
//                    prev[1] = 0;
//                    continue;
//                }
//                if (prev[delta] == 0) {
//                    prev[i] = prev[delta] + dp[i] - 1;
//                    System.out.println(" if i = " + i + " prev[i] = " + prev[i] + " delta = " + delta);
//                } else
//                    prev[i] = prev[delta] + dp[i];
//
//            }
//        }
//        System.out.print("        ");
//        for (int i = 0; i < sum + 1; i++) {
//            System.out.print(i + "  ");
//        }
//        System.out.println("\n " + "db = " + Arrays.toString(dp));
//        System.out.println("количество монет для сбора = " + dp[sum]);
//        System.out.println("Prev = " + Arrays.toString(prev));