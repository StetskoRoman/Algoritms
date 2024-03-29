package YandexAlgoritms3.warmingUp;

// Найти макс число одинаковых букв идущих подряд, можно менять k букв

import java.lang.reflect.Array;
import java.util.*;

public class Task2BeautyString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();

        int res = countBeauty(s, k);
        System.out.println(res);
    }

    static int countBeauty(String s, int k) {

        char[] chars = s.toCharArray();
        Set<Character> characters = new TreeSet<>();
        for (int i = 0; i < chars.length; i++) {
            characters.add(chars[i]);
        }

        List<Integer> integerList = new ArrayList<>();
        for (Character character : characters) {
            integerList.add(findMaxLength(chars, character, k));
        }
        int res = Collections.max(integerList);

        return res;
    }

    static int findMaxLength(char[] chars, char x, int k) {

        int left = 0;
        int right = 0;
        int max = 0;
        int res = 0;
        int haveChangings = k;

        for (int i = left; i < chars.length; i++) {

            if (right == chars.length) {
                break;
            }
            while (right < chars.length) {
                if (chars[right] == x) {
                    right++;
//                    Была здесь проблема, надо решить было что делать когда правого конца достигает
                    if (right == chars.length) {
                        max = right - left;
                        if (max > res) {
                            res = max;
                        }
                        break;
                    }

                    continue;
                }

                if (haveChangings > 0) {
                    right++;
                    haveChangings--;

                } else {
                    max = right - left;
                    if (max > res) {
                        res = max;
                    }

                    if (chars[left] != x) {
                        haveChangings++;
                    }
                    left++;
                    break;
                }

            }
        }
        return res;
    }
}
