package YandexAlgoritms2023.warmingUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task4 {

    public static void main(String[] args) throws IOException {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        String s1 = r.readLine().replaceAll("\\s+", "");
        String s2 = r.readLine().replaceAll("\\s+", "");

        r.close();

        System.out.println(isAnagram(s1, s2));

    }

    public static String isAnagram(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return "NO";
        }
        char[] chars1 = s1.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars2);
        for (int i = 0; i < s1.length(); i++) {
            if (chars1[i] == chars2[i]) {

            } else {
                return "NO";
            }

        }

        return "YES";

    }
}


//    тут ошибка кстати, если во второй строке больше одинаковых символов то неправильно посчитает

//    public static String isAnagram(String s1, String s2) {
//        int result = 0;
//        if (s1.length() != s2.length()) {
//            return "NO";
//        }
//        for (int i = 0; i < s1.length(); i++) {
//            char ch = s1.charAt(i);
//            if (s2.indexOf(ch) >= 0) {
//
//                result++;
//            }
//        }
//        if (result != s1.length()) {
//            return "NO";
//        }
//        return "YES";
//    }