/*
 * Kyle Gonsalves and Alex Grazela
 * kygonsal and agrazela
 * 2/3/2017
 * Lab 2
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class MatrixProduct {
    static int base_case_hits = 0;

    public static int[][] matrixProduct_DAC(int[][] A, int[][] B) {
        /* To be valid, the two matrices must be square, of the same size,
         * and the length(and width) must be a power of two
         */
        if (matriciesInvalid(A, B)) {
            //Throw an Illegal Argument Exception if not valid
            throw new IllegalArgumentException(
             "Both Matricies must be square matricies of the same size, " + 
              "with each side having a power of 2 length");
        }
        return matrixProduct_DAC(A, B, 0, 0, 0, 0, A.length);
    }

    private static int[][] matrixAdd(int[][] A, int[][] B) { 
        int[][] C = new int[A.length][A[0].length];
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
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
            C[n - 1][n - 1] = A[startRowA][startColA] * B[startRowB][startColB];
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
            for(int i = 0; i < n/2; i++) {
                for(int j = 0; j < n/2; j++) {
                    C[i][j] = C11[i][j];
                }
            }   
            for(int i = 0; i < n/2; i++) {
                for(int j = 0; j < n/2; j++) {
                    C[i][j + n/2] = C12[i][j];
                }
            }
            for(int i = 0; i < n/2; i++) {
                for(int j = 0; j < n/2; j++) {
                    C[i + n/2][j] = C21[i][j];
                }
            }
            for(int i = 0; i < n/2; i++) {
                for(int j = 0; j < n/2; j++) {
                    C[i + n/2][j + n/2] = C22[i][j];
                }
            }
         
        }
	return C;
    }

    public static int[][] matrixProduct_Strassen(int[][]A, int[][]B) {
        /* To be valid, the two matrices must be square, of the same size,
         * and the length(and width) must be a power of two
         */
        if (matriciesInvalid(A, B)) {
            //Throw an Illegal Argument Exception if not valid
            throw new IllegalArgumentException(
             "Both Matricies must be square matricies of the same size, " +
              "with each side having a power of 2 length");
        }
        return matrixProduct_Strassen(A, B, 0, 0, 0, 0, A.length);
    }

    private static int[][] matrixProduct_Strassen(int[][] A, int[][] B, 
     int startRowA, int startColA, int startRowB, int startColB, int n) {
        int[][] C = new int[n][n];

        if (n == 1) {
            C[n - 1][n - 1] = A[startRowA][startColA] * B[startRowB][startColB];
        } 
        else {
            int[][]C11;
            int[][]C12;
            int[][]C21;
            int[][]C22;

            int[][] S1 = matrixProduct_StrassenSubtract(B, B, 
             startRowB, startColB + n/2, startRowB + n/2, startColB + n/2, n/2);

            int[][] S2 = matrixProduct_StrassenAdd(A, A,
             startRowA, startColA, startRowA, startColA + n/2, n/2);

            int[][] S3 = matrixProduct_StrassenAdd(A, A, 
             startRowA + n/2, startColA, startRowA + n/2, startColA + n/2, n/2);

            int[][] S4 = matrixProduct_StrassenSubtract(B, B,
             startRowB + n/2, startColB, startRowB, startColB, n/2);

            int[][] S5 = matrixProduct_StrassenAdd(A, A, 
             startRowA, startColA, startRowA + n/2, startColA + n/2, n/2);

            int[][] S6 = matrixProduct_StrassenAdd(B, B, 
             startRowB, startColB, startRowB + n/2, startColB + n/2, n/2);

            int[][] S7 = matrixProduct_StrassenSubtract(A, A, 
             startRowA, startColA + n/2, startRowA + n/2, startColA + n/2, n/2);

            int[][] S8 = matrixProduct_StrassenAdd(B, B,
             startRowB + n/2, startColB, startRowB + n/2, startColB + n/2, n/2);

            int[][] S9 = matrixProduct_StrassenSubtract(A, A, 
             startRowA, startColA, startRowA + n/2, startColA, n/2);

            int[][] S10 = matrixProduct_StrassenAdd(B, B, 
             startRowB, startColB, startRowB, startColB + n/2, n/2);

            int[][] P1 = matrixProduct_Strassen(A, S1,
             startRowA, startColA, 0, 0, n/2);
            int[][] P2 = matrixProduct_Strassen(S2, B,
             0, 0, startRowB + n/2, startColB + n/2, n/2);
            int[][] P3 = matrixProduct_Strassen(S3, B,
             0, 0, startRowB, startColB, n/2);
            int[][] P4 = matrixProduct_Strassen(A, S4,
             startRowA + n/2, startColA + n/2, 0, 0, n/2);
            int[][] P5 = matrixProduct_Strassen(S5, S6, 0, 0, 0, 0, n/2);
            int[][] P6 = matrixProduct_Strassen(S7, S8, 0, 0, 0, 0, n/2);
            int[][] P7 = matrixProduct_Strassen(S9, S10, 0, 0, 0, 0, n/2);

            C11 = matrixProduct_StrassenAdd(P5, P4, 0, 0, 0, 0, n/2);
            C11 = matrixProduct_StrassenSubtract(C11, P2, 0, 0, 0, 0, n/2);
            C11 = matrixProduct_StrassenAdd(C11, P6, 0, 0, 0, 0, n/2);
            //C11 done

            C12 = matrixProduct_StrassenAdd(P1, P2, 0, 0, 0, 0, n/2);
            //C12 done

            C21 = matrixProduct_StrassenAdd(P3, P4, 0, 0, 0, 0, n/2);
            //C21 done

            C22 = matrixProduct_StrassenAdd(P5, P1, 0, 0, 0, 0, n/2);
            C22 = matrixProduct_StrassenSubtract(C22, P3, 0, 0, 0, 0, n/2);
            C22 = matrixProduct_StrassenSubtract(C22, P7, 0, 0, 0, 0, n/2);
            //C22 done
            
            for(int i = 0; i < n/2; i++) {
                for(int j = 0; j < n/2; j++) {
                    C[i][j] = C11[i][j];
                }
            }   
            for(int i = 0; i < n/2; i++) {
                for(int j = 0; j < n/2; j++) {
                    C[i][j + n/2] = C12[i][j];
                }
            }
            for(int i = 0; i < n/2; i++) {
                for(int j = 0; j < n/2; j++) {
                    C[i + n/2][j] = C21[i][j];
                }
            }
            for(int i = 0; i < n/2; i++) {
                for(int j = 0; j < n/2; j++) {
                    C[i + n/2][j + n/2] = C22[i][j];
                }
            }
        }
        return C;
    }

    private static int[][] matrixProduct_StrassenAdd(int[][] A, int [][] B, 
     int startRowA, int startColA, int startRowB, int startColB, int n) {
        int[][] C = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                C[i][j] = A[i + startRowA][j + startColA] + 
                 B[i + startRowB][j + startColB];
            }
        }
        return C;
    }        

    private static int[][] matrixProduct_StrassenSubtract(int[][] A, int [][] B,
     int startRowA, int startColA, int startRowB, int startColB, int n) {
        int[][] C = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                C[i][j] = A[i + startRowA][j + startColA] - 
                 B[i + startRowB][j + startColB];
            }
        }
        return C;
    }

    private static boolean matriciesInvalid(int[][]A, int[][]B) {
        int Arows = A.length;
        int Acols = A[0].length;
        int Brows = B.length;
        int Bcols = B[0].length;
 
        if ( (Arows != Acols) || (Brows != Bcols) || (Arows != Brows) ) {
            return true;
        }

        while ( !((Arows % 2) == 1) ) {
            Arows /= 2;
        }

        return Arows != 1;
    }
}
