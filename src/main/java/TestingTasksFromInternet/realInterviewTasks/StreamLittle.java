package TestingTasksFromInternet.realInterviewTasks;

import java.util.stream.Stream;

public class StreamLittle {

    public static void main(String[] args) {
//        forEach(m -> System.out.println(m)); вывел бы все элементы
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .peek(m -> System.out.println(m)) //выведет 1, т.к. первый элемент выводим в очереди (
                .filter(m -> m % 2 == 0)
                .peek(m -> System.out.println(m)) //выведет 2,
                .findFirst();  //выведет 2,
    }
}
