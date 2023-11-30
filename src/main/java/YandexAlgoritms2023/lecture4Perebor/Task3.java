package YandexAlgoritms2023.lecture4Perebor;

import TestingTasksFromInternet.yandex.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class Task3 {

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
        System.out.println(n);

        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }

        System.out.println();

        int[][] workMatrix = toWorkMatrix(matrix);

        for (int i = 0; i < workMatrix.length; i++) {
            System.out.println();
            for (int j = 0; j < workMatrix[i].length; j++) {
                System.out.print(workMatrix[i][j] + " ");
            }
        }

        HashSet<StringBuilder> set = new HashSet<>();
//        HashSet<StringBuilder> res = solution(workMatrix, set, new StringBuilder(), 0);
//        System.out.println(res);

        ArrayList<Boolean> visited = createVisited(n);


        ArrayList<ArrayList<Integer>> res = solution(workMatrix, new ArrayList<ArrayList<Integer>>(), new ArrayList<Integer>(), visited, 1);
        System.out.println(res);

//        int result = resultDeykstra(resMatrix, f);
//        System.out.println(result);
    }



    static ArrayList<ArrayList<Integer>> solution(int[][] workMatrix, ArrayList<ArrayList<Integer>> partyA, ArrayList<Integer> currentList, ArrayList<Boolean> visited, int current) {


        for (int i = 1; i < workMatrix.length; i++) {

            if (visited.get(i) == false && !currentList.contains(i) && currentList.size() < workMatrix.length - 2) {

                System.out.println("workMatrix.length - 1 = " + (workMatrix.length - 2));

                visited.set(i, true);
                currentList.add(i);
                partyA.add(currentList);
                current++;

                if (currentList.size() >= workMatrix.length - 2) {
                    partyA.add(currentList);
//                    return partyA;
                }

                solution(workMatrix, partyA, currentList, visited, current);
                current--;
                visited.set(i, false);

            }

//            sum += mat[current][i];
//            previous = current;
//            current = i;
//
////                    System.out.println(" sum =  " + sum + "   previous =" + previous + "    current = " + current + "  visited = " + visited );
////                    далее блок если нашли все точки то наименьшим путем до 1-ой (target) вернуться  +  "   previous = " + previous + "  visited = " + visited
//            if (!visited.contains(false)) {
//
//                int[] resMatrix = minLength(mat, current, targetPoint);
//                int result = resultDeykstra(resMatrix, targetPoint);
////                        System.out.println("Заканчиваю одну петлю " + "  and current = " + current + "    and target = " + targetPoint + "    konechniy result + " + result + "  sum = " + sum);
////                        System.out.println(Arrays.toString(resMatrix) + "  and current = " + current + "    and target = " + targetPoint + "    konechniy result + " + result + "  sum = " + sum);
//                res.add(sum + result);
//            }
//
//            solution(mat, current, previous, targetPoint, visited, res, sum);
//            visited.set(i, false);
//            sum -= mat[previous][i];
//            current = beforeCurrent;
//            previous = beforePrevious;

        }
//            for (int j = 0; j < partyA.size(); j++) {
//            if (!currentList.contains(i)) {    одинаковые все остаются тогда
//            if (!currentList.contains(i)) {
//
//                currentList.add(i);
//                partyA.add(currentList);
//                System.out.println("add i= " + i +   "   currentList  " + currentList + "   all lists " + partyA);
//                if (currentList.size() >= workMatrix.length - 2) {
//                    return partyA;
//                }
//
//                solution(workMatrix, partyA, currentList, visited);
//                currentList.remove(i);
//            }



//                        if (!partyA.contains(current)) {
//                current.append(i);
//                partyA.add(current);

//            partyA.add(new HashSet<>(i));
//
//            if (!partyA.contains(i)) {
//                System.out.println(" int i = " + i + "    add to A i = " + i);
//
//
//                if (partyA.size() == workMatrix.length - 2) {
//                    return partyA;
//                }
//                solution(workMatrix, partyA);
//                partyA.remove(i);
//            }


        return partyA;
    }

    static ArrayList<Boolean> createVisited(int n) {
        ArrayList<Boolean> visited = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            visited.add(false);
        }
        visited.set(0, true);
        return visited;
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
}









//    static HashSet<StringBuilder> solution(int[][] workMatrix, HashSet<StringBuilder> partyA, StringBuilder current, int k) {
//
//        for (int i = 1; i < workMatrix.length; i++) {
//            if (!partyA.contains(current)) {
//                current.append(i);
//                partyA.add(current);
//                k++;
//
//                if (k >= workMatrix.length - 2) {
//                    System.out.println("add to partyA " + k);
//                    partyA.add(current);
//                    return partyA;
//                }
//                solution(workMatrix, partyA, current, k);
//                System.out.println("try to replace  k = " + k + " before replacing current = " + current);
//                partyA.remove(current);
//                current.replace(k-1, k, String.valueOf(current));
//                k--;
//
//            }
//
//        }
//
//        return partyA;
//    }
