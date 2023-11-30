package fundamental.Recursion;

import java.util.stream.Stream;

public class Count7 {
    public static int count7(int n) {

        int res = 0;
        char [] chars = Integer.toString(n).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '7') {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(count7(717));

    }
}
