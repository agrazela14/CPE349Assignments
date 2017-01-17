import java.util.*;

public class SortTest {

    public static final int ARRLEN = 15;

    static int main(String args[]) {
        ArrayList<int> ControlArray = new ArrayList(ARRLEN);
        ArrayList<int> SortArray;
        Random rnd = new Random();
        int[] arr = new int[ARRLEN];
        System.out.println("The Random Numbers are");
        

        for (int i = 0; i < ARRLEN; i++) {
            int rndNum = rnd.nextInt();
            arr[i] = rndNum;
            ControlArray.add(rndNum);
            System.out.println(rndNum);
        }
        selectionSort(arr, ARRLEN);
        SortArray = new ArrayList(arr);
        if (SortArray.equals(ControlArray.sort())) {
            System.out.println("Hurray Selection Sort Worked!");
        }
        else {
            System.out.println("Selection Sort DIDN'T Work!");
        }
    }
}
