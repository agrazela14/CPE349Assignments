import java.io.*;
import java.util.*;
import java.lang.*;

public class GameProblem {
    public static void main(String args[]) throws FileNotFoundException{
        Scanner in = new Scanner(System.in), fScan;
        int grid[][], rows, cols;
        String filename;

        System.out.println("Enter in the input filename: ");
        filename = in.nextLine();
        fScan = new Scanner(new File(filename));

        rows = fScan.nextInt();
        cols = fScan.nextInt();
        grid = new int[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                grid[i][j] = fScan.nextInt();
            }
        }
        game(rows, cols, grid);
    }

    public static void game(int n, int m, int[][] A) {
        int S[][] = new int[n][m];
        char R[][] = new char[n][m];

        for(int i = n-1; i >= 0; i--) {
            for(int j = m-1; j >= 0; j--) {
                //The lower right most element
                if(i == n-1 && j == m-1) {
                    S[i][j] = A[i][j];
                    R[i][j] = 'e';
                }
                //In the lowest row
                else if(i == n-1) {
                    if(compare(0, S[i][j + 1]) > 0) {
                        S[i][j] = A[i][j];
                        R[i][j] = 'e';
                    }
                    else {
                        S[i][j] = A[i][j] + S[i][j + 1];
                        R[i][j] = 'r';
                    }
                }
                //In the rightmost column
                else if(j == m-1) {
                    if(compare(0, S[i + 1][j]) > 0) {
                        S[i][j] = A[i][j];
                        R[i][j] = 'e';
                    }
                    else {
                        S[i][j] = A[i][j] + S[i + 1][j];
                        R[i][j] = 'd';
                    }
                }
                //A standard element with something below and to the right
                else {
                    if(compare(S[i][j + 1],S[i + 1][j]) > 0) {
                        S[i][j] = S[i][j + 1] + A[i][j];
                        R[i][j] = 'r'; 
                    }
                    else {
                        S[i][j] = S[i + 1][j] + A[i][j];
                        R[i][j] = 'd'; 
                    }
                }
            }
        } 
        //Now we know all the S values, we need the largest and the route to it
        int max = S[0][0];
        int maxI = 0;
        int maxJ = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("S["+ i + ", " + j + "] = " + S[i][j]);
                System.out.print("    A["+ i + ", " + j + "] = " + A[i][j]);
                System.out.println("    R["+ i + ", " + j + "] = " + R[i][j]);
                if (max < S[i][j]) {
                    max = S[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        System.out.println("Best score: " + max); 
    }

    private static int compare(int num1, int num2) {
    
        if(num1 < num2) {
            return -1;
        }
        else if(num2 < num1) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
