

// Задача 11
// Реализовать волновой алгоритм

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class App_11 {
    public static void main(String[] args) {

        int[][] labirinth = new int[10][10];
        // int [][] labirinth = {{5,7,3,17}, {7,0,1,12}, {8,1,2,3}}; //3 4
        System.out.println(labirinth.length);
        System.out.println(labirinth[0].length);

        createMatrix(labirinth);
        printMatrix(labirinth);
        System.out.println();
        System.out.println();
        int startX = 0;
        int startY = 0;
        int finishX = 9;
        int finishY = 9;
        getShortWay(labirinth, startX, startY, finishX, finishY);
        printMatrix(labirinth);
        int[][] route = getRouteCoord(labirinth, startX, startY, finishX, finishY);
        System.out.println("The route: ");
        System.out.println(Arrays.deepToString(route));
        // System.out.println(Arrays.deepToString(route).replace("], ", "]\n"));
    }

    public static void printMatrix(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                // if (map[i][j] == 99) {
                //     System.out.print("#  ");
                // } else if (map[i][j] <= 0) {
                //     System.out.print("   ");
                // } else {
                //     System.out.print(".  ");
                // } 

                // System.out.print(map[i][j] + " ");
                // System.out.print(map[i][j] + "\t");
                System.out.printf("%5d", map[i][j]);
            }
            System.out.println();
        }
    }

    public static int generateRandomInt(int upperRange) {
        Random random = new Random();
        int x = random.nextInt(upperRange);
        return x;
    }

    public static void createMatrix(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == 0 || i == map.length - 1 || j == 0 || j == map[0].length - 1) {
                    map[i][j] = 1;
                }
            }
        }
        for (int i = 1; i < map.length - 1; i++) {
            // for (int j = 1; j < map[i].length - 1; j++) {
            map[i][generateRandomInt(map[i].length - 2)] = 99;
            map[i][generateRandomInt(map[i].length - 2)] = 99;
            // }
        }
        map[1][1] = 0;
        map[2][1] = 0;
        map[5][7] = 0;
    }

    static void getShortWay(int[][] map, int sX, int sY, int finishX, int finishY) {
        int start = 1;
        int finish = -1;
        map[sX][sY] = start;
        map[finishX][finishY] = -1;
        Queue<Integer> path = new LinkedList<>();
        // ArrayList<Integer> coordinates = new ArrayList<>(2);
        path.add(sX); // add startX coordinate to the array
        path.add(sY); // add startY coordinate to the array
        // coordinates.clear();
        while (map[finishX][finishY] == finish) {
            sX = path.poll();
            sY = path.poll();
            if (0 <= (sY + 1) && (sY + 1) < map[sX].length && map[sX][sY + 1] <= 0) {
                map[sX][sY + 1] = map[sX][sY] + 1;
                path.add(sX);
                path.add(sY + 1);
            }
            if (0 <= (sX + 1) && (sX + 1) < map.length && map[sX + 1][sY] <= 0) {
                map[sX + 1][sY] = map[sX][sY] + 1;
                path.add(sX + 1);
                path.add(sY);
            }
            if (0 <= (sY - 1) && (sY - 1) < map[sX].length && map[sX][sY - 1] <= 0) {
                map[sX][sY - 1] = map[sX][sY] + 1;
                path.add(sX);
                path.add(sY - 1);
            }
            if (0 <= (sX - 1) && (sX - 1) < map.length && map[sX - 1][sY] <= 0) {
                map[sX + 1][sY] = map[sX][sY] + 1;
                path.add(sX - 1);
                path.add(sY);
            }
        }
    }

    static int[][] getRouteCoord(int[][] map, int sX, int sY, int finX, int finY) {
        int finish = map[finX][finY];
        int[][] pathRoute = new int[finish][2];
        while (finish>=1) {
            pathRoute[finish - 1][0] = finX;
            pathRoute[finish - 1][1] = finY;

            if (0 <= (finY + 1) && (finY + 1) < map[sX].length && map[finX][finY + 1] == finish - 1) {
                finY = finY + 1;
            } else if (0 <= (finX + 1) && (finX + 1) < map.length && map[finX + 1][finY] == finish - 1) {
                finX = finX + 1;
            } else if (0 <= (finY - 1) && (finY - 1) < map[sX].length && map[finX][finY - 1] == finish - 1) {
                finY = finY - 1;
            } else if (0 <= (finX - 1) && (finX - 1) < map.length && map[finX - 1][finY] == finish - 1) {
                finX = finX - 1;
            }
            finish--;
        }

        return pathRoute;
    }
}


