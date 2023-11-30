package YandexAlgoritms2023.lecture3WaysGraph;

import java.util.*;

public class test3HeapList {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        System.out.println(list);

//        Queue<Pair> queue = new PriorityQueue<>();
//        queue.add(new Pair(15, 5));
//        queue.add(new Pair(10, 5));
//        queue.add(new Pair(9, 5));
//        queue.add(new Pair(10, 11));
//        queue.add(new Pair(9, 4));
//        System.out.println(queue.toString());

//
//        queue.poll();
//        System.out.println(queue.toString());
    }

//    static class Pair implements Comparator<Pair> {
//
//        int cost;
//        int town;
//
//
//        public Pair(int cost, int y) {
//            // TODO Auto-generated constructor stub
//            this.cost = cost;
//            this.town = y;
//
//        }
//
//        @Override
//        public String toString() {
//            return "Pair{" +
//                    "cost=" + cost +
//                    ", town=" + town +
//                    '}';
//        }

//        @Override
//        public int compareTo(Pair o) {
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
////            int res = this.compareTo(c)
//        }

//        @Override
//        public int compare(Pair o1, Pair o2) {
//            return Comparator.comparing(Pair);
//        }
//
//    }

//    static class Pair implements Comparable <Pair> {
//
//        int cost;
//        int town;
//
//
//        public Pair(int cost, int y) {
//            // TODO Auto-generated constructor stub
//            this.cost = cost;
//            this.town = y;
//
//        }
//
//        @Override
//        public String toString() {
//            return "Pair{" +
//                    "cost=" + cost +
//                    ", town=" + town +
//                    '}';
//        }
//
//        @Override
//        public int compareTo(Pair o) {
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
////            int res = this.compareTo(c)
//        }
//    }
}
