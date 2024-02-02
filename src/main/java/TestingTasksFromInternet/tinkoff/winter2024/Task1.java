package TestingTasksFromInternet.tinkoff.winter2024;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
        System.out.println(solution(str));

    }

    static StringBuilder solution(String str) {
        char[] chars = str.toCharArray();
        StringBuilder res = new StringBuilder();
        int current = 0;
        while (current < str.length()) {
            if (chars[current] == 'c' && current +4 < str.length()) {
                if (str.substring(current, (current +4)).equals("code") && Character.isDigit(chars[current +4])) {

                    current += 5;
                    while (current <str.length() && Character.isDigit(chars[current])) {
                        current++;
                    }
                    res.append("???");
                } else {
                    res.append(chars[current]);
                    current++;
                }
            } else {
                res.append(chars[current]);
                current++;
            }
        }

        return res;
    }
}
