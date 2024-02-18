package YandexAlgoritms3.warmingUp;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task1file {

    public static void main(String[] args) throws IOException {

        List<String> list = new ArrayList<>();
//        String absPath = "S:\\Program\\Projects\\Proj On work\\Tasks\\src\\input.txt";
//        BufferedReader reader = new BufferedReader(new FileReader(absPath));
//
//        String file = reader.readLine();
//        String[] nums = file.split(" ");
//
//        for (int i = 0; i < nums.length; i++) {
//            list.add(nums[i]);
//        }
//        reader.close();

//        String absPath = "S:\\Program\\Projects\\Proj On work\\Tasks\\src\\input.txt";
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(absPath));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] tokens = line.split(" ");
//            if (tokens[0].isEmpty()) {
//                break;
//            }
            for (int i = 0; i < tokens.length; i++) {
                list.add(tokens[i]);
            }
        }
        bufferedReader.close();

//        System.out.println(list);
        Map<String, Long> resMap = getSimbolsInMap(list);
        StringBuilder lastString = new StringBuilder();

        Long maxCount = 0L;
        List<Long> longList = new ArrayList<>();
        List<List<Long>> bigLongList = new ArrayList<>();

        for (Map.Entry<String, Long> literal : resMap.entrySet()) {
            lastString.append(literal.getKey());
            longList.add(literal.getValue());
            if (literal.getValue() > maxCount) {
                maxCount = literal.getValue();
            }
        }
//        System.out.println(longList + "    " + maxCount);
        for (int i = 0; i < maxCount; i++) {
            bigLongList.add(new ArrayList<>());
        }

        char[][] chars = new char[Math.toIntExact(maxCount)][longList.size()];
        for (int i = bigLongList.size() - 1; i >= 0; i--) {

            for (int j = 0; j < longList.size(); j++) {
                if (longList.get(j) > 0) {
                    chars[i][j] = '#';
                    longList.set(j, longList.get(j) - 1);
                } else {
                    chars[i][j] = ' ';
                }

            }
        }

        PrintWriter printWriter = new PrintWriter(System.out);

        for (int i = 0; i < chars.length; i++) {
            printWriter.println();
            for (int j = 0; j < chars[i].length; j++) {
                printWriter.print(chars[i][j]);
            }
        }
        printWriter.println();
        printWriter.print(lastString);
        printWriter.flush();
        printWriter.close();


//        FileWriter writer = new FileWriter("output.txt");
//        writer.write(printWriter.toString());
//        System.out.println("done");
//        writer.flush();

    }

    static Map<String, Long> getSimbolsInMap(List<String> list) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                stringBuilder.append(list.get(i).charAt(j));
            }
        }
        String resString = stringBuilder.toString();
//        System.out.println("stringBuilder = " + stringBuilder + "   " + resString);
//получаем все буквы и количество их
        Map<String, Long> map = Arrays.stream(resString.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

//        System.out.println(map);

        Map<String, Long> treemap = new TreeMap<>(map);
//        System.out.println(treemap);
        return treemap;
    }
}
