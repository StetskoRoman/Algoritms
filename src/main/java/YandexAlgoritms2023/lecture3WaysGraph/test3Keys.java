package YandexAlgoritms2023.lecture3WaysGraph;

import java.util.*;

public class test3Keys {

    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 15);
        map.put(2, 10);
        map.put(2, 8);
        map.put(3, 20);
        map.put(5, 3);

        map.remove(2);

        System.out.println(map);

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(7);
        System.out.println("index = " + list.indexOf(5));

//        Map<Integer, Integer> myMap = (Map<Integer, Integer>) new PriorityQueue<>();
//        myMap.put(1, 3);
//        System.out.println(myMap);

        System.out.println(map.keySet());
//        getMinKey(map, 3);
        System.out.println(getMinKey(map, map.keySet().stream().toArray()));
    }

//    если что попробую так
    static private Integer getMinKey(Map<Integer, Integer> map, Object[] keys) {

        return map.entrySet().stream()
                .filter(p -> Arrays.asList(keys).contains(p.getKey()))
                .min(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();

    }
}
