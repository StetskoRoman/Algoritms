package YandexAlgoritms2023.lecture3WaysGraph;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
/**
 * By: Rajan Parmar
 * At : HackerRank
 **/
public class Task3Prepeared {
    // node ,pair ( neighbor , cost)
//    static HashMap < Integer , HashSet <Pair>> node;
//    static PrintWriter w;
//    public static void main(String [] s) throws Exception{
//        InputReader in;
//
//        boolean online = false;
//        String fileName = "input";
//
//        node = new HashMap<Integer, HashSet<Pair>>();
//
//
//        //ignore online if false it is for online competition
//        if (online) {
//
//            //ignore
//            in = new InputReader(new FileInputStream(
//                    new File(fileName + ".txt")));
//            w = new PrintWriter(new FileWriter(fileName + "Output.txt"));
//        } else {
//
//            // for fast input output . You can use any input method
//            in = new InputReader(System.in);
//            w = new PrintWriter(System.out);
//        }
//
//        // Actual code starts here
//        int t;
//        int n, m;
//        t = in.nextInt();
//
//        while(t-- > 0){
//            n = in.nextInt();
//            m = in.nextInt();
//            while(m-- > 0){
//                int x,y,cost;
//                x = in.nextInt();
//                y = in.nextInt();
//                cost = in.nextInt();
//
//                if(node.get(x)==null){
//                    node.put(x, new HashSet());
//                    node.get(x).add(new Pair(y,cost));
//                }
//                else{
//                    node.get(x).add(new Pair(y,cost));
//                }
//                if(node.get(y)==null){
//                    node.put(y, new HashSet());
//                    node.get(y).add(new Pair(x,cost));
//                }
//                else{
//                    node.get(y).add(new Pair(x,cost));
//                }
//            }
//            int source = in.nextInt();
//            Dijkstra(source,n);
//            node.clear();
//            System.out.println("");
//        }
//    }
//
//    static void Dijkstra(int start , int n) {
//
//        int dist[] = new int[3001];
//        int visited[] = new int[3001];
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        Arrays.fill(visited, 0);
//        dist[start] = 0 ;
//        PriorityQueue < Pair > pq = new PriorityQueue();
//
//        //this will be prioritized according to VALUES (i.e cost in class Pair)
//        pq.add(new Pair(start , 0));
//        while(!pq.isEmpty()){
//            Pair pr = pq.remove();
//            visited[pr.neighbor] = 1;
//            for(Pair p:node.get(pr.neighbor)){
//                if(dist[p.neighbor] > dist[pr.neighbor] + p.cost){
//                    dist[p.neighbor] = dist[pr.neighbor] + p.cost;
//
//                    //add updates cost to vertex through start vertex
//                    if(visited[p.neighbor]==0)
//                        pq.add(new Pair(p.neighbor ,dist[p.neighbor] ));
//                }
//
//            }
//        }
//        for(int i=1;i<=n;i++){
//            if(i==start) continue;
//            if(visited[i]==0)
//                dist[i]=-1;
//            System.out.print(dist[i]+" ");
//        }
//    }

//    static class Pair implements Comparable {
//
//        int neighbor;
//        int cost;
//
//        public Pair(int y, int cost) {
//            // TODO Auto-generated constructor stub
//            neighbor = y;
//            this.cost = cost;
//        }
//
//        @Override
//        public int compareTo(Object o) {
//            // TODO Auto-generated method stub
//            Pair pr = (Pair)o;
//
//            if(cost > pr.cost)
//                return 1;
//            else
//                return -1;
//
//        }
//
//    }

    //Ignore this class , it is for fast input.
    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;

        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}