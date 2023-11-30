package YandexAlgoritms2023.lecture3WaysGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

//TL 8

public class Task3ArrayList {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        int k = 0;

//        Path path = Path.of("S:\\Program\\Projects\\Proj On work\\Tasks\\src\\main\\java\\YandexAlgoritms2023\\lecture3WaysGraph\\tasks3\\08 (6)");

        List<Integer[]> listRoads = new ArrayList<>();
        int s = 0;
        int f = 0;

        PrintWriter printWriter = new PrintWriter(System.out);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))
        try ( BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

//        try ( BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    k = Integer.parseInt(tokens[1]);
                    countLine++;
                    continue;
                }
                if (countLine <= k) {
                    Integer[] wayLength = new Integer[3];
                    wayLength[0] = Integer.parseInt(tokens[0]);
                    wayLength[1] = Integer.parseInt(tokens[1]);
                    wayLength[2] = Integer.parseInt(tokens[2]);
                    listRoads.add(wayLength);
                    countLine++;
//                    System.out.println(countLine);
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

        long[] distance = minLength(listRoads, n, s, f);
        System.out.println(resultDeykstra(distance, f));

    }

    public static long[] minLength(List<Integer[]> list, int N, int s, int f) {
        long startTime = System.nanoTime();

        int n = N + 1;
        List<List<int[]>> workList = new ArrayList<>();
        workList.add(new ArrayList<>(Collections.singleton(new int[]{0, 0})));
        long[] dist = new long[n];
        List<Boolean> visitedList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            visitedList.add(false);
            dist[i] = Long.MAX_VALUE;
        }
        visitedList.set(0, true);
        dist[s] = 0;

        for (int i = 1; i < n; i++) {
            workList.add(new ArrayList<>());
        }

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

        PriorityQueue<Ways> queue = new PriorityQueue<>();
        for (int i = 1; i < n; i++) {
            if (i == s) {
                queue.add(new Ways(0, i));
                continue;
            }
            queue.add(new Ways(Long.MAX_VALUE, i));
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;


        long startTime4 = System.nanoTime();
        while (true) {

            if (visitedList.get(f) == true) {
                break;
            }

            if (queue.isEmpty()) {
                break;
            }

            Ways currentWay = queue.poll();

            int currentI = currentWay.town;
            long currentNumber = currentWay.cost;

//            if (visitedList.get(currentWay.town) == true || currentWay.cost == Long.MAX_VALUE) {
//// если поставить break ошибка в пятом тесте, так тоже работает но снизу код побыстрее по идее должен быть
//                continue;
//            }

            if (currentNumber == Long.MAX_VALUE) {
                if (visitedList.get(currentI) == true ) {
                    continue;
                } else break;
            }

            visitedList.set(currentI, true);

            if (!workList.get(currentI).isEmpty() ) {

                for (int j = 0; j < workList.get(currentI).size(); j++) {

                    long value = currentNumber + (long) workList.get(currentI).get(j)[1];
//value для каждого J, если value окажется меньше чем предыдущее значение, то это новый путь по которому двигаемся
                    int currentTown = workList.get(currentI).get(j)[0];

                    if (value < (long) dist[currentTown]) {
                        dist[currentTown] = value;
                        Ways ways = new Ways(value, currentTown);
                        queue.add(ways);

                    }
                }
            }
        }
//        System.out.println(Arrays.toString(dist));
        return dist;
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

        public Ways(long cost, int y) {
            this.cost = cost;
            this.town = y;

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
    }
}


// System.out.println(currentWay + "  " + currentI + "  " + currentNumber);
//         System.out.println(queue);



//System.out.println("visited  " + visitedList);

//            visitedList.set(currentI, true);
//
//            if (!workList.get(currentI).isEmpty()) {
////                System.out.println("work list  " + currentI + " not empty");
//                for (int j = 0; j < workList.get(currentI).size(); j++) {
////если пути нет условие    currentNumber - дистанцию в и-ом дист (стартовая)
////                if (dist[j] == -1) {
////                    continue;
////                }
//                    int value = 0;
//
//                    value = currentNumber + workList.get(currentI).get(j)[1];
////value для каждого J, если value окажется меньше чем предыдущее значение, то это новый путь по которому двигаемся
//                    if (value < dist[workList.get(currentI).get(j)[0]]) {
//                        dist[workList.get(currentI).get(j)[0]] = value;
//                        map.put(workList.get(currentI).get(j)[0], value);
//                    }
//                }
//                map.remove(currentI);
//            }
//        }

//        for (int i = 1; i < workList.size(); i++) {
//            System.out.println();
//            for (int j = 0; j < workList.get(i).size(); j++) {
//                System.out.print(Arrays.toString(workList.get(i).get(j)) + "  ");
//            }
//        }