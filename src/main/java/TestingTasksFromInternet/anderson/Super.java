package TestingTasksFromInternet.anderson;

import garbage.astonJava.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Super implements Runnable {

    public static void main(String[] args) {

        new Super().run();

        new Thread(new Super()).start();






        List<? super Number> list = new ArrayList<>();

        List<? super Number> listObj = new ArrayList<Object>();
//        List<? super Number> listDouble = new ArrayList<Double>();  // - ошибка

    }

    @Override
    public void run() {
        System.out.println("sumething");

    }
}
