package TestingTasksFromInternet.realInterviewTasks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BiggestPodStroka {

    public static void main(String[] args) {

        String str = "123asdf";

        int res = biggestSubstring(str);
        System.out.println(res);

    }

    static int biggestSubstring(String str) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException();
        }

        char[] chars = str.toCharArray();
        int left = 0;
        int right = 0;

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (right <= str.length() - 1) {

//            System.out.println("counting   left = " + left + "  right = "+  right);

            if (right == left) {
                set.clear();
            }
            if (!set.contains(chars[right])) {
                set.add(chars[right]);
                right++;
                int tempSum = right - left;
                if (tempSum > max) {
                    max = tempSum;
                }
                continue;
            }
            if (set.contains(chars[right])) {
                set.remove(chars[right]);
                left++;
            }

        }

        return max;
    }

    static int solution(String str) {
        return 0;
    }
}

// wrong
//    static int solution(String str) {
//
//        char[] chars = str.toCharArray();
//
//        int right = 0;
//        int left = 0;
//
//        Set<Character> set = new HashSet<>();
//
//        while (left != right) {
//
//            if (!set.contains(chars[left])) {
//                set.add(chars[left]);
//                left++;
//            }  else {
//
//            }
//
//            if (!set.contains(chars[right])) {
//                set.add(chars[right]);
//                right--;
//            }
//
//        }
//
//        return 0;
//    }
