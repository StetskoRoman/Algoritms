package leetCodeWork.StartTasks;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSumInMassive {

//    Если неотсортированный массив
//    public static int[] twoSum(int[] nums, int k) {
//        Set<Integer> set = new HashSet<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            int numberToFind = k - nums[i];
//            if (set.contains(numberToFind)) {
//                return new int[]{numberToFind, nums[i]};
//            } else {
//                set.add(nums[i]);
//            }
//
//        }
//        return new int[0];
//    }

    //    с бинарным поиском можно если упорядочен массив

    //два указателя самое оптимальное опять таки с упорядоченным массивом
    public static int[] twoSum(int[] nums, int k) {
        int left = 0;
        int iteration = 0;
        int sum = 0;
//        если ближайшее надо будет найти
//        int leftSum = k - iteration;
//        int rightSum = k + iteration;
//        while (iteration >= ) {
//            iteration++;
//        }
        int right = nums.length - 1;
        while (left < right) {
            sum = nums[left] + nums[right];
            if (sum == k) {
                return new int[]{nums[left], nums[right]};
            }
            if (sum < k) {
                left++;

            }
            if (sum > k) {
                right--;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {-3, 0, 2, 4, 5};
        System.out.println(Arrays.toString(twoSum(nums, 3)));

    }

}
