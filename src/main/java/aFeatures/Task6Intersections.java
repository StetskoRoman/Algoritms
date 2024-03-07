package aFeatures;

// Найти число непересекающихся отрезков, причем рабочим остаются те что были позже
//10
//4
//1 3
//4 5
//7 8
//4 6
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task6Intersections {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int m = 0;
        int n = 0;
        List<int[]> list = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String[] tokens = line.split(" ");

            if (countLine == 0) {
                m = Integer.parseInt(tokens[0]);
                countLine++;
                continue;
            }
            if (countLine == 1) {
                n = Integer.parseInt(tokens[0]);
                countLine++;
                continue;
            }
            if (countLine <= n + 2) {
                int[] toList = new int[3];
                for (int i = 0; i < 2; i++) {
                    toList[i] = Integer.parseInt(tokens[i]);
                }
                toList[2] = 1;
                list.add(toList);
                countLine++;

                if (countLine == n + 2) {
                    break;
                }
            }
        }

        bufferedReader.close();

        int res = solution(list);

        System.out.println(res);
    }

    static int solution(List<int[]> list) {

        for (int i = 0; i < list.size(); i++) {
            int j = 0;
            while (j < i) {
                if ((list.get(i)[0] <= list.get(j)[1] && list.get(i)[0] >= list.get(j)[0])
                        || (list.get(i)[1] >= list.get(j)[0] && list.get(i)[1] <= list.get(j)[1])
                        || (list.get(i)[0] <= list.get(j)[0] && list.get(i)[1] >= list.get(j)[1])) {

                    list.get(j)[2] = 0;
                }

                j++;
            }
        }
        int res = 0;
        for (int i = 0; i < list.size(); i++) {
            res += list.get(i)[2];
        }

        return res;
    }
}

//for (int i = 0; i < list.size(); i++) {
//        System.out.println(Arrays.toString(list.get(i)));
//        }
