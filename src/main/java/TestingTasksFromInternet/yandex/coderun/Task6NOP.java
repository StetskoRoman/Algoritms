package TestingTasksFromInternet.yandex.coderun;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Task6NOP {

    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int countLine = 0;
        int n = 0;
        int m = 0;
        int[] numsN = new int[0];
        int[] numsM = new int[0];
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] tokens = line.split(" ");

            if (countLine == 0) {
                n = Integer.parseInt(tokens[0]);
                countLine++;
                continue;
            }

            if (countLine == 1) {
                numsN = new int[n];
                for (int i = 0; i < n; i++) {
                    numsN[i] = Integer.parseInt(tokens[i]);
                }
                countLine++;
                continue;
            }

            if (countLine == 2) {
                m = Integer.parseInt(tokens[0]);
                countLine++;
                continue;
            }

            if (countLine == 3) {
                numsM = new int[m];
                for (int i = 0; i < m; i++) {
                    numsM[i] = Integer.parseInt(tokens[i]);
                }

                break;
            }

        }
        bufferedReader.close();

        List<Integer> result = solution(numsN, numsM);


        PrintWriter printWriter = new PrintWriter(System.out);

        if (result == null) {
            printWriter.print("");
            printWriter.flush();
            printWriter.close();
            return;
        }

        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1) {
                printWriter.print(result.get(i));
                break;
            }
            printWriter.print(result.get(i) + " ");
        }
        printWriter.flush();
        printWriter.close();
    }

    static List<Integer> solution(int[] N, int[] M) {

        int length = 0;
        List<List<Integer>> list = new ArrayList<>();
        int pointM = 0;

        List<Integer> addList = new ArrayList<>();
        for (int i = 0; i < N.length; i++) {

            pointM = 0;
            for (int j = pointM; j < M.length; j++) {
                if (N[i] == M[j]) {
                    while ((((i + length) < N.length) && ((j + length) < M.length)) && N[i + length] == M[j + length]) {
//                        System.out.println(" i = " + i + "   j = " + j + "   length = " + length + "   " + N[i + length] + "  " + M[j + length]);
                        addList.add(M[j + length]);
                        length++;
                    }
                    list.add(addList);
                    pointM = j + length;
                    addList = new ArrayList<>();
                    length = 0;

                }
            }
        }

//        System.out.println(list);
        if (list.isEmpty()) {
            return null;
        }
        List<Integer> res = findBiggest(list);
//        System.out.println(res);
        return res;
    }

    static List<Integer> findBiggest(List<List<Integer>> list) {
        int maxCapacity = 0;
        int maxPos = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).size() > maxCapacity) {
                maxCapacity = list.get(i).size();
                maxPos = i;
            }
        }
        return list.get(maxPos);
    }
}
//неправильный ответ на 8-ом тесте
//    static List<Integer> solution(int[] numsN, int[] numsM) {
//
//        int length;
//        List<List<Integer>> list = new ArrayList<>();
//
//        List<Integer> addList = new ArrayList<>();
//        for (int i = 0; i < numsN.length; i++) {
//            length = 0;
//            if (!list.isEmpty() && list.get(0).size() > numsN.length - i) {
////                System.out.println("was break " + list);
//
//                break;
//            }
//
//            for (int j = 0; j < numsM.length; j++) {
//                if (numsN[i] == numsM[j]) {
////                    System.out.println("numsN[" + i + "]=" + numsN[i] + "   j =" + j);
//
//                    addList.add(numsN[i]);
//                    length++;
//                    while (((i + length) < numsN.length) && ((j + length) < numsM.length) && (numsN[i + length] == numsM[j + length])) {
//                        addList.add(numsN[i + length]);
////                        System.out.println(" i = " + i + "  j = " + j + "  length = " + length + "   addList = " + addList) ;
//                        length++;
//
//                    }
//                    if (list.isEmpty()) {
//                        list.add(addList);
////                        System.out.println("zero added = " + list);
//                    }
//                    if (list.get(0).size() < addList.size()) {
////                        System.out.println("list set before +" + list);
//                        list.set(0, addList);
////                        System.out.println("list = inside = " + list);
//
//                    }
//                    length = 0;
//
//                    addList = new ArrayList<>();
////                    System.out.println("addlist here = " + addList);
//
//
//                }
//            }
////            addList.clear();
//
//        }
//
////        System.out.println("list = " + list.get(0));
//        if (list.isEmpty()) {
//            return null;
//        }
//
//        return list.get(0);
//    }

//}

//        for (int i = 0; i < numsM.length; i++) {
//            writer.write(numsM[i] + " ");
//        }
//        writer.write(Arrays.toString(numsN));
//        writer.write(" n = " + n);
//        writer.write(" m = " + m);
//        writer.flush();


