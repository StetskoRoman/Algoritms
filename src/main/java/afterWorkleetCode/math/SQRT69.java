package afterWorkleetCode.math;

import java.math.RoundingMode;

public class SQRT69 {

    public static int mySqrt(int x) {
        int left = 0;
        int right = x;
        int mid = 0;
        if (x < 2) return x;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid == x / mid) return mid;
            if (x / mid > mid) left = mid + 1;
            if (mid > x / mid && (mid - 1) < x / (mid - 1)) {
//                System.out.println("here " + mid);
                return mid - 1;
            }
            if (x / mid < mid) {
                System.out.println(" in the last ");
                right = mid - 1;
//                System.out.println("right = " + right + "    mid = " + mid);
            }

        }
        return mid;

    }

    public static void main(String[] args) {
        int number = 15;
        System.out.println(mySqrt(number));
        int i = 5 / 4;
        System.out.println(5 / 4 == 1);
        System.out.println((int) Math.ceil(9 / 2));
    }
}
