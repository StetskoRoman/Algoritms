package YandexAlgoritms2023.lecture3WaysGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Task2WayDeykstra {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        int[][] matrix = new int[0][0];
        int s = 0;
        int f = 0;

        PrintWriter printWriter = new PrintWriter(System.out);


        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    s = Integer.parseInt(tokens[1]);
                    f = Integer.parseInt(tokens[2]);
                    matrix = new int[n][n];
                    countLine++;
                    continue;
                }
                if (countLine <= n) {
                    for (int i = 0; i < matrix[countLine - 1].length; i++) {
                        matrix[countLine - 1][i] = Integer.parseInt(tokens[i]);
                    }
                    countLine++;
                    if (countLine == n + 1) {
                        break;
                    }
                }
            }
        }

        Deque<Integer> res = minWay(matrix, s, f);
        while (!res.isEmpty()) {
            printWriter.print(res.pop() + " ");
        }
        printWriter.flush();

    }

    public static Deque<Integer> minWay(int[][] matrix, int s, int f) {
        int n = matrix.length + 1;
        int[][] workMatrix = new int[n][n];
        int[] dist = new int[n];
        int[] prev = new int[n];
        List<Boolean> visitedList = new ArrayList<>();
        visitedList.add(false);

        for (int i = 1; i < n; i++) {
            visitedList.add(false);
            dist[i] = Integer.MAX_VALUE;
            prev[i] = 0;
        }
//begining point s
        prev[s] = -1;
        dist[s] = 0;
        dist[0] = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    workMatrix[i][j] = 0;
                    continue;
                }
                workMatrix[i][j] = matrix[i-1][j-1];
            }
        }

        while (visitedList.contains(false)) {
            int min = Integer.MAX_VALUE;
            int currentI = -1;
            int currentNumber = 0;
            for (int i = 1; i < n; i++) {
                if (dist[i] < min && visitedList.get(i) == false && dist[i] != -1) {
                    min = dist[i];
                    currentI = i;
                    currentNumber = dist[i];
                }
            }
            if (currentI == -1) {
                break;
            }
            visitedList.set(currentI, true);

            for (int j = 1; j < n; j++) {
//если пути нет условие    currentNumber - дистанцию в и-ом дист (стартовая)
                if (dist[j] == -1 || workMatrix[currentI][j] == -1) {
                    continue;
                }
                int value = 0;

                value = currentNumber + workMatrix[currentI][j];
//value для каждого J, если value окажется меньше чем предыдущее значение, то это новый путь по которому двигаемся
                if (value < dist[j]) {
                    dist[j] = value;
                    prev[j] = currentI;
                }
            }
        }


        Deque<Integer> stack = new ArrayDeque<>();

        if (prev[f] == 0) {
            stack.push(-1);
            return stack;
        }

        int currentF = f;

        stack.push(currentF);

        while (currentF > 0) {

            for (int i = 1; i < n; i++) {
                if (i == currentF) {
                    currentF = prev[i];
                    if (currentF == -1) {
                        break;
                    }
                    stack.push(prev[i]);

                }
            }
        }
        return stack;
    }
}

//System.out.println(Arrays.toString(prev));

// System.out.println(currentF);

//   System.out.println(Arrays.toString(prev));

//        for (int i = 0; i < matrix.length; i++) {
//            System.out.println();
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//        }

//   System.out.println(stack);
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());



//    public static int resultDeykstra(int[] matrix, int f) {
//        if (matrix[f] == Integer.MAX_VALUE) {
//            return -1;
//        }
//        return matrix[f];
//    }

//System.out.println(Arrays.toString(prev));