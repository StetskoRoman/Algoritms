package astonStupidQuestions;

abstract class My {
    public void mymethod() {
        System.out.print("Abstract");
    }
}

class Poly {
    public static void main(String a[]) {
        My m = new My() {};
        m.mymethod();

        Inter<String, String> stringStringInter;
        Inter<Integer, Integer> interInter = new Inter<Integer, Integer>() {
            @Override
            public Integer convert(Integer inter, Integer inter2) {
                return inter+inter2;
            }
        };
        int integer = 10;
        interInter.writeToConsole(integer);



        System.out.println(interInter.convert(3, 5));
    }
}
