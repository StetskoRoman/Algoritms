package YandexAlgoritms2023.lecture1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Task5Rasrad {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;
        String[] strings = new String[0];
        int m = 0;

        PrintWriter printWriter = new PrintWriter(System.out);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    strings = new String[n];
                    countLine++;
                    continue;
                }

                if (countLine <= n) {
                    strings[countLine - 1] = tokens[0];
                    m = strings[countLine - 1].length();
                    countLine++;
                    if (countLine > n) {
                        break;
                    }
                }
            }
        }

        printWriter.println("Initial array:");
        for (int i = 0; i < strings.length; i++) {
            if (i < strings.length - 1) {
                printWriter.print(strings[i] + ", ");
            } else {
                printWriter.print(strings[i]);
            }
        }
        printWriter.println();
        printWriter.flush();
        categorySort(strings, m);

    }

    static void categorySort(String[] strings, int m) {

        for (int i = 0; i < m; i++) {
            bucketSort(strings, m, i);
        }
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println("**********");
        printWriter.println("Sorted array:");
        for (int j = 0; j < strings.length; j++) {

            if (j < strings.length - 1) {
                printWriter.print(strings[j] + ", ");
            } else {
                printWriter.print(strings[j]);
            }
        }
        printWriter.flush();

    }

    static void bucketSort(String[] strings, int m, int i) {

        int stage = m - i - 1;
        List<String> array0 = new ArrayList<>();
        List<String> array1 = new ArrayList<>();
        List<String> array2 = new ArrayList<>();
        List<String> array3 = new ArrayList<>();
        List<String> array4 = new ArrayList<>();
        List<String> array5 = new ArrayList<>();
        List<String> array6 = new ArrayList<>();
        List<String> array7 = new ArrayList<>();
        List<String> array8 = new ArrayList<>();
        List<String> array9 = new ArrayList<>();

        String input = "0123456789";
        for (int j = 0; j < strings.length; j++) {

            int digit = Integer.parseInt(String.valueOf(strings[j].charAt(stage)));

            switch (digit) {
                case 0:
                    array0.add(strings[j]);
                    break;
                case 1:
                    array1.add(strings[j]);
                    break;
                case 2:
                    array2.add(strings[j]);
                    break;
                case 3:
                    array3.add(strings[j]);
                    break;
                case 4:
                    array4.add(strings[j]);
                    break;
                case 5:
                    array5.add(strings[j]);
                    break;
                case 6:
                    array6.add(strings[j]);
                    break;
                case 7:
                    array7.add(strings[j]);
                    break;
                case 8:
                    array8.add(strings[j]);
                    break;
                case 9:
                    array9.add(strings[j]);
                    break;
            }
        }
        Map<Integer, List<String>> map = new LinkedHashMap<>();
        List<String> emptyList = List.of("empty");

        List<Map<Integer, List<String>>> resultList = new ArrayList<>();

        for (int k = 0; k < input.length(); k++) {
            switch (k) {
                case 0:
                    fillMap(array0, map, emptyList, k);
                    break;
                case 1:
                    fillMap(array1, map, emptyList, k);
                    break;
                case 2:
                    fillMap(array2, map, emptyList, k);
                    break;
                case 3:
                    fillMap(array3, map, emptyList, k);
                    break;
                case 4:
                    fillMap(array4, map, emptyList, k);
                    break;
                case 5:
                    fillMap(array5, map, emptyList, k);
                    break;
                case 6:
                    fillMap(array6, map, emptyList, k);
                    break;
                case 7:
                    fillMap(array7, map, emptyList, k);
                    break;
                case 8:
                    fillMap(array8, map, emptyList, k);
                    break;
                case 9:
                    fillMap(array9, map, emptyList, k);
                    break;

                default:
                    map.put(k, emptyList);

            }
        }

        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.println("**********");
        printWriter.println("Phase " + (i + 1));


        int counting = 0;
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            List<String> value = entry.getValue();
            for (int x = 0; x < value.size(); x++) {
                if (!value.get(x).equals("empty")) {
                    strings[counting] = value.get(x);
                    counting++;
                }
            }
            String valueWithout = value.toString().replaceAll("[\\[\\]]", "");
            printWriter.println("Bucket " + key + ": " + valueWithout);
        }

        printWriter.flush();

    }

    private static void fillMap(List<String> array0, Map<Integer, List<String>> map, List<String> emptyList, int k) {
        if (!array0.isEmpty()) {
            map.put(k, array0);
        } else {
            map.put(k, emptyList);
        }
    }
}


//        resultList.add(map);
//        Iterator<Map.Entry<Integer, List<String>>> iterator =
//                resultList.stream().flatMap(element -> element.entrySet().stream()).iterator();
//
//        while (iterator.hasNext()) {
//            Map.Entry<Integer, List<String>> entry = iterator.next();
//            Integer key = entry.getKey();
//            List<String> value = entry.getValue();
//            String valueWithout = value.toString().replaceAll("[\\[\\]]", "");
//            printWriter.println("Bucket " + key + ": " + valueWithout);
//
//        }

//        List sortedKeys=new ArrayList(map.keySet());
//        Collections.sort(sortedKeys);
//        for (int z = 0; z < map.size(); m++) {
//            System.out.println(map.get(z));
//        }



//   System.out.println(map);

// System.out.println("digit = " + digit);

//        String input = "0123456789";
//        Map<Integer, List<String>> map = new LinkedHashMap<>();
//        for (int k = 0; k < input.length(); k++) {
//        map.put(k, null);
//        }
//        System.out.println(map);
////        for (Map.Entry<String, ArrayList<String>> entry : names.entrySet()) {
////            String key = entry.getKey();
////        }
//        for (int j = 0; j < strings.length; j++) {
//        int digit = Integer.parseInt(String.valueOf(strings[j].charAt(stage)));
//        System.out.println("digit = " + digit);
//        if (map.containsKey(digit)) {
//        map.put(digit, Arrays.asList(strings[j]));
//        }
//        System.out.println(map);
////            List<String> list = new ArrayList<>();