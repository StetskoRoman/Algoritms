package leetCodeWork.StartTasks;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static String removeDuplicates(int[] nums) {
        int[] res = new int[nums.length];
        int j = 0;
        res[0] = nums[0];
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]){
                continue;
            }
            res[j+1] = nums[i+1];
            j++;
        }
        return (j+1) + ", nums = " + Arrays.toString(res);
    }

    public static void main(String[] args) {
        int [] ex = {0,1,2,2,3,5};
        System.out.println(removeDuplicates(ex));

    }
}
