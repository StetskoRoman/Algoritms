package TestingTasksFromInternet.tinkoff.winter2024;

import java.util.ArrayList;
import java.util.List;

public class test444 {

    public static void main(String[] args) {

        List<List<Integer>> mainList = new ArrayList<>();
        List<Integer> list1 = List.of(1, 5, 6);
        List<Integer> list2 = List.of(5, 6);
        List<Integer> list3 = List.of(2);
        List<Integer> list4 = List.of(3, 4);
        List<Integer> list5 = List.of(1, 5, 6);
        List<Integer> list6 = List.of(1, 6, 5);
        List<Integer> list7 = List.of(7);
         mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);
        mainList.add(list4);
        mainList.add(list5);
        mainList.add(list6);
        mainList.add(list7);

        System.out.println(mainList);
        System.out.println(mainList.containsAll(list1));
        System.out.println(list1.containsAll(list2));
        System.out.println(list1.containsAll(list5));
        System.out.println(list1.containsAll(list3));
        System.out.println(list1.containsAll(list6) + "/n");

        inUniqValues(mainList);
        System.out.println(mainList);


    }

    static void inUniqValues(List<List<Integer>> mainList) {

        int point = 0;
        while (point < mainList.size()) {
            for (int i = 0; i < mainList.size(); i++) {
                if (mainList.get(point).containsAll(mainList.get(i)) && i != point) {
                    mainList.remove(i);
                    i--;
                }
            }
            point++;
        }
    }
}
