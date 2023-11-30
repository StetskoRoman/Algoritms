package afterWorkleetCode.arrays;

//Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//
//        You must implement a solution with a linear runtime complexity and use only constant extra space.
//        Input: nums = [4,1,2,1,2]
//        Output: 4

import java.util.Arrays;

public class SingleNumber {

//    ^= - побитовый оператор ХОР (исключающее или), т.е. (
    public static int singleNumber(int[] nums) {

        int res = 0;
        for(int i = 0; i < nums.length; i++)
        {
            res ^= nums[i];
        }
        return res;
    }
//        int point = 0;
//
//        while (point < nums.length) {
//            for (int i = nums.length - 1; i >= 0; i--) {
//                if (nums[point] == nums[i]) {
//                    if (point == i) {
//                        return nums[point];
//                    }
//
//                    System.out.println("point before " + point);
//                    point = i+1;
//                    break;
//                }
//
//            }
//        }
//
//        return 0;


    public static void main(String[] args) {
        int[] array = {2,2,1};
        System.out.println(singleNumber(array));
    }
}
