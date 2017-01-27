/*
 * Alex Grazela and Kyle Gonsalves
 * agrazela and kygonsal
 * 1/20/2017
 * Lab 1
*/

import java.util.*;

public class SortCounts {

    private static final int MIN = 100;
    private static final int MAX = 12800;
    private static final long MILLI = 1000000; 

    public static void main(String args[]) {
        int N;
        int[] selectionArr = new int[MAX];
        int[] mergeArr = new int[MAX];
        int[] quickArr = new int[MAX];
        long selectionCount;
        long mergeCount;
        long quickCount;
        
        for (N = MIN; N <= MAX; N *= 2) {
            selectionCount = 0;
            mergeCount = 0;
            quickCount = 0;
            for (int i = 0; i < 100; i++) {
                fillArrays(N, selectionArr, mergeArr, quickArr);
                selectionCount += runSelectionSort(selectionArr, N);
                mergeCount += runMergeSort(mergeArr, N);
                quickCount += runQuickSort(quickArr, N);
            }
            printify(N, selectionCount, mergeCount, quickCount);
        }
    }

    private static void fillArrays(int N, int[] sel, int[] merge, int[] quick) {
        Random rnd = new Random();
        int rndint;

        for (int i = 0; i < N; i++) {
            rndint = rnd.nextInt(N - 1);
            sel[i] = rndint;
            merge[i] = rndint;
            quick[i] = rndint;
        }
    }

    private static long runSelectionSort(int[] sel, int N) {
        int count;

        count = Sorts1.selectionSort(sel, N);
        
        return (count);
        
    }

    private static long runMergeSort(int[] merge, int N) {
        int count;

        count = Sorts1.mergeSort(merge, N);
        
        return (count);
        
    }

    private static long runQuickSort(int[] quick, int N) {
        int count;

        count = Sorts1.quickSort(quick, N);
        
        return (count);

    }

    private static void printify(int N, long sel, long merge, long quick) {
        System.out.println("N = " + N + " C_ss = " + sel/100 + " C_ms = " + merge/100 + " C_qs = " + quick/100);
        System.out.println();
        /*
        if (i == 5) {
            System.out.println();
        } 
        */
    }
}
