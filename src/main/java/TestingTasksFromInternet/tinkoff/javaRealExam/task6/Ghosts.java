package TestingTasksFromInternet.tinkoff.javaRealExam.task6;

import java.util.*;

public class Ghosts {

    public static void main(String[] args) {

        List<List<Integer>> questions = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        int k = 0;
        while (k < m) {
            List<Integer> line = new ArrayList<>();
            Scanner lineScanner = new Scanner(scanner.nextLine());

            while (lineScanner.hasNext()) {
                line.add(Integer.valueOf(lineScanner.next()));
            }
            k++;
            questions.add(line);
            lineScanner.close();
        }
        scanner.close();

        List<Set<Integer>> listSet = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> integerSet = new HashSet<>();
            integerSet.add(i + 1);
            listSet.add(integerSet);
        }

        Map<Integer, Integer> countingMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            countingMap.put(i + 1, 1);
        }

        int i = 0;
        while (i < m) {
            switch (questions.get(i).get(0)) {

                case (1):

                    for (int j = 0; j < listSet.size(); j++) {
                        if (listSet.get(j).contains(questions.get(i).get(1))
                                && listSet.get(j).contains(questions.get(i).get(2))) {
                            i++;
                            break;
                        }

                        if (listSet.get(j).contains(questions.get(i).get(1))
                                && !listSet.get(j).contains(questions.get(i).get(2))) {

                            Set<Integer> targetSet = new HashSet<>();
                            for (int q = 0; q < listSet.size(); q++) {
                                if (listSet.get(q).contains(questions.get(i).get(2))) {
                                    targetSet.addAll(listSet.get(q));
                                }
                            }
                            listSet.get(j).addAll(targetSet);

                            for (Map.Entry<Integer, Integer> entry : countingMap.entrySet()) {
                                if (listSet.get(j).contains(entry.getKey())) {
                                    entry.setValue(entry.getValue() + 1);
                                }
                            }

                            i++;
                            listSet.remove(targetSet);
                            break;
                        }
                    }
                    break;

                case (2):

                    boolean answer = false;
                    for (int j = 0; j < listSet.size(); j++) {
                        if (listSet.get(j).contains(questions.get(i).get(1))
                                && listSet.get(j).contains(questions.get(i).get(2))) {
                            answer = true;
                            break;
                        }
                    }

                    if (answer) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }

                    i++;
                    break;

                case (3):

                    for (Map.Entry<Integer, Integer> entry : countingMap.entrySet()) {
                        if (entry.getKey().equals(questions.get(i).get(1))) {
                            System.out.println(entry.getValue());
                            break;
                        }
                    }

                    i++;
                    break;

            }
        }

    }
}

// System.out.println(listSet);
//
//         System.out.println(countingMap);

//System.out.println("Counting map = " + countingMap);
//        System.out.println("changed something");
//        System.out.println(listSet.get(j));

// System.out.println(n + "  " + m);
//         for (int z = 0; z < questions.size(); z++) {
//        System.out.println(questions.get(z));
//        }