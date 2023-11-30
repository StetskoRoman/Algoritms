package TestingTasksFromInternet;

import java.util.ArrayList;


public class ExpertTestSecondVers {
    static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {

        int i = a.size() - 1;
        int j = b.size() - 1;
        int m = i + j + 1;

        for (int n = 0; n < b.size(); n++) {
            a.add(0);
        }

        while (j >= 0) {

            if ((i >= 0) && (a.get(i) > b.get(j))) {
                a.set(m, a.get(i));
                i--;
                m--;

            } else {
                a.set(m, b.get(j));
                j--;
                m--;
            }
        }

    }


    public static void main(String... args) {


//            ArrayList<Integer> arr1 = (ArrayList<Integer>) List.of(11, 22, 33);
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(3);
        arr1.add(222);
        arr1.add(233);
        arr1.add(250);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(13);
        arr2.add(144);
        arr2.add(200);

        merge(arr1, arr2);

        System.out.println("ar 1 = " + arr1);
        System.out.println("arr 2 = " + arr2);

    }
}
