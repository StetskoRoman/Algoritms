package TestingTasksFromInternet.anderson;

public class change {

    public static void main(String[] args) {

        String msg = "hello";
        change(msg);
        System.out.println(msg);

        msg = change(msg);
        System.out.println(msg);
    }

    public static String change(String msg) {

        msg = msg + " world";
        return " java";
    }
}
