package YandexAlgoritms2023.warmingUp;

public class EvclidAlgoritm {

    public static void main(String[] args) {

        System.out.println(nokCounting(29, 13));

    }

    public static int nokCounting(int m, int n) {
        int big; int low;
        if (m > n) {
            big = m;
            low = n;
        } else {
            big = n;
            low = m;
        }

        int nok = 1;
        int remainder = -1;
        while (remainder != 0) {
            System.out.println("big = " + big);
            System.out.println("low = " + low);

            remainder = big % low;
            System.out.println("reminder = " + remainder);
            if (remainder == 0) {
                nok = low;
                return nok;
            } else {
                big = low;
                low = remainder;
            }
        }

        return 1;
    }
}
