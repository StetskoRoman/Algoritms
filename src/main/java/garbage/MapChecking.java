package garbage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapChecking {

    public static void main(String[] args) {

        Map<Set<Integer>, List<Integer>> setListMap = new HashMap<>();

        Map<Character, Integer> map = new HashMap<>();
        String str = "password";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }

        System.out.println(map);
        System.out.println();
    }
}
