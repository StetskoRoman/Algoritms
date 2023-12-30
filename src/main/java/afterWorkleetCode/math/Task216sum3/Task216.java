package afterWorkleetCode.math.Task216sum3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task216 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();

        System.out.println(combinationSum3(k, n));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> resList = new ArrayList<>();
        recursion(resList, k, n, 1, new ArrayList<>());
        return resList;
    }

    public static void recursion(List<List<Integer>> res, int k, int n, int i, List<Integer> current) {

        if (k == 0 & n == 0) {
            res.add(new ArrayList<>(current));
        }

        if (i > n || i >= 10 || k == 0 || k > n) {
            return;
        }

        current.add(i);
        System.out.println("current after add = " + current);
        recursion(res, k - 1, n - i, i + 1, current);
//        System.out.println("curr before Remove = " + current);
        current.remove(current.size() - 1);  //delete last that was added
        System.out.println("after remove = " + current);

        recursion(res, k, n, i+1, current);
    }
}
