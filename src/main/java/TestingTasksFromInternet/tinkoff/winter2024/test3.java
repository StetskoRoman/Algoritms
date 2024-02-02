package TestingTasksFromInternet.tinkoff.winter2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class test3 {

    public static void main(String[] args) {

        int a = 15;
        int b = 25;
        Integer B = 25;
        List<Integer> list = new ArrayList<>();
        boolean[] booleans = new boolean[5];
        List<Boolean> booleanList = new ArrayList<>();
        list.add(2);
        System.out.println(list + "   " + a + "   " + B+ "   " + booleanList + Arrays.toString(booleans));
        calc(list, a, B, booleanList, booleans);
        System.out.println(list + "   " + a + "   " + B + "   " + booleanList + Arrays.toString(booleans));

        Pair pair = new Pair(1, 3);
        System.out.println(pair);
        changePair(pair);
        System.out.println(pair);
    }

    static void calc(List<Integer> list, int a, Integer b, List<Boolean> booleanList, boolean[] booleans) {
        a += 1;
        b = b + 2;
        list.add(4);
        list.add(6);
        booleanList.add(true);
        booleans[2] = true;
        return;
    }

    static void changePair(Pair pair) {
        pair.feed += 2;
        pair.interest += 3;
    }

    static class Pair implements Comparable<Pair> {

        int interest;
        int feed;

        public Pair(int interest, int feed) {
            this.interest = interest;
            this.feed = feed;
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
