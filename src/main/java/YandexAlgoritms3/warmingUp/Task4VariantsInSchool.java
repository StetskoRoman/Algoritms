package YandexAlgoritms3.warmingUp;


//петя вася на на один вариант попасть хотят , надо выбрать куда садится чтоб получить один вариант спереди или сзади

import java.util.Arrays;
import java.util.Scanner;

public class Task4VariantsInSchool {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int r = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.close();

        int[] res = findAbsolutePlaceVas(n, k, r, m);
        if (res[0] == -1) {
            System.out.println("-1");
        } else {
            System.out.println(res[0] + " " + res[1]);

        }

    }

    static int[] findAbsolutePlaceVas(int n, int k, int r, int m ) {

        int absPet = translateRelativeToAbsolutePlace(r, m);

        int absVasBehind = -1;
        int absVasBefore = -1;
        if (absPet + k < n) {
            absVasBehind = absPet + k;
        }
        if (absPet - k >= 0) {
            absVasBefore = absPet - k;
        }

        int[] placeBefore = new int[2];
        if (absVasBefore != -1) {
            placeBefore = translateAbsToPlace(absVasBefore);
            if (absVasBehind == -1) {
                return placeBefore;
            }
        }

        int[] placeBehind = new int[2];
        if (absVasBehind != -1) {
            placeBehind = translateAbsToPlace(absVasBehind);
            if (absVasBefore == -1) {
                return placeBehind;
            }
        }

        int[] res = new int[2];
        if (absVasBehind != -1 && absVasBefore != -1 && (r - placeBefore[0] < placeBehind[0] - r)) {
            res = placeBefore;
            return res;
        }
        if (absVasBehind != -1 && absVasBefore != -1) {
            return placeBehind;
        }

        return new int[]{-1, -1};

    }

    static int[] translateAbsToPlace(int absPlace) {

        int r = (absPlace / 2) + 1;
        int m = 0;
        if (absPlace % 2 == 0) {
            m = 1;
        }
        if (absPlace % 2 == 1) {
            m = 2;
        }
        int[] res = new int[2];
        res[0] = r;
        res[1] = m;
        return res;
    }

    static int translateRelativeToAbsolutePlace(int r, int m) {

        int abs = 2 * (r - 1) + (m - 1);
        return abs;
    }
}


//    int[] translatedPlaces = fillPlaces(n);
//
//
//    int a = 4;
//        System.out.println(a / 2);
//                System.out.println(a % 2);
//                System.out.println(Arrays.toString(translateAbsToPlace(a)));
//                System.out.println(translateRelativeToAbsolutePlace(r, m));
