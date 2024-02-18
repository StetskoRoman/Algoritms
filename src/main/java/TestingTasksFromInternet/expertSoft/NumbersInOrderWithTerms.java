package TestingTasksFromInternet.expertSoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//написать код, который выводит числа от 0 до 1000, которые делятся на 3, но не делятся на 5, и сумма цифр в которых меньше десяти.
public class NumbersInOrderWithTerms {

    public static List<Integer> arrayWithTerms(int numbers) {

        List<Integer> resList = new ArrayList<>();

        for (int i = 0; i <= numbers; i++) {
            if ((i % 3 == 0) && (i % 5 != 0)) {
                if (sumDigits(i) < 10) {
                    resList.add(i);
                }
            }
        }

        return resList;
    }

    public static int sumDigits(int number) {
        int length = String.valueOf(number).length();
        int[] array = new int[length];
        int i = 0;
        while (number > 0) {
            array[i] = number % 10;
            i++;
            number /= 10;
        }
        int sum = 0;
        for (int j = 0; j < array.length; j++) {
            sum += array[j];
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println("prov " + 3 % 3);
        System.out.println("prov 2 = " + 712 % 10);
        System.out.println(sumDigits(1012));

        System.out.println(Arrays.toString(new List[]{arrayWithTerms(1000)}));
    }

}
