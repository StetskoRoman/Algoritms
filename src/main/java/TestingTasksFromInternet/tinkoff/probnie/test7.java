package TestingTasksFromInternet.tinkoff.probnie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test7 {

    public static void main(String[] args) {

        int[] nums = {5, 4, 3, 6, 5, 2, 1};
        int [] numsNew = Arrays.stream(nums).sorted().toArray();
        System.out.println(Arrays.toString(numsNew));

        List<Boolean> visited = new ArrayList<>();
        visited.add(true);
        visited.add(true);
        visited.add(true);
        visited.set(2, false);
        System.out.println(visited);
    }
}
