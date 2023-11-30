package TestingTasksFromInternet.yandex.inputOutput;

import java.util.Arrays;

public class CheckMatrix {

    public static void main(String[] args) {

        System.out.println("% " + 1%2);

        int[] array = new int[0];
        System.out.println(array.length);
        int k = 0;
        for (int i = 0; i < 10; i++) {
            k += i;
            if (k >= 7) {
                array = new int[k];
                break;
            }
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }


        System.out.println(array.length);
        System.out.println(Arrays.toString(array));

    }
}
