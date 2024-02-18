package TestingTasksFromInternet.realInterviewTasks;

import java.util.*;

public class SortMatrixInArray {

    public static void main(String[] args) {
//в листе не сортируется

        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(4);
        System.out.println(set);
        set.clear();
        set.add(3);
        System.out.println(set);
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{7, 9});
        list.add(new int[]{3, 5});


        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i)));

        }



    }
}
