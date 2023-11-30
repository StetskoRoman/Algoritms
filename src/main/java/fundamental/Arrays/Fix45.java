package fundamental.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fix45 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 4, 1, 5};
        int temp = 0;
        int posJ = 0;
        int tempFour = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == 4 && nums[i] == 5) {
//                posJ = i+1;
               System.out.println("continue");
                continue;
            }
            if (nums[i - 1] == 5) {

                System.out.println(" i na 5    " + posJ);
                for (int k = 1; k < nums.length; k++) {
                    if (nums[k-1] == 4) {
                        posJ=i-1;
                        tempFour = nums[k];
                        nums[k] = nums[i - 1];
                        nums[i - 1] = tempFour;

                    }


                }
//                System.out.println("Pos j 1 = " + posJ);
            }

            if (nums[i-1] == 4) {
                for (int j = posJ; j < nums.length; j++) {
                   // System.out.println(" j = " + j);
                    if (nums[j] == 5) {
                        if (j < i) {
                            posJ = j+1 ;//ошибка ?
                        } else {
                            posJ = i+1; //тут проблема
                        }

                        temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
//                        System.out.println("pos j 1 raz  " + posJ);
                        break;

                    }

                }
            }
//            System.out.println("i = " + i + Arrays.toString(nums) + "    posJ + " + posJ);
        }
        System.out.println(Arrays.toString(nums));
    }
}
