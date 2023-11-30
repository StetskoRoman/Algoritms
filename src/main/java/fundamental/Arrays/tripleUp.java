package fundamental.Arrays;

public class tripleUp {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        boolean answer = false;
        for (int i = 2; i < nums.length; i++) {
            if ((nums[i] - nums[i - 1] == 1) && (nums[i - 1] - nums[i - 2] == 1)) {
                answer = true;
            }
        }
        System.out.println(answer);
    }
}
