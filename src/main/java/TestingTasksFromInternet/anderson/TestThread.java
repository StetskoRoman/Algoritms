package TestingTasksFromInternet.anderson;

import garbage.astonJava.Test;

public class TestThread extends Thread {

    TestThread() {
        System.out.println("my Thread");
    }

    public void run() {
        System.out.println(" bar");
    }

    public void run(String str) {
        System.out.println(" baz");
    }
}

class ThreadDemo {

    public static void main(String[] args) {
        new TestThread().start();


//        System.out.println("after");
//        Thread t = new TestThread() {
//            public void run() {
//                System.out.println(" foo");
//
//            }
//        };
//        t.start();
    }
}
