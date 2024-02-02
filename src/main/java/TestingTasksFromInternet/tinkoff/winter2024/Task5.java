package TestingTasksFromInternet.tinkoff.winter2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class Task5 {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        int q = 0;

        List<Integer[]> listRoads = new ArrayList<>();
        int s = 0;
        int f = 0;
        List<Integer[]> listQuestions = new ArrayList<>();

        PrintWriter printWriter = new PrintWriter(System.out);
        try ( BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    countLine++;
                    continue;
                }

                if (countLine < n) {
                    Integer[] wayLength = new Integer[3];
                    wayLength[0] = Integer.parseInt(tokens[0]);
                    wayLength[1] = Integer.parseInt(tokens[1]);
                    wayLength[2] = 1;
                    listRoads.add(wayLength);
                    countLine++;
                    continue;
                }

                if (countLine == n) {
                    q = Integer.parseInt(tokens[0]);
                    countLine++;
                    continue;
                }

                if (countLine <= n + q) {
                    Integer[] question = new Integer[2];
                    question[0] = Integer.parseInt(tokens[0]);
                    question[1] = Integer.parseInt(tokens[1]);
                    listQuestions.add(question);
                    countLine++;

                    if (countLine == n + q + 1) {
                        break;
                    }
                    continue;
                }

                break;
            }
        }

        int [] result = resultSolutions(listRoads, listQuestions);
        for (int i = 0; i < result.length; i++) {
            printWriter.println(result[i]);
        }
        printWriter.flush();

    }

    static int minLength(List<Integer[]> list, int N, int s, int f) {

        int n = N + 1;
        List<List<int[]>> workList = new ArrayList<>();
        workList.add(new ArrayList<>(Collections.singleton(new int[]{0, 0})));
        int[] dist = new int[n];
        List<Boolean> visitedList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            visitedList.add(false);
            dist[i] = Integer.MAX_VALUE;
        }
        visitedList.set(0, true);
        dist[s] = 0;
        int[] prev = new int[n];

        for (int i = 1; i < n; i++) {
            workList.add(new ArrayList<>());
            prev[i] = 0;
        }
        prev[s] = -1;

        for (int i = 0; i < list.size(); i++) {

            int[] way = new int[2];
            way[0] = list.get(i)[1];
            way[1] = list.get(i)[2];
            workList.get(list.get(i)[0]).add(way);

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
            queue.add(new Ways(Integer.MAX_VALUE, i));
        }

        while (true) {

            if (visitedList.get(f) == true) {
                break;
            }

            if (queue.isEmpty()) {
                break;
            }

            Ways currentWay = queue.poll();
            int currentI = currentWay.town;
            int currentNumber = currentWay.cost;

            if (currentNumber == Integer.MAX_VALUE) {
                if (visitedList.get(currentI) == true ) {
                    continue;
                } else break;
            }

            visitedList.set(currentI, true);

            if (!workList.get(currentI).isEmpty() ) {

                for (int j = 0; j < workList.get(currentI).size(); j++) {

                    int value = (int) (currentNumber + workList.get(currentI).get(j)[1]);
                    int currentTown = workList.get(currentI).get(j)[0];
                    if (value < dist[currentTown]) {
                        dist[currentTown] = value;
                        prev[currentTown] = currentI;
                        Ways ways = new Ways(value, currentTown);
                        queue.add(ways);

                    }
                }
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();

        if (prev[f] == 0) {
            stack.push(-1);
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
        stack.pop();

        return stack.peek();
    }

    static int[] resultSolutions(List<Integer[]> list, List<Integer[]> listQuestions) {

        int[] result = new int[listQuestions.size()];
        for (int i = 0; i < listQuestions.size(); i++) {
            result[i] = minLength(list, list.size() + 1, listQuestions.get(i)[0], listQuestions.get(i)[1]);
        }

        return result;
    }

    static class Ways implements Comparable<Ways> {

        int cost;
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

        public Ways(int cost, int y) {
            this.cost = cost;
            this.town = y;

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

//
//        for (int i = 0; i < listRoads.size(); i++) {
//        System.out.println();
//        for (int j = 0; j < listRoads.get(i).length; j++) {
//        System.out.print(listRoads.get(i)[j] + "  ");
//        }
//        }

//   System.out.println(" q = " + q + "   questions = " + listQuestions);


//    System.out.println("listquest size = " + listQuestions.size());
//            for (int i = 0; i < listQuestions.size(); i++) {
//        System.out.println("quest = " + Arrays.toString(listQuestions.get(i)));
//        }

// System.out.println("result i =" + result[i] + "  i =" + i);