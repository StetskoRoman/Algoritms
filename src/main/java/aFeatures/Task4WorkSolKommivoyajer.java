package aFeatures;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

//Неориентированный взвешенный граф задан матрицей смежности. Найдите кратчайший цикл, который начинается и заканчивается в вершине номер 1 и проходит через все
// вершины по одному разу.
//
//Формат ввода
//В первой строке вводится число N (N ≤ 10) — количество вершин графа. Следующие N строк содержат по N целых неотрицательных чисел и задают матрицу смежности.
// Число 0 означает, что ребро отстутствует. Любое другое число задаёт вес ребра.
public class Task4WorkSolKommivoyajer {

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
        ArrayList<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
        ArrayList<Integer> result = solution(workMatrix, 1, 1, 1, visited, res, 0);
//        System.out.println(result);
        Integer finalres = Collections.min(result);
        System.out.println(finalres);
//        System.out.println(set);

    }


//    public static ArrayList<Integer> solution(int[][] mat, int current, int previous, int targetPoint,
//                                              ArrayList<Boolean> visited, ArrayList<Integer> res, int sum, ) throws FileNotFoundException {
        public static ArrayList<Integer> solution(int[][] mat, int current, int previous, int targetPoint,
                                              ArrayList<Boolean> visited, ArrayList<Integer> res, int sum) throws FileNotFoundException {

        boolean flag = false;  //нужен чтобы понять надо ли вернуться на предыдущую точку если пути до непосещенной точки из текущей нет
        int beforeCurrent = current;
        int beforePrevious = previous;

            visited.set(current, true);
        for (int k = 1; k < mat.length; k++) {
            if (visited.get(k) == false && mat[current][k] > 0) {
                flag = true;
                break;
            }
        }
        if (flag == true) {

            for (int i = 1; i < mat.length; i++) {

                if (visited.get(i) == false && mat[current][i] > 0) {
                    visited.set(i, true);

                    sum += mat[current][i];
                    previous = current;
                    current = i;

//                    System.out.println(" sum =  " + sum + "   previous =" + previous + "    current = " + current + "  visited = " + visited );
//                    далее блок если нашли все точки то наименьшим путем до 1-ой (target) вернуться  +  "   previous = " + previous + "  visited = " + visited
                    if (!visited.contains(false)) {

                        int[] resMatrix = minLength(mat, current, targetPoint);
                        int result = resultDeykstra(resMatrix, targetPoint);
//                        System.out.println("Заканчиваю одну петлю " + "  and current = " + current + "    and target = " + targetPoint + "    konechniy result + " + result + "  sum = " + sum);
//                        System.out.println(Arrays.toString(resMatrix) + "  and current = " + current + "    and target = " + targetPoint + "    konechniy result + " + result + "  sum = " + sum);
                        res.add(sum + result);
                    }

                    solution(mat, current, previous, targetPoint, visited, res, sum);
                    visited.set(i, false);
                    sum -= mat[previous][i];
                    current = beforeCurrent;
                    previous = beforePrevious;
                }
            }
        }

//        на случай если надо возвращаться, т.е. нет пути до новой непосещенной точки из текущей
        if (flag == false && visited.contains(false)) {
            res.add(-1);

        }

        return res;

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

