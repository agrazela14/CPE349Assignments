import java.util.*;

private static final int MIN 5000
private static final int MAX 160000

public class SortTimes {

    public static void main(String args[]) {
        int N;
        for (N = MIN; N <= MAX; N *= 2) {
            for (int i = 0; i < 5; i++) {
                runSelectionSort();
                runMergeSort();
                runQuickSort();
            }
        }
    }

    private static void runSelectionSort() {

    }

    private static void runMergeSort() {

    }

    private static void runQuickSort() {

    }
}
