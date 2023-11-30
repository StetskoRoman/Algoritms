package TestingTasksFromInternet.yandex.inputOutput;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class XZ {


    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
//тут ошибка кстати, если во второй строке больше одинаковых символов то неправильно посчитает
        String S = r.readLine();
        String J = r.readLine();

        int count = 0;

        int result = 0;
        for (int i = 0; i < S.length(); i++) {

            System.out.println(i);
            char ch = S.charAt(i);
            if (J.indexOf(ch) >= 0) {
//                System.out.println("result do = " + result);
               ++ result;

               count++;
//                result++;

//                System.out.println("result posle = " + result);
            }
        }

        System.out.println("res = " + result);
    }

}
