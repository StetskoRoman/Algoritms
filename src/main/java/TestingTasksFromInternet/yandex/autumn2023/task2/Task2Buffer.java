package TestingTasksFromInternet.yandex.autumn2023.task2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task2Buffer {

    public static void main(String[] args) throws IOException {

        long startTime = System.nanoTime();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String string1 = br.readLine();
//        String string2 = br.readLine();
//        String string3 = br.readLine();
//
//        String[] arr1 = string1.split(" ");
//        String[] arr2 = string2.split(" ");
//        String[] arr3 = string3.split(" ");
//        int q = Integer.parseInt(arr1[2]);
//
//        List<String> A = new ArrayList<>();
//        List<String> B = new ArrayList<>();
//        for (int i = 0; i < arr2.length; i++) {
//            A.add(arr2[i]);
//        }
//        for (int i = 0; i < arr3.length; i++) {
//            B.add(arr3[i]);
//        }
//
//
//        System.out.println(A);
//        System.out.println(B);
//        System.out.println(q);

//        List<List<String>> term = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        int countQ = 0;
        int q = 0;
        List<String> A = new ArrayList<>();
        List<String> B = new ArrayList<>();

        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in)) {

            String line;
//q check      && countQ < q + 2
            while ((line = buffer.readLine()) != null) {
                String[] tokens = line.split(" ");
                if (countQ == 0) {
                    q = Integer.parseInt(tokens[2]);
                    countQ++;
                    continue;
                }

                if (countQ == 1) {
                    for (int i = 0; i < tokens.length; i++) {
                        A.add(tokens[i]);
                    }
                    countQ++;
                    continue;
                }
                if (countQ == 2) {
                    for (int i = 0; i < tokens.length; i++) {
                        B.add(tokens[i]);
                    }
                    countQ++;
                    continue;
                }

                System.out.println("count Q " + countQ);

                    System.out.println("im here");

                    int type = Integer.parseInt(tokens[0]);
                    char player = tokens[1].charAt(0);
                    String card = tokens[2];
                    changingOfCollection(type, player, card, A, B);
                    result.append(variety(A, B) + " ");

                countQ++;
                if (q + 2 < countQ) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(result);


        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000;
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

