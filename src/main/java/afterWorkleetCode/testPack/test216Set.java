package afterWorkleetCode.testPack;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test216Set {

    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();
        set.add(2);
        set.add(5);
        set.add(54);

        System.out.println(set);

        int max = 0;
        int sum = set.stream().mapToInt(Integer::intValue).sum();
        System.out.println("sum with stream =" + sum);


        int sum2 = 0;
        for (Integer e : set) {
            sum2 += e;
        }

        System.out.println("sum2 = " + sum2);


    }
}
