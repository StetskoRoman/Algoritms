package TestingTasksFromInternet.tinkoff.javaBackRealExam.task4;

import java.util.*;

public class Checks {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        scanner.close();
        System.out.println();

        while (c > 0) {
            if (Collections.min(list) >= 0) {
                int position = findNumberForChanging(list);
                list.set(position, list.get(position) - d);
                c--;
                continue;
            }

            if (Collections.min(list) < 0) {
                int position = findNumberForChanging(list);
                if (list.get(position) >= 0) {
                    list.set(position, list.get(position) + d);
                } else {
                    list.set(position, list.get(position) - d);
                }
                c--;
            }
        }

        printResultList(list);
    }


    public static int findNumberForChanging(List<Integer> list) {
        Integer minNumber = Integer.MAX_VALUE;
        int position = 0;
        if (Collections.min(list) >= 0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) < minNumber) {
                    minNumber = list.get(i);
                    position = i;
                }
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (Math.abs(list.get(i)) < minNumber) {
                    minNumber = list.get(i);
                    position = i;
                }
            }
        }

        return position;
    }

    public static void printResultList(List<Integer> list) {
        for (Integer number : list) {
            System.out.print(number + " ");
        }
    }
}


//System.out.println("teper " + list);
//
//
//        System.out.println(n + "  + " + c + "   + " + d);

    //можно удалить, только для проверки метод
//    public static long multiplying(List<Long> list) {
//        long result = 1;
//        for (int i = 0; i < list.size(); i++) {
//            result *= list.get(i);
//        }
//        return result;
//    }