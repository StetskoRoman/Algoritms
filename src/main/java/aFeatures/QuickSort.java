package aFeatures;

import java.io.IOException;
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
            long[] x = {15, 0, 4, 7, 15, 7, 10, 12, -3,-41};
        System.out.println("Было");
                System.out.println(Arrays.toString(x));

                int low = 0;
                int high = x.length - 1;

                quickSort(x, low, high);
                System.out.println("Стало");
                System.out.println(Arrays.toString(x));

    }
}




