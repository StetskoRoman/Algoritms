package fundamental.Recursion;

public class Factorial {
    public static int factorial(int n) {
        int res = n;
        for (int i = n-1; i > 0; i--) {
            res = res*(n-i);
        }
        return res;
    }
    //способ рекурсивный
    public int Recfactorial(int n) {
        int result = 1;
        if (n == 1 || n == 0) {
            return result;
        }
        result = n * Recfactorial(n-1);
        return result;
    }


    public static void main(String[] args) {
        int m=5;

        System.out.println(factorial(25));
    }
}
