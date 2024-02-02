package garbage.expertSoft;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class testMapKey {

    public static void main(String[] args) {

        Map<Integer, Integer> source = new HashMap<>();
        Map<Integer, Integer> dest = new HashMap<>();

        source.put(1, 25);
        source.put(2, 50);

        source.forEach((key, value) -> {
            dest.put(value, key);
        });

        AtomicReference<Integer> newKeys = new AtomicReference<>(0);
        AtomicReference<Integer> sum = new AtomicReference<>(0);

        dest.forEach((key, value)-> {
            sum.updateAndGet(v -> v + value);
            newKeys.updateAndGet(v -> v + key);
        });
        

        System.out.println(sum + "    " + newKeys + "   " + dest);

//не работает (надо внешние переменные подставлять и менять их, стрим сам себя не поменяет)
        dest.forEach((key, value) -> {
            value = (value == 2 ? value += 50 : value);
            value += value;
        });

        System.out.println(dest);

//        for (Map.Entry<Integer, Integer> e : dest.entrySet()) {
//            Integer key = e.getKey();
//            Integer value = e.getValue();
//            value = (value == 50 ? value += 50 : value);
//        }


        System.out.println(dest.size() < source.size());
        System.out.println(dest.size() == source.size());
        System.out.println(dest.size() > source.size());

    }

}
