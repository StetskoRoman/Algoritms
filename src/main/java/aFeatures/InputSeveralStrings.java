package aFeatures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputSeveralStrings {

    public static void main(String[] args) {
        int k = 0;
        List<List<Integer>> questions = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        while (k < m) {
            List<Integer> line = new ArrayList<>();
            Scanner lineScanner = new Scanner(scanner.nextLine());

            while (lineScanner.hasNext()) {
                line.add(Integer.valueOf(lineScanner.next()));
            }
            k++;
            questions.add(line);
            lineScanner.close();
        }
        scanner.close();
    }

}
