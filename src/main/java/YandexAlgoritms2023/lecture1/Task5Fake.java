package YandexAlgoritms2023.lecture1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Task5Fake {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        String[] strings = new String[0];

        PrintWriter printWriter = new PrintWriter(System.out);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    strings = new String[n];
                    countLine++;
                    continue;
                }

                if (countLine <= n) {
                    System.out.println(countLine);
                    strings[countLine - 1] = tokens[0];
                    countLine++;
                    if (countLine > n) {
                        break;
                    }
                }
            }
        }

        printWriter.println("Initial array:");
        for (int i = 0; i < strings.length; i++) {
            if (i < strings.length - 1) {
                printWriter.print(strings[i] + ", ");
            } else {
                printWriter.print(strings[i]);
            }
        }
        printWriter.flush();

        printWriter.println("**********");
        System.out.println("length = " + strings.length);
        printWriter.flush();

        int []array =  {5, 1, 2, 4, 7, 10, 15,255,3};

        countingSort(array, 255);
        System.out.println(Arrays.toString(array));
    }



    public static int[] countingSort(int[] theArray, int maxValue) {
        // Массив со "счётчиками" размером от 0 до максимального значения
        int numCounts[] = new int[maxValue + 1];
        // В соответствующей ячейке (индекс = значение) увеличиваем счётчик
        for (int num : theArray) {
            numCounts[num]++;
        }
        // Подготавливаем массив для отсортированного результата
        int[] sortedArray = new int[theArray.length];
        int currentSortedIndex = 0;
        // идём по массиву со "счётчиками"
        for (int n = 0; n < numCounts.length; n++) {
            int count = numCounts[n];
            // идём по количеству значений
            for (int k = 0; k < count; k++) {
                sortedArray[currentSortedIndex] = n;
                currentSortedIndex++;
            }
        }
        return sortedArray;
    }
}
