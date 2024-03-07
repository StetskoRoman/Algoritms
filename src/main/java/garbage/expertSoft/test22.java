package garbage.expertSoft;

class A {
    static {
        System.out.println("static-CountCharsAgain, ");
    }

//    без скобок ошибка, получается как будто метод отдельный без названия и вообще без ничего
    {
        System.out.println("init-CountCharsAgain, ");
    }

    public A() {
        System.out.println("constructor-CountCharsAgain, ");
    }
}

class B extends A {

    static {
        System.out.println("static-B, ");
    }

    {
        System.out.println("init-B, ");
    }

    public B() {
        System.out.println("constructor-B, ");
    }
}

public class test22 {

    public static void main(String[] args) {
        new B();
    }
}
