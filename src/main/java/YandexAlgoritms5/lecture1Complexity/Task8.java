package YandexAlgoritms5.lecture1Complexity;

public class Task8 {

    public static void main(String[] args) {

        System.out.println(4 % 6);
//        0 5 4 3
        System.out.println(2 % 6);
        double alfa = Math.atan2(0, 10);
        System.out.println(alfa);
//        получаем радианы, если радианы по модулю равны то условие достигнуто
        double beta = Math.atan2(4, 3);
        System.out.println(beta);

        double A = (4.0 / 3.0) * Math.PI;
        double B = (2.0 / 3.0) * Math.PI;
        System.out.println("A = " + A + " b = " + B);
    }
}
