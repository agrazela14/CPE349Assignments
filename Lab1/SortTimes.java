import java.util.*;

public class SortTimes {

    private static final int MIN = 5000;
    private static final int MAX = 160000;
    private static final long MILLI = 1000000; 

    public static void main(String args[]) {
        int N;
        int[] selectionArr = new int[MAX];
        int[] mergeArr = new int[MAX];
        int[] quickArr = new int[MAX];
        long selectionTime;
        long mergeTime;
        long quickTime;
        
        for (N = MIN; N <= MAX; N *= 2) {
            for (int i = 0; i < 5; i++) {
                fillArrays(N, selectionArr, mergeArr, quickArr);
                selectionTime = runSelectionSort(selectionArr, N);
                mergeTime = runMergeSort(mergeArr, N);
                quickTime = runQuickSort(quickArr, N);
                printify(N, i, selectionTime, mergeTime, quickTime);
            }
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
        long pretime;
        long posttime;

        pretime = System.nanoTime();
        Sorts.selectionSort(sel, N);
        posttime = System.nanoTime();
        
        return ((posttime - pretime) / MILLI);
        
    }

    private static long runMergeSort(int[] merge, int N) {
        long pretime;
        long posttime;

        pretime = System.nanoTime();
        Sorts.mergeSort(merge, N);
        posttime = System.nanoTime();
        
        return ((posttime - pretime) / MILLI);
        
    }

    private static long runQuickSort(int[] quick, int N) {
        long pretime;
        long posttime;

        pretime = System.nanoTime();
        Sorts.quickSort(quick, N);
        posttime = System.nanoTime();
        
        return ((posttime - pretime) / MILLI);

    }

    private static void printify(int N, int i, long sel, long merge, long quick) {
        System.out.println("N = " + N + " T_ss = " + sel + " T_ms = " + merge + " T_qs = " + quick);
        if (i == 4) {
            System.out.println();
        } 
    }
}
