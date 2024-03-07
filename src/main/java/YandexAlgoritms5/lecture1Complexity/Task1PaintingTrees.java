package YandexAlgoritms5.lecture1Complexity;
//0 7
//12 5     25
// посчитать общее число в последовательности [-7,7] [4,16] и + 1 добавить


import java.util.Scanner;

public class Task1PaintingTrees {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        int v = scanner.nextInt();
        int q = scanner.nextInt();
        int m = scanner.nextInt();

        System.out.println(countIntersection(p, v, q, m));

    }

    public static int countIntersection(int p, int v, int q, int m) {
        int[] V = new int[2];
        int[] Q = new int[2];
        int result;
        if (p - v <= q - m) {
            V[0] = p - v;
            V[1] = p + v;
            Q[0] = q - m;
            Q[1] = q + m;
        } else {
            V[0] = q - m;
            V[1] = q + m;
            Q[0] = p - v;
            Q[1] = p + v;
        }
        boolean intersection = false;
        int[] res = new int[2];
        if (V[1] >= Q[0]) {
            res[1] = Math.max(V[1], Q[1]);
            intersection = true;
        }
        if (Q[0] <= V[1]) {
            res[0] = V[0];
            intersection = true;
        }
//        System.out.println(intersection);
//        System.out.println(dist(res) + " q[1] = " + Q[1] + "");
        if (intersection == true) {
            if (v == 0 || m == 0) {
                if (v == 0 && m == 0) {
                    return 1;
                }

                result = result = dist(res);
                return result;
            }
            result = dist(res) + 1;
         } else {
            result = dist(V) + dist(Q) + 2;

        }
        return result;
    }

    static int dist(int[] pair) {
        int res;
        if (pair[1] > 0 && pair[0] < 0 || pair[1] > 0 && pair[0] > 0) {
            return res = pair[1] - pair[0];
        } else {
            return res = Math.abs(pair[1] - pair[0]);
        }
    }
}
