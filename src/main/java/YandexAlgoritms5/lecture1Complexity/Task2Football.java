package YandexAlgoritms5.lecture1Complexity;

/**
 * Посчитать сколько голов забить осталось первой команде для победы
 * 0:2
 * 0:3
 * 1 - значит в первом матче 1-ая команда дома играла (если 2 - то в гостях)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2Football {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int a = 0;
        int b = 0;
        int A = 0;
        int B = 0;
        int field = 0;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String[] tokens = line.split("[:\\s]");

            if (countLine == 0) {
                a = Integer.parseInt(tokens[0]);
                b = Integer.parseInt(tokens[1]);
                countLine++;
                continue;
            }
            if (countLine == 1) {
                A = Integer.parseInt(tokens[0]);
                B = Integer.parseInt(tokens[1]);
                countLine++;
                continue;
            }
            field = Integer.parseInt(tokens[0]);
            break;

        }
        bufferedReader.close();
//        System.out.println(a + "  " + b + "  guest = " + field);

        System.out.println(countGoalsNeed(a, b, A, B, field));

    }

    public static int countGoalsNeed(int a, int b, int A, int B, int field) {

        int delta = 0;
        int goalInGuestsA = 0;
        int goalInGuestsB = 0;
        if (field == 1) {
            goalInGuestsA = A;
            goalInGuestsB = b;
        } else {
            goalInGuestsA = a;
            goalInGuestsB = B;
        }

        delta = (a - b) + (A - B);

        if (delta > 0) {
            return 0;
        }

        if (delta == 0 && goalInGuestsA > goalInGuestsB) {
            return 0;
        }

        if (delta == 0 && goalInGuestsA < goalInGuestsB) {
            return 1;
        }

        if (delta < 0 && a - b > 0) {
            // см тест 51 и random2
            if (goalInGuestsA > goalInGuestsB && goalInGuestsB>A) {
                return Math.abs(delta);
            }
            return Math.abs(delta) + 1;
        }

        if (delta < 0 && field == 1) {
            return Math.abs(delta);
        } else return Math.abs(delta) + 1;

    }
}

//    public static int countGoalsNeed(int a, int b, int A, int B, int field) {
//        int res = 0;
//
//        int deltaab = a - b;
//        int deltaAB = A - B;
////        System.out.println(deltaab + "   " + deltaAB);
//        if (deltaab == 0 && deltaAB == 0 && field == ) {
//            return 1;
//        }
//        if (deltaab + deltaAB > 0) {
//            return 0;
//        }
//
//
//        if (deltaab == 0 && field == 1) {
//            res = Math.abs(deltaAB) + 1;
//            return res;
//        }
//        if (deltaab == 0 && field == 2) {
//            System.out.println("here I am");
//            res = Math.abs(deltaAB);
//            return res;
//        }
//
//        if (field == 1) {
//            res = Math.abs(deltaab + deltaAB);
//            return res;
//        }
//        if (field == 2) {
//            res = Math.abs(deltaab + deltaAB) + 1;
//            return res;
//        }
//
//        if (deltaAB == 0) {
//
//        }
//
//        return 0;
//    }

