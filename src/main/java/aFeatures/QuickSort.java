package aFeatures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class QuickSort {

    public static void quickSort(long[] array, int low, int high) {
        if (array.length == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (low >= high)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        long opora = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }

            while (array[j] > opora) {
                j--;
            }

            if (i <= j) {//меняем местами
                long temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    public static void main(String[] args) throws IOException {
            long[] x = {8, 0, 4, 7, 3, 7, 10, 12, -3};
        System.out.println("Было");
                System.out.println(Arrays.toString(x));

                int low = 0;
                int high = x.length - 1;

                quickSort(x, low, high);
                System.out.println("Стало");
                System.out.println(Arrays.toString(x));

//        int countLine = 0;
//        int n = 0;
//        long[] nums = new long[0];
//        long x = 0;
//
//        PrintWriter printWriter = new PrintWriter(System.out);
//
//
//        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
//            String line;
//
//            while ((line = bufferedReader.readLine()) != null) {
//                String[] tokens = line.split(" ");
//
//                if (countLine == 0) {
//                    n = Integer.parseInt(tokens[0]);
//                    nums = new long[n];
//                    countLine++;
//                    continue;
//                }
//
//                if (countLine == 1) {
//
//                    for (int i = 0; i < n; i++) {
//                        nums[i] = Long.parseLong(tokens[i]);
//                    }
//                    break;
//                }
//            }
//        }
//
//        quickSort(nums, 0, nums.length);
//        for (int i = 0; i < nums.length; i++) {
//            printWriter.print(nums[i] + " ");
//
//        }
//        printWriter.flush();
    }
}




