package YandexAlgoritms2023.lecture4Perebor;

import java.util.ArrayList;
import java.util.List;

public class Task5Fake {

    public static void generateBracketSequences(int n) {
        List<String> result = new ArrayList<>();
        generateBracketSequences("", 0, 0, n, result);
        for (String sequence : result) {
            System.out.println(sequence);
        }
    }

    private static void generateBracketSequences(String current, int open, int close, int n, List<String> result) {
        // базовый случай: достигли нужной длины последовательности
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // рекурсивные вызовы: добавляем скобку на каждом шаге
        if (open < n) {
            generateBracketSequences(current + "(", open + 1, close, n, result);
        }
        if (close < open) {
            generateBracketSequences(current + ")", open, close + 1, n, result);
        }
        if (open < n) {
            generateBracketSequences(current + "[", open + 1, close, n, result);
        }
        if (close < open) {
            generateBracketSequences(current + "]", open, close + 1, n, result);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        generateBracketSequences(n);
    }
}
