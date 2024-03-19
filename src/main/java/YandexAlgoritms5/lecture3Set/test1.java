package YandexAlgoritms5.lecture3Set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class test1 {

    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>(Set.of(1, 3, 5));
        Set<Integer> set2 = new HashSet<>(Set.of(2, 3, 5));
        Set<Integer> resSet = new HashSet<>();
        resSet.addAll(set1);
        resSet.addAll(set2);
        System.out.println(resSet);
        System.out.println(0%2);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 15);
        map.put(3, 30);
        System.out.println(map);
        System.out.println(map.get(2));
        System.out.println(map.get(1));
        System.out.println(map.get(1));
        System.out.println(map.entrySet());
    }
}
