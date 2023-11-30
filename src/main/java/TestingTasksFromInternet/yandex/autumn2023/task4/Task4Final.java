package TestingTasksFromInternet.yandex.autumn2023.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Task4Final {

    public static void main(String[] args) throws IOException {

        int n = 0;
        int countS = 0;
        char[] lang = new char[0];
        int[] id = new int[0];

        try (InputStreamReader in = new InputStreamReader(System.in);
             BufferedReader buffer = new BufferedReader(in)) {

            String line;

            while ((line = buffer.readLine()) != null) {
                String[] tokens = line.split(" ");
                if (countS == 0) {
                    n = Integer.parseInt(tokens[0]);
                    countS++;
                    continue;
                }
                if (countS == 1) {
                    lang = new char[n];
                    for (int i = 0; i < n; i++) {
                        lang[i] = tokens[i].charAt(0);
                    }
                    countS++;
                    continue;
                }
                if (countS == 2) {
                    id = new int[2 * (n + 1)];
                    for (int i = 0; i < id.length; i++) {
                        id[i] = Integer.parseInt(tokens[i]);
                    }
                    break;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        int barrier[] = calculateBarriers(id, lang);
        PrintWriter printWriter = new PrintWriter(System.out);

        for (int i = 0; i < barrier.length; i++) {
            result.append(barrier[i] + " ");
        }
        printWriter.print(result);
        printWriter.flush();


    }

    public static int[] calculateBarriers(int[] id, char[] lang) {

        List<Emloyer> empList = new ArrayList<>();
        int level = 1;
        int position = 1;

        for (int i = 0; i < lang.length; i++) {
            empList.add(new Emloyer(0,0, i + 1, lang[i], 0, 0, 0, false, false));
        }

        for (int i = position; i < id.length; i++) {

            for (int j = 0; j < empList.size(); j++) {
                if (i < id.length - 1) {
                    if (id[i + 1] == id[i] && empList.get(j).id == id[i]) {

                        empList.get(j).firstOccur = i;
                        empList.get(j).lastOccur = i + 1;
                        empList.get(j).position = position;
                        empList.get(j).level = level;
                        position++;
                        i++;

                        break;
                    }
                }

                if (empList.get(j).id == id[i] && empList.get(j).isActive == false) {
                    empList.get(j).isBoss = true;
                    empList.get(j).position = position;
                    empList.get(j).level = level;
                    empList.get(j).isActive = true;
                    empList.get(j).firstOccur = i;

                    position++;
                    level++;
                    break;
                }

                if (empList.get(j).id == id[i] && empList.get(j).isActive == true) {
                    empList.get(j).lastOccur = i;
                    level--;
                    break;
                }
            }
        }

        empList.add(0, new Emloyer(0, (id.length-1), 0, '0', 0, 0, 0, true, true));
        int[] barrier = new int[lang.length];

        for (int i = 1; i < empList.size(); i++) {

            for (int j = i; j >= 0; j--) {

                if (empList.get(j).level < empList.get(i).level &&
                        empList.get(j).position < empList.get(i).position &&
                        empList.get(j).isBoss &&
                        empList.get(j).lastOccur > empList.get(i).firstOccur &&
                        empList.get(j).lang == empList.get(i).lang) {

                    empList.get(i).barrier = empList.get(i).level - empList.get(j).level - 1;

                    barrier[(empList.get(i).id - 1)] = empList.get(i).level - empList.get(j).level - 1;
                    break;

                } else {
                    empList.get(i).barrier = empList.get(i).level - 1;
                    barrier[(empList.get(i).id - 1)] = empList.get(i).level - 1;
                }
            }
        }

        for (int i = 0; i < empList.size(); i++) {
            System.out.println(empList.get(i));
        }
        System.out.println();

        return barrier;
    }
}

class Emloyer {

    public Emloyer(int firstOccur, int lastOccur, int id, char lang, int position, int level, int barrier, boolean isActive, boolean isBoss) {
        this.firstOccur = firstOccur;
        this.lastOccur = lastOccur;
        this.id = id;
        this.lang = lang;
        this.position = position;
        this.level = level;
        this.barrier = barrier;
        this.isActive = isActive;
        this.isBoss = isBoss;
    }
    int firstOccur;

    int lastOccur;
    int id;
    char lang;
    int position;
    int level;
    int barrier;
    boolean isActive;
    boolean isBoss;

    @Override
    public String toString() {
        return "Emloyer{" +
                "firstOccur=" + firstOccur +
                ", lastOccur=" + lastOccur +
                ", id=" + id +
                ", lang=" + lang +
                ", position=" + position +
                ", level=" + level +
                ", barrier=" + barrier +
                ", isActive=" + isActive +
                ", isBoss=" + isBoss +
                '}';
    }
}
