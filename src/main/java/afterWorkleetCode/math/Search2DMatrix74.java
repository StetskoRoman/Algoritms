package afterWorkleetCode.math;

//You are given an m x n integer matrix matrix with the following two properties:
//
//        Each row is sorted in non-decreasing order.
//        The first integer of each row is greater than the last integer of the previous row.
//        Given an integer target, return true if target is in matrix or false otherwise.
//
//        You must write a solution in O(log(m * n)) time complexity.
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//        Output: true
public class Search2DMatrix74 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (target < matrix[0][0]) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (target <= matrix[i][matrix[i].length-1]) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (target == matrix[i][j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int [][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(matrix, 35));
        System.out.println(matrix[0].length);
    }
}
