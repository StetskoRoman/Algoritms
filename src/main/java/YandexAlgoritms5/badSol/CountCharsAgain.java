package YandexAlgoritms5.badSol;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountCharsAgain {

    public static void main(String[] args) {
        String a = "abacbab,.qw!~12$##@@!";

        StringBuilder stringBuilder = countAllChars(a);
        System.out.println(stringBuilder);

    }

    private static StringBuilder countAllChars(String a) {
        Map<String, Long> map = Arrays.stream(a.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            stringBuilder.append(entry.getKey() + ":" + entry.getValue() + " | ");
        }
        String res = stringBuilder.toString();
        return stringBuilder;
    }
//                .boxed()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
}











































//    Map<String, Long> map = Arrays.stream(a.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));