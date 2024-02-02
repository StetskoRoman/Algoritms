package TestingTasksFromInternet.tinkoff.winter2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task4WithAllComments {

    public static void main(String[] args) throws IOException {

        int countLine = 0;

        int n = 0;
        int m = 0;
        int g = 0;
        int[] a = new int[0];
        int[] b = new int[0];
        List<Integer[]> listMates = new ArrayList<>();


        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {

                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    m = Integer.parseInt(tokens[1]);
                    g = Integer.parseInt(tokens[2]);
                    countLine++;
                    continue;
                }

                if (countLine == 1) {
                    a = new int[n];
                    for (int i = 0; i < n; i++) {
                        a[i] = Integer.parseInt(tokens[i]);
                    }
                    countLine++;
                    continue;
                }

                if (countLine == 2) {
                    b = new int[n];
                    for (int i = 0; i < n; i++) {
                        b[i] = Integer.parseInt(tokens[i]);
                    }
                    countLine++;
                    continue;
                }

                if (countLine < m + 3) {
                    Integer[] friend = new Integer[2];
                    friend[0] = Integer.valueOf(tokens[0]);
                    friend[1] = Integer.valueOf(tokens[1]);
                    listMates.add(friend);

                    countLine++;
                    if (countLine == m + 3) {
                        break;
                    }
                }
            }
        }

        List<Pair> pairList = new ArrayList<>();
        pairList.add(new Pair(0, 0));
        for (int i = 0; i < n; i++) {
            pairList.add(new Pair(a[i], b[i]));
        }
        System.out.println(pairList);

        for (int i = 0; i < listMates.size(); i++) {
            System.out.println(Arrays.toString(listMates.get(i)));
        }

        List<List<Integer>> mainList = findAllMates(listMates, n);
        List<Pair> pairResList = calculateMates(mainList, pairList);
        Collections.sort(pairResList);

        System.out.println("mainlist = " + mainList + "   mates calculated = " + pairResList);


        List<Pair> resList = new ArrayList<>();

        boolean[] visited = new boolean[pairResList.size()];

//        recursInterest(pairResList, new Pair(0, 0), 0, g, resList, visited);
        List<Integer> integerList = new ArrayList<>();
        recursInterest(mainList, pairList, integerList, 0, 0, g, 0);
        System.out.println("res = " + resList);
        System.out.println(integerList);

//        List<Boolean> used = new ArrayList<>();
//        for (int i = 0; i < mainList.size(); i++) {
//            used.add(i, false);
//        }
//        System.out.println("used = " + used);
//
////        recursInterest(mainList, pairList, resList, 0, 0, g, 0);
////        recursInterest(mainList, pairList, resList, 0, 0, g);
//        if (resList.isEmpty()) {
//            System.out.println(0);
//            return;
//        }
//        Integer answer = Collections.max(resList);
//        System.out.println(resList);
////        возвращаем максимальный интерес
//        System.out.println(answer);
    }

    static List<List<Integer>> findAllMates(List<Integer[]> listMates, int n) {
//find all uniq largest friend chain
        List<List<Integer>> mainList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            mainList.add(list);
        }
        System.out.println(mainList + " before");
        for (int i = 0; i < listMates.size(); i++) {
            for (List<Integer> integerSet : mainList) {
                if (integerSet.contains(listMates.get(i)[0])) {
                    integerSet.add(listMates.get(i)[1]);
                    continue;
                }
                if (integerSet.contains(listMates.get(i)[1])) {
                    integerSet.add(listMates.get(i)[0]);
                }
            }
        }
        System.out.println(mainList);
        inUniqValues(mainList);
        System.out.println(mainList);


        return mainList;
    }

    static void inUniqValues(List<List<Integer>> mainList) {
//найти все уникальные максимальные списки
        int point = 0;
        while (point < mainList.size()) {
            for (int i = 0; i < mainList.size(); i++) {
                if (mainList.get(point).containsAll(mainList.get(i)) && i != point) {
                    mainList.remove(i);
                    i--;
                }
            }
            point++;
        }
    }

    static List<Pair> calculateMates(List<List<Integer>> mainList, List<Pair> pairList) {

        List<Pair> matesCalculated = new ArrayList<>();

        for (int i = 0; i < mainList.size(); i++) {
            int addInterest = 0;
            int addFeed = 0;
            for (int j = 0; j < mainList.get(i).size(); j++) {
                addInterest += pairList.get(mainList.get(i).get(j)).interest;
                addFeed += pairList.get(mainList.get(i).get(j)).feed;
            }
            matesCalculated.add(new Pair(addInterest, addFeed));
        }

        return matesCalculated;
    }

    //    , boolean[] counted    && counted[current] == false
