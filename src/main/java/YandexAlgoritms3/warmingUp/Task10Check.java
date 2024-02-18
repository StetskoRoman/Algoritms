package YandexAlgoritms3.warmingUp;

public class Task10Check {

    public static void main(String[] args) {

        long a = 99999;
        System.out.println(countSum(a));
    }

    static long countSum(long a) {
        int n = 1;
        long sum = 0;
        while (n < a / 2) {
            sum += n * (a - n);
            n++;

        }
        sum *= 2;

        return sum;
    }
}
