package TestingTasksFromInternet.tinkoff.probnie;
//У Кости есть бумажка, на которой написано ﻿
//�
//n﻿ чисел. Также у него есть возможность не больше, чем ﻿
//�
//k﻿ раз, взять любое число с бумажки, после чего закрасить одну из старых цифр, а на ее месте написать новую произвольную цифру.
//
//На какое максимальное значение Костя сможет увеличить сумму всех чисел на листочке?

//Формат выходных данных
//
//В выходной файл выведите одно число — максимальную разность между конечной и начальной суммой.

//Замечание
//
//В первом примере Костя может изменить две единицы на две девятки, в результате чего сумма чисел увеличится на ﻿
//16
//16﻿.
//
//Во втором примере Костя меняет число ﻿
//85
//85﻿ на ﻿
//95
//95﻿.
//
//В третьем примере можно ничего не менять.
//
//Обратите внимание, что ответ может превышать вместимость ﻿
//32
//32﻿-битного типа данных.
//
//Примеры данных
//Пример 1
//5  2
//1  2  1  3  5
//16

//Пример 2
//3  1
//99  5  85
//10
//Пример 3
//1  10
//9999
//1  10
//9999
//0

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.OptionalLong;
import java.util.Scanner;

//Частичное решение...
public class Task4 {

    public static void main(String[] args) throws IOException {
        int countLine = 0;
//        int n = 0;
//        int k = 0;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] nums = new long[n];
        int k = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextLong();
        }
//        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] tokens = line.split("  ");
//
//                if (countLine == 0) {
//                    n = Integer.parseInt(tokens[0]);
//                    k = Integer.parseInt(tokens[1]);
//                    nums = new long[n];
//                    countLine++;
//                    continue;
//                }
//                if (countLine == 1) {
//                    for (int i = 0; i < n; i++) {
//                        nums[i] = Long.parseLong(tokens[i]);
//                    }
//                    break;
//                }
//            }
//        }

//        System.out.println(Arrays.toString(nums));

        long sum = Arrays.stream(nums).sum();
        long max = Arrays.stream(nums).max().getAsLong();
        int row = Objects.toString(max).length();


        long lastSum = solution(nums, k, row);
        System.out.println(lastSum-sum);
    }

    private static long solution(long[] nums, int k, int row) {

        int totalNums = nums.length;

        while (k > 0) {
            int count9 = 0;
            int countLowLength = 0;

            long base = 9+48;
            int pos = 0;

            if (row == 0) {
                break;
            }

            for (int i = 0; i < nums.length; i++) {

                int length = Objects.toString(nums[i]).length();

                if (length < row) {
                    countLowLength++;
                    continue;
                }
                if (Objects.toString(nums[i]).charAt(length - row) == 9 + 48) {
                    count9++;
                    continue;
                }
                if (Objects.toString(nums[i]).charAt(length - row) < base) {
                    base = Objects.toString(nums[i]).charAt(length - row);
//                    System.out.println("base = " + base);
                    pos = i;
                }
//                System.out.println(" i = " + i + "  here count9 =" + count9 + "  and lowLength =" + countLowLength);

            }


            if (count9 == nums.length - countLowLength) {
                row--;
                continue;
            }

            char[] currentNum = Objects.toString(nums[pos]).toCharArray();

            currentNum[currentNum.length - row] = 9 + '0';

            long number = Long.parseLong(new String(currentNum));
            nums[pos] = number;
//            System.out.println("current  = " + currentNum[currentNum.length - row] + "  k = " + k + "   row = " + row  + "    array = " + Arrays.toString(nums));
            k--;

        }
//        System.out.println("in the end " + Arrays.toString(nums));

        long resSum = Arrays.stream(nums).sum();
        return resSum;
    }
}

//System.out.println("here and   row = " + row + "   k = " + k + "    array = " + Arrays.toString(nums));


//                    if (i == nums.length - 1) {
//                        if (count9 == nums.length - countLowLength) {
//                            count9 = 0;
//                            countLowLength = 0;
//                            row--;
//                            System.out.println("IN FOR 1  here and   row = " + row + "   k = " + k + "    array = " + Arrays.toString(nums));
//
//                            break;
//                        }
//                    }


//    char[] chars = {1, 3, 5, 7, 9};
//        System.out.println(chars[3]);
//                String num = "";
//                for (int i = 0; i < chars.length; i++) {
//        num += chars[i];
//        }
//        System.out.println("num = " + num);

//  System.out.println(max);
//        System.out.println(Objects.toString(max).length());
//        System.out.println(Objects.toString(max).toCharArray().length);
//        System.out.println(Objects.toString(max).charAt(0));
