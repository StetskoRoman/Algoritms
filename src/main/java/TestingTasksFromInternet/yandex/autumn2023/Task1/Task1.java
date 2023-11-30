package TestingTasksFromInternet.yandex.autumn2023.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Task1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string1 = br.readLine();
        String string2 = br.readLine();
        br.close();

        String[] beginningStr = string1.split(" ");
        String[] endingStr = string2.split(" ");
        int[] beginning = new int[beginningStr.length];
        int[] ending = new int[endingStr.length];

        for (int i = 0; i < beginning.length; i++) {
            beginning[i] = Integer.parseInt(beginningStr[i]);
            ending[i] = Integer.parseInt(endingStr[i]);
        }

        long beginningTime = calculateTimeInSec(beginning);
        long endingTime = calculateTimeInSec(ending);

        long delta = endingTime - beginningTime;
        long dayInSec = 60 * 60 * 24;
        long resDays = (delta / dayInSec);
        long resSec = (int) (delta % dayInSec);
        System.out.println(resDays + " " + resSec);
    }

    public static long calculateTimeInSec(int[] nums) {
        long[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        long dayInSec = 60 * 60 * 24;
        long countDays = 0;
        long resultSec = 0;

        for (int i = 0; i < daysInMonth.length; i++) {
            if (i + 1 == nums[1]) {
                countDays += nums[2] - 1;
                break;
            }
            countDays += daysInMonth[i];
        }

        resultSec = 365 * nums[0] * dayInSec
                + dayInSec * countDays
                + nums[3] * 3600
                + nums[4] * 60
                + nums[5];

        return resultSec;
    }

}
