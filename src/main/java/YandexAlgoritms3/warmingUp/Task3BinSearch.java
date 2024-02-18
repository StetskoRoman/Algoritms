package YandexAlgoritms3.warmingUp;

//Найти сколько из чисел в последовательности меньше чем заданное
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Task3BinSearch<T extends Comparable<T>> {

    private List<T> a;

    public Task3BinSearch(List<T> words) {
        a = words;
    }


    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        Set<Integer> set = new TreeSet<>();
        int k = 0;
        int[] kArray = new int[0];

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    countLine++;
                    continue;
                }
                if (countLine == 1) {
                    for (int i = 0; i < n; i++) {
                        set.add(Integer.valueOf(tokens[i]));
                    }
                    countLine++;
                    continue;
                }
                if (countLine == 2) {
                    k = Integer.parseInt(tokens[0]);
                    countLine++;
                    continue;
                }
                if (countLine == 3) {
                    kArray = new int[k];
                    for (int i = 0; i < k; i++) {
                        kArray[i] = Integer.parseInt(tokens[i]);
                    }

                    break;
                }

            }
        }

        List<Integer> list = new ArrayList<>(set);
//        System.out.println(list);
//        System.out.println(Arrays.toString(kArray));

        List<Integer> res = solution(list, kArray);
        PrintWriter printWriter = new PrintWriter(System.out);
        for (int i = 0; i < res.size(); i++) {
            printWriter.println(res.get(i));
        }
        printWriter.flush();
        printWriter.close();
    }

    static List<Integer> solution(List<Integer> list, int[] kArray) {

        Task3BinSearch task3BinSearch = new Task3BinSearch(list);
//надо обработать крайнее положение, когда весь лист меньше чем заданной kArray[i] , тогда добавлять +1 (или list.size)
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < kArray.length; i++) {
            if (list.get(list.size() - 1) < kArray[i]) {
                resList.add(list.size());
                continue;
            }
            int temp = task3BinSearch.search(kArray[i]);
            resList.add(temp);
        }

        return resList;
    }

    public int search(Comparable<T> v) {
        int low = 0;
        int high = a.size() - 1;
        int mid = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            T midVal = a.get(mid);
            int result = v.compareTo(midVal);

            if (result < 0) {
                high = mid - 1;
            } else if (result > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
// именно нижний, с мидовым иногда на 1 меньше получалось
        return low;
    }
}

//    public static void main(String[] args) {
//
//        Set<Integer> integers = new TreeSet<>();
//        integers.add(100);
//        integers.add(1);
//        integers.add(50);
//        integers.add(1);
//        System.out.println(integers);
//        List<Integer> list = new ArrayList<>(integers);
//        System.out.println(list);
//
//        List<Integer> array = List.of(1, 3, 5, 10, 12, 13);
////проверка, если есть число то включая, если нет то не включая
//        Task3BinSearch task3BinSearch = new Task3BinSearch(array);
//        Integer a = 4;
//        int res = task3BinSearch.search(a);
//        System.out.println(res);
//
//        System.out.println("now my");
//        int[] kArray = {1, 4, 10, 12, 13, 14, 15};
//
//        List<Integer> result = solution(array, kArray);
//        PrintWriter printWriter = new PrintWriter(System.out);
//        for (int i = 0; i < result.size(); i++) {
//            printWriter.println(result.get(i));
//        }
//        printWriter.flush();
//        printWriter.close();
//
//
//    }


