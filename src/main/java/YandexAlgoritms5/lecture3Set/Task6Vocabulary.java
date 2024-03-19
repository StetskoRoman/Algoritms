package YandexAlgoritms5.lecture3Set;
/**сократить слова к словарным если возможно
 * a b
 * abdafb basrt casds dsasa a
 * otvet: a b casds dsasa a
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class Task6Vocabulary {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int n = 0;

        Set<String> vocabulary = new HashSet<>();
        List<String> text = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String[] tokens = line.split(" ");

            if (countLine == 0) {
                for (int i = 0; i < tokens.length; i++) {
                    vocabulary.add(tokens[i]);
                }
                countLine++;
                continue;
            }

            if (countLine == 1) {
                for (int i = 0; i < tokens.length; i++) {
                    text.add(tokens[i]);
                }
                countLine++;
                if (countLine == 2) {
                    break;
                }
                continue;
            }
        }
        bufferedReader.close();

//        System.out.println(vocabulary + "  " + text);

        List<String> res = solution(text, vocabulary);
        PrintWriter printWriter = new PrintWriter(System.out);
        for (int i = 0; i < res.size(); i++) {
            printWriter.print(res.get(i) + " ");
        }
        printWriter.flush();
    }

    static List<String> solution(List<String> text, Set<String> vocabulary) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < text.size(); i++) {
            char[] chars = text.get(i).toCharArray();
            StringBuilder sb = new StringBuilder();
            boolean existInVocabulary = false;
            for (int j = 0; j < chars.length; j++) {
                sb.append(chars[j]);
                if (vocabulary.contains(String.valueOf(sb))) {
                    result.add(String.valueOf(sb));
                    existInVocabulary = true;
                    break;
                }
            }
//            System.out.println(existInVocabulary);
            if (existInVocabulary == false) {
                result.add(String.valueOf(sb));
            }

        }

        return result;
    }
}
