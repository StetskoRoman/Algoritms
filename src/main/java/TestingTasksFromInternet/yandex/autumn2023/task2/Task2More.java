package TestingTasksFromInternet.yandex.autumn2023.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Task2More {

    public static void main(String[] args) throws IOException {

        StringBuilder result = new StringBuilder();
        int countQ = 0;
        int q = 0;
        int del = 0;
        int counting = 0;
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        List<Integer> oldA = new ArrayList<>();
        List<Integer> oldB = new ArrayList<>();

        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in)) {

            String line;

            while ((line = buffer.readLine()) != null) {
                String[] tokens = line.split(" ");
                if (countQ == 0) {
                    q = Integer.parseInt(tokens[2]);
                    countQ++;
                    continue;
                }

                if (countQ == 1) {
                    for (int i = 0; i < tokens.length; i++) {
                        A.add(Integer.valueOf(tokens[i]));
                    }
                    countQ++;
                    continue;
                }
                if (countQ == 2) {
                    for (int i = 0; i < tokens.length; i++) {
                        B.add(Integer.valueOf(tokens[i]));
                    }
                    oldA.addAll(A);
                    oldB.addAll(B);

                    del = deleting(A, B);
                    counting = variety(A, B);
                    System.out.println("after deleting " + A);
                    System.out.println(B);
                    System.out.println(del);
                    countQ++;
                    continue;
                }
                System.out.println("Step = " + (countQ - 2));
                System.out.println("CountCharsAgain = " + A);
                System.out.println("B = " + B);
                System.out.println("Old CountCharsAgain = " + oldA);
                System.out.println("Old B = " + oldB);
//                if (countQ == 3) {
//                    del = deleting(CountCharsAgain, B);
//                    result.append(variety(CountCharsAgain, B) + " ");
//                    System.out.println("after deleting " + CountCharsAgain);
//                    System.out.println(B);
//                    System.out.println(del);
//                    countQ++;
//                    continue;
//                }

                int type = Integer.parseInt(tokens[0]);
                char player = tokens[1].charAt(0);
                int card = Integer.parseInt(tokens[2]);


                counting += changingOfCollection(type, player, card, A, B, oldA, oldB);
                result.append(counting + " ");
//                result.append(variety(CountCharsAgain, B) + " ");
//                oldA = CountCharsAgain;
//                oldB = B;
                countQ++;
                if (q + 2 < countQ) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.print(result);
        printWriter.flush();
        printWriter.close();
    }

    public static int variety(List<Integer> A, List<Integer> B) {

        int sumOfCopies = 0;
        for (int i = 0; i < B.size(); i++) {
            Integer str = B.get(i);
            if (A.indexOf(str) >= 0) {
                sumOfCopies += 2;
            }
        }
        return A.size() + B.size() - sumOfCopies;
    }

    public static int changingOfCollection(int type, char player, Integer card, List<Integer> A, List<Integer> B, List<Integer> oldA, List<Integer> oldB) {

        int one = 0;

        if (type == 1) {
            if (player == 'A') {
                A.add(card);
            } else {
                B.add(card);
            }

            if (A.contains(card) && B.contains(card)) {
                one = -1;
                A.remove(card);
                B.remove(card);
                return one;
            } else {
                one = 1;
                return one;
            }
        }

        if (type == -1) {
            if (player == 'A') {

                if (A.contains(card)) {
                    A.remove(card);
                    if (oldB.contains(card)) {
                        one = 1;
                        return one;
                    } else {
                        one = -1;
                        return one;
                    }
                } else {
                    if (oldB.contains(card)) {
                        one = 1;
                        return one;
                    } else {
                        one = -1;
                        return one;
                    }
                }

            } else {

                if (B.contains(card)) {
                    B.remove(card);
                    if (oldA.contains(card)) {
                        one = 1;
                        return one;
                    } else {
                        one = -1;
                        return one;
                    }
                } else {
                    if (oldA.contains(card)) {
                        one = 1;
                        return one;
                    } else {
                        one = -1;
                        return one;
                    }
                }
            }
        }
        return one;
    }


    public static int deleting(List<Integer> A, List<Integer> B) {

        int countDeletes = 0;

        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < B.size(); j++) {
                if (B.get(j) == A.get(i)) {
                    B.remove(B.get(j));
                    j--;
                    A.remove(A.get(i));
                    i--;
                    countDeletes++;
                    break;
                }

            }
        }
        return countDeletes;
    }
}

//
//2 1 0 1 2 3 2 1 0 1
