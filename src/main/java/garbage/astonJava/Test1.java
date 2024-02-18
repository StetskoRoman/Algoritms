package garbage.astonJava;

public class Test1 implements Runnable {
    String x,y;

    public static void main(String[] args) {
        Test1 run = new Test1();
        Thread obj1 = new Thread(run);
        Thread obj2 = new Thread(run);
        obj1.start();
        obj2.start();

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (this) {
                x = "hello";
                y = "java";
                System.out.println(x+" " + y + " ") ;
            }
        }
    }
}
