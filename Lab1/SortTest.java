import java.util.*;

public class SortTest {

    public static final int ARRLEN = 160000;

    public static void main(String args[]) {
        Random rnd = new Random();
        int[] SelectionArr = new int[ARRLEN];
        int[] MergeArr = new int[ARRLEN];
        int[] QuickArr = new int[ARRLEN];
        int[] ControlArr = new int[ARRLEN];
        System.out.println("The Random Numbers are");
        
        for (int i = 0; i < ARRLEN; i++) {
            int rndNum = rnd.nextInt(ARRLEN);
            SelectionArr[i] = rndNum;
            MergeArr[i] = rndNum;
            QuickArr[i] = rndNum;
            ControlArr[i] = rndNum;
            System.out.println(rndNum);
        }
        Arrays.sort(ControlArr); 
        Sorts.selectionSort(SelectionArr, ARRLEN);
        Sorts.mergeSort(MergeArr, ARRLEN);
        Sorts.quickSort(QuickArr, ARRLEN);
        System.out.println("Control SelectionSort MergeSort QuickSort");

        for (int i = 0; i < ARRLEN; i++) {
            System.out.println(ControlArr[i] + " " + SelectionArr[i] + " " + MergeArr[i] + " " + QuickArr[i]);
        }
    }
}
