package YandexAlgoritms2023.lecture4Perebor;

public class test4 {

    public static void main(String[] args) {

        int[] mat = {4, 7, 1, 2, 6, 10};

        int res = recursiveSum(mat, 0, 0);
        System.out.println("final res " + res);
    }

//    по итогу вернет самый первый элемент
//    public static int recursiveSum(int[] mat, int current, int sum) {
//
//        if (current == mat.length) {
//            return sum;
//        }
//        System.out.println("before sum = " + sum);
//
//        sum += mat[current];
//
//        System.out.println("after sum = " + sum);
//        recursiveSum(mat, current + 1, sum);
//
//        return sum;
//    }

//        по итогу вернет самый первый элемент
    public static int recursiveSum(int[] mat, int current, int sum) {

        if (current == mat.length) {
            return sum;
        }
        System.out.println("before sum = " + sum);

        sum += mat[current];

        System.out.println("after sum = " + sum);
        recursiveSum(mat, current + 1, sum);

        return sum;
    }


//    вернет сумму конечную реальную
//    public static int recursiveSum(int[] mat, int current, int sum) {
//
//        if (current == mat.length) {
//            return sum;
//        }
//        System.out.println("before sum = " + sum);
//
//        sum += mat[current];
//
//        System.out.println("after sum = " + sum);
//
//        return recursiveSum(mat, current + 1, sum);
//    }
}
