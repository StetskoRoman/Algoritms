package garbage.expertSoft;

public class testThread {

    private static int i = 0;

    public static void doSmth() {
        synchronized (testThread.class) {
            while (true) {
                System.out.println("count " + ++i);
            }
        }
    }

    public static void main(String[] args) {

        new Thread(testThread::doSmth).start();
        new Thread(testThread::doSmth).start();

    }
}
