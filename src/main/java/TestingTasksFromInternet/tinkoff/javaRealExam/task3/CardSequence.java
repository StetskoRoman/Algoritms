package TestingTasksFromInternet.tinkoff.javaRealExam.task3;

//7
//        4 4 1 7 5 3 8
//        4 1 4 5 7 3 8

import java.util.*;


public class CardSequence {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < b.length; i++) {
            b[i] = scanner.nextInt();
        }

        if (canCowboyWin(a, b)) {
            System.out.println("YES");
        } else System.out.println("NO");
    }

    public static boolean canCowboyWin(int[] a, int[] b) {
        int left = 0;
        int right = a.length - 1;
        int lStart = 0;
        int rStart = 0;

        if (!isSequencesHaveTheSameNumbers(a, b)) return false;

        while (left < a.length) {
            if (a[left] == b[left]) {
                left++;
            } else {
                lStart = left;
                break;
            }
        }

        while (right > 0) {
            if (a[right] == b[right]) {
                right--;
            } else {
                rStart = right;
                break;
            }
        }

        boolean status = true;

        while (lStart < rStart) {
            if (b[lStart] > b[lStart + 1]) {
                status = false;
                break;
            }

            for (int i = lStart; i <= rStart; i++) {
                int temp = 0;

                if (b[lStart] == a[i]) {
                    temp = a[i];
                    a[i] = a[lStart];
                    a[lStart] = temp;
                    lStart++;
                    break;
                }
            }
        }

        return status;
    }

    public static boolean isSequencesHaveTheSameNumbers(int[] a, int[] b) {
        List<Integer> aList = matrixToArray(a);
        List<Integer> bList = matrixToArray(b);
        Collections.sort(aList);
        Collections.sort(bList);
        if (aList.equals(bList)) {
            return true;
        }
        return false;
    }

    public static List<Integer> matrixToArray(int[] a) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        return list;
    }
}


//        public static List<Integer> matrixToArray(int[] a) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < a.length; i++) {
//            list.add(a[i]);
//        }
//        return list;
//    }
//
//    public static boolean isSequencesHaveSameNumbers(int[] a, int[] b) {
////        List<Integer> aList = matrixToArray(a);
////        List<Integer> bList = matrixToArray(b);
////        while (aList.size() > 0) {
////
////        }
////        for (int i = 0; i < a.length; i++) {
//
////            for (int j = 0; j < b.length; j++) {
////                if (bList.contains())
////            }
//        return return new HashSet<>(a).equals(new HashSet<>(b));;
//        }
//
//    }
//}

//    public static List<Integer> matrixToArray(int[] a) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < a.length; i++) {
//            list.add(a[i]);
//        }
//        return list;
//    }
//
//}


//        while (left < right) {
//            System.out.println("left here = " + left);
//            System.out.println("right here = " + right);
//            if ((a[left] == b[left]) && (lStart == 0)) {
//                left++;
//                continue;
//            } else {
//                System.out.println("here");
//                lStart = left;
//                left++;
//            }
//            if (a[right] == b[right]) {
//                right--;
//
//            } else {
//                rStart = right;
//                right--;
//
//            }
//        }


//    public static boolean isSequencesHaveSameNumbers(int[] a, int[] b) {
//        List<Integer> aList = matrixToArray(a);
//        List<Integer> bList = matrixToArray(b);
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < b.length; j++) {
//                if (bList.contains())
//            }
//        }
//    }