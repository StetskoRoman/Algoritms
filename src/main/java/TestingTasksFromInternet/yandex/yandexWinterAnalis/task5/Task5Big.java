package TestingTasksFromInternet.yandex.yandexWinterAnalis.task5;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task5Big {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();


        List<BigInteger[]> resList = solution(n);
        //
//        System.out.println(Arrays.toString(solution(n).get(0)));


//        System.out.println(toResult(resList));
        BigInteger[] result = toResult(resList);
        System.out.println(result[0] + " " + result[1]);

    }



    static List<BigInteger[]> solution(long n) {

        BigInteger pos1Bot = new BigInteger("2");
        BigInteger pos2Bot = new BigInteger("3");;
        BigInteger pos3Bot = new BigInteger("7");;

        int counting = 1;

        long currentProbTop = 0;
        long currentProbBot = 0;

        List<BigInteger[]> list = new ArrayList<>();
        list.add(new BigInteger[]{new BigInteger("2"), new BigInteger("7")});

        BigInteger futureNotAllTop = new BigInteger("1");
        BigInteger futureNotAllBot = new BigInteger("1");

        while (counting < n) {

            BigInteger probAllWhiteTop = new BigInteger("12");
            BigInteger probAllWhiteBot = (pos1Bot.multiply(pos2Bot)).multiply(pos3Bot);
            BigInteger nokprobBefore = nokCounting(probAllWhiteBot, probAllWhiteTop);

            probAllWhiteTop = probAllWhiteTop.divide(nokprobBefore);
            probAllWhiteBot = probAllWhiteBot.divide(nokprobBefore);
//            System.out.println(probAllWhiteTop + "     " + probAllWhiteBot);
//Здесь 5/7
            BigInteger probNotAllWhiteTop = probAllWhiteBot.subtract(probAllWhiteTop);
            BigInteger probNotAllWhiteBot = probAllWhiteBot;
            BigInteger nokNotAll = nokCounting(probNotAllWhiteBot, probNotAllWhiteTop);
            probNotAllWhiteBot = probNotAllWhiteBot.divide(nokNotAll) ;
            probNotAllWhiteTop = probNotAllWhiteTop.divide(nokNotAll) ;
//            System.out.println(probAllWhiteTop + "    tut probNotAllWhite after Nok  " + probNotAllWhiteBot);

            pos1Bot = pos1Bot.add(new BigInteger("1"));
            pos2Bot = pos2Bot.add(new BigInteger("1"));
            pos3Bot = pos3Bot.add(new BigInteger("1"));

            probAllWhiteTop = new BigInteger("12");
            probAllWhiteBot = (pos1Bot.multiply(pos2Bot)).multiply(pos3Bot);
            BigInteger nokProbAfter = nokCounting(probAllWhiteBot, probAllWhiteTop);
//            здесь 1/8
            probAllWhiteTop = probAllWhiteTop.divide(nokProbAfter) ;
            probAllWhiteBot = probAllWhiteBot.divide(nokProbAfter);

            futureNotAllTop = futureNotAllTop.multiply(probNotAllWhiteTop) ;
            futureNotAllBot = futureNotAllBot.multiply(probNotAllWhiteBot);
            BigInteger nokFuture = nokCounting(futureNotAllBot, futureNotAllTop);
            futureNotAllTop = futureNotAllTop.divide(nokFuture) ;
            futureNotAllBot = futureNotAllBot.divide(nokFuture);
//            System.out.println("future NotAll = " + futureNotAllTop + "  future bot = " + futureNotAllBot);

            BigInteger addTop = futureNotAllTop.multiply(probAllWhiteTop);
            BigInteger addBot = futureNotAllBot.multiply(probAllWhiteBot) ;
            BigInteger nokBeforeAdd = nokCounting(addTop, addBot);
            addTop = addTop.divide(nokBeforeAdd);
            addBot = addBot.divide(nokBeforeAdd) ;
            list.add(new BigInteger[]{addTop, addBot});

            counting++;
//            System.out.println("counting = "+ counting + "  nokbeforeAdd = " + nokBeforeAdd  + "  addTop = " + addTop + "  addBot= " + addBot );

        }

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(Arrays.toString(list.get(i)));
//        }

        return list;
    }

    static BigInteger[] toResult(List<BigInteger[]> list) {

        BigInteger m = list.get(0)[0];
        BigInteger n = list.get(0)[1];
        BigInteger[] res = {m, n};
        for (int i = 1; i < list.size(); i++) {
            res = sumFraction(res[0], res[1], list.get(i)[0], list.get(i)[1]);
//            System.out.println("res = " + res[0] + "  " + res[1]);
        }

        return res;
    }

    public static BigInteger[] sumFraction(BigInteger a, BigInteger b, BigInteger c, BigInteger d) {
        BigInteger[] result = new BigInteger[2];
        BigInteger m = (a.multiply(d)).add(c.multiply(b));
        BigInteger n = b.multiply(d);
        BigInteger nok = nokCounting(m, n);
        result[0] = m.divide(nok);
        result[1] = n.divide(nok);
        return result;
    }

    static BigInteger nokCounting(BigInteger m, BigInteger n) {
        BigInteger big; BigInteger low;
        if (m.compareTo(n) > 0) {
            big = m;
            low = n;
        } else {
            big = n;
            low = m;
        }

        BigInteger nok = new BigInteger("1");
        BigInteger remainder = new BigInteger("-1");
        while ( remainder.compareTo(BigInteger.ZERO)!=0) {

            remainder = big.mod(low);
            if (remainder.compareTo(BigInteger.ZERO) == 0) {
                nok = low;
                return nok;
            } else {
                big = low;
                low = remainder;
            }
        }

        return new BigInteger("1");
    }
}


// System.out.println("big = " + big);
//         System.out.println("low = " + low);

//            System.out.println("1t nok " + nokprobBefore);
//                    System.out.println("1t top = " + probAllWhiteTop);
//                    System.out.println("1t bot = " + probAllWhiteBot);
