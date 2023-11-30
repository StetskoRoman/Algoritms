package YandexAlgoritms2023.warmingUp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double xA = scanner.nextDouble();
        double yA = scanner.nextDouble();
        double xB = scanner.nextDouble();
        double yB = scanner.nextDouble();

        double res = solution(xA, yA, xB, yB);
        System.out.println(res);

    }

    public static double solution(double xA, double yA, double xB, double yB) {
        double rA = Math.sqrt(xA * xA + yA * yA);
        double rB = Math.sqrt(xB * xB + yB * yB);
        double alfa = Math.atan2(yA, xA);
        double beta = Math.atan2(yB, xB);
        double maxAlfa;
        double minAlfa;
        double minR;
        double maxR;

        if (rA < rB) {
            minR = rA;
            maxR = rB;
        } else {
            minR = rB;
            maxR = rA;
        }
        if (alfa > beta) {
            maxAlfa = alfa;
            minAlfa = beta;
        } else {
            maxAlfa = beta;
            minAlfa = alfa;
        }

        double sum1;
        double sum2;
        List<Double> listRes = new ArrayList<>();
        listRes.add(rA + rB);

        if (minR == 0) {
            return maxR;
        }

        sum1 = Math.abs(rA - rB);
        sum2 = minR * (Math.abs(minAlfa - maxAlfa));
        listRes.add(sum1 + sum2);

        sum2 = minR * (Math.abs(minAlfa + 2 * Math.PI - maxAlfa));
        listRes.add(sum1 + sum2);

        double result = Collections.min(listRes);

        return result;
    }
}


//double atan2(double y, double x)
//    Метод Math.atan2() – преобразует прямоугольные координаты (x, y) в полярные координаты (r, тета) и возвращает тета.

//System.out.println("result = " + res);

// System.out.println(alfa);
//
//         System.out.println(beta);
//         double teta = beta + 2 * Math.PI;
//         System.out.println(teta);

//System.out.println(listRes);

//System.out.println("dobavil " + (sum1 + sum2) + "  a min alfa i max alfa " + minAlfa + "  " + maxAlfa);