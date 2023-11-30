package TestingTasksFromInternet.competitionsYandex.Algoritms.Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task2Final {
    public static void main(String[] args) throws IOException {

        int countS = 0;
        int n = 0;
        int m = 0;
        int[] nums = new int[0];

        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in)) {

            String line;

            while ((line = buffer.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countS == 0) {
                    n = Integer.parseInt(tokens[0]);
                    m = Integer.parseInt(tokens[1]);
                    countS++;
                    continue;
                }

                nums = new int[n];
                for (int i = 0; i < tokens.length; i++) {
                    nums[i] = Integer.parseInt(tokens[i]);
                }
                break;
            }
        }

        System.out.println(solution(nums, m));


    }

    public static int solution(int[] nums, int m) {

        int min;
        int minPos = 0;
        int[] minPosArray = new int[m];
        int countMinPosArray = 0;
        int j = m;
        int countMin = 0;

        while (j > 0) {
            min = Integer.MAX_VALUE;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < min) {
                    countMin = 0;
                    min = nums[i];
                    minPos = i;
                }
                if (nums[i] == min) {
                    countMin++;
                }
            }


            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == min) {

                    if (j >= countMin) {
                        int counting = 0;

                        while (counting < countMin) {
                            for (int z = 0; z < nums.length; z++) {
                                if (nums[z] == min) {
                                    minPosArray[countMinPosArray] = z;
                                    nums[z] = Integer.MAX_VALUE;
                                    countMinPosArray++;
                                    counting++;
                                }
                            }
                        }
                        j -= countMin;
                        break;
                    }

                    if (j < countMin) {

                        int[] lastPos = new int[countMin];
                        int countV = 0;

                        for (int v = 0; v < nums.length; v++) {
                            if (nums[v] == min) {
                                lastPos[countV] = v;
                                countV++;
                            }
                        }

                        while (j > 0) {

                            int maxX = 0;
                            int maxP = 0;
                            int minP = 0;
                            int minN = Integer.MAX_VALUE;
                            int deltaMin = Integer.MAX_VALUE;
                            int deltaMax = Integer.MAX_VALUE;

                            int tempMin;
                            int tempMax;
                            int posMax = 0;
                            int posMin = 0;

                            for (int k = 0; k < minPosArray.length; k++) {
                                if (minPosArray[k] > maxX) {
                                    maxP = minPosArray[k];

                                }
                                if (minPosArray[k] < minN && (minPosArray[k]!=0)) {
                                    minP = minPosArray[k];

                                }
                            }

                            for (int c = 0; c < lastPos.length; c++) {

                                if (lastPos[c] < minP) {
                                    tempMin = minP - lastPos[c];
                                    if (tempMin < deltaMin) {
                                        deltaMin = tempMin;
                                        posMin = c;
                                    }
                                }

                                if (lastPos[c] > maxP) {
                                    tempMax = lastPos[c] - maxP;
                                    if (tempMax < deltaMax) {
                                        deltaMax = tempMax;
                                        posMax = c;
                                    }

                                }
                            }

                            if (j > 0) {
                                if (deltaMax < deltaMin) {

                                    minPosArray[countMinPosArray] = lastPos[posMax];
                                    countMinPosArray++;
                                    lastPos[posMax] = Integer.MAX_VALUE;
                                    j--;
                                } else {
                                    minPosArray[countMinPosArray] = lastPos[posMin];
                                    countMinPosArray++;
                                    lastPos[posMin] = Integer.MAX_VALUE;
                                    j--;
                                }
                            }
                        }
                    }
                }
            }
        }

        int max = 0;
        min = Integer.MAX_VALUE;

        for (int i = 0; i < minPosArray.length; i++) {
            if (minPosArray[i] > max) {
                max = minPosArray[i];
            }
            if (minPosArray[i] < min) {
                min = minPosArray[i];
            }
        }

        return max - min + 1;
    }
}
