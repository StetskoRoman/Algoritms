package fundamental.Arrays;

public class either24 {
    public static void main(String[] args) {
        int [] nums = {4, 4, 1, 2, 2};
        boolean condition;
        int count2 = 0;
        int count4 = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i - 1] == 4 && nums[i] == 4) {
                count4++;
            }
            if (nums[i - 1] == 2 && nums[i] == 2) {
                count2++;
            }

        }
        if ((count2 > 0 || count4 > 0) && !((count2 >= 1) && (count4 >= 1))) {
            condition = true;
        }
    }
}
