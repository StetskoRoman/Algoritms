package fundamental.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class mapAB4 {
    public static Map<String, String> mapAB4(Map<String, String> map) {
//        Set<Map.Entry<String, String>> entrySet =

        if (map.containsKey("a") && map.containsKey("b") && map.get("a").length() == map.get("b").length()) {
            map.put("a", "");
            map.put("b", "");
        }


        if (map.containsKey("a") && map.containsKey("b") && map.get("a").length() != map.get("b").length()) {
            String keyMax = null;
            int aLength = map.get("a").length();
            int bLength = map.get("b").length();
            if (aLength > bLength) {
                keyMax = "a";
            } else {
                keyMax = "b";
            }
            map.put("c", map.get(keyMax));
        }

        return map;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "a");
        map.put("b", "");
        map.put("c", "");
        System.out.println(map);
        System.out.println(mapAB4(map));
        System.out.println();
        Set<Map.Entry<String, String>> entrySet = map.entrySet(); //поток
        System.out.println(entrySet);

    }

}
