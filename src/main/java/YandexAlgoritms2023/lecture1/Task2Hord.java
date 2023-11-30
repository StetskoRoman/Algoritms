package YandexAlgoritms2023.lecture1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Task2Hord {

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

        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            printWriter.print(nums[i] + " ");

        }
        printWriter.flush();
    }

    private static int partition(int arr[], int begin, int end) {
//        int pivot = arr[end];
        int pivotPos = (int) (Math.random() * (begin - end)) + end;
        int pivot = arr[pivotPos];
        System.out.println(pivot + "   " + pivotPos );
        System.out.println(Arrays.toString(arr));
//        int left = (begin - 1);
        int left = begin;
        int right = end;

        int leftNum = 0;
        int rightNum = 0;

        Boolean isLeftExist = false;
        Boolean isRightExist = false;

        while (left <= right) {
            if (arr[left] <= pivot) {
                left++;
                continue;
            }
            if (arr[right] > pivot) {
                right--;
                continue;
            }

            if (arr[left] > pivot || left < right) {
                leftNum = arr[left];
                isLeftExist = true;

                while (arr[right] > pivot) {
                    right--;

                }
                rightNum = arr[right];
                isRightExist = true;
                if (isLeftExist && isRightExist) {
                    int temp = leftNum;
                    arr[leftNum] = rightNum;
                    arr[right] = temp;
                    left++;
                    right--;
                    continue;
                }


//                if (isLeftExist && !isRightExist) {
//                    arr[left] = arr[];
//                    pivotPos = left;
//
//                    break;
//                }
//                arr[right]

            }
        }

//        for (int i = begin; j < end; j++) {
//            if (arr[j] <= pivot) {
//                left++;
//
//                int swapTemp = arr[left];
//                arr[left] = arr[j];
//                arr[j] = swapTemp;
//            }
//        }
//
//        int swapTemp = arr[left + 1];
//        arr[left + 1] = arr[end];
//        arr[end] = swapTemp;

        return left + 1;
    }

    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }
}

