package TestingTasksFromInternet.tinkoff.Summer2023;

import java.util.*;

public class StrokiPodstroki3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        int leftStart = 0;

        Set<Character> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        System.out.println(countMinLengthGoodString(chars));
    }

    public static int countMinLengthGoodString(char[] chars) {
//        List<Character> characters = new ArrayList<>();
//        List<Integer> listOrders = new ArrayList<>();
        Set<Character> characters = new HashSet<>();
        Set<Integer> listOrders = new HashSet<>();
        int minSum = Integer.MAX_VALUE;
        int k = 1;
        while (k < chars.length) {
//            System.out.println("Nachalo k = " + k);
            if (chars[k - 1] == chars[k]) {
                k++;
            } else {
                characters.add(chars[k - 1]);
                listOrders.add(k - 1);
                characters.add(chars[k]);
                listOrders.add(k);
                k++;
            }
//                System.out.println(characters);
//            System.out.println(listOrders);
            if (characters.contains('a') && characters.contains('b') && characters.contains('c') && characters.contains('d')) {
                int sum = (Collections.max(listOrders)+1) - Collections.min(listOrders);
                characters.clear();
                listOrders.clear();
//                System.out.println("Здесь к = " + k + "  i summ = " + sum);
                k -= (sum-2);
                if (sum < minSum) {
                    minSum = sum;
                }
            }
//            System.out.println(minSum);

        }

        return minSum;
    }
}

//        for (int i = 1; i < chars.length; i++) {
//            set.add(chars[i - 1]);
//            if (chars[i] == chars[i - 1]) {
//                leftStart = i;
//            }
//            if (set.size() == 4) {
//                return;
//            }
//            System.out.println(chars[i]);
//        }