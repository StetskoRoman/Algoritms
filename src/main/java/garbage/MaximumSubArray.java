package garbage;


//Given an integer array nums, find the
//subarray
// with the largest sum, and return its sum.
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//        Output: 6

//i = n; важно чтобы не сбить цепочку  i = начало цепочки, n - конец
// итак
import java.util.*;

//
public class MaximumSubArray {

    public static int maxSubArray(int[] nums) {

//        List<Integer> sumList = new ArrayList<>();


        if (nums.length == 1) {
            return nums[0];
        }
        if (maxIntegerOfArray(nums) <= 0) {
            return maxIntegerOfArray(nums);
        }

        int temptSum = 0;
        int sum = 0;
        int n = 0;
        int i = 0;
        int countingSums = 0;

        while (n < nums.length) {
            System.out.println("Countin i");

                System.out.println("here i = " + i);
                if (nums[n] >= 0) {
                    while (nums[n] >= 0) {
                        if (n == nums.length - 1) {
                            n++;
                            System.out.println("final ending " + n);
                            break;
                        }
                        n++;

                    }
                    //считаем всегда строчки где заканчиваются + числа
                    temptSum = sumSubArray(nums, i, n - 1);
                    System.out.println("temp sum = " + temptSum);
                    countingSums++;
                    if (temptSum > sum) {
                        sum = temptSum;
                    }
//                    sumList.add(sumSubArray(nums, i, n-1));
//                    countingSums++;
                }

                if (n > nums.length - 1) {
                    n++;
                    System.out.println("final ending 2  " + n);
                    break;
                }

            int sumNegative = 0;
            System.out.println("итак я тут и n = " + n + "   " + sumNegative + " a temosum = " + temptSum);
                    while (nums[n] < 0) {
                        if (n == nums.length - 1) {
                            n++;
                            System.out.println("I cant be here!");
                            break;
                        }
                        //тупорылый пздц как так можно, просто суммируй отрицательные числа подряд и пока меньше предыдущей суммы - дальше считать, а как больше, новый i и на новый круг
                        sumNegative += Math.abs(nums[n]);

                        if (sumNegative < temptSum) {

                            n++;
                            System.out.println("sum negative before = " + sumNegative +"   "+ n);

                        }

//                        System.out.println("here sumNegative = " + sumNegative + " and ill be on " + n + "  tempt sum = " + temptSum);


//                        if (sumNegative > temptSum) {
                        else {
                            System.out.println("here sumNegative = " + sumNegative + " and ill be on " + n + "  tempt sum = " + temptSum);
                            n++;
                            i = n;
                            break;
                        }
//                        while (sumNegative < sum) {
//
////                            break;
//                        }
//                        if (sumNegative > sum)
//                        else
//                        {
//                            System.out.println("here sumNegative = " + sumNegative + " and ill be on " + n);
//                            n++;
//                            i = n;
//                            break;
//                        }
                    }


//                        if (sumSubArray(nums, i, n) > 0) {
//                            System.out.println(nums[n] + "  " + i + "  " + n + " v itoge  = " + sumSubArray(nums,i,n));
//                            n++;
//                            System.out.println("i`m here ");
//
//                        } else {
//                            System.out.println("Big break");
//                            n++;
//                            i = n;
//                            break;
//                        }

            System.out.println();

            }

//            n++;

//        System.out.println(sumList);

//        sum = Collections.max(sumList);

        return sum;
    }


    public static void main(String[] args) {

        int num = 0;
        for (int i = 0; i < 100; i++)
            num = ++num;
        System.out.println(num);

//        int[] array = {5, 1, -5, 11, -13, -2, 1, -17, 15, 7, 2, 4, -5};
        int[] array = {10, 9, 6, -7,-100, -1, 110, 9, 5};
        System.out.println(maxIntegerOfArray(array));
        System.out.println(maxPos(array));
        System.out.println(sumSubArray(array, 0, 3));
        System.out.println("asd = " + maxSubArray(array));

    }

    public static int maxIntegerOfArray(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static int maxPos(int[] nums) {
        int max = nums[0];
        int maxI = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxI = i;
            }
        }
        return maxI;
    }

    public static int sumSubArray(int[] nums, int begin, int end) {

        int sum = 0;
        for (int i = begin; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
