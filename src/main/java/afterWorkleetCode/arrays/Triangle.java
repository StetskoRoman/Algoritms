package afterWorkleetCode.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//Given a triangle array, return the minimum path sum from top to bottom.
//
//        For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
//        Example 1:
//
//        Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//        Output: 11
//        Explanation: The triangle looks like:
//        2
//        3 4
//        6 5 7
//        4 1 8 3
//        The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {

        int sum = triangle.get(0).get(0);
        int k = 0;
        int[] sumContainers = new int[(int) Math.pow(2, (triangle.size() - 1))];
        System.out.println(sumContainers.length);


        while (k <= triangle.size() - 1) {
            for (int i = 1; i < triangle.size(); i++) {
                int temp = 0;
            }
            k++;
        }

//            while (k < triangle.get(i).size()) {
//                temp = triangle.get(i).get(k);
//            }

//            if (triangle.get(i).get(k) < triangle.get(i).get(k + 1)) {
//                temp = triangle.get(i).get(k);
//                sum += temp;
//            } else {
//                temp = triangle.get(i).get(k + 1);
//                sum += temp;
//                k++;
//            }


        return 0;
    }
//        а теперь в обратном порядке надо пройти
//        int alterSum = triangle.get(0).get(0);
//        int alterMin = Collections.min(triangle.get(triangle.size()-1));
//        int alterK = 0;
//
////        Choose min from down
//        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
//            if (alterMin == triangle.get(triangle.size() - 1).get(i)) {
//                alterK = i;
//                alterSum += triangle.get(triangle.size() - 1).get(alterK);
//                alterK--;
//            }
//        }
//
//        for (int i = triangle.size() - 2; i >= 1; i--) {
//            int temp = 0;
//            if (alterK < triangle.get(i).size() - 1) {
//                if (triangle.get(i).get(alterK) < triangle.get(i).get(alterK + 1)) {
//                    temp = triangle.get(i).get(alterK);
//                    alterSum += temp;
//                } else {
//                    temp = triangle.get(i).get(alterK + 1);
//                    alterSum += temp;
//                    alterK--;
//                }
//
//            } else {
//                alterSum += triangle.get(i).get(alterK);
//                alterK--;
//            }
//
//        }
//
//        return Math.min(alterSum, sum);
//    }

    public static void main(String[] args) {

        List<Integer> pos1 = new ArrayList<>();
        pos1.add(2);
        List<Integer> pos2 = List.of(3, 4);
        List<Integer> pos3 = List.of(6, 5, 7);
        List<Integer> pos4 = List.of(4, 1, 8, 3);

        List<List<Integer>> figure = List.of(pos1, pos2, pos3, pos4);

//        List<Integer> pos1 = List.of(-1);
//        List<Integer> pos2 = List.of(2, -3);
//        List<Integer> pos3 = List.of(1, -2, -1);
//        List<List<Integer>> figure = List.of(pos1, pos2, pos3);
//        System.out.println(figure);
        System.out.println("res " + minimumTotal(figure) + "   size = " + figure.size());


    }
}
