package TestingTasksFromInternet.tinkoff.javaRealExam.task2;

//
import java.util.*;

public class Sheriff {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(countWordSheriff(str));
    }

    public static int countWordSheriff(String str) {
        char[] chars = str.toCharArray();
        Set<String> set = new HashSet<>();
        List<Character> oldList = new ArrayList<>();
        Set<String> exampleSet = new HashSet<>(Arrays.asList("s", "h", "e", "r", "i"));

        for (int i = 0; i < chars.length; i++) {
            oldList.add(chars[i]);
        }
        int resultCounting = 0;
        int k = 0;
        int fCount = 0;

        while (k < oldList.size()) {
            String current = String.valueOf(oldList.get(k));

            if ((exampleSet.contains(current)) && (!set.contains(current))) {
                set.add(current);
                oldList.remove(k);
                if (checkIfWordAlreadyBuilt(set)) {
                    resultCounting++;
                    set.clear();
                    k=0;
                }
                continue;
            }

            if (current.equals("f")) {
                fCount++;
                oldList.remove(k);
            }
                if (fCount >= 2 && !set.contains("ff")) {
                    set.add("ff");
                    fCount -= 2;
                }
                if (checkIfWordAlreadyBuilt(set)) {
                    resultCounting++;
                    set.clear();
                    k=0;
                }

            if (current.equals("f")) {
                continue;
            }

            k++;
        }

        return resultCounting;
    }

    public static boolean checkIfWordAlreadyBuilt(Set<String> set) {
        if (set.contains("s") && set.contains("h") && set.contains("e") && set.contains("r") && set.contains("i") && set.contains("ff")) {
            return true;
        }
        return false;
    }
}

//        if (checkIfWordAlreadyBuilt(set)) {
//            resultCounting++;
//            set.clear();
//        }