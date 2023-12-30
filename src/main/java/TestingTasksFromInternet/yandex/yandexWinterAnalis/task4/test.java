package TestingTasksFromInternet.yandex.yandexWinterAnalis.task4;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class test {
    public static void main(String[] args) {

        BigDecimal a = new BigDecimal("15.555");
        BigDecimal res = a.setScale(2, RoundingMode.HALF_UP);
        System.out.println(res);
    }
}
