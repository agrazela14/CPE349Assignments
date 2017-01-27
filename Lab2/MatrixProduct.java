import java.util.*;
import java.lang.*;
import java.io.*;

public class MatrixProduct {
    public static int[][] matrixProduct_DAC(int[][] A, int[][] B) {
        if (matriciesInvalid(A, B)) {
            throw new IllegalArgumentException("Both Matricies must be square matricies of the same size, with each side having a power of 2 length");
        }
        
        int[][]C = new int[A.length][A.length];
        
        matrixProduct_DAC(A, B, C);
        return C;
    }

    /*
    private static void matrixProduct_DAC(int[][]A, int[][]B, int[][]C, int n) {
        C[n][
        
    } 
    */

    private static int[][] matrixAdd(int[][] A, int[][] B, 
     int startRowA, int startColA, int startRowB, int startColB, int n) {

    } 

    private static int[][] matrixProduct_DAC(int[][] A, int[][] B, 
     int startRowA, int startColA, int startRowB, int startColB, int n) {
        int[][] C = new int[n][n];
        if (n == 1) {
            C[n][n] = A[startRowA][startColA] * B[startRowB][startColB];    
        } 
        else {
            int[][] C11 = matrixAdd(A, B, startRowA, startColA, startRowB, startColB, n/2);
            /*
            matrixProduct_DAC(A, B, C, startRowA, startColA, startRowB, startColB, n/2);
            matrixProduct_DAC(A, B, C, startRowA, startColA + n/2, startRowB + n/2, startColB, n/2);
            */

             
         
         

    }
         

    public static int[][] matrixProduct_Strassen(int[][]A, int[][]B) {
        if (matriciesInvalid(A, B)) {
            throw new IllegalArgumentException("Both Matricies must be square matricies of the same size, with each side having a power of 2 length");

        }

    }

    private static boolean matriciesInvalid(int[][]A, int[][]B) {
        int Arows = A.length;
        int Acols = A[0].length;
        int Brows = B.length;
        int Bcols = B[0].length;
        
        if ( (Arows != Acols) || (Brows != Bcols) || (Arows != Brows) ) {
            return true;
        }

        while ( !(Arows % 2) ) {
            Arows /= 2;
        }

        return Arows != 1;
    }


    }
