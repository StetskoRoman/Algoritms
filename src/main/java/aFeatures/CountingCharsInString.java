package aFeatures;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountingCharsInString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Long> output = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String another = Arrays.stream(input.split(""))
                .filter(m -> m.equals("q"))
                .toString();


        String s = another;
        System.out.println(s);
//
        System.out.println("Output : "+output);

    }
}


//"" - по буквам строку разбивает


//For example, to compute the set of last names of people in each city:
// Map<City, Set<String>> namesByCity    = people.stream().collect(      groupingBy(Person::getCity,                 mapping(Person::getLastName,                         toSet())));


//    Map<String, Long> output = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));