//    static boolean isEnoughFood(List<Pair> pairResList, Pair pair, int current, int g) {
//
//        if (pair.feed + pairResList.get(current).feed < g) {
//            pair.interest += pairResList.get(current).interest;
//            pair.feed += pairResList.get(current).feed;
//
//            return true;
//        }
//   isEnoughFood(pairList, pair, i, g)
//        return false;
//    }


//    static List<Pair> recursInterest(List<Pair> pairList, Pair pair, int startPoint, int g, List<Pair> resultList, boolean[] visited) {
//        if (visited[startPoint] == false) {
//            System.out.println("pair before = " + pair);
//            pair = new Pair(pairList.get(startPoint).interest, pairList.get(startPoint).feed);
//            System.out.println("pair after = " + pair);
//            if (pair.feed > g) {
//                return resultList;
//            }
//            visited[startPoint] = true;
//            System.out.println("visited = " + Arrays.toString(visited));
//            resultList.add(pair);
//        }
//
//
//
//        if (startPoint == pairList.size()) {
//            return resultList;
//        }
//
////        for (int i = 0; i < pairList.size(); i++) {
////        while (point < pairList.size()) {
//        for (int i = 0; i < pairList.size(); i++) {
//            if (pair.feed + pairList.get(i).feed < g && visited[i] == false) {
//
//                pair.interest += pairList.get(i).interest;
//                pair.feed += pairList.get(i).feed;
//                visited[i] = true;
//                resultList.add(pair);
//                System.out.println(Arrays.toString(visited));
//                recursInterest(pairList, pair, (startPoint + 1), g, resultList, visited);
//                pair.interest -= pairList.get(i).interest;
//                pair.feed -= pairList.get(i).feed;
//                visited[i] = false;
//
//
//            }
////            if (isEnoughFood(pairList, pair, point, g)) {
////                pair.interest += pairList.get(point).interest;
////                pair.feed += pairList.get(point).feed;
////
////                recursInterest(pairList, pair, (point + 1), g, resultList);
////
////                pair.interest -= pairList.get(point).interest;
////                pair.feed -= pairList.get(point).feed;
////            } else {
////                resultList.add(pair);
////                return;
////            }
//        }
//
//        System.out.println(pairList + "  resList = " + resultList);
//
//        return resultList;
//    }

//
//    private static ArrayList<Integer> nQueen(int[][] mat, int k, ArrayList<Integer> res)
//    {
//        if (k == mat.length) {
//            return res;
//        }
//
//        for (int i = 0; i < mat.length; i++) {
//            if (isSafe(mat, k, i)) {
//                mat[k][i] = 1;
//                if (k == mat.length - 1) {
//                    res.add(1);
//                }
//
//                nQueen(mat, k + 1, res);
////                 возвращаемся
//                mat[k][i] = 0;
//            }
//        }
//        return res;
//    }


