package TestingTasksFromInternet.tinkoff.javaRealExam.task5;

import java.util.*;

public class Roads {

    public static void main(String[] args) {

        List<List<Integer>> roads = new ArrayList<>();
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
            roads.add(line);
            lineScanner.close();
        }
        scanner.close();

        List<Set<Integer>> listSet = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> integerSet = new HashSet<>();
            integerSet.add(i + 1);
            listSet.add(integerSet);
        }

        int i = 0;
        while (i < m) {

            for (int j = 0; j < listSet.size(); j++) {

                if (listSet.get(j).contains(roads.get(i).get(0)) && !listSet.get(j).contains(roads.get(i).get(1))) {

                    Set<Integer> targetSet = new HashSet<>();
                    for (int q = 0; q < listSet.size(); q++) {
                        if (listSet.get(q).contains(roads.get(i).get(1))) {
                            targetSet.addAll(listSet.get(q));
                        }
                    }
                    listSet.get(j).addAll(targetSet);
                    i++;
                    listSet.remove(targetSet);
                    break;

                }

                if (listSet.get(j).contains(roads.get(i).get(0)) && listSet.get(j).contains(roads.get(i).get(1))){
                    i++;
                    break;
                }
            }
        }

        List<Integer> resultList = new ArrayList<>();

        for (i = 0; i < listSet.size(); i++) {
            List<Integer> list = new ArrayList<>();
            int result = 0;

            for (int j = 0; j < roads.size(); j++) {
                if (listSet.get(i).contains(roads.get(j).get(0)) || listSet.get(i).contains(roads.get(j).get(1))) {
                    list.add(roads.get(j).get(2));
                }
            }

            Collections.sort(list);
            result = list.get(list.size() - 1 - (listSet.get(i).size() - 2));
            resultList.add(result);

        }

        System.out.println(Collections.min(resultList) - 1);
    }
}

//System.out.println("list = " + list);

//System.out.println("res list = " + resultList);

//        System.out.println("po itogu " + listSet);
//                System.out.println("itog dorogi " + roads);
//

//    Map<Set<Integer>, List<Integer>> countingMap = new HashMap<>();


//  System.out.println(n + "  " + m);
//          for (int z = 0; z < roads.size(); z++) {
//        System.out.println(roads.get(z));
//        }