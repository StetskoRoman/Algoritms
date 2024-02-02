package garbage.expertSoft;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

class SomeThread extends Thread {

    public void run() {
        for (int i=0; i < 10; i++)
            System.out.println(i);

    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {
        SomeThread test = new SomeThread();
        test.start();
        test.join();  // wait for this thread to die, and then continue execution, without- 2 threads will work together

        SomeThread test2 = new SomeThread();
        test2.start();


    }
}



//class SomeThread extends Thread {
//    private static final CountDownLatch countDownLatch = new CountDownLatch(1);
//    public void run() {
//        try {
//            countDownLatch.await();
//            for (int i = 0; i < 10; i++) {
//                System.out.println(i);
//            }
//        } catch (InterruptedException ex) {
//            Logger.getLogger(TestString.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        SomeThread test = new SomeThread();
//        test.start();
//
//        SomeThread test2 = new SomeThread();
//        test2.start();
//        countDownLatch.countDown();
//    }
//}
