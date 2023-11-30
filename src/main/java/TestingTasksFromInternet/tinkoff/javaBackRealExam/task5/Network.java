package TestingTasksFromInternet.tinkoff.javaBackRealExam.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Network {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        List<List<Integer>> compList = new ArrayList<>();

        int k = 0;
        while (k < n) {
            List<Integer> line = new ArrayList<>();
            Scanner lineScanner = new Scanner(scanner.nextLine());

            while (lineScanner.hasNext()) {
                line.add(Integer.valueOf(lineScanner.next()));
            }
            k++;
            compList.add(line);
            lineScanner.close();
        }

        k = 0;
        List<List<Integer>> serverList = new ArrayList<>();
        while (k < m) {
            List<Integer> line = new ArrayList<>();
            Scanner lineScanner = new Scanner(scanner.nextLine());

            while (lineScanner.hasNext()) {
                line.add(Integer.valueOf(lineScanner.next()));
            }
            k++;
            serverList.add(line);
            lineScanner.close();
        }
        scanner.close();

        serversOrder(serverList, compList);

    }

    public static void serversOrder(List<List<Integer>> servers, List<List<Integer>> computers) {

        int allDistance = 0;
        List<String> strings = new ArrayList<>();
        int k = 0;
        while (k < computers.size()) {
            int minDistance = Integer.MAX_VALUE;
            int positionOfComputerToServer = 0;
            for (int i = 0; i < computers.size(); i++) {
                for (int j = 0; j < servers.size(); j++) {
                    if (distanceBetweenPoints(servers.get(j), computers.get(i)) < minDistance) {
                        minDistance = distanceBetweenPoints(servers.get(j), computers.get(i));
                        positionOfComputerToServer = j;
                    }
                }
                strings.add("s " + (positionOfComputerToServer + 1) + " -> c " + (i+1));
                allDistance += minDistance;
                k++;

            }
        }

        List<Integer> firstServer = new ArrayList<>();
        int minPoint = Integer.MAX_VALUE;
        int firstServerPosition = 0;

        for (int i = 0; i < servers.size(); i++) {
            int mindistance = servers.get(i).get(0) * servers.get(i).get(0) + servers.get(i).get(1) * servers.get(i).get(1);

            if (mindistance < minPoint) {
                minPoint = mindistance;
                firstServerPosition = i;
                firstServer = servers.get(i);
            }
        }

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> previousServer = firstServer;
        int previousServerPosition = firstServerPosition;
        resultList.add(previousServer);

        k = 0;
        while (k < servers.size()-1) {
            int minDistance = Integer.MAX_VALUE;
            int currentPositionOfServer = 0;
            List<Integer> currentServer = new ArrayList<>();

            for (int i = 0; i < servers.size(); i++) {
                if (distanceBetweenPoints(servers.get(i), previousServer) < minDistance && !servers.get(i).equals(previousServer) && !resultList.contains(servers.get(i))) {
                    minDistance = (int) distanceBetweenPoints(servers.get(i), previousServer);
                    currentPositionOfServer = i;
                    currentServer = servers.get(i);
                }
            }

            allDistance+=minDistance;
            resultList.add(currentServer);
            strings.add("s " + (previousServerPosition+1) + " -> s " + (currentPositionOfServer+1));

            previousServer = currentServer;
            previousServerPosition = currentPositionOfServer;
            k++;

        }
        System.out.println((servers.size()+computers.size()-1) + " " + allDistance);
        printResult(strings);

    }

    public static int distanceBetweenPoints(List<Integer> p1, List<Integer> p2) {
        int res = (int) (Math.pow(p1.get(0) - p2.get(0), 2) + Math.pow(p1.get(1) - p2.get(1), 2));
        return res;
    }

    public static void printResult(List<String> resultList) {
        for (String str : resultList) {
            System.out.println(str);
        }
    }

}

//System.out.println("INSIDE cicle " + minDistance + "  + position of server + " + currentPositionOfServer);
//System.out.println(n + "   " + m);
//        System.out.println(compList);
//        System.out.println(serverList);

//  System.out.println("First server i s " + firstServer + "   " + firstServerPosition);

//        while (0 < computers.size()) {
//
//            int minDistance = Integer.MAX_VALUE;
//            int positionOfComputer = 0;
//
//            for (int i = 0; i < computers.size(); i++) {
//                for (int j = 0; j < resultList.size(); j++) {
//                    if (distanceBetweenPoints(resultList.get(j), computers.get(i)) < minDistance) {
//                        minDistance = distanceBetweenPoints(resultList.get(j), computers.get(i));
//                        positionOfComputer = j;
//                    }
//                }
//                resultList.add(positionOfComputer + 1, computers.get(i));
//                computers.remove(computers.get(i));
//            }
//            allDistance += distanceBetweenPoints(resultList.get(positionOfComputer + 1), resultList.get(positionOfComputer));
//        }

// if (servers.get(i).get(0) * servers.get(i).get(0) + servers.get(i).get(1) * servers.get(i).get(1) < minPoint) {

//  if (servers.get(i).get(0) * servers.get(0) + servers.get(1) * servers.get(1) < minPoint) {
//        minPoint = server.get(0) * server.get(0) + server.get(1) * server.get(1);
//        firstServer = servers;
//        }

//    public static List<List<Integer>> serversOrder(List<List<Integer>> servers, List<Integer> firstServer) {
//        int distance = 0;
//        List<List<Integer>> resultList = new ArrayList<>();
//        List<Integer> previousServer = firstServer;
//        resultList.add(previousServer);
//        servers.remove(previousServer);
//        while (0 < servers.size()) {
//
//            int minDistance = Integer.MAX_VALUE;
//            int positionOfServer = 0;
//            for (int i = 0; i < servers.size(); i++) {
//                if (Math.pow(servers.get(i).get(0) - previousServer.get(0), 2) + Math.pow(servers.get(i).get(1) - previousServer.get(1), 2) < minDistance) {
//
//                    minDistance = (int) (Math.pow(servers.get(i).get(0) - previousServer.get(0), 2) + Math.pow(servers.get(i).get(1) - previousServer.get(1), 2));
//                    positionOfServer = i;
//                }
//            }
//            System.out.println("distance between " + minDistance);
//            previousServer = servers.get(positionOfServer);
//            resultList.add(previousServer);
//            servers.remove(previousServer);
//
//
//        }
//
//        return resultList;
//
//    }
