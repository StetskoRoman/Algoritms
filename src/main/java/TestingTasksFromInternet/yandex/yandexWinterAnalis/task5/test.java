package TestingTasksFromInternet.yandex.yandexWinterAnalis.task5;

import java.math.BigInteger;

public class test {

    public static void main(String[] args) {

        BigInteger a = new BigInteger("13");
        BigInteger b = new BigInteger("39");
        System.out.println(a);
        BigInteger c = b.divide(a);
        System.out.println(c);

//        a = b.divide(a);
//        System.out.println(" a = " + a);

        BigInteger ost = a.mod(BigInteger.valueOf(3));
        System.out.println(ost);
    }
}
