package YandexAlgoritms2023.lecture2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task5Equals {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();
        bufferedReader.close();

        System.out.println(solution(str));

    }

    //сделать то же но с хешами?
    public static long solution(String str) {

        long sum = 0l;

        for (int i = 0; i < str.length(); i++) {
            int k = 1;
            int p = str.length();
            while (p > i + 1) {

                String workStr = str.substring(i, p);
                String reverseStr = reverseString(workStr);

                if (workStr.equals(reverseStr)) {
                    sum++;
                    p--;
                } else {
                    p--;
                }

            }
        }
        sum += str.length();

        return sum;
    }

    static String reverseString(String str) {
        String resString = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            resString += str.charAt(i);
        }
        return resString;
    }
}



//
//                System.out.println(" work  = " + workStr);
//                        System.out.println("reverse = " + reverseStr);
//                        System.out.println("is equal = " + workStr.equals(reverseStr));


//        for (int i = 0; i < str.length()-1; i++) {
//            int k = 2;
//            int p = str.length() - i;
//            while (k <= p) {
//                if (isEqual(hashes, i, i, k)) {
//                    System.out.println(" i = " + i);
//                    sum++;
//                    k++;
//                } else {
//                    k++;
//                }
//            }
//        }
//        sum += str.length();