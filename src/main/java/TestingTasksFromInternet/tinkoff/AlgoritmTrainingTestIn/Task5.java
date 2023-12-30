package TestingTasksFromInternet.tinkoff.AlgoritmTrainingTestIn;

//2 3 5
//1 3 2
//2 3 1
//1 4 2
//3 3 3 3 4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task5 {
    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        int m = 0;
        int k = 0;
        List<int[]> list = new ArrayList<>();
        int[] kMatrix = new int[0];

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    m = Integer.parseInt(tokens[1]);
                    k = Integer.parseInt(tokens[2]);
                    countLine++;
                    continue;
                }

                if (countLine <= m) {
                    int[] matrix = new int[3];
                    for (int i = 0; i < tokens.length; i++) {
                        matrix[i] = Integer.parseInt(tokens[i]);
                    }
                    list.add(matrix);
                    countLine++;
                    continue;
                }
                if (countLine == m + 1) {
                    kMatrix = new int[k];
                    for (int i = 0; i < k; i++) {
                        kMatrix[i] = Integer.parseInt(tokens[i]);
                    }
                    break;
                }

            }
        }


        System.out.println(solution(list, kMatrix));
    }

    public static int solution(List<int[]> list, int[] kMatrix) {

        int k = kMatrix.length;
        int curTown = 1;
        int curCar = 0;
        for (int i = 0; i < list.size(); i++) {
            if (kMatrix[0] == list.get(i)[1] && list.get(i)[0] == 1) {
                curCar = list.get(i)[1];
            }
        }

        int countTransport = 0;
        if (curCar != 0) {

            while (countTransport < k) {

                curCar = kMatrix[countTransport];

                int countProhod = 0;
                for (int i = 0; i < list.size(); i++) {
                    if (curCar == list.get(i)[1] && curTown == list.get(i)[0]) {
                        curTown = list.get(i)[2];
                        break;
                    }
                    countProhod++;
                }
                if (countProhod >= list.size()) {
                    return 0;
                }

                countTransport++;

            }

        } else return 0;

        return curTown;
    }
}




//        System.out.println(Arrays.toString(list.get(2)));
//                System.out.println(Arrays.toString(kMatrix));