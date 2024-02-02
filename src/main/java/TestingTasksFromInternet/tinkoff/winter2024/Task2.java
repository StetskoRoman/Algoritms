package TestingTasksFromInternet.tinkoff.winter2024;

import java.io.PrintWriter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();

        PrintWriter printWriter = new PrintWriter(System.out);
        List<Long> res = solution(nums);
        printWriter.println(res.size());
        for (int i = 0; i < res.size(); i++) {
            if (i == res.size() - 1) {
                printWriter.print(res.get(i));
                break;
            }
            printWriter.print(res.get(i)+ " " );
        }
        printWriter.flush();

    }

    static List<Long> solution(int[] nums) {

        Map<Integer, Long> map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Long> list = new ArrayList<>();
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list);

        return list;
    }
}
