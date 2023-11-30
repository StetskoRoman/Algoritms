package leetCodeWork.StartTasks;

import java.util.ArrayList;
import java.util.List;

public class HappyNumber {
    public static boolean isHappy(int n) {
        int count = 0;
        while (n != 1 && count<=100)  {

        List<Integer> list = new ArrayList<>();
        while (n > 0){
            list.add(n%10);
            n/=10;
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i)*list.get(i));
            sum += list.get(i);
            }
        n=sum;
            count++;
        }
        System.out.println("count " + count);

        if (n == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int x = 2056;

        System.out.println(isHappy(x));


    }
}
