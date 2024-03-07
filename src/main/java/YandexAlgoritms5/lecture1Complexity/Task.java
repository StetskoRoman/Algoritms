package YandexAlgoritms5.lecture1Complexity;

import javax.xml.crypto.Data;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Task {

    public static void main(String[] args) {

        Calendar calendar = new GregorianCalendar(2013, 2 , 25);
        System.out.println(calendar.getTime());



        System.out.println(8 % 1);

        System.out.println(100 / 3);
        System.out.println("a");
        int q = 15;
        int c = 25;
        if (q == 15) {
            if (c == 25) {
                System.out.println("c = " + c);

            }
        }

        StringBuilder sb1 = new StringBuilder("abc");
        StringBuilder sb2 = new StringBuilder("abc");
        StringBuilder sb3 = sb1;
        System.out.println(sb1.equals("abc") + "  " + sb1 == sb2 + "  " + sb1.equals(sb2));
        System.out.println(sb1 == sb2);
        System.out.println(sb1.equals(sb2));
        System.out.println("sb3/sb1 = " + sb1.equals(sb3));

        BigInteger a2 = new BigInteger("2");
        BigInteger a1 = new BigInteger("1");
        BigInteger nok = a2.mod(a1);
        System.out.println(nok);

        int count = 0;
        count = count + 1;
        int decl = 0;
        while (count >= 0 && decl>=0) {
            decl--;
            count--;
            System.out.println("do smth");
        }
    }
}
