package fundamental.Arrays;

public class CountXX {

    public  static int  countXX(String str) {
        int n = 0;
        char [] charArray = str.toCharArray();
        for (int i = 1; i < str.toCharArray().length; i++) {
            if (charArray[i-1] == 'x' && charArray[i] == 'x') {
                n++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int res = countXX("abcxxxx");
        System.out.println(res);
    }
}
