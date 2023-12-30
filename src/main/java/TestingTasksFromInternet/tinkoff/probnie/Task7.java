package TestingTasksFromInternet.tinkoff.probnie;

import java.util.*;
import java.util.stream.IntStream;

public class Task7 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            nums[i] = scanner.nextInt();
        }
        nums[0] = 0;

//        System.out.println(Arrays.toString(nums));

        searchBadElement(nums);

        int[] result = solution(nums);
        System.out.println(result[0] + " " + result[1]);
    }

    static int[] solution(int[] nums) {
        int[] res = new int[2];
        int pos = 1;
//        boolean[] visited = new boolean[nums.length + 1];
        List<Boolean> visited = new ArrayList<>();
        for (int k = 0; k < nums.length; k++) {
            visited.add(false);
        }
        visited.set(0, true);


        boolean changed = false;

        int countSteps = 0;
//countSteps < nums.length - 1
        while (true) {

            if (!visited.contains(false) == true && changed == true) {
                res[0] = -1;
                res[1] = -1;
                return res;
            }

//            if (visited.get(pos) == true && changed == true) {
//                res[0] = -1;
//                res[1] = -1;
//                return res;
//            }
            if (!visited.contains(false) && nums[pos] == 1) {
                return res;
            }


            if (visited.get(pos) == true && changed == false) {
                changed = true;
                int insertPos = searchBadElement(nums);

                res[0] = pos;
                res[1] = insertPos;
                nums[pos] = insertPos;
                pos = insertPos;
//                System.out.println(" insert pos = " + insertPos + "   Array = " + Arrays.toString(nums));

                for (int i = 0; i < visited.size(); i++) {
                    visited.set(i, false);
                }
                visited.set(0, true);
                countSteps = 0;

                while (countSteps < nums.length) {
                    countSteps++;
                    for (int i = 0; i < nums.length; i++) {
                        if (nums[pos] == i && visited.get(pos) == false) {
                            visited.set(pos, true);
                            pos = i;

                            break;
                        }
                    }
                    if (!visited.contains(false)) {
                        return res;
                    }
                }

                return new int[]{-1, -1};
            }

            for (int i = 1; i < nums.length; i++) {
                if (nums[pos] == i && visited.get(pos) == false) {
                    visited.set(pos, true);
                    pos = i;
                    countSteps++;
//                    System.out.println(visited + "          pos = " + pos  + "   countSteps = " + countSteps + "   changed? = " +changed);
                    break;

                }
            }

            if (!visited.contains(false) && nums[pos] == 1) {
                return res;
            }
        }

//        return res;
    }

    static int searchBadElement(int[] nums) {
        int x = 0;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < nums.length; i++) {
            x = nums[i];
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            }
            if (!map.containsKey(x)) {
                map.put(x, 1);
            }
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                result = entry.getKey();
            }
        }
//        System.out.println(map);
//        System.out.println("result in map = " + result);
        return result;
    }
}

    //фикс баг через подсчет
//    static int searchBadElement(int[] nums) {
//        int[] arrayClean = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            arrayClean[i] = i;
//        }
//        int [] numsOld = Arrays.stream(nums).sorted().toArray();
//        System.out.println(Arrays.toString(arrayClean));
//        System.out.println(Arrays.toString(numsOld));
//        for (int i = 0; i < nums.length; i++) {
//            if (numsOld[i] == arrayClean[i]) {
//                continue;
//            } else {
//                System.out.println("return i = " + i);
//                return i;
//            }
//        }
////        System.out.println("return 0");
//        return 0;
//    }

