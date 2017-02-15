import java.io.*;

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
                grid[i][j] = in.nextInt();
            }
        }
        game(rows, cols, grid);
    }

    public static void game(int n, int m, int[][] A) {
        int S[][] = new int[n][m];
        char R[][] = new int[n][m];

        for(int i = n-1; i >= 0; i--) {
            for(int j = m-1; j >= 0; j--) {
                if(i == n-1 && j == m-1) {
                    S[i][j] = A[i][j];
                    R[i][j] = 'e';
                }
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
                else {
                    if(compare(S[i + 1][j],S[i][j + 1]) > 0) {

                    }
                    else {

                    }
                }
            }
        } 
    }

    private int compare(int num1, int num2) {
    
        if(num1 < num2) {
            return -1;
        }
        else if(num2 > num1) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
