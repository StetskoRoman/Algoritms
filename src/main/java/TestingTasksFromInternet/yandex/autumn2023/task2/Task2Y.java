package TestingTasksFromInternet.yandex.autumn2023.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Так работает но ввод надо вручную прописывать хз как сделать
public class Task2Y {

    public static void main(String[] args) throws IOException {

        long startTime = System.nanoTime();

        Scanner scanner = new Scanner(System.in);
        int An = scanner.nextInt();
        int Bn = scanner.nextInt();
        int q = scanner.nextInt();

        List<String> A = new ArrayList<>();
        List<String> B = new ArrayList<>();
        for (int i = 0; i < An; i++) {
            A.add(scanner.next());
        }
        for (int i = 0; i < Bn; i++) {
            B.add(scanner.next());
        }


        System.out.println(A);
        System.out.println(B);
        System.out.println(q);

//        List<List<String>> term = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in)) {
            String line;
            int countQ = 1;
            while ((line = buffer.readLine()) != null && countQ < q) {
                String[] tokens = line.split(" ");
                System.out.println("count Q " + countQ);
                if (tokens.length > 1) {
                    System.out.println("im here");

                    int type = Integer.parseInt(tokens[0]);
                    char player = tokens[1].charAt(0);
                    String card = tokens[2];
                    changingOfCollection(type, player, card, A, B);
                    result.append(variety(A, B) + " ");
                }
//                List<String> lineList = new ArrayList<>();


//                for (int i = 0; i < tokens.length; i++) {
//                    lineList.add(tokens[i]);
//                }

//                term.add(lineList);
                countQ++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        List<String> A = new ArrayList<>();
//        A.addAll(term.get(1));
//        List<String> B = new ArrayList<>();
//        B.addAll(term.get(2));


//        for (int i = 3; i < term.size(); i++) {
//            int type = Integer.parseInt(term.get(i).get(0));
//            char player = term.get(i).get(1).charAt(0);
//            String card = term.get(i).get(2);
//            changingOfCollection(type, player, card, A, B);
//            result.append(variety(A, B) + " ");
//        }
        System.out.println("result = " + result);


        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;
        System.out.println("sout dur " + duration);

    }

    public static int variety(List<String> A, List<String> B) {

        int sumOfCopies = 0;
        for (int i = 0; i < B.size(); i++) {
            String str = B.get(i);
            if (A.indexOf(str) >= 0) {
                sumOfCopies += 2;
            }
        }
        return A.size() + B.size() - sumOfCopies;
    }

    public static void changingOfCollection(int type, char player, String card, List<String> A, List<String> B) {

        if (type == 1) {
            if (player == 'A') {
                A.add(card);
            } else {
                B.add(card);
            }
        }

        if (type == -1) {
            if (player == 'A') {
                A.remove(card);
            } else {
                B.remove(card);
            }
        }
    }
}
