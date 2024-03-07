package astonStupidQuestions;

import java.util.HashSet;
import java.util.Set;
// ответ на вопрос как в один баке в сете запихать все числа - не переопределять equals
public class CheckHashSet {

    public static void main(String[] args) {

        Set<AA> set = new HashSet<>();
        int n = 1000;
        for (int i = 0; i < n; i++) {
            set.add(new AA(2, 2));
        }
        System.out.println(set);

    }
}
