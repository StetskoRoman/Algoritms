package fundamental.Mathem;

public class IntIntoDate {

    public static String intToDate(int num) {
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        int day = 0;
        while (num > 0) {
            if (num >= 3600) {
                num -= 3600;
                hours++;
                continue;
            }

            if (hours >= 24) {
                hours -= 24;
                day++;
                continue;
            }

            if (num >= 60) {
                num -= 60;
                minutes++;
                continue;
            }

            if (num < 60) {
                seconds = num;
                break;
            }

        }

        return (String)("days: "+ day + ", time is " + hours+":"+minutes+":"+seconds);
    }

    public static void main(String[] args) {
        System.out.println(intToDate(3500000));
    }
}
