package TestingTasksFromInternet.tinkoff.winter2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Task33 {

    public static void main(String[] args) throws IOException {

        PrintWriter printWriter = new PrintWriter(System.out);

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
        int giftsReady = 0;
        int giftsSent = 0;
        boolean[] gifted = new boolean[amountGifts];

        int minMaterial = Integer.MAX_VALUE;
        int lastDay = Integer.MIN_VALUE;
        int[] c = new int[amountGifts];
        for (int i = 0; i < list.size(); i++) {
            c[i] = list.get(i)[1];
            if (list.get(i)[2] > lastDay) {
                lastDay = list.get(i)[2];
            }
            if (list.get(i)[0] < minMaterial) {
                minMaterial = list.get(i)[0];
            }
        }

        while (true) {

            if (currentDay > lastDay) {
                return false;
            }

            if (giftsReady == 0 && giftsSent == amountGifts) {
                return true;
            }

            for (int i = 0; i < list.size(); i++) {
                if (currentDay > list.get(i)[0]) {
                    c[i]--;
                }

                if (c[i] == 0) {
                    giftsReady++;
                }
            }
            if (giftsReady == 0) {
                currentDay++;
                continue;
            }


            int sentFaster = Integer.MAX_VALUE;
            int currentPoint = 0;
            for (int i = 0; i < list.size(); i++) {
                if (c[i] <= 0 && gifted[i] == false && list.get(i)[2] < sentFaster) {
                    sentFaster = list.get(i)[2];
                    currentPoint = i;
                }
            }

            if (giftsReady > 0) {
                giftsReady--;
                gifted[currentPoint] = true;
                giftsSent++;
            }

            if (giftsSent == amountGifts) {
                return true;
            }

            currentDay++;

        }

    }
}

//  for (int i = 0; i < list.size(); i++) {
//            System.out.println(Arrays.toString(list.get(i)));
//        }

//            System.out.println("gifts ready = " + giftsReady + "   gifts sent = " + giftsSent + "   DAY= " + currentDay   +
//                    "   curr point " + currentPoint +  "    LAST DAY = " + lastDay);
//            System.out.println(Arrays.toString(gifted));
