import java.util.*;
import java.lang.*;
import java.io.*;

public class MatrixWork {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in), fileReader;
        String filename;
        int rowsA, rowsB, colsA, colsB;
        int a[][], b[][], c[][];

        System.out.println("Enter in the input filename");
        filename = in.nextLine();
        fileReader = new Scanner(new File(filename));

        rowsA = fileReader.nextInt();
        colsA = fileReader.nextInt();
        a = new int[rowsA][colsA];
        for(int i = 0; i < rowsA; i++) {
            for(int j = 0; j < colsA; j++) {
                a[i][j] = fileReader.nextInt();
            }
        }
        rowsB = fileReader.nextInt();
        colsB = fileReader.nextInt();
        b = new int[rowsB][colsB];
        for(int i = 0; i < rowsB; i++) {
            for(int j = 0; j < colsB; j++) {
                b[i][j] = fileReader.nextInt();
            }
        }

        c = MatrixProduct(a, b);

        System.out.println("Iterative Method:");
        for(int i = 0; i < c.length; i++) {
            for(int j = 0; j < c[0].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }

        c = MatrixProduct.matrixProduct_DAC(a, b);

        System.out.println("Normal Recursive Product Matrix:");
        for(int i = 0; i < c.length; i++) {
            for(int j = 0; j < c[0].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }

        c = MatrixProduct.matrixProduct_Strassen(a, b);

        System.out.println("Strassen Recursive Product Matrix:");
        for(int i = 0; i < c.length; i++) {
            for(int j = 0; j < c[0].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] MatrixProduct(int[][] a, int[][] b) {
        int c[][] = new int[a.length][b[0].length];        

        if(a[0].length != b.length) {
             System.out.println(
              "a's number of columns doesn't match b's number of rows");
             System.exit(1);
        }

        for(int i = 0; i < c.length; i++) {
            for(int j = 0; j < c[0].length; j++) {
                for(int k = 0; k < a[0].length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return c;
    } 
}
