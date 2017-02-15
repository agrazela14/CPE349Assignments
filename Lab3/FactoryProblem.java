import java.util.*;
import java.io.*;
import java.lang.*;

public class FactoryProblem {
    public static void main(String args[]) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        String filename;
        int rowsA, rowsB, colsA, colsB;
        int S[][], T[][], min[][], j, e1, e2, x1, x2;

        System.out.println("Enter in the input filename");
        filename = in.nextLine();

        Scanner fileReader = new Scanner(new File(filename));

        j = fileReader.nextInt();
        e1 = fileReader.nextInt();
        e2 = fileReader.nextInt();
        x1 = fileReader.nextInt();
        x2 = fileReader.nextInt();

        S = new int[2][j];
        T = new int[2][j - 1];
        min = new int[2][j];

        for (int i = 0; i < j; i++) {
            S[0][i] = fileReader.nextInt();
        }
        for (int i = 0; i < j; i++) {
            S[1][i] = fileReader.nextInt();
        }

        for (int i = 0; i < j - 1; i++) {
            T[0][i] = fileReader.nextInt();
        }
        for (int i = 0; i < j - 1; i++) {
            T[1][i] = fileReader.nextInt();
        }

        twoLineFactory(T, S, e1, e2, x1, x2, j);
    }

    private static void twoLineFactory(int[][] T, int[][] S, int e1, int e2, int x1, int x2, int j) {
        int [][] min = new int[2][j + 1];
        int [][] route = new int[2][j + 1];
        min[0][0] = e1 + S[0][0]; 
        min[1][0] = e2 + S[1][0]; 

        for (int i = 1; i < j; i++) {
            min[0][i] = compare(min[0][i - 1] + S[0][i], min[1][i - 1] + T[1][i - 1] + S[0][i], route, i - 1, 0);
            min[1][i] = compare(min[0][i - 1] + T[0][i - 1] + S[1][i], min[1][i - 1] + S[1][i], route, i - 1, 1);
        }
        min[0][j] = min[0][j - 1] + x1;
        min[1][j] = min[1][j - 1] + x2;

        printResults(min, route);
    }
    //route array 1 column 0s and 1s for which way it went
    //Other column is just index
    private static int compare(int x, int y, int[][] route, int index, int lineNum) {
        if (x < y) {
            route[lineNum][index] = 0; 
            return x;
        }
        route[lineNum][index] = 1; 
        return y;
    }

    private static void printResults(int[][] min, int[][] route) {
        int j = min[0].length - 1;
        int routeLine = (min[0][j] < min[1][j]) ? 0 : 1;
        int optimalTime = (min[0][j] < min[1][j]) ? min[0][j] : min[1][j];
        int[] LineNumbers = new int[j];
        LineNumbers[0] = routeLine + 1;

        for (int i = j - 1; i > 0; i--) {
            if (route[routeLine][i] == 0) {
                LineNumbers[(i)] = 1;
                routeLine = 0;
            }
            else {
                LineNumbers[(i)] = 2;
                routeLine = 1;
            }
        }

        System.out.println("The optimal solution is " + optimalTime + "\n");
        System.out.println("The optimal route is:");

        for (int i = 0; i < LineNumbers.length; i++) {
            System.out.println("station " + (i + 1) + ", line " + LineNumbers[i]);
        }
    }
}
