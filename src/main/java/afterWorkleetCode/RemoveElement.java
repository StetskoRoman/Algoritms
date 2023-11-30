package afterWorkleetCode;

import java.util.Arrays;

//Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
//
//        Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
//
//        Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
//        Return k.
//Input: nums = [3,2,2,3], val = 3
//Output: 2, nums = [2,2,_,_]
//Explanation: Your function should return k = 2, with the first two elements of nums being 2.
//It does not matter what you leave beyond the returned k (hence they are underscores).
public class RemoveElement {

    // Правильное и быстрое
//    public static int removeElement(int[] nums, int val) {
//        int i=0;
//        for(int j=0; j < nums.length;j++){
//            if(nums[j]!= val){
//                int temp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = temp;
//                i++;
//            }
//        }
//        for (int j = 0; j < nums.length; j++) {
//            System.out.println(nums[j]);
//        }
//        return i;
//    }

    public static int removeElement(int[] nums, int val) {
        int k = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                k--;
            }
        }

        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                temp = nums[i];

                for (int j = nums.length-1; j >= 0; j--) {
                    if (nums[j] != val && j>i) {  //самое важное j>i должно быть
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] num = {3, 1, 3, 2, 2, 2};
        System.out.println(removeElement(num,3));
        System.out.println(Arrays.toString(num));
    }
}
