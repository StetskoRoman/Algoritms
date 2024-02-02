package TestingTasksFromInternet.tinkoff;

import java.util.List;
import java.util.stream.Collectors;

public class First {

    public static void main(String[] args) {

        boolean b1 = true, b2 = false;
        int i1 = 2, i2 = 5;
        System.out.println((i1 | i2) == 3);
        int d = i1 | i2;
        int c = i1 & i2;
        System.out.println(" d = " + d + "   c = " + c);
//        System.out.println(i2 == b1);

        System.out.println(b1 || !b2);
        System.out.println((i1 ^ i2) < 4);

        String str = "abcde";
        str.trim();
        str.toUpperCase();
        String str1 = str.substring(3, 4);
        System.out.println(str + " " + str1);

        List<Integer> numbers = List.of(1, 2, 3, 4);
        int total = 0;

        for (Integer x : numbers) {
            if (x % 2 == 0) {
                total += x * x;
            }
        }
        System.out.println(total);

        List<Integer> total2 = numbers.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(total2);

        int total3 = numbers.stream().mapToInt(x -> x % 2 == 0 ? x * x : 0).sum();
        System.out.println(total3);

        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println("s1 == s2 is:" + (s1 == s2));

        byte bb = (byte) 200;
        System.out.println(bb);

        int arr[] = { 22, 2, 10 };

        int[] arr1 = { 1, 11, 3 };

        int[] arr5 = new int[] { 33, 41, 0 };

    }
}
