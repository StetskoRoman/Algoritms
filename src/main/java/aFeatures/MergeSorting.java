package aFeatures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class MergeSorting {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        int[] nums = new int[0];
        long x = 0;

        PrintWriter printWriter = new PrintWriter(System.out);


        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    nums = new int[n];
                    countLine++;
                    continue;
                }

                if (countLine == 1) {

                    for (int i = 0; i < n; i++) {
                        nums[i] = Integer.parseInt(tokens[i]);
                    }
                    break;
                }
            }
        }

        System.out.println("before " + Arrays.toString(nums));

        int[] result = sortArray(nums);
        System.out.println("after " + Arrays.toString(result));
    }

    public static int [] sortArray(int[] arrayA){ // сортировка Массива который передается в функцию
        // проверяем не нулевой ли он?
        if (arrayA == null) {
            return null;
        }
        // проверяем не 1 ли элемент в массиве?
        if (arrayA.length < 2) {
            return arrayA; // возврат в рекурсию в строки ниже см комменты.
        }
        // копируем левую часть от начала до середины
        int [] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);

        // копируем правую часть от середины до конца массива, вычитаем из длины первую часть
        int [] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);

        // рекурсией закидываем поделенные обе части обратно в наш метод, он будет крутится до тех пор,
        // пока не дойдет до 1 элемента в массиве, после чего вернется в строку и будет искать второй такой же,
        // точнее правую часть от него и опять вернет его назад
        arrayB = sortArray(arrayB); // левая часть возврат из рекурсии строкой return arrayA;
        arrayC = sortArray(arrayC); // правая часть возврат из рекурсии строкой return arrayA;

        // далее опять рекурсия возврата слияния двух отсортированных массивов
        return mergeArray(arrayB, arrayC);
    }

    static int[] mergeArray(int[] n, int[] m) {
        int size = n.length + m.length;
        int[] nums = new int[size];
        int nCount = 0;
        int mCount = 0;
        int i = 0;
        while (i < size) {
            if (nCount == n.length) {
                for (int j = i; j < size; j++) {
                    nums[j] = m[mCount];
                    mCount++;
                }
                break;
            }
            if (mCount == m.length) {
                for (int j = i; j < size; j++) {
                    nums[j] = n[nCount];
                    nCount++;
                }
                break;
            }

            if (n[nCount] < m[mCount]) {
                nums[i] = n[nCount];
                nCount++;
                i++;

            } else {
                nums[i] = m[mCount];
                mCount++;
                i++;
            }

        }
        return nums;
    }
}
