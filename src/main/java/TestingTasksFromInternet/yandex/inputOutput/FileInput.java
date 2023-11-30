package TestingTasksFromInternet.yandex.inputOutput;

import java.io.*;
import java.net.URL;
import java.util.Properties;

public class FileInput {




    public static void main(String[] args) throws IOException {


        String pathOutput = "output.txt";
//        File file = new File(pathInput);
//
//        File fileResult = new File(pathOutput);
        File directory = new File("./");

        System.out.println(directory.getAbsolutePath());
//        String pathInput = directory.getAbsolutePath() + "input.txt";
        String pathInput = "src/main/java/TestingTasksFromInternet/yandex/inputOutput/input.txt";
        System.out.println(pathInput);



        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathInput));
             PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")))) {

            Integer a = Integer.valueOf(bufferedReader.readLine());
            Integer b = Integer.valueOf(bufferedReader.readLine());
            System.out.println(a);
            System.out.println(b);
        }



    }
}
