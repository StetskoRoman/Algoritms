package TestingTasksFromInternet.tinkoff.winter2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task44 {

    public static void main(String[] args) throws IOException {

        int countLine = 0;

        int n = 0;
        int m = 0;
        int g = 0;
        int [] a = new int[0];
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
        System.out.println(mainList);

        List<Integer> resList = new ArrayList<>();
        recursInterest(mainList, pairList, resList, 0, 0, g);

        Integer answer = Collections.max(resList);
        System.out.println(resList);
        System.out.println(answer);
    }

    static List<List<Integer>> findAllMates(List<Integer[]> listMates, int n) {

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
        inUniqValues(mainList);

        return mainList;
    }

    static void inUniqValues(List<List<Integer>> mainList) {

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

    static void recursInterest(List<List<Integer>> mainList, List<Pair> pairList, List<Integer> listFeed, int interest, int feed, int gw) {

        if (feed > gw) {
            return;
        }

        int removeFeed = 0;
        int removeInterest = 0;
        for (int i = 0; i < mainList.size(); i++) {

            for (int j = 0; j < mainList.get(i).size(); j++) {
                feed += pairList.get(mainList.get(i).get(j)).feed;
                interest += pairList.get(mainList.get(i).get(j)).interest;
                removeFeed = pairList.get(mainList.get(i).get(j)).feed;
                removeInterest = pairList.get(mainList.get(i).get(j)).interest;
            }

            if (feed <= gw) {
                listFeed.add(interest);
                recursInterest(mainList, pairList, listFeed, interest, feed, gw);
                feed -= removeFeed;
                interest-= removeInterest;
            }

            if (feed > gw) {
                return;
            }
        }

    }


    static class Pair {

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
    }
}


// System.out.println("size = " + mainList.get(i).size() +  "  feed = " + feed + "  interest = " + interest);
