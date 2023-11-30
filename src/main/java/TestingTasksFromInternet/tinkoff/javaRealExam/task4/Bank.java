package TestingTasksFromInternet.tinkoff.javaRealExam.task4;

import java.util.*;
import java.util.stream.Collectors;

public class Bank {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[m * 2];
        for (int i = 0; i < a.length; i += 2) {
            a[i] = scanner.nextInt();
            a[i + 1] = a[i];
        }
        List<Integer> resultList = banknotes(a, n);
        int resultSum = 0;
        for (int i = 0; i < resultList.size(); i++) {
            resultSum += resultList.get(i);
        }


        if (banknotes(a, n).size() != 0 && resultSum == n) {
            System.out.println(resultSum);
            for (int j = 0; j < resultList.size(); j++) {
                System.out.print(resultList.get(j) + " ");
            }

        } else {
            System.out.println(-1);
        }

    }

    public static List<Integer> banknotes(int[] a, int n) {
        List<Integer> oldList = matrixToSortedArray(a);
        System.out.println("old list " + oldList);

        int delta = 0;
        int minDelta = 0;
        int sum = 0;
        int right = a.length - 1;
        List<Integer> list = new ArrayList<>();
        int maxSum = oldList.stream().mapToInt(i -> i.intValue()).sum();
        System.out.println("maxSum = " + maxSum);
        if (maxSum < n) {
            return new ArrayList<>(0);

        }

//        try {
        while (sum < n || oldList.size() == 0) {
            System.out.println("HERE ");

            for (int i = oldList.size() - 1; i >= 0; i--) {
                delta = n - sum;
                minDelta = oldList.get(0);
                if (minDelta > delta) {
                    return list;
                }
                System.out.println("delta = " + delta);
                System.out.println("mindelta = " + minDelta);
//                    if (delta < minDelta && !oldList.contains(minDelta)) {
//
//                        return list;
//                    }
                if (oldList.contains(delta)) {
                    list.add(delta);
                    sum += delta;
                    return list;
                }

                //здесь условие


                if ((oldList.get(i) < delta) && oldList.get(i) + minDelta <= delta) {
                    sum += oldList.get(i);
                    list.add(oldList.get(i));
                    System.out.println("sum = " + sum + "  dobavili a=" + oldList.get(i));
                    oldList.remove(i);
                    continue;

                }

//                if (oldList.get(i) >= minDelta) {
//                    list.add(oldList.get(0));
//                    System.out.println("dobavil s nachala + " + oldList.get(0));
//                    oldList.remove(0);
//                    continue;
//
//                }

                for (int j = 0; j < oldList.size(); j++) {
                    System.out.println("TUTA aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                    if (oldList.get(j) == delta) {
                        break;
                    }
                    if (j == oldList.size() - 1) {
                        return list;
                    }

                }

            }
//                if (a[right] <= n - sum) {
//                    sum += a[right];
//                    list.add(a[right]);
//                    right--;
//                    System.out.println("sum = " + sum);
//                } else right--;

        }
        System.out.println(list);
//        } catch (ArrayIndexOutOfBoundsException e) {
//            return new ArrayList<>(0);
//        }
        return list;
    }

    public static List<Integer> matrixToSortedArray(int[] a) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        Collections.sort(list);

        return list;
    }
}

//|| minDelta<delta

// && oldList.get(i) + minDelta <= delta


//        System.out.println(n + "  " + m);
//        System.out.println(Arrays.toString(a));

//&& oldList.get(i)+minDelta <= n-sum

//if (oldList.get(right) <= n - sum) {
//        sum += oldList.get(right);
//        list.add(oldList.get(right));
//        right--;
//        System.out.println("sum = " + sum);
//        } else right--;