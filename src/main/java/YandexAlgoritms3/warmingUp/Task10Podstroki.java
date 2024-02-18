package YandexAlgoritms3.warmingUp;
//есть слово, надо выписать все его подстроки и подсчитать количество каждой буквы из всех подстрок
// суть: abcd -  b последняя - 2 варианта,  b первая = 3 варианта, где внутри будет - каждая из подстрок где b последняя c той где b первая - 1(т.к не включая когда b одна)
//т.е. 2+ 2 + 1*(3-1) = 6

import java.io.PrintWriter;
import java.util.*;

public class Task10Podstroki {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = " " + scanner.nextLine();

        char[] chars = str.toCharArray();

        Map<Character, Long> res = resultInMap(chars);
        PrintWriter printWriter = new PrintWriter(System.out);

        for (Map.Entry<Character, Long> entry : res.entrySet()) {
            printWriter.println(entry.getKey() + ": " + entry.getValue());
        }
        printWriter.flush();
        printWriter.close();

    }

    static Map<Character, Long> resultInMap(char[] chars) {

        List<Pair> list = new ArrayList<>();
        for (int i = 1; i < chars.length; i++) {
            list.add(getPairLiteral(chars, i));
        }
        System.out.println(list);
        long sum = 0;
        Map<Character, Long> map = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).count;
            if (map.get(list.get(i).character) != null) {
                map.put(list.get(i).character, (map.get(list.get(i).character) + list.get(i).count));
            } else {
                map.put(list.get(i).character, list.get(i).count);
            }

        }
        System.out.println("sum = " + sum);
        System.out.println(map);

        return map;
    }

    static Pair getPairLiteral(char[] chars, int pos) {

        Long count = 0L;
        count = (long) (pos + ((chars.length - 1) - pos) + (pos - 1) * ((chars.length - 1) - pos));
        Pair pair = new Pair(chars[pos], count);

        return pair;
    }

    static class Pair {

        Character character;
        Long count;

        public Pair(Character character, Long count) {
            this.character = character;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "character=" + character +
                    ", count=" + count +
                    '}';
        }
    }
}
