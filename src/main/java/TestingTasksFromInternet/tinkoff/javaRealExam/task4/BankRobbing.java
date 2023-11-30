package TestingTasksFromInternet.tinkoff.javaRealExam.task4;

import java.util.*;

public class BankRobbing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[m * 2];
        for (int i = 0; i < a.length; i += 2) {
            a[i] = scanner.nextInt();
            a[i + 1] = a[i];
            if (a[i] == n) {
                System.out.println(1);
                System.out.println(n);
                return;
            }
        }
        scanner.close();

        List<Integer> initList = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            initList.add(a[i]);
        }

        int maxSum = initList.stream().mapToInt(v -> v).sum();
        if (maxSum < n) {
            System.out.println(-1);
            return;
        }

        Collections.sort(initList);
        List<Integer> resultList = new ArrayList<>();

        int sum = 0;
        int sumInResult = 0;
        int minDelta = 0;

        while (sumInResult < n) {
            minDelta = initList.get(0);
            int left = 0;
            int right = initList.size() - 1;
            int middle = right / 2;

            sumInResult = resultList.stream().mapToInt(v -> v).sum();

            int delta = n - sumInResult;

            if (minDelta > delta) {
                System.out.println(-1);
                return;
            }

            while (left < right) {
                sum = initList.get(left) + initList.get(right);
                if (sum == delta) {
                    resultList.add(initList.get(left));
                    resultList.add(initList.get(right));
                    System.out.println(resultList.size());
                    printResultList(resultList);
                    return;
                }

                if (sum < delta) {
                    left++;
                }

                if (sum > delta) {
                    right--;
                }
            }

            if (initList.get(middle) < delta && initList.size() - 1 > middle) {
                for (int i = middle; i < initList.size(); i++) {
                    if (initList.get(i) < delta) {
                        resultList.add(initList.get(i));
                        initList.remove(i);
                        break;
                    }
                }
            } else if (initList.get(middle) > delta) {
                for (int i = middle; i > 0; i--) {
                    if (initList.get(i) < delta) {
                        resultList.add(initList.get(i));
                        initList.remove(i);
                        break;
                    }
                }
            }
        }

        if (sumInResult != n) {
            System.out.println(-1);
        }
    }

    public static void printResultList(List<Integer> list) {
        for (Integer number : list) {
            System.out.print(number + " ");
        }
    }
}

//            if (list.get(middle) < delta * 2 && list.size() - 1 > middle) {
//
//            }


//            sumInResult = resultList.stream().mapToInt(v -> v).sum();
//            sum = list.get(left) + list.get(right);
//            System.out.println("SumInresult " + sumInResult);
//            System.out.println("sum here = " + sum);
////            int delta = n - sumInResult;
//            System.out.println("delta = " + delta);
//
//            if (list.get(middle) < delta) {
//                if (list.get(middle+1).)


//            else if (list.get(left) * 2 < delta) {
//                System.out.println("AAAAAAAAAAAAAAAAAAAAAA");
//                resultList.add(list.get(left));
//                left++;
//                continue;
//            }
//            else if (list.get(right / 2) * 2 < delta) {
//                System.out.println("AAAAAAAAAAAAAAAAAAAAAA");
//                resultList.add(list.get(right / 2));
//                list.remove(right / 2);
//                right--;
//            }

//            if (sum == delta) {
//                resultList.add(list.get(left));
//                resultList.add(list.get(right));
//                System.out.println(resultList.size());
//                System.out.println(resultList);
//                return;
//            }
//
//            if (sum < delta) {
//                System.out.println("tuta");
//                left++;
//            }
//
//            if (sum > delta) {
//                System.out.println("tuta tuta ");
//                right--;
//            }

//            if (list.get(right) * 1.618 < delta) {
//                resultList.add(list.get(right));
//                right--;
//
//            }


//            sumInResult = resultList.stream().mapToInt(v -> v).sum();
//            sum = list.get(left) + list.get(right);