package fundamental.AP1;

import java.util.Arrays;

public class CopyEvens {
    public static int[] copyEvens(int[] nums, int count) {
        int[] array = new int[count];
        int i = -1;
        int j = 0;
        while (j < count) {

            i++;
            if (nums[i] % 2 == 0) {
                array[j] = nums[i];
                j++;
                continue;
            }

        }
        return array;
    }

    public static void main(String[] args) {

        int [] arr = {6, 1, 2, 4, 5, 8};
        int count = 4;

        System.out.println(copyEvens(arr,count));

        System.out.println(Arrays.toString(copyEvens(arr,count)));

    }
}
