package TestingTasksFromInternet.yandex.autumn2023.Task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task5L {

    public static void main(String[] args) throws IOException {

        int countS = 0;
        int countN = 0;
        int n = 0;

        List<Long[]> listMatrix = new ArrayList<>();

        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in)) {

            String line;

            while ((line = buffer.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countS == 0) {
                    n = Integer.parseInt(tokens[0]);
                    countS++;
                    continue;
                }

                if (countS % 2 == 1) {
                    countS++;
                    continue;
                }

                if (countS % 2 == 0) {
                    Long[] matrix = new Long[tokens.length];
                    for (int i = 0; i < tokens.length; i++) {
                        matrix[i] = Long.valueOf(tokens[i]);
                    }
                    listMatrix.add(matrix);
                    countN++;
                    countS++;

                    if (countN == n) {
                        break;
                    }
                }
            }
        }

        long result = 0L;

        for (int i = 0; i < listMatrix.size(); i++) {
            for (int j = i + 1; j < listMatrix.size(); j++) {
                result += closeness(listMatrix.get(i), listMatrix.get(j));
            }
        }

        System.out.println(result);

    }

    public static long closeness(Long[] a, Long[] b) {
        long count = 0L;

        for (int i = 0; i < a.length; i++) {
            if (i == b.length) {
                break;
            }
            if (a[i] == b[i]) {
                count++;
            } else {
                break;
            }
        }
//System.out.println("count = " + count);
        return count;
    }
}

//System.out.println("count = " + count);

//21_474_836_479
//                int k = 0;
//                    k = Integer.parseInt(tokens[0]);

// System.out.println(n);
//
//         for (int i = 0; i < listMatrix.size(); i++) {
//        System.out.println(Arrays.toString(listMatrix.get(i)));
//        }
//
//        int s = closeness(listMatrix.get(0), listMatrix.get(2));
//        System.out.println("result " + s);




//            for (int i = 0; i < listMatrix.size(); i++) {
//        System.out.println(Arrays.toString(listMatrix.get(i)));
//        }
//
//        int s = closeness(listMatrix.get(0), listMatrix.get(2));
//        System.out.println("result " + s);
//
//        System.out.println(result);