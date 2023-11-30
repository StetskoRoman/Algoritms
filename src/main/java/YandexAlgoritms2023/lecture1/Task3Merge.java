package YandexAlgoritms2023.lecture1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Task3Merge {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        int m = 0;
        long[] numsN = new long[0];
        long[] numsM = new long[0];
        PrintWriter printWriter = new PrintWriter(System.out);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    countLine++;
                    continue;
                }
                if (countLine == 1) {
                    numsN = new long[n];
                    for (int i = 0; i < n; i++) {
                        numsN[i] = Long.parseLong(tokens[i]);

                    }
                    countLine++;
                    continue;
                }
                if (countLine == 2) {
                    m = Integer.parseInt(tokens[0]);
                    countLine++;
                    continue;
                }
                if (countLine == 3) {
                    numsM = new long[m];
                    for (int i = 0; i < m; i++) {
                        numsM[i] = Long.parseLong(tokens[i]);
                    }

                    break;
                }
            }
        }

        long[] result = sortMerge(numsN, numsM);
        for (int i = 0; i < result.length; i++) {
                printWriter.print(result[i] + " ");
        }
        printWriter.flush();

    }

    static long[] sortMerge(long[] n, long[] m) {
        int size = n.length + m.length;
        long[] nums = new long[size];
        int nCount = 0;
        int mCount = 0;
        int i = 0;
        while (i < size) {
            if (nCount == n.length) {
                for (int j = i; j < size; j++) {
                    nums[j] = m[mCount];
                    mCount++;
                }
                break;
            }
            if (mCount == m.length) {
                for (int j = i; j < size; j++) {
                    nums[j] = n[nCount];
                    nCount++;
                }
                break;
            }

            if (n[nCount] < m[mCount]) {
                nums[i] = n[nCount];
                nCount++;
                i++;

            } else {
                nums[i] = m[mCount];
                mCount++;
                i++;
            }

        }
        return nums;
    }

}

//    System.out.println(Arrays.toString(numsN) + "   " + Arrays.toString(numsM));
// System.out.println("after  " + Arrays.toString(result));

//    printWriter.print(result[i] + " ");
//        }
//        printWriter.flush();
//System.out.println(nums[i - 1]);