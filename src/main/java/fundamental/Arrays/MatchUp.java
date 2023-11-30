package fundamental.Arrays;

public class MatchUp {
    public static void main(String[] args) {
        int [] nums1 = {1, 2, 3};
        int[] nums2 = {3, 5, 10};
        int result = 0;
        int temp = 0;
        for (int i = 0; i < nums1.length; i++) {
            temp = nums1[i] - nums2[i];
            if ((Math.abs(temp) < 3) && temp != 0) {
                result++;
            }
        }
        System.out.println(result);

    }
}
