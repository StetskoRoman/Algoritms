package YandexAlgoritms3.warmingUp;

// Найти макс число одинаковых букв идущих подряд, можно менять k букв

import java.util.*;

public class Task2Clear {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();

        char[] chars = s.toCharArray();
        System.out.println(k + "   " + s + "   chars =" + Arrays.toString(chars));

        System.out.println(findMaxLength(chars, 'a', k));

        int res = countBeauty(s, k);
        System.out.println(res);
    }

    static int countBeauty(String s, int k) {

        char[] chars = s.toCharArray();
        Set<Character> characters = new TreeSet<>();
        for (int i = 0; i < chars.length; i++) {
            characters.add(chars[i]);
        }
        System.out.println(characters);
        List<Integer> integerList = new ArrayList<>();
        for (Character character : characters) {
            integerList.add(findMaxLength(chars, character, k));
        }
        System.out.println(integerList);
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
//            System.out.println("in for cicle i = " + i + " right = " + right);
            if (right == chars.length) {
                break;
            }
            while (right < chars.length) {
                if (chars[right] == x) {
                    right++;
//                    дошли до конца
                    if (right == chars.length) {
                        max = right - left;
//                    System.out.println(max + "   left = " + left + "  right = " + right + "   k = " + haveChangings + "  " + max);
                        if (max > res) {
                            res = max;
                        }
                        break;
                    }

                    continue;
                }

                if (haveChangings > 0) {
//                    System.out.println(" k > 0 before " + haveChangings + "  right = " +right);
                    right++;
                    haveChangings--;
                    continue;

                } else {
                    max = right - left;
//                    System.out.println(max + "   left = " + left + "  right = " + right + "   k = " + haveChangings + "  " + chars[right]);
                    if (max > res) {
                        res = max;
                    }

                    if (chars[left] != x) {
                        haveChangings++;
                    }
                    left++;
//                    System.out.println("in the end   k = " + haveChangings + "  left = " + left);
                    break;
                }

            }
        }
        return res;
    }
}
