package TestingTasksFromInternet.tinkoff.AlgoritmTrainingTestIn;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class test1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double c = scanner.nextDouble();
        System.out.println(c);
        double a = 0.1;
        System.out.println(a + 0.23);

        Set<Integer> set = new LinkedHashSet<>();
        set.add(2);
        set.add(4);
        set.add(7);
        set.add(5);
        System.out.println(set);

    }
}
