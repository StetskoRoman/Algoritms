package TestingTasksFromInternet.tinkoff.winter2024;

import java.util.*;
import java.util.stream.Collectors;

public class test4Pair {

    public static void main(String[] args) {
        Pair pair1 = new Pair(3, 5);
        Pair pair2 = new Pair(3, 5);
        Pair pair3 = new Pair(3, 5);
        Set<Pair> pairs = new HashSet<>();
        pairs.add(pair1);
        if (!pairs.contains(pair2)) {
            pairs.add(pair2);
        }
        pairs.add(pair2);
        pairs.add(pair3);

        System.out.println(pairs);

        List<Pair> pairList = new ArrayList<>();
        pairList.add(new Pair(3, 6));
        pairList.add(new Pair(4, 7));
        pairList.add(new Pair(6, 8));
        changePair(pairList.get(0));
        System.out.println(pairList.stream().collect(Collectors.toList()));
        System.out.println(pairList);
        System.out.println(pairList.stream().map(Pair::getInterest).collect(Collectors.toList()));

        Pair pair = new Pair(1, 3);
        changePair(pair);
        System.out.println(pair);
        Integer integer = 10;
        changeInteger(integer);
        System.out.println("Integer will not change " + integer);

        String str = "asd";
        changeString(str);
        System.out.println("String will nit change " + str);
    }

    static void changeString(String str) {
        str += 15;
        return;
    }

    static <T> void changeInteger(T integer){

        if (integer instanceof Integer) {
        }
        return;
    }

    static void changePair(Pair pair) {
        pair.feed+=2;
        pair.interest += 4;
        return;
    }

    static class Pair implements Comparable<Pair> {

        int interest;
        int feed;

        public Pair(int interest, int feed) {
            this.interest = interest;
            this.feed = feed;
        }

        public int getInterest() {
            return interest;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair pair)) return false;
            return interest == pair.interest && feed == pair.feed;
        }

        @Override
        public int hashCode() {
            return Objects.hash(interest, feed);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "interest=" + interest +
                    ", feed=" + feed +
                    '}';
        }

        @Override
        public int compareTo(Pair o) {
            if (this.feed == o.feed) {
                if (this.interest == o.interest) {
                    return 0;
                }

                if (this.interest < o.interest) {
                    return -1;
                } else {
                    return 1;
                }
            }
            if (this.feed < o.feed) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
