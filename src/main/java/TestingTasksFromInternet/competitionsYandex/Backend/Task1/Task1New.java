package TestingTasksFromInternet.competitionsYandex.Backend.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//faster and more memory  - 28 tests
public class Task1New {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String string1 = br.readLine();
        String string2 = br.readLine();
        br.close();

        String[] str1 = string1.split(" ");
        String[] str2 = string2.split(" ");
        int n = Integer.parseInt(str1[0]);
        int m = Integer.parseInt(str1[1]);
        int[] nums = new int[str2.length];

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(str2[i]);
            if (nums[i] != 0) {
                list.add(nums[i]);
            }
        }

        long result = solution(list);

        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.print(result);
        printWriter.flush();
    }

    public static Long solution(List<Integer> list) {

        Long sum = 0L;

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i) * list.get(i);

                if (i + 1 < list.size()) {

                    for (int j = i + 1; j <= i + list.get(i) ; j++) {
                        if (j == list.size()) {
                            break;
                        }
                            sum += list.get(j);

                    }
                }
            }

        return sum;
    }
}




//&& (j < list.size())