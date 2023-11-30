package YandexAlgoritms2023.lecture3WaysGraph;

import java.util.TreeMap;
import java.util.TreeSet;

public class test3Tree {

    public static void main(String[] args) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(3, 5);
        map.put(1, 3);

        map.put(2, 1);
        System.out.println(map);

        map.put(3, 4);//повторяющиеся ключи перезапишет value
        System.out.println(map);
        int i = 2;
        System.out.println(map.get(i));  //возвращает значение по ключу

        map.put(1, map.get(1) + 4);
        System.out.println(map);

        System.out.println(map.ceilingEntry(0));

        TreeSet<Integer> integers = new TreeSet<>();
        integers.add(5);
        integers.add(3);
        integers.add(4);
        System.out.println(integers);
        System.out.println(integers.pollFirst());
        System.out.println(integers);
        System.out.println(integers.remove(4));
        System.out.println(integers);
    }
}


// 1  function Dijkstra(Graph, source):
//         2
//         3      create vertex set Q
//         4
//         5      for each vertex v in Graph:
//         6          dist[v] ← INFINITY
//         7          prev[v] ← UNDEFINED
//         8          add v to Q
//         9      dist[source] ← 0
//         10
//         11      while Q is not empty:
//         12          u ← vertex in Q with min dist[u]
//         13
//         14          remove u from Q
//         15
//         16          for each neighbor v of u:           // only v that are still in Q
//         17              alt ← dist[u] + length(u, v)
//         18              if alt < dist[v]:
//        19                  dist[v] ← alt
//        20                  prev[v] ← u
//        21
//        22      return dist[], prev[]
