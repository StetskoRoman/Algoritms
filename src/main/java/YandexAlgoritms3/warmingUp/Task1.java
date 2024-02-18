package YandexAlgoritms3.warmingUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task1 {

    public static void main(String[] args) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<String> list = new ArrayList<>();

        while ((line = bufferedReader.readLine()) != null) {
            String[] tokens = line.split(" ");
            if (tokens[0].isEmpty()) {
                break;
            }
            for (int i = 0; i < tokens.length; i++) {
                list.add(tokens[i]);
            }

        }
        bufferedReader.close();


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
            if (i != 0) {
                printWriter.println();
            }
            for (int j = 0; j < chars[i].length; j++) {
                printWriter.print(chars[i][j]);
            }
        }
        printWriter.println();
        printWriter.print(lastString);
        printWriter.flush();
        printWriter.close();
    }

    static Map<String , Long> getSimbolsInMap(List<String> list) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length(); j++) {
                stringBuilder.append(list.get(i).charAt(j));
            }
        }
        String resString = stringBuilder.toString();

        Map<String, Long> map = Arrays.stream(resString.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> treemap = new TreeMap<>(map);

        return treemap;
    }
}
