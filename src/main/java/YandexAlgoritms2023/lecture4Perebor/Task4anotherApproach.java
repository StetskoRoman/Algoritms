package YandexAlgoritms2023.lecture4Perebor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Task4anotherApproach
{

    // Function to find the minimum weight
    // Hamiltonian Cycle
    static int tsp(int[][] graph, boolean[] v,
                   int currPos, int n,
                   int count, int cost, int ans, int prev)
    {
        int beforePrev = prev;

        // If last node is reached and it has a link
        // to the starting node i.e the source then
        // keep the minimum value out of the total cost
        // of traversal and "ans"
        // Finally return to check for more possible values
        if (count == n && graph[currPos][0] > 0)
        {
            ans = Math.min(ans, cost + graph[currPos][0]);
            return ans;
        }

        // BACKTRACKING STEP
        // Loop to traverse the adjacency list
        // of currPos node and increasing the count
        // by 1 and cost by graph[currPos,i] value
        for (int i = 0; i < n; i++)
        {
            if (v[i] == false && graph[currPos][i] > 0)
            {

                // Mark as visited
                v[i] = true;
                prev = currPos;
                ans = tsp(graph, v, i, n, count + 1,
                        cost + graph[currPos][i], ans, prev);

                // Mark ith node as unvisited
                v[i] = false;
            }
//my
//            if (i == n - 1 && v[i] == false) {
//                ans = tsp(graph, v, prev, n, count,
//                        cost + graph[currPos][prev], ans, beforePrev);
//            }

        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        int countLine = 0;
        int n = 0;
        int[][] matrix = new int[0][0];


        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(" ");

                if (countLine == 0) {
                    n = Integer.parseInt(tokens[0]);
                    matrix = new int[n][n];
                    countLine++;
                    continue;
                }
                if (countLine <= n) {
                    for (int i = 0; i < matrix[countLine - 1].length; i++) {
                        matrix[countLine - 1][i] = Integer.parseInt(tokens[i]);
                    }
                    countLine++;
                    if (countLine == n + 1) {
                        break;
                    }
                }
            }
        }
                boolean[] v = new boolean[n];

        // Mark 0th node as visited
        v[0] = true;
        int ans = Integer.MAX_VALUE;

        // Find the minimum weight Hamiltonian Cycle
        ans = tsp(matrix, v, 0, n, 1, 0, ans, 0);

        // ans is the minimum weight Hamiltonian Cycle
        System.out.println(ans);
    }
}
    // Driver code
//    public static void main(String[] args)
//    {
//
//        // n is the number of nodes i.e. V
//        int n = 4;
//
//        int[][] graph = {{0, 10, 15, 20},
//                {10, 0, 35, 25},
//                {15, 35, 0, 30},
//                {20, 25, 30, 0}};
//
//        // Boolean array to check if a node
//        // has been visited or not
//        boolean[] v = new boolean[n];
//
//        // Mark 0th node as visited
//        v[0] = true;
//        int ans = Integer.MAX_VALUE;
//
//        // Find the minimum weight Hamiltonian Cycle
//        ans = tsp(graph, v, 0, n, 1, 0, ans);
//
//        // ans is the minimum weight Hamiltonian Cycle
//        System.out.println(ans);
//    }

