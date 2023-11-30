package fundamental.Functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class noTeen {
    public static List<Integer> noTeen(List<Integer> nums) {
        List<Integer> str = nums.stream()
                .filter(m-> m>19 || m<13)
                .collect(Collectors.toList());
        return str;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(15);
        list.add(22);
        list.add(19);

        System.out.println(noTeen(list));
    }
}
