package garbage.astonJava;

public class testString {
    static Boolean test;
    public static void main(String[] args) {


        if (test) {
            System.out.println(true);
        }

        String a = "asd";
        System.out.println(a);
        String b = "asd";
        System.out.println(b);
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}
