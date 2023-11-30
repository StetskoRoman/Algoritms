package TestingTasksFromInternet.tinkoff.probnie;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.*;
import java.util.stream.Collectors;

public class Eternal4Sums {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(500);
        l.add(200);
        l.add(5);
        System.out.println("l = " + l);
        System.out.println(l.stream().sorted().collect(Collectors.toList()));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        long sumOld = 0;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            sumOld += a[i];
        }

        Map<Integer, List<Integer>> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            char [] chars = String.valueOf(a[i]).toCharArray();
            int [] number = new int[chars.length];

            for (int q = 0; q < number.length; q++) {
                number[q] = chars[q] - '0';
                System.out.println(" chars " + number[q]);
            }
            for (int j = number.length - 1; j >= 0; j--) {
                System.out.println(" j = " + (j+1) + "   number[j] = " + number[number.length-j-1]);

                fill(map, j + 1, number[number.length-j-1]);

            }
            System.out.println();
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {

//            System.out.println(entry.getValue().stream().sorted().collect(Collectors.toList()));
            entry.getValue().stream().sorted().collect(Collectors.toList());

        }



//        System.out.println(map.values().stream().
////                flatMap(f->f.stream()).   - отсортирует всё как один массив
//
//                sorted().
//                collect(Collectors.toList()));
//        System.out.println(map.entrySet().stream().sorted());

        System.out.println(map.entrySet());
        System.out.println(sumOld);
        System.out.println(n + "  " + k);
        System.out.println(Arrays.toString(a));

    }

    static void fill(Map<Integer, List<Integer>> map, Integer key, Integer... values) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
                .addAll(Arrays.asList(values));
    }
}
//while(myChar != 'n' && myChar != 'N')  - двойное условия
//        map.computeIfAbsent(1, m -> new ArrayList<>()).add(2);
//        map.computeIfAbsent(1, m -> new ArrayList<>()).add(3);
//
//        map.computeIfAbsent(5, m -> new ArrayList<>()).add(8);
//
//        map.computeIfAbsent(6, m -> new ArrayList<>()).add(4);
//        map.computeIfAbsent(6, m -> new ArrayList<>()).add(7);
//        map.computeIfAbsent(6, m -> new ArrayList<>()).add(9);
//        map.computeIfAbsent(6, m -> new ArrayList<>()).add(4);