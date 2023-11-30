package afterWorkleetCode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

//Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the
//        result in any order.
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//        Output: [9,4]
//        Explanation: [4,9] is also accepted.
public class IntersectionTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
// хз че тут если честно
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            s1.add(nums1[i]);
            System.out.println(s1);
        }
        for (int i = 0; i < nums2.length; i++) {
            s2.add(nums2[i]);
            System.out.println(s2);
        }
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : s1) {
            if (s2.contains(i)) {
                l.add(i);
            }
        }
        int r = l.size();
        int[] arr = new int[r];
        for (int i = 0; i < r; i++) {
            arr[i] = l.get(i);
        }
        return arr;


//        int [] res = new int[3];
//        for (int i = 0; i < nums1.length; i++) {
//            for (int j = 0; j < nums2.length; j++) {
//                if (nums1[i] == nums2[j]) {
//                    while (nums1[i] == nums2[j]) {
//                        i++;
//                        j++;
//                    }
//                }
//            }
//        }
//
//        return null;
    }

    public static void main(String[] args) {
        int[] arr1 = {9, 4, 9, 8, 4};
        int[] arr2 = {4, 5, 9};
        System.out.println(Arrays.toString(intersection(arr1, arr2)));
    }
}
