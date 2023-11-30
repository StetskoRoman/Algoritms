package YandexAlgoritms2023.lecture4Perebor;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class test1 {

    public static void main(String[] args) {

        System.out.println(0 % 2);

        Set<Integer> stack = new HashSet<>();
        stack.add(2);
        stack.add(7);
        stack.add(11);
        System.out.println(stack);
        System.out.println(stack.remove(2));
        System.out.println(stack);
    }
}
