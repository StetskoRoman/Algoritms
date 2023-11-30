package YandexAlgoritms2023.lecture2;

public class test {

    public static void main(String[] args) {

        System.out.println(" check " + (int)1/2);

//        char a = 'a';
//        System.out.println((int)a);
        int count = 1;
        for (int i = 0; i < 900011; i++) {
            if (i == count - 1) {

                count++;
            }

        }
        System.out.println(count);
    }
}
