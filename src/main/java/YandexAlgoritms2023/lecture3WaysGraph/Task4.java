package YandexAlgoritms2023.lecture3WaysGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Task4 {

    public static void main(String[] args) throws IOException {
        int countLine = 0;
        int r = 0;
        int n = 0;

        List<int[]> listRoads = new ArrayList<>();
        int d = 0;
        int v = 0;


        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {

                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);

                    countLine++;
                    continue;
                }

                if (countLine == 1) {
                    d = Integer.parseInt(tokens[0]);
                    v = Integer.parseInt(tokens[1]);
                    countLine++;
                    continue;
                }

                if (countLine == 2) {
                    r = Integer.parseInt(tokens[0]);
                    countLine++;
                    continue;
                }

                if (countLine <= r + 2) {
                    int[] wayLength = new int[4];
                    wayLength[0] = Integer.parseInt(tokens[0]);
                    wayLength[1] = Integer.parseInt(tokens[1]);
                    wayLength[2] = Integer.parseInt(tokens[2]);
                    wayLength[3] = Integer.parseInt(tokens[3]);
                    listRoads.add(wayLength);
                    countLine++;

                    if (countLine == r + 3) {
                        break;
                    }
                }

            }
        }

//        for (int i = 0; i < listRoads.size(); i++) {
//            System.out.println(Arrays.toString(listRoads.get(i)));
//        }

        long res = minLength(listRoads, n, d, v);
        System.out.println(res);

    }

    public static long minLength(List<int[]> list, int N, int d, int v) {
        int n = N + 1;
        List<List<int[]>> workList = new ArrayList<>();
        workList.add(new ArrayList<>(Collections.singleton(new int[]{0, 0, 0})));
        long[] dist = new long[n];
        List<Boolean> visitedList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            visitedList.add(false);
            dist[i] = Long.MAX_VALUE;
        }
        visitedList.set(0, true);
        dist[d] = 0;

        for (int i = 1; i < n; i++) {
            workList.add(new ArrayList<>());
        }

//        заполняем список смежности c двусторонними дорогами
        for (int i = 0; i < list.size(); i++) {
            int[] way = new int[3];
            way[0] = list.get(i)[2];
            way[1] = list.get(i)[1];   //время отправления
            way[2] = list.get(i)[3];    //время прибытия

            workList.get(list.get(i)[0]).add(way);

        }

        TreeSet<Ways> treeSet = new TreeSet<>();
        for (int i = 1; i < n; i++) {

            if (i == d) {
                treeSet.add(new Ways(0, i));
                continue;
            }
            treeSet.add(new Ways(Long.MAX_VALUE, i));
        }

//        System.out.println(" treeSET = " + treeSet);

        while (visitedList.contains(false)) {

            if (visitedList.get(v) == true) {
                break;
            }

            if (treeSet.isEmpty()) {
                break;
            }

            Ways currentWay = treeSet.pollFirst();
//            так оставить для тех у кого нет пути
            if (visitedList.get(currentWay.town) == true || currentWay.cost == Long.MAX_VALUE) {
                continue;
            }

            int currentI = currentWay.town;
            long currentNumber = currentWay.cost;
            int startTime;
//            System.out.println("current i = " + currentI+  "  currentNumber = " + currentNumber + " start time ");

            visitedList.set(currentI, true);

            if (!workList.get(currentI).isEmpty()) {

                for (int j = 0; j < workList.get(currentI).size(); j++) {
                    startTime = workList.get(currentI).get(j)[1];
                    long value = workList.get(currentI).get(j)[2];
//value для каждого J, если value окажется меньше чем предыдущее значение, то это новый путь по которому двигаемся  && startTime >= dist[currentI] - важна, без нее не работает
                    int currentTown = workList.get(currentI).get(j)[0];

                    if (value < (long) dist[currentTown]&& startTime >= dist[currentI]) {
                        Ways wayForDeleting = new Ways(dist[currentTown], currentTown);
                        treeSet.remove(wayForDeleting);
                        dist[currentTown] = value;
                        treeSet.add(new Ways(value, currentTown));
                    }
                }
            }

        }
//        System.out.println(treeSet);
//        System.out.println(Arrays.toString(dist));

        long result = resultDeykstra(dist, v);
        return result;
    }

    public static long resultDeykstra(long[] matrix, int f) {
        if (matrix[f] == Long.MAX_VALUE) {
            return -1;
        }
        return (long) matrix[f];
    }

    static class Ways implements Comparable<Ways> {

        long cost;
        int town;



        public Ways(long cost, int town) {
            this.cost = cost;
            this.town = town;

        }

        @Override
        public String toString() {
            return "Ways{" +
                    "cost=" + cost +
                    ", town=" + town +
                    '}';
        }

        @Override
        public int compareTo(Ways o) {
            if (this.cost == o.cost) {
                if (this.town == o.town) {
                    return 0;
                }
                if (this.town < o.town) {
                    return -1;
                } else {
                    return 1;
                }
            }
            if (this.cost < o.cost) {
                return -1;
            } else {
                return 1;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Ways ways)) return false;
            return cost == ways.cost && town == ways.town;
        }

        @Override
        public int hashCode() {
            return Objects.hash(cost, town);
        }
    }
}
