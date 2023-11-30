package YandexAlgoritms2023.warmingUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task9 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();
        bufferedReader.close();

        System.out.println(solution(str));

    }

    public static String solution(String str) {

        if (str.length() % 2 != 0) {
            return "no";
        }

        char[] chars = str.toCharArray();
        int round = 0;
        int square = 0;
        int figure = 0;

        for (int i = 0; i < chars.length; i++) {

            if (round < 0 || square < 0 || figure < 0) {
                return "no";
            }

            switch (chars[i]) {

                case '(':
                    round++;
                    break;

                case ')':
                    round--;
//                    if (square % 2 != 0 || figure % 2 != 0) {
//                        return "no";
//                    }
                    break;

                case '[':
                    square++;
                    break;

                case ']':
                    square--;
//                    if (round % 2 != 0 || figure % 2 != 0) {
//                        return "no";
//                    }
                    break;

                case '{':
                    figure++;
                    break;

                case '}':
                    figure--;
//                    if (round % 2 != 0 || square % 2 != 0) {
//                        return "no";
//                    }
                    break;
            }
        }

        if (round != 0 || square != 0 || figure != 0) {
            return "no";
        }

        return "yes";
    }

}

