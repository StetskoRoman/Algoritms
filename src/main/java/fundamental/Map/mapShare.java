package fundamental.Map;

import java.util.HashMap;
import java.util.Map;

public class mapShare {
    public static Map<String, String> mapShare(Map<String, String> map) {
        System.out.println(map);
        String stringA;
        String defStr = "0";
        if (map.containsKey("a")) {
            stringA = map.getOrDefault("a", defStr);
            if (map.containsKey("b")) {
                map.put("b", stringA);
            }
        }
        if (map.containsKey("c")) {
            map.remove("c");
        }

    return map;
    }
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "aaa");
        map.put("b", "bbb");
        map.put("c", "ccc");
        System.out.println(map);

        System.out.println(mapShare(map).entrySet());
    }
}
