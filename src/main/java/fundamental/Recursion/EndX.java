package fundamental.Recursion;

import java.util.ArrayList;
import java.util.List;

public class EndX {
    public static String endX(String str) {
        int countX = 0;
        char[] chars = str.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'x') {
                countX++;
            }
            list.add(chars[i]);
        }

        int j = 0;
        while (j < list.size()) {
            if (list.get(j) == 'x') {
                list.remove(list.get(j));
                continue;
            }
            j++;
        }


        return str;
    }

    public static void main(String[] args) {
        List<String> copies = new ArrayList<>();
        copies.add("yay");
        copies.add("yuyay");
        copies.add("c");
        copies.add("ysady");

        String str = "zxcqxwexx";

        System.out.println(endX(str));
    }
}
