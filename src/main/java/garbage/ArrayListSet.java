package garbage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//list.set заменяет элемент
//list.add добавляет, смещая вправо остальное всё
public class ArrayListSet {

    public static void main(String[] args) {
 // Задачка -
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .peek(m -> System.out.println(m))
                .filter(m -> m % 2 == 0)
                .peek(m -> System.out.println(m))
                .findFirst();

        List<Integer> list = new ArrayList<>();
        list.addAll(List.of(1, 3, 5, 8, 10, 12));
        System.out.println(list.get(1));
        list.add(1, 2);
        System.out.println(list.get(1));
        System.out.println(list.get(2));
    }
}
