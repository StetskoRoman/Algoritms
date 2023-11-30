package garbage;

import java.util.ArrayList;
import java.util.List;

//list.set заменяет элемент
//list.add добавляет, смещая вправо остальное всё
public class ArrayListSet {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.addAll(List.of(1, 3, 5, 8, 10, 12));
        System.out.println(list.get(1));
        list.add(1, 2);
        System.out.println(list.get(1));
        System.out.println(list.get(2));
    }
}
