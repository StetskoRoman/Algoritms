package YandexAlgoritms2023.warmingUp;
//
//Задана последовательность целых чисел a1, a2, …, an. Задаются запросы: сказать любой элемент последовательности на отрезке от L до R включительно, не равный минимуму на этом отрезке.
//
//        Формат ввода
//        В первой строке содержатся два целых числа N, 1 ≤ N ≤ 100 и M, 1 ≤ M ≤ 1000 — длина последовательности и количество запросов соответственно.
//
//        Во второй строке — сама последовательность, 0 ≤ ai ≤ 1000.
//
//        Начиная с третьей строки перечисляются M запросов, состоящих из границ отрезка L и R, где L, R - индексы массива, нумеруются с нуля.
//
//        Формат вывода
//        На каждый запрос выведите в отдельной строке ответ — любой элемент на [L, R], кроме минимального. В случае, если такого элемента нет, выведите "NOT FOUND".
//
//        Пример 1
//        Ввод	Вывод
//        10 5
//        1 1 1 2 2 2 3 3 3 10
//        0 1
//        0 3
//        3 4
//        7 9
//        3 7
//        NOT FOUND
//        2
//        NOT FOUND
//        10
//        3


import java.io.*;

public class Task1 {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        int m = 0;
        int [] nums = new int[0];
        PrintWriter printWriter = new PrintWriter(System.out);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    m = Integer.parseInt(tokens[1]);
                    countLine++;
                    continue;
                }

                if (countLine == 1) {
                    nums = new int[n];
                    countLine++;
                    for (int i = 0; i < n; i++) {
                        nums[i] = Integer.parseInt(tokens[i]);
                    }
                    continue;
                }

                if (countLine <= m + 2) {
                    int beginning = Integer.parseInt(tokens[0]);
                    int end = Integer.parseInt(tokens[1]);
                    countLine++;

                    printWriter.println(answer(nums, beginning, end));


                    if (countLine == m + 2) {
                        break;
                    }
                }
            }
        }

        printWriter.flush();


    }

    public static String answer(int[] nums, int beginning, int end) {
        int min = Integer.MAX_VALUE;

        for (int i = beginning; i <= end; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        for (int i = beginning; i <= end; i++) {
            if (nums[i] > min) {
                return String.valueOf(nums[i]);
            }
        }

        return "NOT FOUND";
    }

}






// System.out.println(n + "   " + m);


// System.out.println(nums[i]);







