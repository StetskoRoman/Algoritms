package fundamental.Functional;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class NoYY {
    public static List<String> noYY(List<String> strings) {
        List<String> str = strings.stream()
                .map(m->m+'y')
                .collect(Collectors.toList());
        System.out.println("str = " + str);
        String substring = "yy";
        int i = 0;

        while (i< str.size()){
            if (str.get(i).contains(substring)) {
                System.out.println("deleting str " + i);
                str.remove(str.get(i));
                continue;
            }
            i++;
            System.out.println(str);
        }

        return str;
    }

    public static void main(String[] args) {

        List<String> copies = new ArrayList<>();
        copies.add("yay");
        copies.add("yuyay");
        copies.add("c");
        copies.add("ysady");
        copies.add("yjya");

        System.out.println("final answer " + noYY(copies));


    }
}
