package TestingTasksFromInternet.tinkoff.winter2024;

import java.util.LinkedHashSet;
import java.util.Set;

public class test4 {

    public static void main(String[] args) {

        Set<Integer> set = new LinkedHashSet<>();
        set.add(3);
        set.add(5);
        Set<Set<Integer>> setSet = new LinkedHashSet<>();

        Set<Integer> set1 = new LinkedHashSet<>();
        set.add(5);
        set.add(3);

        setSet.add(set1);
        setSet.add(set);

        Set<Integer> set2 = new LinkedHashSet<>();
        set2.add(5);
        setSet.add(set2);
        System.out.println(setSet);

        for (Set<Integer> integerSet : setSet) {
            if (integerSet.contains(3)) {
                integerSet.add(25);
                System.out.println("contains 3 " + integerSet);
            }
        }

        Boolean ffa = false;
        System.out.println(ffa.equals(false));
        System.out.println(ffa==false);
    }
}
