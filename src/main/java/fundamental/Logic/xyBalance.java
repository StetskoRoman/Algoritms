package fundamental.Logic;

public class xyBalance {
    public static void main(String[] args) {
        String str = "aabxxy";
        char tempForX;
        int position = 0;
        char tempForY;
        int positionY = 0;
        char [] strChar = str.toCharArray();
        for (int i = 0; i < strChar.length; i++) {
            if (strChar[i] == 'x'){
                tempForX = strChar[i];
                position = i;
            }
            if (strChar[i] == 'y') {
                tempForY = strChar[i];
                positionY = i;

            }
        }
        if (positionY > position) {

        }
    }
}
