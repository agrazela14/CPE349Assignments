import java.util.*
import java.io.*
import java.lang.*


public class FactorProblem {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in), fileReader;
        String filename;
        int rowsA, rowsB, colsA, colsB;
        int S[][], T[][], min[][], j, e1, e2, x1, x2;

        System.out.println("Enter in the input filename");
        filename = in.nextLine();
        fileReader = new Scanner(new File(filename));
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

        min = twoLineFactory(min, T, S, e1, e2, x1, x2, j);
        printResults(min, x1, x2);
    }

    private static int[][] twoLineFactory(int[][] T, int[][] S, int e1, int e2, int x1, int x2, int j) {
        int [][] min = new int[2][j];
        min[0][0] = e1 + S[0][0]; 
        min[1][0] = e2 + S[1][0]; 

        for (int i = 1; i < j; i++) {
            min[0][i] = compare(min[0][i - 1] + S[0][i], min[1][i - 1] + T[1][i - 1] + S[0][i]);
            min[1][i] = compare(min[1][i - 1] + S[1][i], min[0][i - 1] + T[0][i - 1] + S[1][i]);
        }
        return min;
    }


    private static int compare(int x, int y) {
        if (x > y) {
            return x;
        }
        return y;
    }

    print

}
