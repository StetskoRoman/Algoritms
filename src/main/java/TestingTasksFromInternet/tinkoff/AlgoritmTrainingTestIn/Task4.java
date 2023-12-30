package TestingTasksFromInternet.tinkoff.AlgoritmTrainingTestIn;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task4 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        scanner.close();

        List<Integer> sortedList = list.stream().distinct().collect(Collectors.toList());
        Collections.sort(sortedList);

        List<String> result = solution(sortedList);
        PrintWriter printWriter = new PrintWriter(System.out);
        for (int i = 0; i < result.size(); i++) {
            printWriter.print(result.get(i) + " ");

        }
        printWriter.flush();

    }

    public static List<String> solution(List<Integer> sortedList) {

        List<String> resList = new ArrayList<>();

        int n = sortedList.size();
        int i = 0;
        int startPos = 0;
        int stopPos = 0;
        while (i < n) {

            if (i + 2 < n && sortedList.get(i + 1) == sortedList.get(i) + 1 && sortedList.get(i + 2) == sortedList.get(i) + 2) {
                startPos = i;

                while (i + 2 < n && sortedList.get(i + 1) == sortedList.get(i) + 1 && sortedList.get(i + 2) == sortedList.get(i) + 2) {
                    i++;
                }
                i++;
                stopPos = i;
                resList.add(String.valueOf(sortedList.get(startPos)));
                resList.add("...");
                resList.add(String.valueOf(sortedList.get(stopPos)));
                i++;

            }
            if (i + 2 < n && sortedList.get(i + 1) == sortedList.get(i) + 1 && sortedList.get(i + 2) == sortedList.get(i) + 2) {
                continue;
            }

            if (i < n) {
                resList.add(String.valueOf(sortedList.get(i)));
                i++;
            }

        }

        return resList;
    }
}

//Иван очень любит читать. Раз в месяц он приходит в библиотеку и берет много книг, чтобы прочитать их за следующий месяц.
//
//Чтобы не забыть никакую книгу, Ваня ведет список номеров книг, которые он хотел бы прочитать. Этот список пополняется достаточно хаотично, поэтому номера книг в этом списке могут повторяться.
//
//Перед очередным походом в библиотеку Иван открыл список и увидел в нем n записей. Ваня боится, что в библиотеке его не примут с таким списком. Поэтому он хочет получить отсортированный по номерам список минимальной длины, содержащий, возможно в неявном виде, в точности только желаемые книги.
//
//Для достижения этой цели Иван может использовать следующее сокращение: если он хочет взять книги с номерами ﻿

//x,x+1,…,y−1,y,﻿ то он может записать в список всего ﻿
//3
//3﻿ записи: ﻿

//x,…,y,﻿ что будет означить, что ему нужны книги с ﻿
//�
//x﻿ по ﻿
//�
//y﻿.
//
//Помогите Ване получить желаемый список.
//
//Формат входных данных
//
//В первой строке входного файла дано одно целое число ﻿
//�
//n﻿ — число записей в исходном списке книг ﻿

//(1≤n≤⋅10
//5
// )﻿. Во второй строке дано ﻿

//n﻿ чисел ﻿

//​
// ﻿ — элементы исходного списка книг ﻿

//Формат выходных данных
//
//Выведите список книг с минимальным числом элементов такой, что в нем будут в точности все желаемые книги. Если существует несколько списков с минимальным числом элементов, выведите список с наименьшим числом номеров книг, указанных явно.
//
//Система оценки
//
//Баллы за каждую подзадачу начисляются только в случае, если все тесты этой подзадачи и необходимых подзадач успешно пройдены.
//
//
//
//Замечание
//
//В третьем тесте из условия список «1 3 ...5 9 ...11» является ответом, так как содержит минимальное число номеров книг, тогда как «1 3 ...5 9 10 11» ответом не является.

//System.out.println("start pos = " + startPos);
//System.out.println("current i after = " + i);


//        System.out.println(list);
//        System.out.println(sortedList);
//
//        System.out.println(solution(sortedList));