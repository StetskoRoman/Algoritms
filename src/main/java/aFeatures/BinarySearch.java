package aFeatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BinarySearch {

    public static void main(String[] args) {

        int[] ints = {1, 3, 5, 7, 9, 12, 14, 16};
        System.out.println(searchPosition(ints,4));


    }

    public static int searchPosition(int[] nums, int x) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left+(right-left)/2;
            if (nums[mid] == x) {
                return mid;
            }

            if (nums[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }


}
