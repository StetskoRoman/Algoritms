package fundamental.Functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Copies3 {
    public static List<String> copies3(List<String> strings) {
        List<String> str = strings.stream()
                .map(m-> m+'*')
                .collect(Collectors.toList());
        return str;
    }

    public static void main(String[] args) {
        List<String> copies = new ArrayList<>();
        copies.add("a");
        copies.add("bb");
        copies.add("ccc");

        copies.stream()
                .filter(s -> s.length() >= 2)
                .forEach(s -> System.out.println(s));

        List<String> str = copies.stream()   //вот оно!
                .map(m -> m + m + m)
                .collect(Collectors.toList());

        System.out.println(str);

        int count = (int) copies.stream()
                .filter(s -> s.length() >= 2)
                .count();

        System.out.println("count = " + count);

        System.out.println(copies3(copies));

    }
}
