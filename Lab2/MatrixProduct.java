import java.util.*;
import java.lang.*;
import java.io.*;

public class MatrixProduct {
    public static int[][] matrixProduct_DAC(int[][] A, int[][] B) {
        if (matriciesInvalid(A, B)) {
            throw new IllegalArgumentException(
             "Both Matricies must be square matricies of the same size, with each side having a power of 2 length");
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

    private static int[][] matrixAdd(int[][] A, int[][] B) { 
        int[][]C = new int[n][n];
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) [
                C[i][j] = A[i][j] + B[i][j];
            }
        } 
        return C;
    } 

    private static int[][] matrixProduct_DAC(int[][] A, int[][] B, 
     int startRowA, int startColA, int startRowB, int startColB, int n) {
        int[][] C = new int[n][n];
        int[][] C11, C12, C21, C22;
        if (n == 1) {
            C[n][n] = A[startRowA][startColA] * B[startRowB][startColB];    
        } 
        else {
            C11 = matrixAdd(matrixProduct_DAC(A, B, startRowA, startColA, 
                                       startRowB, startColB, n/2), 
                            matrixProduct_DAC(A, B, startRowA, startColA + n/2,
                                       startRowB + n/2, startColB, n/2));

            C12 = matrixAdd(matrixProduct_DAC(A, B, startRowA, startColA, 
                                       startRowB, startColB + n/2, n/2), 
                            matrixProduct_DAC(A, B, startRowA, startColA + n/2,
                                       startRowB + n/2, startColB + n/2, n/2));

            C21 = matrixAdd(matrixProduct_DAC(A, B, startRowA + n/2, startColA, 
                                              startRowB, startColB, n/2), 
                            matrixProduct_DAC(A, B, startRowA + n/2,
                             startColA + n/2, startRowB + n/2, startColB, n/2));

            C22 = matrixAdd(matrixProduct_DAC(A, B, startRowA + n/2, 
                             startColA, startRowB, startColB + n/2, n/2), 
                            matrixProduct_DAC(A, B, startRowA + n/2, 
                             startColA + n/2, startRowB + n/2, 
                             startColB + n/2, n/2));
            for(int i = 0; i < n/2, i++) {
                for(int j = 0; j < n/2, j++) {
                    C[i][j] = C11[i][j];
                }
            }   
            for(int i = 0; i < n/2, i++) {
                for(int j = 0; j < n/2, j++) {
                    C[i][j + n/2 + 1] = C12[i][j];
                }
            }
            for(int i = 0; i < n/2, i++) {
                for(int j = 0; j < n/2, j++) {
                    C[i + n/2 + 1][j] = C21[i][j];
                }
            }
            for(int i = 0; i < n/2, i++) {
                for(int j = 0; j < n/2, j++) {
                    C[i + n/2 + 1][j + n/2 + 1] = C22[i][j];
                }
            }
         
        }
	return C;
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
