package YandexAlgoritms3.warmingUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// A -> B -> C    А клиентское время в начале запроса   время B на сервере когда сигнал получен,   C время клиентское когда ответ получен
// Клиент установить серверное время должен в момент С, учитывая что AB=BC
public class Task7SNTP {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        List<int[]> list = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String[] tokens = line.split(":");

            if (countLine < 3) {

                int[] time = new int[3];
                for (int i = 0; i < 3; i++) {
                    time[i] = Integer.parseInt(tokens[i]);
                }
                list.add(time);
                countLine++;
                if (countLine == 3) {
                    break;
                }
            }
        }
        bufferedReader.close();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i)));
        }

        int absA = timeToAbsSec(list.get(0));
        int absB = timeToAbsSec(list.get(1));
        int absC = timeToAbsSec(list.get(2));

        if (absC < absA) {
            absC += 24 * 3600;
        }

        System.out.println(absA +  "   " + absC);
        double delta = ((double) absC -(double) absA) / 2;
        System.out.println(delta);
        int addTime = (int) Math.round(delta);
        System.out.println("added time  " + addTime);

        int resultAbs = absB + addTime;


        int[] res = absTimeToTime(resultAbs);
        System.out.println("res abs = " + resultAbs + "   res = " + Arrays.toString(res));
        String[] strRes = new String[3];
        for (int i = 0; i < strRes.length; i++) {
            if (res[i] < 10) {
                strRes[i] = String.valueOf("0" + res[i]);
            } else {
                strRes[i] = String.valueOf(res[i]);
            }
        }
        System.out.println(res[0] + ":" + res[1] + ":" + res[2]);
        System.out.println(strRes[0] + ":" + strRes[1] + ":" + strRes[2]);
    }

    static int timeToAbsSec(int[] time) {

        int absTime = 0;
        absTime = time[0] * 60 * 60 + time[1] * 60 + time[2];
        return absTime;
    }

    static int[] absTimeToTime(int absTime) {

        int hour = absTime / 3600;
        int ostHours = 0;
        if (hour >= 24) {
            ostHours = (hour / 24);
            hour = hour % 24;

            System.out.println("int if, hour= " + hour + "   osthour = " + ostHours);
        }
        int minutes = (absTime % 3600) / 60;
        int sec = absTime - ((ostHours * 24 * 3600) + (hour * 3600)) - minutes * 60;
        int[] time = new int[3];
        time[0] = hour;
        time[1] = minutes;
        time[2] = sec;
        System.out.println(Arrays.toString(time));
        return time;
    }
}
