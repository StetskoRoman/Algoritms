package YandexAlgoritms2023.warmingUp;
//Даны две рациональные дроби: a/b и c/d. Сложите их и результат представьте в виде несократимой дроби m/n.
//
//        Формат ввода
//        Программа получает на вход 4 натуральных числа a, b, c, d, каждое из которых не больше 100.
//
//        Формат вывода
//        Программа должна вывести два натуральных числа m и n такие, что m/n=a/b+c/d и дробь m/n – несократима.
//
//        Пример
//        Ввод	Вывод
//        1 2 1 2
//        1 1

import java.io.IOException;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        int[] res = calculate(a, b, c, d);

        System.out.println(res[0] + " " + res[1]);

    }


    public static int[] calculate(int a, int b, int c, int d) {
        int[] result = new int[2];
        int m = a * d + c * b;
        int n = b * d;
        int nok = nokCounting(m, n);
        result[0] = m / nok;
        result[1] = n / nok;
        return result;
    }

//    по алгоритму Эвклида
    public static int nokCounting(int m, int n) {
        int big; int low;
        if (m > n) {
            big = m;
            low = n;
        } else {
            big = n;
            low = m;
        }

        int nok = 1;
        int remainder = -1;
        while (remainder != 0) {

            remainder = big % low;
            if (remainder == 0) {
                nok = low;
                return nok;
            } else {
                big = low;
                low = remainder;
            }
        }

        return 1;
    }

}






















