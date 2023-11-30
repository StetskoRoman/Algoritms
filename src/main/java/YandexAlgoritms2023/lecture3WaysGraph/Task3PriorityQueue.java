package YandexAlgoritms2023.lecture3WaysGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

//TL 8

public class Task3PriorityQueue {

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
                    break;
                }

            }
        }

//        for (int i = 0; i < listRoads.size(); i++) {
//            System.out.println();
//            for (int j = 0; j < listRoads.get(i).length; j++) {
//                System.out.print(listRoads.get(i)[j] + "  ");
//            }
//        }
//        long startTime = System.nanoTime();

        List<Long> distance = minLength(listRoads, n, s, f);

        System.out.println(resultDeykstra(distance, f));
//        long endTime = System.nanoTime();
//        long duration = (endTime - startTime)/1000000;
//        printWriter.println("sout dur " + duration);
//        printWriter.flush();
    }

    public static List<Long> minLength(List<int[]> list, int N, int s, int f) {
        int n = N + 1;
        List<List<int[]>> workList = new ArrayList<>();
        workList.add(new ArrayList<>(Collections.singleton(new int[]{0, 0})));
//        long[] dist = new long[n];
        List<Long> dist = new ArrayList<>();
        List<Boolean> visitedList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            visitedList.add(false);
            dist.add(Long.MAX_VALUE);
//            dist[i] = Long.MAX_VALUE;
        }
        visitedList.set(0, true);
        dist.set(s, 0L);
//        dist[s] = 0;

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

//        Queue<Ways> queue = new PriorityQueue<>();
//        for (int i = 1; i < n; i++) {
//            if (i == s) {
//                queue.add(new Ways(0, i));
//                continue;
//            }
//            queue.add(new Ways(Long.MAX_VALUE, i));
//        }

        Queue<Long> queue = new PriorityQueue<>();
        for (int i = 1; i < n; i++) {
            if (i == s) {
                queue.add(0L);
                continue;
            }
            queue.add(Long.MAX_VALUE);
        }
//        System.out.println(queue);

//        int countsmt = 0;
        while (visitedList.contains(false)) {
//            countsmt++;
//            System.out.println(countsmt);


            if (visitedList.get(f) == true) {
//                System.out.println(visitedList);
                break;
            }

            if (queue.isEmpty()) {
                break;
            }

//            if (visitedList.get(currentWay.town) == true || currentWay.cost == Long.MAX_VALUE) {
//// если поставить break ошибка в пятом тесте
//                continue;
//            }
            long currentNumber = queue.poll();
            if (currentNumber == Long.MAX_VALUE) {
                break;
            }
            int currentI = 0;

            int pos = dist.indexOf(currentNumber);
            if (visitedList.get(pos) == false) {
                currentI = dist.indexOf(currentNumber);
            } else {
                for (int i = pos; i < n; i++) {
                    if (dist.get(i) == currentNumber && visitedList.get(i) == false) {
                            currentI = pos;
                            break;
                    }
                }

            }


            System.out.println("current number = " + currentNumber + "        " + currentI);
//            версия с объектом
//            int currentI = currentWay.town;
//            long currentNumber = currentWay.cost;
            if (currentNumber == Long.MAX_VALUE) {
                if (visitedList.get(currentI) == true) {
                    continue;
                } else break;
// если поставить break ошибка в пятом тесте

            }

            visitedList.set(currentI, true);
//            visitedList.set(currentI, true);
//&& visitedList.get(currentI) && visitedList.get(currentI) == false
            if (!workList.get(currentI).isEmpty()) {
//                continue;
//            } else {
//                System.out.println("work list  " + currentI + " not empty");
                for (int j = 0; j < workList.get(currentI).size(); j++) {

                    long value = currentNumber + (long) workList.get(currentI).get(j)[1];
//value для каждого J, если value окажется меньше чем предыдущее значение, то это новый путь по которому двигаемся
                    int currentTown = workList.get(currentI).get(j)[0];
                    if (value < dist.get(currentTown)) {
                        dist.set(currentTown, value);
//                        dist[currentTown] = value;
                        queue.add(value);
                    }
                }
            }
//            System.out.println(currentI + "   i + numb " + currentNumber );
//             System.out.println(currentWay + "  " + currentI + "  " + currentNumber);
//         System.out.println(queue);
//            System.out.println(Arrays.toString(dist));

        }
//        System.out.println(Arrays.toString(dist));
        System.out.println(dist);

        return dist;
    }

    public static long resultDeykstra(List<Long> matrix, int f) {
        if (matrix.get(f) == Long.MAX_VALUE) {
            return -1;
        }
        return (long) matrix.get(f);
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