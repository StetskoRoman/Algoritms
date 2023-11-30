package YandexAlgoritms2023.lecture3WaysGraph;

import javafx.util.Pair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

//TL 8

public class Task3Tree {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        int k = 0;

        List<int[]> listRoads = new ArrayList<>();
        int s = 0;
        int f = 0;

        PrintWriter printWriter = new PrintWriter(System.out);

//        Path path = Path.of("S:\\Program\\Projects\\Proj On work\\Tasks\\src\\main\\java\\YandexAlgoritms2023\\lecture3WaysGraph\\tasks3\\08 (6)");
//        (BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8))

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
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
//        long startTime = System.nanoTime();

        long distance = minLength(listRoads, n, s, f);

        System.out.println(distance);
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime)/1000000;
//
//        System.out.println("sout dur " + duration);
    }

    public static long minLength(List<int[]> list, int N, int s, int f) {
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

// отсюда изменения
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            map.put(i, Integer.MAX_VALUE);
//        }
//        map.put(s, 0);
//        System.out.println(map);

//        Queue<Ways> treeSet = new PriorityQueue<>();
//        for (int i = 1; i < n; i++) {
//            if (i == s) {
//                treeSet.add(new Ways(0, i));
//                continue;
//            }
//            treeSet.add(new Ways(Long.MAX_VALUE, i));
//        }

        TreeSet<Pair<Long, Integer>> treeSet = new TreeSet<>(Comparator
                .comparingLong(Pair<Long, Integer>::getKey)
                .thenComparing(Pair::getValue));
        for (int i = 1; i < n; i++) {
            if (i == s) {
                treeSet.add(new Pair<Long, Integer>(0l, i));
                continue;
            }
            treeSet.add(new Pair<Long, Integer>(Long.MAX_VALUE, i));
        }

//        System.out.println(treeSet);

        while (visitedList.contains(false)) {

            if (visitedList.get(f) == true) {
//                System.out.println(visitedList);
                break;
            }

            if (treeSet.isEmpty()) {
                break;
            }

            Pair<Long, Integer> currentWay = treeSet.pollFirst();
            int currentI = currentWay.getValue();
            long currentNumber = currentWay.getKey();

//            так оставить для тех у кого нет пути
            if (visitedList.get(currentI) == true || currentNumber == Long.MAX_VALUE) {
                continue;
            }


//            System.out.println(currentNumber);

            visitedList.set(currentI, true);

            if (!workList.get(currentI).isEmpty()) {

                for (int j = 0; j < workList.get(currentI).size(); j++) {

                    long value = currentNumber + (long) workList.get(currentI).get(j)[1];
//value для каждого J, если value окажется меньше чем предыдущее значение, то это новый путь по которому двигаемся
                    int currentTown = workList.get(currentI).get(j)[0];
                    if (value < (long) dist[currentTown]) {
                        Pair<Long, Integer> wayForDeleting = new Pair<>(dist[currentTown], currentTown);
                        treeSet.remove(wayForDeleting);
//                            System.out.println("removing " + dist[workList.get(currentI).get(j)[0]] + "   " + workList.get(currentI).get(j)[0]);
                        dist[currentTown] = value;
                        treeSet.add(new Pair<>(value, currentTown));
                    }
                }
            }
//            System.out.println(currentI + "   i + numb " + currentNumber );
//             System.out.println(currentWay + "  " + currentI + "  " + currentNumber);
//         System.out.println(treeSet);
//            System.out.println(Arrays.toString(dist));

        }
//        System.out.println(treeSet);
//        System.out.println(Arrays.toString(dist));

        long result = resultDeykstra(dist, f);
        return result;
    }

    public static long resultDeykstra(long[] matrix, int f) {
        if (matrix[f] == Long.MAX_VALUE) {
            return -1;
        }
        return (long) matrix[f];
    }
}

//    static class Ways implements Comparable<Ways> {
//
//        long cost;
//        int town;
//
//
//        public Ways(long cost, int y) {
//            this.cost = cost;
//            this.town = y;
//
//        }
//
//        @Override
//        public String toString() {
//            return "Ways{" +
//                    "cost=" + cost +
//                    ", town=" + town +
//                    '}';
//        }
//
//        @Override
//        public int compareTo(Ways o) {
//            if (this.cost == o.cost) {
//                if (this.town == o.town) {
//                    return 0;
//                }
//                if (this.town < o.town) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            }
//            if (this.cost < o.cost) {
//                return -1;
//            } else {
//                return 1;
//            }
//        }
//    }



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