//    static void recursInterest(List<List<Integer>> mainList, List<Pair> pairList, List<Integer> listInterest, int interest, int feed, int gw, int current) {
//
//        if (feed > gw) {
//            return;
//        }
//
//        for (int i = current; i < mainList.size(); i++) {
//            int removeFeed = 0;
//            int removeInterest = 0;
//
//            for (int j = 0; j < mainList.get(i).size(); j++) {
//
//                feed += pairList.get(mainList.get(i).get(j)).feed;
//                interest += pairList.get(mainList.get(i).get(j)).interest;
//                removeFeed += pairList.get(mainList.get(i).get(j)).feed;
//                removeInterest += pairList.get(mainList.get(i).get(j)).interest;
//            }
////            System.out.println("size = " + mainList.get(i).size() + "  feed = " + feed + "  interest = " + interest + "  i = " + i + "  current = " + current);
//            if (feed <= gw) {
//
//                listInterest.add(interest);
//                System.out.println("added  " + listInterest);
//                recursInterest(mainList, pairList, listInterest, interest, feed, gw, (current + 1));
//                if (current < 0) {
//                    return;
//                }
//                current--;
//                feed -= removeFeed;
//                interest -= removeInterest;
//            } else {
//
//                interest-=removeInterest;
//                feed -= removeFeed;
//
//                System.out.println("else case interest = " + interest + "  cur feed = " + feed + "  interest = " + interest + " remove interest = " + removeInterest + " curr = " + current);
//                recursInterest(mainList, pairList, listInterest, interest, feed, gw, (current + 1));
//
//            }
//
//        }
//    }


    //    работает с 6 но не работает с 4
    static void recursInterest(List<List<Integer>> mainList, List<Pair> pairList, List<Integer> listInterest, int interest, int feed, int gw, int current) {

        if (feed > gw) {
            return;
        }

        for (int i = current; i < mainList.size(); i++) {
            int removeFeed = 0;
            int removeInterest = 0;

            for (int j = 0; j < mainList.get(i).size(); j++) {

                feed += pairList.get(mainList.get(i).get(j)).feed;
                interest += pairList.get(mainList.get(i).get(j)).interest;
                removeFeed += pairList.get(mainList.get(i).get(j)).feed;
                removeInterest += pairList.get(mainList.get(i).get(j)).interest;
            }
//            System.out.println("size = " + mainList.get(i).size() + "  feed = " + feed + "  interest = " + interest + "  i = " + i + "  current = " + current);
            if (feed <= gw) {

                listInterest.add(interest);
                System.out.println("added  " + listInterest);
                recursInterest(mainList, pairList, listInterest, interest, feed, gw, (current + 1));
                if (current < 0) {
                    return;
                }
                current--;
                feed -= removeFeed;
                interest -= removeInterest;
            } else {

                System.out.println("else case interest = " + interest + "  curfeed = " + feed + "  interest = " + interest + " remove interest = " + removeInterest + " curr = " + current);
                recursInterest(mainList, pairList, listInterest, interest - removeInterest, feed - removeFeed, gw, (current + 1));

            }


        }
    }


//    такой наверн даже получше чтоли?
//    static void recursInterest(List<List<Integer>> mainList, List<Pair> pairList, List<Integer> listInterest, int interest, int feed, int gw, int current) {
//
//        if (feed > gw) {
//            return;
//        }
//        int removeFeed = 0;
//        int removeInterest = 0;
//        for (int i = current; i < mainList.size(); i++) {
//
//            for (int j = 0; j < mainList.get(i).size(); j++) {
//
//                feed += pairList.get(mainList.get(i).get(j)).feed;
//                interest += pairList.get(mainList.get(i).get(j)).interest;
//                removeFeed = pairList.get(mainList.get(i).get(j)).feed;
//                removeInterest = pairList.get(mainList.get(i).get(j)).interest;
//            }
//            System.out.println("size = " + mainList.get(i).size() +  "  feed = " + feed + "  interest = " + interest + "  i = " + i + "  current = " + current);
//            if (feed <= gw) {
//                listInterest.add(interest);
//                recursInterest(mainList, pairList, listInterest, interest, feed, gw, (current+1));
//                if (current < 0) {
//                    return;
//                }
//                current--;
//                feed -= removeFeed;
//                interest -= removeInterest;
//            }
//
//
//        }
//    }


