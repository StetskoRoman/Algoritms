package garbage;

import java.util.*;

final class Animal {
        public  static final int a = 0;
    public static void main(String[] args) {
        Map<Integer, Integer> relations = new HashMap<>();
        relations.put(1, 2);
        relations.put(3, 4);
        relations.forEach((k, v) -> relations.put(v, k));
    }
}
