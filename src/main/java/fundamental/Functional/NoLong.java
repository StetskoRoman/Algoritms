package fundamental.Functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NoLong {

    public static List<String> noLong(List<String> strings) {
        List<String> str = strings.stream()
                .filter(m->m.length()<4)
                .collect(Collectors.toList());
        return str;
    }

    public static void main(String[] args) {
        List<String> copies = new ArrayList<>();
        copies.add("yay");
        copies.add("yuyay");
        copies.add("c");
        copies.add("ysady");
        copies.add("yjya");

        System.out.println(noLong(copies));


    }


}
