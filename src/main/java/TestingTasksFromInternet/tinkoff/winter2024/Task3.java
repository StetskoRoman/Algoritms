package TestingTasksFromInternet.tinkoff.winter2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Task3 {

    public static void main(String[] args) throws IOException {

        PrintWriter printWriter = new PrintWriter(System.out);

        int countLine = 0;
        int n = 0;
        int[] nums;
        List<int[]> list = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    countLine++;
                    continue;
                }

                if (countLine <= n) {
                    nums = new int[3];
                    for (int i = 0; i < 3; i++) {
                        nums[i] = Integer.parseInt(tokens[i]);
                    }
                    list.add(nums);
                    countLine++;

                    if (countLine == n + 1) {
                        break;
                    }
                }
            }
        }

        List<Pair> pairList = getPairs(list);
        Collections.sort(pairList);

        boolean res = solution(pairList);
        if (res == true) {
            System.out.println("YES");

        } else System.out.println("NO");
    }

    static List<Pair> getPairs(List<int[]> list) {

        List<Pair> pairList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {

            pairList.add(new Pair(list.get(i)[0] + list.get(i)[1], list.get(i)[2]));
        }
        return pairList;
    }

    static boolean solution(List<Pair> pairList) {

        for (int i = 0; i < pairList.size(); i++) {
            if (pairList.get(i).readyDay > pairList.get(i).lastDay) {
                return false;
            }
        }

        int n = pairList.size();
        List<Boolean> addedGift = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            addedGift.add(false);
        }

        int currentDay = 0;
        int readyNow = 0;
        int alreadSent = 0;
        int currentI = 0;
        List<Pair> readyList = new ArrayList<>();
        int[] condition = new int[3];

        while (!readyList.isEmpty() || addedGift.contains(false)) {

            if (readyList.isEmpty()) {
                for (int i = 0; i < pairList.size(); i++) {
                    if (pairList.get(i).readyDay >= currentDay && addedGift.get(i) == false && readyNow == 0) {
                        currentDay = pairList.get(i).readyDay;
                        break;
                    }
                }
            }

            for (int i = currentI; i < pairList.size(); i++) {
                if (pairList.get(i).readyDay <= currentDay && addedGift.get(i) == false) {
                    readyList.add(pairList.get(i));
                    addedGift.set(i, true);
                    readyNow++;
                }
            }

            for (int i = 0; i < readyList.size(); i++) {
                if (currentDay > readyList.get(i).lastDay) {
                    return false;
                }
            }
            if (!readyList.isEmpty()) {
                condition = getGiftForSending(readyList, readyNow, alreadSent, currentDay);
                readyNow = condition[0];
                alreadSent = condition[1];
                currentDay = condition[2];

            }

            if (readyNow == 0 && readyList.isEmpty() && alreadSent == n) {
                return true;
            }
        }

        return false;
    }

    static int[] getGiftForSending(List<Pair> readyList, int readyNow, int alreadySent, int currentDay) {
        int minLastDay = Integer.MAX_VALUE;
        int posForDeletePair = 0;

        int[] resultCondition = new int[3];
        for (int i = 0; i < readyList.size(); i++) {
            if (readyList.get(i).lastDay < minLastDay) {
                minLastDay = readyList.get(i).lastDay;
                posForDeletePair = i;
            }
        }
        readyList.remove(posForDeletePair);
        resultCondition[0] = readyNow -= 1;
        resultCondition[1] = alreadySent += 1;
        resultCondition[2] = currentDay += 1;

        return resultCondition;
    }


    static class Pair implements Comparable<Pair> {

        int readyDay;
        int lastDay;

        public Pair(int readyDay, int lastDay) {
            this.readyDay = readyDay;
            this.lastDay = lastDay;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair pair)) return false;
            return readyDay == pair.readyDay && lastDay == pair.lastDay;
        }

        @Override
        public int hashCode() {
            return Objects.hash(readyDay, lastDay);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "readyDay=" + readyDay +
                    ", lastDay=" + lastDay +
                    '}';
        }

        @Override
        public int compareTo(Pair o) {
            if (this.readyDay == o.readyDay) {
                if (this.lastDay == o.lastDay) {
                    return 0;
                }

                if (this.lastDay < o.lastDay) {
                    return -1;
                } else {
                    return 1;
                }
            }
            if (this.readyDay < o.readyDay) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}

//    static int findReadyForToday(List<Pair> pairList, int startListPos, int currentDay) {
//        int count = 0;
////        int[] res = new int[2];
//        for (int i = startListPos; i < pairList.size(); i++) {
//            if (pairList.get(i).readyDay == currentDay) {
//                count++;
//            }
//            if (currentDay < pairList.get(i).readyDay) {
////                res[1] = i;
//                break;
//            }
//        }
////        res[0] = count;
//
//        return count;
//    }

//        @Override
//        public int compareTo(Pair o) {
//            if (this.lastDay == o.lastDay) {
//                if (this.readyDay == o.readyDay) {
//                    return 0;
//                }
//
//                if (this.readyDay < o.readyDay) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            }
//            if (this.lastDay < o.lastDay) {
//                return -1;
//            } else {
//                return 1;
//            }
//        }
//    }


//  for (int i = 0; i < list.size(); i++) {
//            System.out.println(Arrays.toString(list.get(i)));
//        }

//            System.out.println("gifts ready = " + giftsReady + "   gifts sent = " + giftsSent + "   DAY= " + currentDay   +
//                    "   curr point " + currentPoint +  "    LAST DAY = " + lastDay);
//            System.out.println(Arrays.toString(gifted));
