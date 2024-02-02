package aFeatures;

import com.sun.jdi.Value;

import java.security.Key;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class BinarySearcherGeneric<T extends Comparable<T>> {
    private T[] a;

    public BinarySearcherGeneric(T[] words) {
        a = words;
    }

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
//        integerList = List.of(1, 4, 6, 8, 5, 4, 2, 5, 11, 5);
        integerList = List.of(2, 4, 6, 8, 10);
        List<Integer> listFromStream = integerList.stream().map(m -> m = 5).collect(Collectors.toList()); //вернет все элементы по 5
        List<Integer> listFromStream2 = integerList.stream().filter(m->m==5).collect(Collectors.toList());
        List<Integer> listFromStream3 = integerList.stream().filter(m -> m == 5).findFirst().stream().toList();
        Map<Integer, Long> integerIntegerMap = integerList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Integer> finalIntegerList = integerList;
//        не получается в мапу положить так позицию в листе на место ключа

//                .collect(toMap(i -> finalIntegerList.indexOf(i), i -> finalIntegerList.get(i)));
//        Map<Integer, Integer> result2 = integerList.stream()
//                .collect(toMap(i -> finalIntegerList.get(i), Function.identity()));

//        System.out.println(result);
//        System.out.println(result2);
        System.out.println(listFromStream);
        System.out.println(listFromStream2);
        System.out.println(listFromStream3);
        System.out.println(integerIntegerMap);

        Ways[] massive = new Ways[5];
        for (int i = 0; i < massive.length; i++) {
            Ways ways = new Ways(i * 3 + 2, i);
            massive[i] = ways;
        }

        Ways way = new Ways(5, 1);
        BinarySearcherGeneric<Ways> binarySearcherGeneric = new BinarySearcherGeneric<>(massive);
        int posCurrWay = binarySearcherGeneric.search(way);
        System.out.println(posCurrWay);
        System.out.println(posCurrWay + "    way = " + massive[posCurrWay]);

    }

    public int search(Comparable<T> v) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            T midVal = a[mid];
            int result = v.compareTo(midVal);

            if (result < 0) {
                high = mid - 1;
            }

            else if (result > 0) {
                low = mid + 1;
            }

            else {
                return mid;
            }
        }

        return -1;
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


