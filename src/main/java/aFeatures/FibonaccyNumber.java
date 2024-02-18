package aFeatures;

import java.math.BigInteger;
import java.util.Arrays;
//bigDecimal надо по хорошему
public class FibonaccyNumber {

    public static void main(String[] args) {

        int n = 200;

        long[] res = getSequenceFibonaccy(n);

        System.out.println(Arrays.toString(res));
        BigInteger[] resBig = getFibonaccyBig(n);

        System.out.println(Arrays.toString(resBig));
        System.out.println(res[100]);
        System.out.println(resBig[100]);
    }

    static long[] getSequenceFibonaccy(int n) {

        long[] nums = new long[n];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i < nums.length; i++) {
            nums[i] = nums[i - 2] + nums[i - 1];
        }
        return nums;
    }

//    O(nlog(n)) - т.к. в больших числах сложение как в столбик происходит
    static BigInteger[] getFibonaccyBig(int n) {

        BigInteger[] nums = new BigInteger[n];
        nums[0] = BigInteger.valueOf(1);
        nums[1] = BigInteger.valueOf(1);

        for (int i = 2; i < nums.length; i++) {
            nums[i] = nums[i - 2].add(nums[i - 1]);
        }
        return nums;
    }
}
