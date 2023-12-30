package TestingTasksFromInternet.yandex.yandexWinterAnalis.task5;

import java.util.*;

public class Task5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        List<long[]> resList = solution(n);
//        System.out.println(Arrays.toString(solution(n).get(0)));


//        System.out.println(toResult(resList));
        long[] result = toResult(resList);
//        System.out.println(result[0] + " " + result[1]+ "   " + (double)result[0]/(double) result[1]);
        System.out.println(result[0] + " " + result[1]);

    }



    static List<long[]> solution(long n) {

//        long pos1Top = 1;
//        long pos2Top = 2;
//        long pos3Top = 6;

        long pos1Bot = 2;
        long pos2Bot = 3;
        long pos3Bot = 7;

        int counting = 1;

        long currentProbTop = 0;
        long currentProbBot = 0;

        List<long[]> list = new ArrayList<>();
        list.add(new long[]{2, 7});

        long futureNotAllTop = 1;
        long futureNotAllBot = 1;

        while (counting < n) {

            long probAllWhiteTop = 12l;
            long probAllWhiteBot = pos1Bot * pos2Bot * pos3Bot;
            long nokprobBefore = nokCounting(probAllWhiteBot, probAllWhiteTop);
            probAllWhiteTop /= nokprobBefore;
            probAllWhiteBot /= nokprobBefore;
//            System.out.println(probAllWhiteTop + "     " + probAllWhiteBot);
//Здесь 5/7
            long probNotAllWhiteTop = probAllWhiteBot - probAllWhiteTop;
            long probNotAllWhiteBot = probAllWhiteBot;
            long nokNotAll = nokCounting(probNotAllWhiteBot, probNotAllWhiteTop);
            probNotAllWhiteBot /= nokNotAll;
            probNotAllWhiteTop /= nokNotAll;
//            System.out.println(probAllWhiteTop + "    tut probNotAllWhite after Nok  " + probNotAllWhiteBot);

            pos1Bot++;
            pos2Bot++;
            pos3Bot++;

            probAllWhiteTop = 12l;
            probAllWhiteBot = pos1Bot * pos2Bot * pos3Bot;
            long nokProbAfter = nokCounting(probAllWhiteBot, probAllWhiteTop);
//            здесь 1/8
            probAllWhiteTop /= nokProbAfter;
            probAllWhiteBot /= nokProbAfter;

            futureNotAllTop *= probNotAllWhiteTop;
            futureNotAllBot *= probNotAllWhiteBot;
            long nokFuture = nokCounting(futureNotAllBot, futureNotAllTop);
            futureNotAllTop /= nokFuture;
            futureNotAllBot /= nokFuture;
//            System.out.println("future NotAll = " + futureNotAllTop + "  future bot = " + futureNotAllBot);

            long addTop = futureNotAllTop * probAllWhiteTop;
            long addBot = futureNotAllBot * probAllWhiteBot;
            long nokBeforeAdd = nokCounting(addTop, addBot);
            addTop/=nokBeforeAdd;
            addBot /= nokBeforeAdd;
            list.add(new long[]{addTop, addBot});

            counting++;
//            System.out.println("counting = "+ counting + "  nokbeforeAdd = " + nokBeforeAdd  + "  addTop = " + addTop + "  addBot= " + addBot );

        }

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(Arrays.toString(list.get(i)));
//        }

        return list;
    }

    static long[] toResult(List<long[]> list) {

        long m = list.get(0)[0];
        long n = list.get(0)[1];
        long[] res = {m, n};
        for (int i = 1; i < list.size(); i++) {
            res = sumFraction(res[0], res[1], list.get(i)[0], list.get(i)[1]);
//            System.out.println("res = " + res[0] + "  " + res[1]);
        }

        return res;
    }

    public static long[] sumFraction(long a, long b, long c, long d) {
        long[] result = new long[2];
        long m = a * d + c * b;
        long n = b * d;
        long nok = nokCounting(m, n);
        result[0] = m / nok;
        result[1] = n / nok;
        return result;
    }

    static long nokCounting(long m, long n) {
        long big; long low;
        if (m > n) {
            big = m;
            low = n;
        } else {
            big = n;
            low = m;
        }

        long nok = 1;
        long remainder = -1;
        while (remainder != 0) {

            remainder = big % low;
            if (remainder == 0) {
                nok = low;
                return nok;
            } else {
                big = low;
                low = remainder;
            }
        }

        return 1;
    }
}


//+ "   " + (double)result[0]/(double) result[1]


//    static long[] toResult(List<long[]> list) {
//        System.out.println("size = " + list.size());
//
//        long top = 0l;
//        long multiplyBot = 1;
//        for (int i = 0; i < list.size(); i++) {
//            multiplyBot *= list.get(i)[1];
//        }
//        for (int i = 0; i < list.size(); i++) {
//            top += list.get(i)[0] * multiplyBot / list.get(i)[1];
//        }
//        long nok = nokCounting(multiplyBot, top);
//        top/= nok;
//        multiplyBot /= nok;
//        System.out.println("top = " + top + "  bot = " + multiplyBot + "  nok = " + nok + " final res = " + (double) ((double)top/(double) multiplyBot));
//
//        return null;
//    }