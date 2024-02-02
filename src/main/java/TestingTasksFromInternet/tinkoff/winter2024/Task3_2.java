package TestingTasksFromInternet.tinkoff.winter2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3_2 {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        int[] nums;
        List<int[]> list = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    countLine++;
                    continue;
                }

                if (countLine <= n ) {
                    nums = new int[3];
                    for (int i = 0; i < 3; i++) {
                        nums[i] = Integer.parseInt(tokens[i]);
                    }
                    list.add(nums);
                    countLine++;

                    if (countLine == n + 1) {
                        break;
                    }
                }
            }
        }

        boolean res = solution(list);
        if (res == true) {
            System.out.println("YES");

        } else System.out.println("NO");
    }

    static boolean solution(List<int[]> list) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] + list.get(i)[1] > list.get(i)[2]) {
                return false;
            }
        }

        int amountGifts = list.size();
        int currentDay = 0;
        int giftsSent = 0;
        boolean[] giftedAlready = new boolean[amountGifts];
        int[] readyTime = new int[amountGifts];
        int[] sTime = new int[amountGifts];
        for (int i = 0; i < amountGifts; i++) {
            readyTime[i] = list.get(i)[0] + list.get(i)[1];
            sTime[i] = list.get(i)[2];
        }

        int lastDay = Integer.MIN_VALUE;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[2] > lastDay) {
                lastDay = list.get(i)[2];
            }
        }

        while (true) {

            int currentGift = 0;
            int fasterSent = Integer.MAX_VALUE;
            for (int i = 0; i < amountGifts; i++) {
                if (sTime[i] < fasterSent && giftedAlready[i] == false) {
                    fasterSent = sTime[i];
                    currentGift = i;
                }
            }

            int rightGift = Integer.MAX_VALUE;
            for (int i = 0; i < amountGifts; i++) {
                if (fasterSent == sTime[i] && readyTime[i] < rightGift && giftedAlready[i] == false) {
                    rightGift = readyTime[i];
                    currentGift = i;
                }
            }

            if (currentDay <= sTime[currentGift] && giftedAlready[currentGift] == false) {

                if (currentDay < readyTime[currentGift]) {
                    currentDay = readyTime[currentGift];
                }
                giftsSent++;
                giftedAlready[currentGift] = true;
                currentDay++;
                System.out.println("giftSent = " + giftsSent + "   currentDay = " + currentDay + "  " + Arrays.toString(giftedAlready) + "  " + Arrays.toString(readyTime)) ;
                if (giftsSent == amountGifts) {
                    return true;
                }

            } else return false;

        }

    }
}


//            System.out.println("current gift = " + currentGift + "  fasterSent = " + fasterSent);


//                System.out.println("giftSent = " + giftsSent + "   currentDay = " + currentDay + "  " + Arrays.toString(giftedAlready) + "  " + Arrays.toString(readyTime)) ;