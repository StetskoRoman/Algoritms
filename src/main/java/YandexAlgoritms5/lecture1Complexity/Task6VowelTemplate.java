package YandexAlgoritms5.lecture1Complexity;
/**3
 5 7 2
 + везде расставить и заменить в одной паре + на * так чтобы нечетная сумма получалась
 ОБЯЗАТЕЛЬНО * тоже должен где то быть? А нет, не должен)
 6
 * -76959846 -779700294 380306679 -340361999 58979764 -392237502
 */

import java.util.Arrays;
import java.util.Scanner;

public class Task6VowelTemplate {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }
        scanner.close();

        int posToChange = posWhereX(arr);
//        System.out.println(posToChange);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            if (i == posToChange) {
                stringBuilder.append("x");
            } else stringBuilder.append("+");
        }
        System.out.println(stringBuilder);
    }

    static int posWhereX (long[] arr) {
        long sum = Arrays.stream(arr).sum();
        int posToChange = -1;

        if (sum % 2 == 1) {
//            System.out.println("%1");
            for (int i = 1; i < arr.length; i++) {
                if (Math.abs((arr[i - 1] + arr[i]) % 2) == 0 && (arr[i - 1] * arr[i]) % 2 == 0) {
                    posToChange = i - 1;
                    return posToChange;
                }
                if (Math.abs((arr[i - 1] + arr[i]) % 2) == 1 && Math.abs((arr[i - 1] * arr[i]) % 2) == 1) {
                    posToChange = i - 1;
                    return posToChange;
                }
            }
        }

        if (sum % 2 == 0) {
//            System.out.println("%0");
            for (int i = 1; i < arr.length; i++) {
//                System.out.println("a =" + arr[i - 1] + "  b = " + arr[i] + "  a+b = " +(arr[i - 1] + arr[i]) % 2 + "   a*b = " + (arr[i - 1] * arr[i]) % 2);
                if (Math.abs((arr[i - 1] + arr[i]) % 2) == 0 && Math.abs((arr[i - 1] * arr[i]) % 2) == 1) {
//                    System.out.println("a =" + arr[i - 1] + "  b = " + arr[i]);
                    posToChange = i - 1;
                    return posToChange;
                }
                if ( Math.abs((arr[i - 1] + arr[i]) % 2) == 1 && Math.abs((arr[i - 1] * arr[i]) % 2) == 0) {
//                    System.out.println("a =" + arr[i - 1] + "  b = " + arr[i]);
                    posToChange = i - 1;
                    return posToChange;
                }
            }
        }
        return -1;
    }
}
