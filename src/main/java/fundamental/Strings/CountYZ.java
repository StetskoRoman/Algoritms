package fundamental.Strings;

import java.nio.file.Paths;
import java.util.Arrays;

public class CountYZ {
    public static int countYZ(String str) {
        String workStr = str.toLowerCase();
        char[] charsWorkStr = workStr.toCharArray();
        String finStr = null;
        if (charsWorkStr[0] == '!' || charsWorkStr[1] == '!') {
            finStr = workStr.substring(2);
        } else {
            finStr = workStr;
        }
//        System.out.println(finStr);
        String[] strings = finStr.split("[, ?.@:!0-9-]+");
        int count = 0;
        for (int i = 0; i < strings.length; i++) {
            char [] charArray = strings[i].toCharArray();
                if (charArray[charArray.length - 1] == 'y' || charArray[charArray.length - 1] == 'z') {
                    count++;
            }
//            System.out.println(Arrays.toString(charArray));
        }


        return count;
    }

    public static void main(String[] args) {
        int re = countYZ("day yak");
        System.out.println(re);

    }
}
