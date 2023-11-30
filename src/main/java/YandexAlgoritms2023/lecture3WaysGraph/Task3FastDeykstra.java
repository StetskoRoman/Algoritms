package YandexAlgoritms2023.lecture3WaysGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//TL 6
public class Task3FastDeykstra {

    public static void main(String[] args) throws IOException {


        int countLine = 0;
        int n = 0;
        int k = 0;

        List<int[]> listRoads = new ArrayList<>();
        int s = 0;
        int f = 0;

        PrintWriter printWriter = new PrintWriter(System.out);


        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    k = Integer.parseInt(tokens[1]);
                    countLine++;
//                    System.out.println("n = " + n + "   k = " + k);
                    continue;
                }
                if (countLine <= k) {
                    int[] wayLength = new int[3];
                    wayLength[0] = Integer.parseInt(tokens[0]);
                    wayLength[1] = Integer.parseInt(tokens[1]);
                    wayLength[2] = Integer.parseInt(tokens[2]);
                    listRoads.add(wayLength);
                    countLine++;
                    continue;
                }
                if (countLine == k + 1) {
                    s = Integer.parseInt(tokens[0]);
                    f = Integer.parseInt(tokens[1]);
                }
                break;
            }
        }

//        for (int i = 0; i < listRoads.size(); i++) {
//            System.out.println();
//            for (int j = 0; j < listRoads.get(i).length; j++) {
//                System.out.print(listRoads.get(i)[j] + "  ");
//            }
//        }

       int [] distance =  minLength(listRoads, n, s, f);

        System.out.println(resultDeykstra(distance, f));
    }

    public static int[] minLength(List<int[]> list, int N, int s, int f) {
        int n = N + 1;
        List<List<int[]>> workList = new ArrayList<>();
        workList.add(null);
        int[] dist = new int[n];
        List<Boolean> visitedList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            visitedList.add(false);
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;

        for (int i = 1; i < n; i++) {
            workList.add(new ArrayList<>());
        }
//        System.out.println(workList);
//        System.out.println(visitedList);
//        System.out.println(Arrays.toString(dist));
//        заполняем список смежности c двусторонними дорогами
        for (int i = 0; i < list.size(); i++) {
            int[] way = new int[2];
            way[0] = list.get(i)[1];
            way[1] = list.get(i)[2];

            workList.get(list.get(i)[0]).add(way);
//            с одним массивом путается
            int[] way2 = new int[2];
            way2[0] = list.get(i)[0];
            way2[1] = list.get(i)[2];

            workList.get(list.get(i)[1]).add(way2);

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

            for (int j = 0; j < workList.get(currentI).size(); j++) {
//если пути нет условие    currentNumber - дистанцию в и-ом дист (стартовая)
//                if (dist[j] == -1) {
//                    continue;
//                }
                int value = 0;

                value = currentNumber + workList.get(currentI).get(j)[1];
//value для каждого J, если value окажется меньше чем предыдущее значение, то это новый путь по которому двигаемся
                if (value < dist[workList.get(currentI).get(j)[0]]) {
                    dist[workList.get(currentI).get(j)[0]] = value;
                }
            }

        }

//        for (int i = 1; i < workList.size(); i++) {
//            System.out.println();
//            for (int j = 0; j < workList.get(i).size(); j++) {
//                System.out.print(Arrays.toString(workList.get(i).get(j)) + "  ");
//            }
//        }

//        System.out.println(Arrays.toString(dist));

        return dist;
    }

    public static int resultDeykstra(int[] matrix, int f) {
        if (matrix[f] == Integer.MAX_VALUE) {
            return -1;
        }
        return matrix[f];
    }
}

//System.out.println("way1 = " + Arrays.toString(way));

//           System.out.println("way 2 = " + Arrays.toString(way2));

//  System.out.println("s and f " + s + "   " + f);

//    public static int[] minLength(List<Integer> list, int s, int f) {
//
//        int n = matrix.length + 1;
//        int[][] workMatrix = new int[n][n];
//        int[] dist = new int[n];
//        List<Boolean> visitedList = new ArrayList<>();
//        visitedList.add(false);
//        for (int i = 1; i < n; i++) {
//            visitedList.add(false);
//            dist[i] = Integer.MAX_VALUE;
//        }
////begining point s
//        dist[s] = 0;
//        dist[0] = Integer.MAX_VALUE;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == 0 || j == 0) {
//                    workMatrix[i][j] = 0;
//                    continue;
//                }
//                workMatrix[i][j] = matrix[i - 1][j - 1];
//            }
//        }
//
//        while (visitedList.contains(false)) {
//            int min = Integer.MAX_VALUE;
//            int currentI = -1;
//            int currentNumber = 0;
//            for (int i = 1; i < n; i++) {
//                if (dist[i] < min && visitedList.get(i) == false && dist[i] != -1) {
//                    min = dist[i];
//                    currentI = i;
//                    currentNumber = dist[i];
//                }
//            }
//            if (currentI == -1) {
//                break;
//            }
//            visitedList.set(currentI, true);
//
//            for (int j = 1; j < n; j++) {
////если пути нет условие    currentNumber - дистанцию в и-ом дист (стартовая)
//                if (dist[j] == -1 || workMatrix[currentI][j] == -1) {
//                    continue;
//                }
//                int value = 0;
//
//                value = currentNumber + workMatrix[currentI][j];
////value для каждого J, если value окажется меньше чем предыдущее значение, то это новый путь по которому двигаемся
//                if (value < dist[j]) {
//                    dist[j] = value;
//                }
//            }
//
//        }
//
//        return dist;
//    }



//            way[0] = list.get(i)[0];
//            System.out.println("way 2 = " + Arrays.toString(way));
//            workList.get(list.get(i)[1]).add(way);

