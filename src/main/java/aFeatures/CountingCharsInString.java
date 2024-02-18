package aFeatures;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountingCharsInString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Long> output = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(output);
//        вот как с листом
//Map<Integer, Long> integerIntegerMap = integerList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
// вот как с массивом сделать надо-> упаковка (boxed()) делает
//        Map<Integer, Long> map = Arrays.stream(nums)
//                .boxed()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println(map);

        String another = Arrays.stream(input.split(""))
                .filter(m -> m.equals("q"))
                .toString();

        Integer a = 453;
        char [] ch = a.toString().toCharArray();
        Integer b = Integer.valueOf(ch[1]) ;
        char x = ch[1];
        int y = x - '0';
        System.out.println("b = " + b + "   y = " + y);

        String pin = "asdf";
        System.out.println(pin.length());
//        for (int i = 0; i < ch.length;i++)
        System.out.println(Arrays.toString(ch));
        String s = another;
        System.out.println(s);
//
        System.out.println("Output : "+output);
//        Map<int, int> map = new HashMap<>()
        List<Integer> res = new ArrayList<>();
//        Collections.sort(r);
//        for (int i = 0; i < res.size())
    }
}

//count how much time appear element
//        Map<Integer, Integer> map = new LinkedHashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            x = nums[i];
//            if (map.containsKey(x)) {
//                map.put(x, map.get(x) + 1);
//            }
//            if (!map.containsKey(x)) {
//                map.put(x, 1);
//            }
//        }

// чтоб подсчитать максимальное встречающееся количество раз
//        Map.Entry<Integer, Integer> maxCounted = null;
//        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            if (maxCounted == null || maxCounted.getValue() < entry.getValue()) {
//                maxCounted = entry;
//            }
//        }


//"" - по буквам строку разбивает


//For example, to compute the set of last names of people in each city:
// Map<City, Set<String>> namesByCity    = people.stream().collect(      groupingBy(Person::getCity,                 mapping(Person::getLastName,                         toSet())));


//    Map<String, Long> output = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));