package YandexAlgoritms2023.warmingUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Task6 {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int k = 0;
        int n = 0;
        long[] nums = new long[0];

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    k = Integer.parseInt(tokens[0]);
                    countLine++;
                    continue;
                }
                if (countLine == 1) {
                    n = Integer.parseInt(tokens[0]);
                    nums = new long[n];
                    countLine++;
                    continue;
                }
                if (countLine < n + 2) {
                    nums[countLine - 2] = Long.parseLong(tokens[0]);
                    countLine++;

                    if (countLine == n + 2) {
                        break;
                    }
                }
            }
        }

        System.out.println(liftTime(nums, k));

    }

    public static BigInteger liftTime(long[] nums, int k) {

        BigInteger fullLiftTime = new BigInteger("0");

        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) {
                sum = (nums[i] / k) * 2 * (i + 1);
                fullLiftTime = fullLiftTime.add(BigInteger.valueOf(sum));
                nums[i] = nums[i] % k;
            }
        }

        int floor = nums.length - 1;
        long freeLiftPlace = k;
        long addSum = 0l;
        while (floor >= -1) {

            if (floor == -1) {
                break;
            }

            if (freeLiftPlace == 0) {
                freeLiftPlace = k;
            }

            if (nums[floor] == 0) {
                floor--;
                continue;
            }

            if (nums[floor] != 0 && freeLiftPlace == k) {
                freeLiftPlace -= nums[floor];
                nums[floor] = 0;
                addSum += (floor + 1) * 2;
                floor--;
                continue;
            }
//            всех людей забирает если
            if (nums[floor] != 0 && nums[floor] <= freeLiftPlace) {
                freeLiftPlace -= nums[floor];
                nums[floor] = 0;
                floor--;
                continue;
            }
//            не всех людей забирает  соответсвтенно должен вернуться на тот же этаж
            if (nums[floor] != 0 && nums[floor] > freeLiftPlace) {
                nums[floor]-= freeLiftPlace;
                freeLiftPlace -= freeLiftPlace;
            }

        }

        fullLiftTime = fullLiftTime.add(BigInteger.valueOf(addSum));

        return fullLiftTime;
    }
}






// System.out.println(Arrays.toString(nums));
//        System.out.println("basic summ = " + fullLiftTime);

//  System.out.println("here free = " + freeLiftPlace + "    floor = " + floor);
//  System.out.println("add sum = " + addSum);