package YandexAlgoritms2023.warmingUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Task9Check {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str = bufferedReader.readLine();
        bufferedReader.close();

        boolean result = areBalanced(str);
        if (result) {
            System.out.println("yes");
        } else System.out.println("no");
    }


//    как бы добавляет с конца скобки в очередь
    static boolean areBalanced(String s) {
        final var stack = new LinkedList<Character>();
        final var n = s.length();
        for (var i = 0; i < n; i++) {
            System.out.println(stack);
            final var ch = s.charAt(i);
            switch (ch) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case ')':
                case ']':
                case '}':

                    if (stack.isEmpty()) {
                        return false;
                    }
//                   берет новую закрывающую скобку и смотрит, совпадает ли она с последней в очереди(то есть недавней), если нет - последовательность нарушена
                    final char top = stack.poll();
                    if (top != ch) {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }
}

