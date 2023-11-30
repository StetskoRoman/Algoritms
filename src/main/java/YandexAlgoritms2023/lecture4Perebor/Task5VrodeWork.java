package YandexAlgoritms2023.lecture4Perebor;

import java.io.PrintWriter;
import java.util.*;

public class Task5VrodeWork {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        char[] chars = new char[n];
        Deque<Character> deque = new ArrayDeque<>();
        LinkedHashSet<char[]> res = new LinkedHashSet<>();
//
        LinkedHashSet<char[]> answer = solution(chars, 0, n, deque, res);
//        ArrayList<char[]> answer = solution(chars, 0, n, deque, new ArrayList<>());

//        System.out.println("answer size = " + answer.size());

        PrintWriter printWriter = new PrintWriter(System.out);

//        for (int i = 0; i < answer.size(); i++) {
//            for (int j = 0; j < answer.get(i).length; j++) {
//                printWriter.print(answer.get(i)[j]);
//            }
//            printWriter.println();
//        }
        for (int i = 0; i < answer.size(); i++) {
            printWriter.println(Arrays.toString(answer.iterator().next()));
        }
        printWriter.flush();
    }

    static LinkedHashSet<char[]> solution(char[] chars, int pos, int n, Deque<Character> stack, LinkedHashSet<char[]> res) {

//        static ArrayList<char[]> solution(char[] chars, int pos, int n, Deque<Character> stack, ArrayList<char[]> res) {
        if (pos == n) {
            res.add(chars);
            return res;
        }

        for (int i = 0; i < 3; i++) {
            if (n - pos == stack.size()) {
//                System.out.println("here ");
                char ch = stack.pop();  //извлекаем 100%
                if (ch == '[') {
                    chars[pos] = ']';
                } else {
                    chars[pos] = ')';
                }
//                System.out.println("pos before " + pos + "   stack = " + stack + "   chars = " + Arrays.toString(chars));
                pos++;  //проверить будет ли pos мегяться тут
                solution(chars, pos, n, stack, res);
//                    а надо ли тут возвращаться? вроде да
                stack.push(ch);
                pos--;
//                System.out.println("pos after " + pos);

            }

//            тут вставляем ( или
            if (i == 0) {

                if (n - pos > stack.size()) {
                    char ch = '(';  //можем либо добавить либо убрать
                    chars[pos] = ch;
                    stack.push(ch);
                    pos++;
//                    System.out.println("pos before " + pos + "   stack = " + stack + "   chars = " + Arrays.toString(chars));
                    solution(chars, pos, n, stack, res);
                    stack.pop();
                    pos--;

                }
            }
// for [ ]
            if (i == 1) {
//                if (n - pos == stack.size()) {
//                    char ch = stack.pop();  //извлекаем 100%
//                    if (ch == '[') {
//                        chars[pos] = ']';
//                    } else {
//                        chars[pos] = ')';
//                    }
//                    System.out.println("IN  I == 1    pos before " + pos + "   stack = " + stack + "   chars = " + Arrays.toString(chars));
//                    pos++;  //проверить будет ли pos мегяться тут
//                    solution(chars, pos, n, stack, res);
//                    stack.push(ch);
//                    pos--;
//
//                }
                if (n - pos > stack.size()) {
                    char ch = '[';
                    chars[pos] = ch;
                    stack.push(ch);
//                    System.out.println("IN  I == 1    pos before " + pos + "   stack = " + stack + "   chars = " + Arrays.toString(chars));
                    pos++;
                    solution(chars, pos, n, stack, res);
                    stack.pop();
                    pos--;

                }
            }

            if (i == 2 && !stack.isEmpty()) {
//                limitInArray(chars, pos, n, stack);
                char ch = stack.pop();
                if (ch == '[') {
                    chars[pos] = ']';
                } else {
                    chars[pos] = ')';
                }
//                System.out.println("IN  I == 2    pos before " + pos + "   stack = " + stack + "   chars = " + Arrays.toString(chars));
                pos++;
                solution(chars, pos, n, stack, res);
                stack.push(ch);
                pos--;
            }
            if (pos == n - 1) {
//                System.out.println("time to add " + Arrays.toString(chars) + " sizeRes = " +  res.size());
                res.add(chars);

                System.out.println("final + " + Arrays.toString(res.iterator().next()));
                return res;
            }


        }
//        System.out.println("final visov  size= " + res.size());
        return res;
    }

}
