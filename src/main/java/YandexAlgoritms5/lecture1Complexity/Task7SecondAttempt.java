package YandexAlgoritms5.lecture1Complexity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task7SecondAttempt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int soldiers = scanner.nextInt();
        int hp = scanner.nextInt();
        int p = scanner.nextInt();

        firstRound(soldiers, hp, p);

    }

    static int giveResult(int soldiers, int hp, int enemySoldiers, int p, int round) {

        List<Integer> list = new ArrayList<>();
        int res = roundStart(soldiers, hp, 0, p, 0, list);
        if (list.contains(-1)) {
            return -1;
        }
        int sumRound = Collections.max(list);
        return sumRound;
    }

    static int[] firstRound (int soldiers, int hp, int p) {
        int[] startParams = new int[4];

        hp -= soldiers;
        if (hp > 0) {

            int enemySoldiers = p;
            int days = 0;
            int damage = soldiers - p;
            if (damage > 0) {

                days = (hp - soldiers) / damage;

            }


            hp = hp -  (days * damage);
            System.out.println("hp = " + hp + "  days = " + days + "  ");
        }


        return null;



    }

    static int roundStart(int soldiers, int hp, int enemySoldiers, int p, int round, List<Integer> listRounds) {

        return 0;
    }
}
