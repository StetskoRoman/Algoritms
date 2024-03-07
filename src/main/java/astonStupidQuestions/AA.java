package astonStupidQuestions;

import java.util.Objects;

public class AA {

    private int a;
    private int b;

    public AA(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "AA{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getA(), getB());
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
