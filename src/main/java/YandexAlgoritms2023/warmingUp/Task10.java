package YandexAlgoritms2023.warmingUp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Task10 {

    public static void main(String[] args) throws IOException {

        int countLine = 0;
        int t = 0;

        PrintWriter printWriter = new PrintWriter(System.out);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            long n = 0;
            long a = 0;
            long b = 0;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    t = Integer.parseInt(tokens[0]);
                    countLine++;
                    continue;
                }

                if (countLine <= t) {
                    n = Long.parseLong(tokens[0]);
                    a = Long.parseLong(tokens[1]);
                    b = Long.parseLong(tokens[2]);

                    printWriter.println(solution(n, a, b));

                    countLine++;
                    if (countLine > t) {
                        break;
                    }
                }
            }
        }
        printWriter.flush();

    }

    static String solution(long n, long a, long b) {

        long ost = n % a;
        long delta = b - a;
        long nGroups = n / a;

        if (ost <= delta * nGroups) {
            return "YES";
        }
        return "NO";
    }
}


//    System.out.println("ost = " + ost + "   ngroups = " + nGroups);