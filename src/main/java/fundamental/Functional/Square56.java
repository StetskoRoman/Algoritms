package fundamental.Functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Square56 {
    public static List<Integer> square56(List<Integer> nums) {
        List<Integer> str = nums.stream()
                .map(m -> m * m + 10)
                .collect(Collectors.toList());

        str.removeIf(m -> Integer.toString(m).charAt(Integer.toString(m).length() - 1) == '5' || Integer.toString(m).charAt(Integer.toString(m).length() - 1) == '6');
        return str;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(15);
        list.add(22);
        list.add(19);

        System.out.println(square56(list));

    }
}
