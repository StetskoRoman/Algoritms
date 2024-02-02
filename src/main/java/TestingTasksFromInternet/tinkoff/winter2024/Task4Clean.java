package TestingTasksFromInternet.tinkoff.winter2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Task4Clean {

    public static void main(String[] args) throws IOException {

        int countLine = 0;

        int n = 0;
        int m = 0;
        int gw = 0;
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
                    gw = Integer.parseInt(tokens[2]);
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
                    if (m == 0 && countLine == 3) {
                        break;
                    }
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

        List<List<Integer>> mainList = findAllMates(listMates, n);
        List<Pair> pairResList = calculateMates(mainList, pairList);
        Collections.sort(pairResList);

        Set<Integer> integerSet = solution(pairResList, gw);
        if (integerSet.isEmpty()) {
            System.out.println(0);
            return;
        }
        Integer maxInterest = Collections.max(integerSet);
        System.out.println(maxInterest);

    }

    static Set<Integer> solution(List<Pair> pairResList, int g) {

        Set<Integer> resSetInt = new LinkedHashSet<>();
        int n = pairResList.size();
        int currentPoint = 0;
        int lastPoint = n - 1;

        if (pairResList.get(0).feed > g) {
            return resSetInt;
        }

        for (int i = currentPoint; i < n; i++) {
            Pair pair = pairResList.get(i);
            if (pair.feed <= g) {
                resSetInt.add(pair.interest);

            } else continue;

            if (i == lastPoint) {
                break;
            }
                for (int j = lastPoint; j > i; j--) {
                    if (pair.feed + pairResList.get(j).feed <= g) {
                        pair.feed += pairResList.get(j).feed;
                        pair.interest += pairResList.get(j).interest;

                        resSetInt.add(pair.interest);
                    }
                }

            pair = pairResList.get(i);
            if (i != lastPoint) {
                for (int c = i + 1; c < n; c++) {
                    if (pair.feed + pairResList.get(c).feed <= g) {
                        pair.feed += pairResList.get(c).feed;
                        pair.interest += pairResList.get(c).interest;

                        resSetInt.add(pair.interest);
                    }
                }
            }
        }

        return resSetInt;
    }

    static List<List<Integer>> findAllMates(List<Integer[]> listMates, int n) {

        List<List<Integer>> mainList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            mainList.add(list);
        }

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

                if (this.interest < o.interest) {
                    return -1;
                } else {
                    return 1;
                }
            }
            if (this.feed < o.feed) {
                return -1;
            } else {
                return 1;
            }
        }
    }

}


//else {
//                        resList.add(pair);
//                        break;
//                    }

//    static Integer findMaxInterest(Set<Pair> pairSet) {
//        int maxInterest = Integer.MIN_VALUE;
//        for (Pair pair : pairSet) {
//            if (pair.interest > maxInterest) {
//                maxInterest = pair.interest;
//            }
//        }
//        return maxInterest;
//    }
//
//    static Integer findMaxInt(Set<Integer> integerSet) {
//        int maxInterest = Integer.MIN_VALUE;
//        for (Integer interest : integerSet) {
//            if (interest > maxInterest) {
//                maxInterest = interest;
//            }
//        }
//        return maxInterest;
//    }