package TestingTasksFromInternet.yandex.autumn2023.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//1672 мс
public class Task2A {

    public static void main(String[] args) throws IOException {



        List<List<String>> term = new ArrayList<>();

        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in)) {
            String line;
            int qCounting = 0;
            while ((line = buffer.readLine()) != null) {
                List<String> lineList = new ArrayList<>();
                String[] tokens = line.split(" ");
                for (int i = 0; i < tokens.length; i++) {
                    lineList.add(tokens[i]);
                }
                term.add(lineList);
                qCounting++;
                if (Integer.parseInt(term.get(0).get(2))+2 < qCounting) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> A = new ArrayList<>();
        A.addAll(term.get(1));
        List<String> B = new ArrayList<>();
        B.addAll(term.get(2));
        StringBuilder result = new StringBuilder();

        for (int i = 3; i < term.size(); i++) {
            int type = Integer.parseInt(term.get(i).get(0));
            char player = term.get(i).get(1).charAt(0);
            String card = term.get(i).get(2);
            changingOfCollection(type, player, card, A, B);
            result.append(variety(A, B) + " ");
        }
        System.out.println(result);

    }

    public static int variety(List<String> A, List<String> B) {

        int sumOfCopies = 0;
        for (int i = 0; i < B.size(); i++) {
            String str = B.get(i);
            if (A.indexOf(str) >= 0) {
                sumOfCopies += 2;
            }
        }
        return A.size() + B.size() - sumOfCopies;
    }

    public static void changingOfCollection(int type, char player, String card, List<String> A, List<String> B) {

        if (type == 1) {
            if (player == 'A') {
                A.add(card);
            } else {
                B.add(card);
            }
        }

        if (type == -1) {
            if (player == 'A') {
                A.remove(card);
            } else {
                B.remove(card);
            }
        }
    }

}


//    public static int[] strToIntArray(String[] array) {
//        int[] nums = new int[array.length];
//        for (int i = 0; i < array.length; i++) {
//            nums[i] = Integer.parseInt(array[i]);
//        }
//        return nums;
//    }

//        System.out.println("res = " + result);
//
//
//
//
//                String a = "11111111111111111111111111";
//                String b = "11111111111111111111111111";
//                System.out.println(a.equals(b));
//
//
//                changingOfCollection(-1, 'B', "2", A, B);
//                System.out.println("A = " + A);
//                System.out.println("b = " + B);
//
//                System.out.println(variety(A, B));
////        int[] B = strToIntArray(term.get(2));
////        int q =
////
////        System.out.println(Arrays.toString(term.get(12)));
////
////        System.out.println(Arrays.toString(strToIntArray(term.get(1))));