package aFeatures;

import java.util.ArrayList;
import java.util.List;

public class FindingAllSimpleNumbers {

    static List<Integer> eratosphenMethod(int n) {
        boolean[] nums = new boolean[n+1];
        List<Integer> result = new ArrayList<>();
        nums[0] = false;
        nums[1] = false;
        for (int i = 2; i < nums.length; i++) {
            nums[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (nums[i] == true) {
                for (int j = i * i; j <= n; j += i) {
                    nums[j] = false;
                }
            }
        }

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == true) {
                result.add(i);
            }
        }

        return result;
    }
}
