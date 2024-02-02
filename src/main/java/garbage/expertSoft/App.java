package garbage.expertSoft;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

//public class App {
//    public static volatile int value = 0;  // volatile не поможет в одновременном изменении переменной несколькими тредами
//
//    public static void main(String[] args) {
//        Runnable task = () -> {
//            for (int i = 0; i < 10000; i++) {
//                int oldValue = value;
//                int newValue = ++value;
//                if (oldValue + 1 != newValue) {
//                    throw new IllegalStateException(oldValue + " + 1 = " + newValue);
//                }
//            }
//        };
//        new Thread(task).start();
//        new Thread(task).start();
//        new Thread(task).start();
//    }
//}

public class App {
    public static int value = 0;
    public static AtomicInteger atomic = new AtomicInteger(0);  // как правильно атомарную переменную сделать

    String method() {
        try {
            throw new Exception();
        } catch (Exception e) {
            return "catch";
        }  finally {
            return "finally";
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        App app = new App();
        System.out.println(app.method());
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                value++;
                atomic.incrementAndGet();
            }
        };
        for (int i = 0; i < 3; i++) {
            new Thread(task).start();
        }
        Thread.sleep(300);
        System.out.println(value);  //значение будет меняться от раза к разу
        System.out.println(atomic.get());
    }


}
