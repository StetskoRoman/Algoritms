package TestingTasksFromInternet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//тут надо было соединить два листа в один в порядке возрастания (не работает, если не отсортированы изначально листы)
public class ExpertTest {
    static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {

        ArrayList<Integer> resListA = new ArrayList<>();
        int indexA = 0;
        int indexB = 0;

        while (indexA<a.size()) {
            if (a.get(indexA) < b.get(indexB)) {
                resListA.add(a.get(indexA));
                indexA++;

                if (indexA >= a.size()) {
                    break;
                }

            } else {

                resListA.add(b.get(indexB));
                indexB++;
                if (indexB >= b.size()) {
                    break;
                }
            }

        }
        while (indexA > indexB) {
            resListA.add(b.get(indexB));
            indexB++;
        }

        while (indexB > indexA) {
            resListA.add(a.get(indexA));
            indexA++;
        }
        a.clear();
        for (Integer number : resListA) {
            a.add(number);
        }
    }
        public static void main(String... args) {


//            ArrayList<Integer> arr1 = (ArrayList<Integer>) List.of(11, 22, 33);
            ArrayList<Integer> arr1 = new ArrayList<>();
            arr1.add(3);
            arr1.add(22);
            arr1.add(23);
            ArrayList<Integer> arr2 = new ArrayList<>();
            arr2.add(4);
            arr2.add(13);
            arr2.add(15);

            merge(arr1,arr2);

            System.out.println("ar 1 = " + arr1);



    }
}
