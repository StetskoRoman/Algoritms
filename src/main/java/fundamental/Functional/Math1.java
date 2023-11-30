package fundamental.Functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Math1 {
    public static List<Integer> math1(List<Integer> nums) {
        List<Integer> str = nums.stream()
                .map(m -> (m + 1) * 10)
                .collect(Collectors.toList());
        return str;
    }

    public static void main(String[] args) {
        List<Integer> copies = new ArrayList<>();
        copies.add(4);
        copies.add(15);
        copies.add(1555);

        System.out.println(math1(copies));
    }
}
