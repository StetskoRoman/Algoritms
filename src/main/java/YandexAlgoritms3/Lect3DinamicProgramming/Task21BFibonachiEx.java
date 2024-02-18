package YandexAlgoritms3.Lect3DinamicProgramming;

import java.util.Scanner;

public class Task21BFibonachiEx {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();

        long res = solution(n);
        System.out.println(res);
    }

    static long solution(int n) {

        if (n < 4) {
            long[] db = new long[4];
            db[1] = 2;
            db[2] = 4;
            db[3] = 7;
            return db[n];

        } else {
            long[] db = new long[n + 1];
            db[1] = 2;
            db[2] = 4;
            db[3] = 7;

            for (int i = 4; i < db.length; i++) {
                db[i] = db[i - 3] + db[i - 2] + db[i - 1];
            }

            return db[n];
        }
    }
}
