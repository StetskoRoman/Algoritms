package leetCodeWork.StartTasks;

import java.util.*;
import java.util.stream.Collectors;

public class kWeakestRows {
    public static void main(String[] args) {
        int k = 2;
        int [][] mat = {{1,0,0,0}, {1,1,1,1},{1,0,0,0},{1,0,0,0}};
        List<Map<Integer, Integer>> list = new ArrayList<>();
        Map<Integer, Integer> mapArray = new HashMap<>();
        int[] arrayK = new int[mat.length];
        int temp = 0;
        for (int i = 0; i < mat.length; i++) {

            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    temp += 1;
                }
            }

            arrayK[i] = temp;
            temp = 0;
            mapArray.put(i, arrayK[i]);
            list.add(mapArray);
            System.out.println(mapArray);
        }
        System.out.println(Arrays.toString(arrayK));

        Map<Integer, Integer> sortedMap = mapArray.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(sortedMap);

//        for (int i = 0; i < k; i++) {
//            list.add(sortedMap.get(3));
//        }
        System.out.println("list " + list);

    }
}
