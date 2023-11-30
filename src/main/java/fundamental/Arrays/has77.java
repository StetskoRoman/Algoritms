package fundamental.Arrays;

public class has77 {
    public static void main(String[] args) {
        int[] array = {1, 7, 1, 1, 7}; //1, 7, 1, 1, 7
        boolean are = false;
        for (int i = 2; i < array.length; i++) {
            if ((array[i - 2] == 7 && array [i] == 7) || (array[i-1] == 7 && array [i] == 7) || (array[i-2] == 7 && array[i-1] == 7)){
                are = true;
            }
        }
        System.out.println("asdf " + are);
    }
}
