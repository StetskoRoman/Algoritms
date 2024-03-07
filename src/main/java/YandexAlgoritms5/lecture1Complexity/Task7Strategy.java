package YandexAlgoritms5.lecture1Complexity;
/**
 * Каждый солдат из вашей армии либо убивает одного из солдат вашего противника, либо наносит 1 очко урона казарме. Каждый солдат может выбрать своё действие. Когда казарма теряет все свои единицы здоровья, она разрушается.
 * Ваш противник атакует. Он убьет k ваших солдат, где k — количество оставшихся у противника солдат.
 * Если казармы еще не разрушены, ваш противник производит p новых солдат.
 * 250
 * 500
 * 187
 */

import java.util.*;

public class Task7Strategy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int soldiers = scanner.nextInt();
        int hp = scanner.nextInt();
        int p = scanner.nextInt();

        int res = giveResult(soldiers, hp, 0, p, 0);
        System.out.println(res);

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

    static int roundStart(int soldiers, int hp, int enemySoldiers, int p, int round, List<Integer> listRounds) {

        System.out.println("round = " + round + " soldiers = " + soldiers + "  hp = " + hp + "  enemy = " + enemySoldiers);
        if (soldiers > 0 && hp <= 0 && enemySoldiers <= 0) {
            listRounds.add(round);
            return round;
        }

        if (soldiers == enemySoldiers && hp >= soldiers) {
            listRounds.add(-1);
            return -1;
        }

        if (soldiers <= 0 && enemySoldiers > 0) {
            listRounds.add(-1);
            return -1;
        }

        int[] atkRound = atk(soldiers, hp, enemySoldiers);
        System.out.println(Arrays.toString(atkRound));
        if (atkRound[1] == 0) {
            roundStart(atkRound[0], atkRound[1], atkRound[2], p, round + 1, listRounds);
        } else
            roundStart(atkRound[0], atkRound[1], atkRound[2] + p, p, round + 1, listRounds);

//        if (atkRound[1] <= 0 && atkRound[2] <= 0) {
//            listRounds.add(round);
//            return round;
//        }
        return round;
    }

    public static int[] atk(int soldiers, int hp, int enemySoldiers) {
        int atkDamage = soldiers;
        int[] resultRound = new int[3];
        //if we can kill all enemies soldiers-have to do it
        if (enemySoldiers > 0 && soldiers > enemySoldiers) {
            int tempDamage = soldiers - hp;
            int intDoub = (((enemySoldiers - tempDamage) * 2) / 3);
            double doub = (((double) enemySoldiers - (double) tempDamage) * 2) / 3;
            int z = soldiers - (enemySoldiers - tempDamage);
//            System.out.println("tempDamage = " + tempDamage + "  doub = " + doub + "   indtDoub = " + intDoub + " z = " + z );


//            System.out.println("tempDamage = " + tempDamage);
//            if (soldiers >= hp && stoitKillBarak(soldiers, hp, enemySoldiers) == true) {
            if (soldiers >= hp) {
                int A = stoitKillBarak(soldiers, hp, enemySoldiers);
                int B = stoitKillBarakSecond(soldiers, hp, enemySoldiers);
                System.out.println("A = " + A + "  b = " + B);

//            if (soldiers >= hp && soldiers - (enemySoldiers - tempDamage) >= (((enemySoldiers - tempDamage) * 2) / 3) - 5) {

//            if (soldiers >= hp && soldiers - (enemySoldiers - tempDamage) >= (enemySoldiers - tempDamage)) {

                atkDamage -= hp;
                enemySoldiers -= tempDamage;
                atkDamage -= tempDamage;
                hp -= hp;
//                System.out.println("tempDam = " + tempDamage + "   atk damage = " + atkDamage +  "  enemy soldiers = " + enemySoldiers);
            } else {
                atkDamage -= enemySoldiers;
                enemySoldiers -= enemySoldiers;
            }

        }
//        System.out.println("1 atk damage = " + atkDamage + "   enemySold " + enemySoldiers + "  hp = " + hp);
        //always kill castle if we can
        if (hp <= atkDamage && hp > 0) {
//            System.out.println("here1  atk before " + atkDamage + "  hp = " + hp);
            atkDamage -= hp;
            hp -= hp;
        }

//        System.out.println("2 atk damage = " + atkDamage + "   enemySold " + enemySoldiers + "  hp = " + hp);

        if (atkDamage > 0) {
//            System.out.println("here 2");
            enemySoldiers -= atkDamage;
            atkDamage -= atkDamage;
        }
//        System.out.println("3 atk damage = " + atkDamage + "   enemySold " + enemySoldiers + "  hp = " + hp);

        if (enemySoldiers <= 0 && hp > 0) {
//            System.out.println("here 3");
            hp -= Math.abs(enemySoldiers);
        }
//        System.out.println("4 atk damage = " + atkDamage + "   enemySold " + enemySoldiers + "  hp = " + hp);

        if (enemySoldiers > 0) {
//            System.out.println("here 4");
            soldiers -= enemySoldiers;
        }
//        System.out.println("5 atk damage = " + atkDamage + "   enemySold " + enemySoldiers + "  hp = " + hp);

        resultRound[0] = soldiers;
        resultRound[1] = hp;
        if (enemySoldiers <= 0) {
            resultRound[2] = 0;
        } else
            resultRound[2] = enemySoldiers;
        return resultRound;
    }

    static int stoitKillBarak(int soldiers, int hp, int enemySoldiers) {

        int savedDamage = soldiers - hp;
        int count = 0;
        while (soldiers > 0 && enemySoldiers >= 0) {
            System.out.println("in while soldiers = " + soldiers + "   enemy = " + enemySoldiers);
            enemySoldiers -= savedDamage;
            soldiers -= enemySoldiers;
            savedDamage = soldiers;
            count++;

            if (soldiers > 0 && enemySoldiers <= 0) {
                return count;
            }
        }
        return Integer.MAX_VALUE;

//        return Integer.MAX_VALUE;
    }

    static int stoitKillBarakSecond(int soldiers, int hp, int enemySoldiers) {

        int savedDamage = soldiers - hp;
        int count = 0;
//        while (soldiers > 0 && enemySoldiers >= 0) {
        System.out.println("int while 2");
        if (soldiers - (enemySoldiers - savedDamage) > enemySoldiers - savedDamage) {
            enemySoldiers -= savedDamage;
            soldiers -= enemySoldiers;
            savedDamage = soldiers;
            count++;
        }
        while (soldiers > 0 && enemySoldiers >= 0) {
            enemySoldiers -= savedDamage;
            soldiers -= enemySoldiers;
            savedDamage = soldiers;
            count++;
            if (soldiers > 0 && enemySoldiers <= 0) {
                return count;
            }

        }
        return Integer.MAX_VALUE;
    }

}

//Поздравьте! Я решил G. Разрушить казарму! Всего лишь двое суток размышлений)
//Видел тут обсуждение с фибоначчи, но не понял о чем это, если кто-то может - объясните, я бы прочитал с удовольствием)
//Сам я только что решил бинпоиском, под спойлером опишу решение:
//Сначала бинпоиском нахожу такое Y, при котором я добиваю казарму и в последующих ходах точно добиваю армию противника. Это происходит за log(n)
//Далее  запускаю основной алгоритм и бью сначала армию противника, появляющуюся на каждом раунде, а на сдачу заезжаю по казарме. Как только хп казармы оказывается меньше найденного выше Y - можно атаковать казарму и добивать армию. По сути это просто происходит линейно.
//То есть общая сложноcm O(n)
