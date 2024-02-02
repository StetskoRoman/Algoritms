package garbage.expertSoft;

public class testMethodValue {

    public int shift(int value, int offset) {
        value += offset;
        return value;
    }

    public static void main(String[] args) {
        testMethodValue m = new testMethodValue();
        int v = 2;
        m.shift(v, 5);
        System.out.println(v);
    }
}
