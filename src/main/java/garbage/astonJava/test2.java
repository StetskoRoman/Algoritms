package garbage.astonJava;

public class test2 extends Thread {

    test2() {
    }

    test2(Runnable runnable) {
        super(runnable);
    }

    public void run() {
        System.out.println("Inside Thread");
    }


}

class RunnableDemo implements Runnable {

    public void run() {
        System.out.println("Inside Runnable");

    }

}

class ThreadDemo {
    public static void main(String[] args) {
        new test2().start();
        new test2(new RunnableDemo()).start();

        RunnableDemo runnableDemo = new RunnableDemo();
        Thread thread = new Thread(runnableDemo);
        thread.start();
    }
}
