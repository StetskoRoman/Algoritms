package aFeatures;
/**
 * Задано две строки, нужно проверить, является ли одна анаграммой другой. Анаграммой называется строка, полученная из другой перестановкой букв.
 */

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Anagram {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();

        System.out.println(isAnagram(str1,str2));

    }

    public static String isAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return "NO";
        }

                Map<String, Long> map1 = Arrays.stream(str1.split("")).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println(map1);
        Map<String, Long> map2 = Arrays.stream(str2.split("")).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println(map2);

        if (map1.entrySet().stream()
                .allMatch(e -> e.getValue().equals(map2.get(e.getKey())))){
            return "YES";
        }
        return "NO";
    }
}
