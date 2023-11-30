package YandexAlgoritms2023.lecture1;

import java.util.*;

public class test {

    public static void main(String[] args) {

        String q = "aba";
        String x = "aba";
        System.out.println(q==x);

        char a = 'a';
        char b = 'b';
        System.out.println(a<b);

        char a1 = '1';
        char a2 = '2';
        System.out.println(a1<a2);

        String abc = "abc";
        System.out.println(abc.charAt(2));

        Map<Integer, List<String>> map = new LinkedHashMap<>();
        List<String> list = new ArrayList<>();
        list.add("12");
        list.add("15");
        list.add("12");
        list.add("11");
        map.put(1, list);
        System.out.println(map);

        List<Integer> integerList = Arrays.asList(1, 2, 3);
        System.out.println(integerList.toString().replaceAll("^\\[|\\]$", ""));
    }
}
