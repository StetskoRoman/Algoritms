package YandexAlgoritms3.warmingUp;
//Вам необходимо ответить на запросы узнать сумму всех элементов числовой матрицы N×M в прямоугольнике с левым верхним углом (x1, y1) и правым нижним (x2, y2)
// префиксные суммы посчитать, а потом их аккуратно повычитать оставляя заданное пространство

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Task9FixSomething {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int k = 0;
        int n = 0;
        int m = 0;
        List<int[]> list = new ArrayList<>();
        List<int[]> limitList = new ArrayList<>();
        String absPath = "S:\\Program\\Projects\\Proj On work\\Tasks\\src\\main\\java\\YandexAlgoritms3\\warmingUp\\05 (2)";
//        String absPath = "S:\\Program\\Projects\\Proj On work\\Tasks\\src\\05 (2)";
        BufferedReader bufferedReader = Files.newBufferedReader(Path.of(absPath), StandardCharsets.UTF_8);
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(absPath));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String[] tokens = line.split(" ");

            if (countLine == 0) {
                n = Integer.parseInt(tokens[0]);
                m = Integer.parseInt(tokens[1]);
                k = Integer.parseInt(tokens[2]);
                list.add(new int[m + 1]);
                countLine++;
                continue;
            }

            if (countLine < n + 1) {

                int[] nums = new int[m + 1];
                for (int i = 0; i < tokens.length; i++) {
                    nums[i + 1] = Integer.parseInt(tokens[i]);
                }
                list.add(nums);
                countLine++;
                continue;
            }

            if (countLine < k + n + 1) {

                int[] nums = new int[4];
                for (int i = 0; i < tokens.length; i++) {
                    nums[i] = Integer.parseInt(tokens[i]);
                }
                limitList.add(nums);
                countLine++;
                if (countLine == n + k + 1) {
                    break;
                }
            }
        }
        bufferedReader.close();


        int[][] prefixMatrix = getPrefixMatrix(list);
        List<Integer> result = resultSolution(prefixMatrix, limitList);
        PrintWriter printWriter = new PrintWriter(System.out);
        for (Integer integer : result) {
            printWriter.println(integer);
        }
        printWriter.flush();
        printWriter.close();

    }

    static List<Integer> resultSolution(int[][] prefixMatrix, List<int[]> limitList) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < limitList.size(); i++) {
            list.add(getSumOfSquare(prefixMatrix, limitList.get(i)));
        }

        return list;
    }

    static int getSumOfSquare(int[][] prefixMatrix, int[] limits) {

        int sum = 0;

        sum = prefixMatrix[limits[2]][limits[3]] - prefixMatrix[limits[0] - 1][limits[3]] - prefixMatrix[limits[2]][limits[1] - 1] + prefixMatrix[limits[0] - 1][limits[1] - 1];

        return sum;
    }

    static int[][] getPrefixMatrix(List<int[]> list) {
        int n = list.size();
        int m = list.get(0).length;

        int[][] prefixMatrix = new int[n][m];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                prefixMatrix[i][j] = prefixMatrix[i - 1][j - 1] + sumStolb(list, i, j) + sumArray(list, i, j) - list.get(i)[j];
            }
        }


        return prefixMatrix;
    }

    static int sumStolb(List<int[]> list, int array, int stolb) {
        int i = 0;
        int sum = 0;

        while (i <= array) {
            sum += list.get(i)[stolb];
            i++;
        }
        return sum;
    }

    static int sumArray(List<int[]> list, int array, int stolb) {
        int j = 0;
        int sum = 0;

        while (j <= stolb) {
            sum += list.get(array)[j];
            j++;
        }
        return sum;
    }
}

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(Arrays.toString(list.get(i)));
//        }
//
//        for (int i = 0; i < limitList.size(); i++) {
//            System.out.println(Arrays.toString(limitList.get(i)));
//        }
//        sumStolb(list, 1, 2);
//        sumArray(list, 0, 2);