//    работает с 10, 12, 15, на 6 косяк (надо условие чтоб если первая цепочка неподходит чтото делать)
//    static void recursInterest(List<List<Integer>> mainList, List<Pair> pairList, List<Integer> listInterest, int interest, int feed, int gw, int current) {
//
//        if (feed > gw) {
//            return;
//        }
//        int removeFeed = 0;
//        int removeInterest = 0;
//        for (int i = current; i < mainList.size(); i++) {
//
//            for (int j = 0; j < mainList.get(i).size(); j++) {
//
//                feed += pairList.get(mainList.get(i).get(j)).feed;
//                interest += pairList.get(mainList.get(i).get(j)).interest;
//                removeFeed = pairList.get(mainList.get(i).get(j)).feed;
//                removeInterest = pairList.get(mainList.get(i).get(j)).interest;
//            }
//            System.out.println("size = " + mainList.get(i).size() +  "  feed = " + feed + "  interest = " + interest + "  i = " + i + "  current = " + current);
//            if (feed <= gw) {
//                listInterest.add(interest);
//            }
////            else {
////                recursInterest(mainList, pairList, listInterest, interest-removeInterest, feed-removeFeed, gw, (current+1));
//////                if (current < 0) {
//////                    return;
//////                }
//////                current--;
//////                feed -= removeFeed;
//////                interest -= removeInterest;
////            }
//
//            recursInterest(mainList, pairList, listInterest, interest, feed, gw, (current+1));
//            if (current < 0) {
//                return;
//            }
//            current--;
//            feed -= removeFeed;
//            interest -= removeInterest;
//        }
//    }

//, int point
//    static void recursInterest(List<List<Integer>> mainList, List<Pair> pairList, List<Integer> listFeed, int interest, int feed, int gw, List<Boolean> used) {
//        System.out.println("used = " + used);
//        if (feed > gw) {
//            return;
//        }
//
//        int removeFeed = 0;
//        int removeInterest = 0;
//        for (int i = 0; i < mainList.size(); i++) {
//
//            for (int j = 0; j < mainList.get(i).size(); j++) {
//
//                    feed += pairList.get(mainList.get(i).get(j)).feed;
//                    interest += pairList.get(mainList.get(i).get(j)).interest;
//                    removeFeed = pairList.get(mainList.get(i).get(j)).feed;
//                    removeInterest = pairList.get(mainList.get(i).get(j)).interest;
//                }
//
////            System.out.println("size = " + mainList.get(i).size() +  "  feed = " + feed + "  interest = " + interest + "  used = " + used);
//
//            if (feed <= gw && used.get(i) == false) {
//                listFeed.add(interest);
//                used.set(i, true);
//
//                System.out.println("size = " + mainList.get(i).size() +  "  feed = " + feed + "  interest = " + interest + "  used = " + used + "  i = " + i);
////                System.out.println("unside   used = " + used);
//                recursInterest(mainList, pairList, listFeed, interest, feed, gw, used);
////                i--;  "   point = " + point
////                point--;
//                feed -= removeFeed;
//                interest -= removeInterest;
//                used.set(i, false);
//            } else {
//                feed-= removeFeed;
//                interest -= removeInterest;
//            }
//
//            if (feed > gw) {
//                return;
//            }
//        }
//
//    }


    static class Pair implements Comparable<Pair> {

        int interest;
        int feed;

        public Pair(int interest, int feed) {
            this.interest = interest;
            this.feed = feed;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair pair)) return false;
            return interest == pair.interest && feed == pair.feed;
        }

        @Override
        public int hashCode() {
            return Objects.hash(interest, feed);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "interest=" + interest +
                    ", feed=" + feed +
                    '}';
        }


        @Override
        public int compareTo(Pair o) {
            if (this.feed == o.feed) {
                if (this.interest == o.interest) {
                    return 0;
                }
//                if (this.interest > o.interest) {
//                    return -1;
//                } else {
//                    return 1;
//                }
            }
            if (this.feed < o.feed) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}
