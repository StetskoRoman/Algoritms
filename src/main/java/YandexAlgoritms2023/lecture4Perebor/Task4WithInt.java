package YandexAlgoritms2023.lecture4Perebor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task4WithInt {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        int[][] matrix = new int[0][0];


        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    if (n == 1) {
                        System.out.println(0);
                        return;
                    }
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

//        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        int[][] workMatrix = toWorkMatrix(matrix);
        ArrayList<Boolean> visited = createVisited(n);

//        for (int i = 0; i < matrix.length; i++) {
//            System.out.println();
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//        }
//        System.out.println(n);
//
//        for (int i = 0; i < workMatrix.length; i++) {
//            System.out.println();
//            for (int j = 0; j < workMatrix[i].length; j++) {
//                System.out.print(workMatrix[i][j] + " ");
//            }
//        }

        ArrayList<Integer> resList = new ArrayList<>();

//        int res = countWays(workMatrix, 1, 1, 1, visited, resList, 0);
        int res = countWays(workMatrix, 1, 1, 1, visited, resList, 0);
        System.out.println(res);

        System.out.println("final result = " + res);



    }

    static int countWays(int[][] mat, int currentPoint, int previous, int targetPoint, ArrayList<Boolean> visited, ArrayList<Integer> res, int sum) {
//        System.out.println(visited);
//        System.out.println("current point na vhode = " + currentPoint);

        int beforeCurrent = currentPoint;
        int beforePrevious = previous;
        if (currentPoint >= mat.length) {
            return 0;
        }

        visited.set(currentPoint, true);

        for (int j = 1; j < mat.length; j++) {
            if (j == currentPoint) {
                continue;
            }

            if (visited.get(j) == false && mat[currentPoint][j] > 0) {
                System.out.println("otkuda + kuda " + currentPoint + "    " + j + "   skok length  " + mat[currentPoint][j]);
//                System.out.println("sum before = " + sum);
                sum += mat[currentPoint][j];
//                System.out.println("sum after " + sum);
                visited.set(j, true);
                previous = currentPoint;
                currentPoint = j;

                if (!visited.contains(false)) {

                    int[] resMatrix = minLength(mat, currentPoint, targetPoint);


                    int result = resultDeykstra(resMatrix, targetPoint);
//                    System.out.println("result here = " + result);
                    sum+=result;
                    System.out.println(Arrays.toString(resMatrix) + "  and current = " + currentPoint +"    and target = " + targetPoint + "    konechniy result + " + result + "  sum = " + sum);

                    res.add(sum);
//                    System.out.println("print result " + res);
                    return sum;
                }

                sum = countWays(mat, currentPoint, previous, targetPoint, visited, res, sum);

                currentPoint = beforeCurrent;
                previous = beforePrevious;
                visited.set(j, false);
            }


            if (j == mat.length - 1 && mat[currentPoint][j] == 0) {

                sum += mat[currentPoint][previous];
                System.out.println("here i  sum = " + sum + "  currentPos = " + currentPoint + "    previous wiil be " + previous + "  before previous = " + beforePrevious);
                visited.set(currentPoint, true);
                currentPoint = previous;
                previous = beforePrevious;

                countWays(mat, currentPoint, previous, targetPoint, visited, res, sum);

//                как будто бы не надо, я ведь и так возвращаюсь к предыдущей точке
                currentPoint = beforeCurrent;
                previous = beforePrevious;
                visited.set(j, false);

            }
        }


        return sum;
    }

    static int[][] toWorkMatrix(int[][] mat) {
        int n = mat.length + 1;
        int[][] workMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    workMatrix[i][j] = 0;
                    continue;
                }
                workMatrix[i][j] = mat[i - 1][j - 1];
            }
        }
        return workMatrix;
    }

    static ArrayList<Boolean> createVisited(int n) {
        ArrayList<Boolean> visited = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            visited.add(false);
        }
        visited.set(0, true);
        return visited;
    }

    static int findMinRib(int[][] mat) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat.length; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                if (mat[i][j] < min) {
                    min = mat[i][j];
                }
            }
        }
        return min;
    }

    public static int[] minLength(int[][] workMatrix, int s, int f) {
        int n = workMatrix.length;
//        int[][] workMatrix = new int[n][n];
        int[] dist = new int[n];
        List<Boolean> visitedList = new ArrayList<>();
        visitedList.add(false);
        for (int i = 1; i < n; i++) {
            visitedList.add(false);
            dist[i] = Integer.MAX_VALUE;
        }
//begining point s
        dist[s] = 0;
        dist[0] = Integer.MAX_VALUE;


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
                }
            }

        }

        return dist;
    }

    public static int resultDeykstra(int[] matrix, int f) {
        if (matrix[f] == Integer.MAX_VALUE) {
            return -1;
        }
        return matrix[f];
    }
}

//    private static ArrayList<Integer> nQueen(int[][] mat, int k, ArrayList<Integer> res)
//    {
//        if (k == mat.length) {
//            return res;
//        }
//
//        for (int i = 0; i < mat.length; i++) {
//            if (isSafe(mat, k, i)) {
//                mat[k][i] = 1;
//                if (k == mat.length - 1) {
//                    res.add(1);
//                }
//
//                nQueen(mat, k + 1, res);
////                 возвращаемся
//                mat[k][i] = 0;
//            }
//        }
//        return res;
//    }


