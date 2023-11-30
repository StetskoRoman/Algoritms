package afterWorkleetCode.arrays;

//Given a sorted array of distinct integers and a target value, return the index if the target is found. If not,
//        return the index where it would be if it were inserted in order.
//
//        You must write an algorithm with O(log n) runtime complexity.
//        Input: nums = [1,3,5,6], target = 5
//        Output: 2
//Input: nums = [1,3,5,6], target = 2
//        Output: 1
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if ((target < nums[i]) && (target > nums[i - 1])) {
                return i;
            }
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        return 0;
    }

    public static void main(String[] args) {
        int [] nums = {1,3,5,6};
        int target = 0;
        System.out.println(searchInsert(nums, target));
    }
}
