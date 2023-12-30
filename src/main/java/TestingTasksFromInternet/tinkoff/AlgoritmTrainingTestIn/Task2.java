package TestingTasksFromInternet.tinkoff.AlgoritmTrainingTestIn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        List<String> list = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split("#");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    countLine++;
                    continue;
                }

                if (countLine == 1) {

                    for (int i = 0; i < tokens.length; i++) {
                        list.add(tokens[i]);
                    }
                    break;
                }
            }
        }

        int[] result = solution(list);
        System.out.println(result[0] + " " + result[1]);

    }

    public static int[] solution(List<String> list) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int[] res = new int[2];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() < min) {
                min = list.get(i).length();
            }
            if (list.get(i).length() > max) {
                max = list.get(i).length();
            }
        }
        res[0] = min;
        res[1] = max;
        return res;
    }
}
