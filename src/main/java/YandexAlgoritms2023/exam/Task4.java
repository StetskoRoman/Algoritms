package YandexAlgoritms2023.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Task4 {
    public static void main(String[] args) throws IOException {
        int countLine = 0;
        long n = 0;
        int m = 0;
        long[] dano = new long[0];
        long x = 0;


        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Long.parseLong(tokens[0]);
                    m = Integer.parseInt(tokens[1]);
                    dano = new long[m];
                    countLine++;
                    continue;
                }

                if (countLine == 1) {

                    for (int i = 0; i < m; i++) {
                        dano[i] = Integer.parseInt(tokens[i]);
                    }
                    break;
                }
            }
        }


//        System.out.println(Arrays.toString(dano) + "     m n " + m + "  " + n);
        int[] countDano = new int[m];
        ArrayList<long[]> result = solution(dano, countDano, new ArrayList<Long>(),  0, n, new ArrayList<long[]>());
//        for (int i = 0; i < result.size(); i++) {
//            System.out.println(Arrays.toString(result.get(i)));
//        }

        PrintWriter printWriter = new PrintWriter(System.out);
        long[] minus = new long[1];
        minus[0] = -1;
        if (result.isEmpty()) {
            printWriter.println(0);
            printWriter.flush();
            return;
        }
        if (result.get(0)[0] == -1) {
            printWriter.println(-1);
            printWriter.flush();
            return;
        }

        int length = minLength(result);
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).length == length) {
                printWriter.println(length);
                for (int j = 0; j < result.get(i).length; j++) {
                    printWriter.print(result.get(i)[j] + " ");
                }
                printWriter.flush();
                return;
            }
        }

    }
//, ArrayList<long[]> anotherRes
    static ArrayList<long[]> solution(long[] dano, int[] countDano, ArrayList<Long> nums, long k, long n, ArrayList<long[]> res) {

        if (k < n && !countCount(countDano) ) {
            long[] toRes = new long[1];
            toRes[0] = -1;
            res.add(toRes);
            return res;
        }

        if (k == n) {
            long[] toRes = new long[nums.size()];
            for (int i = 0; i < nums.size(); i++) {
                toRes[i] = nums.get(i);
            }
            res.add(toRes);
            return res;
        }

        for (int i = 0; i < dano.length; i++) {
            long current = dano[i];
            if (isSafe(k, current, n) && countDano[i] < 2) {
                countDano[i]++;
                nums.add(current);
//                k = sum(nums);
                k+=current;
                solution(dano, countDano, nums, k, n, res);
                countDano[i]--;
                k-=current;
//                k -= sum(nums);
                nums.remove(current);

            }
        }

        return res;
    }

    static boolean isSafe(long k, long current, long n) {
        if (current + k <= n) {
            return true;
        } else {
            return false;
        }
    }

//    static boolean isSafe(ArrayList<Long> nums, long k, long n) {
//        long sum = 0;
//        for (int i = 0; i < nums.size(); i++) {
//            sum += nums.get(i);
//        }
//        if (sum + k <= n) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    static Long sum(ArrayList<Long> nums) {
//        Long sum = 0l;
//        for (int i = 0; i < nums.size(); i++) {
//            sum += nums.get(i);
//        }
//        return sum;
//    }

    static boolean countCount(int[] countDano) {
        int count = 0;
        for (int i = 0; i < countDano.length; i++) {
            if (countDano[i] == 2) {
                count++;
            }
        }
        if (count == countDano.length) {
            return false;
        }
        return true;
    }

    static int minLength(ArrayList<long[]> res) {
        int length = Integer.MAX_VALUE;
        for (int i = 0; i < res.size(); i++) {
            if (length > res.get(i).length) {
                length = res.get(i).length;
            }
        }
        return length;
    }
}
