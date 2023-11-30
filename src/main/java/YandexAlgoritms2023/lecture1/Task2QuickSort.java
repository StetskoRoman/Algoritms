package YandexAlgoritms2023.lecture1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Task2QuickSort {

    public static void main(String[] args) throws IOException {
        int countLine = 0;
        int n = 0;
        int[] nums = new int[0];
        long x = 0;


        PrintWriter printWriter = new PrintWriter(System.out);


        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    nums = new int[n];
                    countLine++;
                    continue;
                }

                if (countLine == 1) {

                    for (int i = 0; i < n; i++) {
                        nums[i] = Integer.parseInt(tokens[i]);
                    }
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
        System.out.println("after first iter");

        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

        System.out.println("AND FINALLY");
//        resultSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

//        for (int i = 0; i < nums.length; i++) {
//            printWriter.print(nums[i] + " ");
//
//        }
//        printWriter.flush();
//        int left = solution(x, nums);
//        printWriter.println(left);
//        printWriter.println(n - left);
//        printWriter.flush();
    }

    static int quickSort(int[] nums, int left, int right) {

        int n = nums.length;
//        int partitionPos = 1;
        int partitionPos = (int) (Math.random() * (right - left)) + left;
        int partitionNum = nums[partitionPos];
        System.out.println("part num = " + partitionNum + "  part pos " + partitionPos  + "  || in the begining left = " + left + "  right = " + right);
        int E = 0;
        boolean isEactive = false;
        int G = -1;
        boolean isGactive = false;
        int N = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] == partitionNum && isEactive == false) {
                E = i;
                isEactive = true;
                continue;
            }
            if (nums[i] > partitionNum && isGactive == false) {
                G = i;
                isGactive = true;
                continue;
            }

            if (isGactive && isEactive) {
                break;
            }
        }
        System.out.println(" E = " + E + "   G = " + G);

//         меняем местами если если G будет в матрице раньше E - точно работает норм
        if (isGactive == true && isEactive == true && G < E) {
            int temp = nums[G];
            int tempGpos = G;
            nums[G] = nums[E];
            nums[E] = temp;
            G = E;
            E = tempGpos;

            System.out.println(nums[E] + "   " + E + " eto E");
            System.out.println(nums[G] + "   " + G + " eto G");
        }

        for (int i = left; i <= right; i++) {
            if (nums[i] > partitionNum) {
                G = i;
                System.out.println("final G = " + G);
                break;
            }
        }
        System.out.println(" before main session " + Arrays.toString(nums));


        while (N <= right) {
//            System.out.println("here N = " + N + "   and num = " + nums[N]);
//            System.out.println("inside array " + Arrays.toString(nums));
            if (nums[N] < partitionNum && N < E) {
                N++;
                continue;
            }
//            переход вперед
            if (nums[N] == partitionNum && N <= E) {
                N++;
                continue;
            }

            if (nums[N] > partitionNum) {
//                System.out.println("here ");
                N++;
                continue;
            }

            if (nums[N] == partitionNum && G >= 0) {
                System.out.println("tutachki");
                int y = nums[N];
                nums[N] = nums[G];
                nums[G] = y;
                G++;
                N++;
                continue;
            }
            if (nums[N] == partitionNum && G < 0) {
                N++;
                continue;
            }

            if ((nums[N] < partitionNum && G >= 0 && G > N) || (nums[N] < partitionNum && G < 0)) {

                int y = nums[N];
                nums[N] = nums[E];
                nums[E] = y;
                E++;
                N++;
                continue;
            }
            if (nums[N] < partitionNum && G >= 0 && G < N) {

                int y = nums[N];
                nums[N] = nums[G];
                nums[G] = nums[E];
                nums[E] = y;
                E++;
                G++;
                N++;
                continue;
            }

        }
        System.out.println("final: E = " + E + "  G = " + G + "   N = " + N);
        System.out.println(" and in the end array is " + Arrays.toString(nums));

        if (E > 0) {
            System.out.println("another cycle E > 0");
            quickSort(nums, 0, E - 1);
        }

//        if (G < nums.length - 1) {
//            System.out.println("Cycle s G ");
//            quickSort(nums, G, nums.length - 1);
//        }

        return G;

    }
}
//    static void resultSort(int[] nums, int E, int G) {
//        if (E > 0) {
//            System.out.println("inside result sort  right = " + E + "    left = " + G);
//
//            int[] partition = quickSort(nums, E, G);
//            left = partition[0];
//            right = partition[1];
//            resultSort(nums, 0, left);
//            resultSort(nums, right, nums.length - 1);
//
//        }
//
//    }



//if (E > 0) {
//            System.out.println("another cycle E > 0");
//            quickSort(nums, 0, E-1);
//        }
//
//        if (G < nums.length - 1) {
//            System.out.println("Cycle s G ");
//            quickSort(nums, G, nums.length - 1);
//        }


//    static void resultSort(int[] nums, int left, int E, int G,  int right) {

//    int[] partition = quickSort(nums, left, right);
//        left = partition[0];
//                right = partition[1];
//                if (left > 1) {
//                resultSort(nums, 0, left);
//                }
//                if (right < nums.length - 2) {
//        resultSort(nums, right, nums.length - 1);
//        }

//    int E, int G,


// if (right - left > 1) {
//         System.out.println("inside result sort  right = " + right + "    left = " + left);
//
//         int[] partition = quickSort(nums, left, right);
//         left = partition[0];
//         right = partition[1];
//         resultSort(nums, 0, left);
//         resultSort(nums, right, nums.length - 1);
//
//         }


//System.out.println("final: E = " + E + "  G = " + G + "   N = " + N);
//        int[] result = new int[2];
//        result[0] = E-1;
//        result[1] = G;
