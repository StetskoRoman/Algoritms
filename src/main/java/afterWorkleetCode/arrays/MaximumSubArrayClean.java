package afterWorkleetCode.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Работает но медленнее чем надо
//Given an integer array nums, find the
//        subarray
//        with the largest sum, and return its sum.


public class MaximumSubArrayClean {


    //    чистое решение
    public static int maxSubArray(int[] nums)  throws Exception{

        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(sum, max);  //присваивает max = sum если sum > max

            if (sum < 0) sum = 0;
        }

        return max;
    }


    public static int maxIntegerOfArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static int sumSubArray(int[] nums, int begin, int end) {

        int sum = 0;
        for (int i = begin; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {

//        int[] array = {5, 1, -5, 11, -11, 2, 1, -17, 10, 1, 2, 3, -5};
        int[] array = {10, 9, 6, -7, -1, 110, 9, 5};
        System.out.println(maxIntegerOfArray(array));
        System.out.println(sumSubArray(array, 0, 3));
//        System.out.println("asd = " + maxSubArray(array));

    }
}
