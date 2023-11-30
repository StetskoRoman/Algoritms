package YandexAlgoritms2023.lecture3WaysGraph;

import com.sun.jdi.Value;
import javafx.util.Pair;
//import javafx.util.Pair;
import java.util.Comparator;
import java.util.TreeSet;


public class test3New {

    public static void main(String[] args) {
//        Pair<Key Type, Value Type> var_name = new Pair<>(key, value);
//         Pair pair = new Pa
//        Pair<String, Integer> agePair = new Pair<>("Alice", 25);.
        Pair<Integer, Integer> pair4 = new Pair<>(15, 40);
        Pair<Integer, Integer> pair1 = new Pair<>(13, 25);
        Pair<Integer, Integer> pair2 = new Pair<>(13, 33);
        Pair<Integer, Integer> pair3 = new Pair<>(15, 20);
//        System.out.println(pair1);
//        System.out.println(pair1.getKey());
//        System.out.println(pair1.getValue());
        TreeSet<Pair<Integer, Integer>> treeSet = new TreeSet<>(Comparator
                .comparingInt(Pair<Integer, Integer>::getKey)
                .thenComparing(Pair::getValue));
        treeSet.add(pair2);
        treeSet.add(pair3);
        treeSet.add(pair4);
        treeSet.add(pair1);
        System.out.println(treeSet);
        System.out.println(treeSet.pollFirst());
        System.out.println(treeSet);
    }
}
