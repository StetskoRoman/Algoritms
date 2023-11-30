package TestingTasksFromInternet.tinkoff.javaBackRealExam.task2;

import java.util.*;

public class Password {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();

        System.out.println(numberOfSymbolsAfterDeleting(str, k));

    }

    public static int numberOfSymbolsAfterDeleting(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else{
                map.put(chars[i], 1);
            }
        }

        int mapSize = map.size();
        int countedChar = 1;
        int countDeleting = 0;
        int delta = 0;

        while (countDeleting < k) {
            delta = k - countDeleting;
            if (delta>countedChar){

                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (entry.getValue() == countedChar) {
                        countDeleting++;
                        if (countDeleting == k) {
                            break;
                        }
                    }
                }
                countedChar++;
            } else break;
        }

        int result = mapSize-countDeleting;

        return result;
    }
}


//        Map<Character, Integer> map = new HashMap<>();
//        char[] chars = str.toCharArray();
//        List<Character> characterList = new ArrayList<>();
//        for (char letter : chars) {
//            characterList.add(letter);
//        }
//
//
//        for (int i = 0; i < characterList.size(); i++) {
//            if (map.containsKey(characterList.get(i))) {
//                map.put(characterList.get(i), map.get(characterList.get(i)) + 1);
//            } else{
//                map.put(chars[i], 1);
//            }
//        }
//
//
//        int mapSize = map.size();
//
//        int countedChar = 1;
//        int countDeleting = 0;
//        int delta = 0;
//        while (countDeleting < k) {
//            int numberForDeletingInThisRound = 0;
//            delta = k - countDeleting;
//            if (delta>countedChar){
//                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//                    if (entry.getValue() == countedChar) {
//                        countDeleting++;
//                        if (countDeleting == k) {
//                            break;
//                        }
//                    }
//                }
//                countedChar++;
//            } else break;
//
//
//
//        }
//
//        int result = mapSize-countDeleting;
//
//
//        System.out.println(result);

//            System.out.println(map);
//
//        System.out.println(n + "   " + k);
//        System.out.println(str);
//        System.out.println(map);


//            for (Iterator<Character> iterator = map.keySet().iterator(); iterator.hasNext(); ) {
//                Character key = iterator.next();
//                if (key.  equals(countedChar)) {
//                    System.out.println("удаляю чет " + map);
//                    numberForDeletingInThisRound += countedChar;
//                    iterator.remove();
//                }
//            }
//            k -= numberForDeletingInThisRound;




//        for(Iterator<Integer> iterator = map.keySet().iterator(); iterator.hasNext(); ) {
//            Integer key = iterator.next();
//            if(key != 1) {
//                iterator.remove();
//            }
//        }







//  System.out.println("mapsize = " + mapSize);