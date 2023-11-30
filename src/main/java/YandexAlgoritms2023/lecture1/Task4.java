package YandexAlgoritms2023.lecture1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Task4 {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        int[] nums = new int[0];
        long x = 0;

        PrintWriter printWriter = new PrintWriter(System.out);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    nums = new int[n];
                    countLine++;
                    continue;
                }

                if (countLine == 1) {

                    for (int i = 0; i < n; i++) {
                        nums[i] = Integer.parseInt(tokens[i]);
                    }
                    break;
                }
            }
        }

        int[] result = sortArray(nums);
        for (int num : result) {
            printWriter.print(num + " ");
        }
        printWriter.flush();
    }

    public static int [] sortArray(int[] arrayA){

        if (arrayA == null) {
            return null;
        }
        if (arrayA.length < 2) {
            return arrayA;
        }

        int [] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);

        int [] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);

        arrayB = sortArray(arrayB);
        arrayC = sortArray(arrayC);

        return mergeArray(arrayB, arrayC);
    }

    static int[] mergeArray(int[] n, int[] m) {
        int size = n.length + m.length;
        int[] nums = new int[size];
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
