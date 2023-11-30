package YandexAlgoritms2023.lecture4Perebor;

import java.io.PrintWriter;
import java.util.*;

public class Task5_2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        char[] chars = new char[n];
        Deque<Character> deque = new ArrayDeque<>();
        ArrayList<char[]> res = new ArrayList<>();

        ArrayList<char[]> answer = solution(chars, 0, n, deque, res);

        PrintWriter printWriter = new PrintWriter(System.out);
        for (int i = 0; i < answer.size(); i++) {
            for (int j = 0; j < answer.get(i).length; j++) {
                printWriter.print(answer.get(i)[j]);
            }
            printWriter.println();
        }
        printWriter.flush();
    }

    static ArrayList<char[]> solution(char[] chars, int pos, int n, Deque<Character> stack, ArrayList<char[]> res) {

        if (pos == n) {
            res.add(chars);
            return res;
        }
        boolean goRecursion = false;
        boolean flag = false;
        char ch = 0;
        for (int i = 0; i < 3; i++) {
            int k = stack.size();

            if (n - pos <= k) {
                goRecursion = true;
                ch = stack.pop();  //извлекаем 100%
                System.out.println("here извлекаем ch= " + ch);
                if (ch == '[') {
                    chars[pos] = ']';
                }
                if (ch == '(') {
                    chars[pos] = ')';
                }
                flag = true;
                System.out.println("pos before " + pos + "   stack = " + stack + "  ch = " + ch);
                pos++;  //проверить будет ли pos мегяться тут
//                    solution(chars, pos, n, stack, res);
////                    а надо ли тут возвращаться? вроде да
//                    stack.push(ch);
//                    pos--;
                System.out.println("pos after " + pos);
            }

//            тут вставляем ( или
            if (i == 0) {

                if (n - pos > k) {
                    goRecursion = true;
                    ch = '(';  //можем либо добавить либо убрать
                    chars[pos] = ch;
                    stack.push(ch);
                    pos++;
                    System.out.println("chars  () " + Arrays.toString(chars) + " ch = " + ch + "  stack = " + stack);
//                    solution(chars, pos, n, stack, res);
//                    stack.pop();
//                    pos--;


                }
            }
// for [ ]
            if (i == 1) {
//                if (n - pos == stack.size()) {
//                    ch = stack.pop();  //извлекаем 100%
//                    if (ch == '[') {
//                        chars[pos] = ']';
//                    } else {
//                        chars[pos] = ')';
//                    }
//                    pos++;  //проверить будет ли pos мегяться тут
//                    solution(chars, pos, n, stack, res);
//                    stack.push(ch);
//                    pos--;


//                if (n - pos > stack.size()) {
//                    ch = '(';  //можем либо добавить либо убрать
//                    chars[pos] = ch;
//                    stack.push(ch);
//                    flag = true;
//                    pos++;
//                    System.out.println("chars  () " + Arrays.toString(chars));
////                    solution(chars, pos, n, stack, res);
////                    stack.pop();
////                    pos--;
//                    System.out.println("chars  = " + Arrays.toString(chars));
//
//                }
                if ((n - pos) > k) {
                    goRecursion = true;
                    ch = '[';
                    chars[pos] = ch;
                    stack.push(ch);
                    System.out.println("IN I = 1  ch = " + ch + "  chars = " + Arrays.toString(chars) + "   n = " + n + "  pos = " + pos + "  stacksize = " + stack.size() + " k = " + k);
                    pos++;
//                    solution(chars, pos, n, stack, res);
//                    stack.pop();
//                    pos--;

                }
            }


            if (i == 2 && !stack.isEmpty()) {
//                limitInArray(chars, pos, n, stack);
                goRecursion = true;
                ch = stack.pop();
                System.out.println("В удаляющем I==2  ch = " + ch);
                if (ch == '[') {
                    chars[pos] = ']';
                }
                if (ch == '(') {
                    chars[pos] = ')';
                }
                pos++;
                flag = true;
//                solution(chars, pos, n, stack, res);
//                stack.push(ch);
//                pos--;
            }

            if (pos == n) {
                System.out.println(" Добавляю финальные  " + Arrays.toString(chars));
                res.add(chars);
                for (int z = 0; z < res.size(); z++) {
                    System.out.println("ВЫВОЖУ RES " + Arrays.toString(res.get(z)));
                }
                return res;

            }


            System.out.println("coming in recursion  false  + pos = " + pos + " stack = " + stack + "  length stack = " + stack.size() + "    Arrays = " + Arrays.toString(chars));
//                solution(chars, pos, n, stack, res);

            if (goRecursion == true) {
                System.out.println("In recursion true + pos = " + pos + " stack = " + stack + "  length stack = " + stack.size() + "    Arrays = " + Arrays.toString(chars) + "   will try push  ch = " + ch);
                solution(chars, pos, n, stack, res);
                if (flag == true) {
                    pos--;
                    chars[pos] = ch;
//                if (ch ==)
                    stack.push(ch);
                }
                if (flag == false) {
                    pos--;
                    chars[pos] = ch;
                    System.out.println("INside flag  stack = " + stack);

                    stack.pop();

                }
            }

        }

        return res;
    }

}
