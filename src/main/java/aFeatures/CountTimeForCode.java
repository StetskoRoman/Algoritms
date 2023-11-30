package aFeatures;

public class CountTimeForCode {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("sout dur " + duration);
    }
}
