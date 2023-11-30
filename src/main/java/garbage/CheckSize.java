package garbage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckSize {

    public static void main(String[] args) {
        int n = 5;
        List<Set<Integer>> listSet = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> integerSet = new HashSet<>();
            integerSet.add(i + 10);
            listSet.add(integerSet);
        }

        listSet.get(0).addAll(listSet.get(3));
        System.out.println(listSet);

        listSet.remove(listSet.get(3));
        System.out.println(listSet);

        Set<Integer> targetSet = new HashSet<>();
        targetSet.addAll(listSet.get(0));
        System.out.println(targetSet);



//        if (listSet.get(j).contains(questions.get(i).get(1)) && !listSet.get(j).contains(questions.get(i).get(2))) {
////                            listSet.get(j).add(questions.get(i).get(2));
//            Set<Integer> targetSet = new HashSet<>();
//            for (int q = 0; q < listSet.size(); q++) {
//                if (listSet.get(q).contains(questions.get(i).get(2))) {
//                    targetSet.addAll(listSet.get(q));
//                }
//            }
//        }
    }
}
