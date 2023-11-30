package fundamental.Logic;

import java.util.ArrayList;
import java.util.List;

public class Up5Down3 {

    public static void main(String[] args) {

            int[] array = {4236, 7, 13};
            int sum = 0;
            int tempAdd = 0;
            int tenpAddSecond = 0;
            int lastSum = 0;
            int numAfterFinal = 0;

        for (int i = 0; i < array.length; i++) {
            String finalNumber = null;
                String n = Integer.toString(array[i]);
                char[] charArray = n.toCharArray();
                List<Integer> listArr = new ArrayList<Integer>();
                for (int j = 0; j < charArray.length; j++) {
                    int ch = Character.getNumericValue(charArray[j]);
                    listArr.add(ch);
                }
                for (int z = 0; z < listArr.size() - 1; z++){
                    finalNumber += String.valueOf(listArr.get(z));
                }
                finalNumber += 0;
            finalNumber = finalNumber.substring(4);
            numAfterFinal = Integer.parseInt(finalNumber);


                if (listArr.get(charArray.length - 1) / 5 >= 1) {
                    numAfterFinal += 10;
                }

                sum += numAfterFinal;

                System.out.println(tempAdd);
                System.out.println(tenpAddSecond);
                System.out.println(lastSum);
            }

        System.out.println("Sum = " + sum);
        System.out.println("1234567 " + 23%10);

        }
    }
