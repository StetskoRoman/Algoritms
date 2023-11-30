package afterWorkleetCode.arrays;

import java.util.*;
import java.util.stream.Collectors;

//Given an array nums of size n, return the majority element.
//
//        The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
//        Input: nums = [2,2,1,1,1,2,2]
//        Output: 2
public class MajorityElement169 {

    public static int majorityElement(int[] nums) {

        int x = 0;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            x = nums[i];
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            }
            if (!map.containsKey(x)) {
                map.put(x, 1);
            }
        }
        Map.Entry<Integer, Integer> maxCounted = null;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxCounted == null || maxCounted.getValue() < entry.getValue()) {
                maxCounted = entry;
            }
        }

//        Альтернативы

//        Character maxKey = null;
//        for (Character key : hm.keySet()) {
//            if (maxKey == null || hm.get(key) > hm.get(maxKey)) {
//                maxKey = key;
//            }
//        }

//        Map.Entry<Character, Integer> maxEntry = hm.entrySet().stream()
//                .max(Comparator.comparing(Map.Entry::getValue))
//                .orElse(null);

        System.out.println(map.entrySet());
        System.out.println(map.keySet());
        System.out.println(map.keySet().stream().findFirst());


        return maxCounted.getKey();
    }

    public static void main(String[] args) {
        int[] array = {2, 2, 1, 1, 1, 2, 2};
        int[] array2 = {6, 5, 5};
//        countingElements(array);

        System.out.println(majorityElement(array2));


    }

//    public static int countingElements(int[] nums) {
//
//        int x = 0;
//        Map<Integer, Integer> map = new LinkedHashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            x = nums[i];
//            if (map.containsKey(x)) {
//                map.put(x, map.get(x) + 1);
//            }
//            if (!map.containsKey(x)) {
//                map.put(x, 1);
//            }
//
//        }
//        System.out.println(map.entrySet());
//        System.out.println(map.keySet());
//        System.out.println(map.keySet().stream().findFirst());
//
//        return map.keySet().stream().findFirst().orElse(0);
//    }
}
