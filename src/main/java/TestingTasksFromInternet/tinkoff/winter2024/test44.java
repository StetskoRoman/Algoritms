package TestingTasksFromInternet.tinkoff.winter2024;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test44 {

    public static void main(String[] args) {

        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(List.of(1, 5, 6));
        matrix.add(List.of(2));
        matrix.add(List.of(3, 4));
        matrix.add(List.of(3, 4));
        matrix.add(List.of(5, 6));
        matrix.add(List.of(1, 5, 6));
        System.out.println(matrix);

        List<List<Integer>> result = removeContainedSublists(matrix);
        Set<List<Integer>> set = new HashSet<>();
        set.addAll(matrix);
        System.out.println(set);
    }

    public static List<List<Integer>> removeContainedSublists(List<List<Integer>> matrix) {
        List<List<Integer>> result = new ArrayList<>();

        for (List<Integer> sublist : matrix) {
            boolean isContained = false;

            for (List<Integer> otherSublist : matrix) {
                if (sublist != otherSublist && isSubset(sublist, otherSublist)) {
                    isContained = true;
                    break;
                }
            }

            if (!isContained) {
                boolean isSubset = false;

                for (List<Integer> existingSublist : result) {
                    if (isSubset(sublist, existingSublist)) {
                        isSubset = true;
                        break;
                    }
                }

                if (!isSubset) {
                    result.add(sublist);
                }
            }
        }

        return result;
    }

    public static boolean isSubset(List<Integer> sublist, List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        for (int num : sublist) {
            if (!set.contains(num)) {
                return false;
            }
        }
        return true;
    }
}
