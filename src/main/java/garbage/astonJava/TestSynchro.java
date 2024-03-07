package garbage.astonJava;

import static java.lang.Thread.sleep;

public class TestSynchro implements Runnable {
    public TestSynchro() {
    }

    public synchronized void run() {
        System.out.println("CountCharsAgain start");
        try {
            wait(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }



    public static synchronized void main(String[] args) throws InterruptedException {

        TestSynchro runnableDemo = new TestSynchro();
        Thread thread = new Thread(runnableDemo);
        thread.start();
        System.out.println("after start before wait");
        thread.wait(2000);


    }

}

class B {

}
