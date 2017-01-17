import java.utils.*;

public static final ARRLEN = 15;
public class SortTest {

    static int main(String args[]) {
        ArrayList<int> ControlArray = new ArrayList<int>(ARRLEN);
        ArrayList<int> SortArray;
        Random rnd = new Random();
        int[ARRLEN] arr;
        System.out.println("The Random Numbers are");
        

        for (int i = 0; i < ARRLEN; i++) {
            int rndNum = rnd.nextInt();
            arr[i] = rndNum;
            ControlArray.add(rndNum);
            System.out.println(rndNum);
        }
        selectionSort(arr, ARRLEN);
        SortArray = new ArrayList<int>(arr);
        if (SortArray.equals(ControlArray.sort())) {
            System.out.println("Hurray Selection Sort Worked!");
        }
        else {
            System.out.println("Selection Sort DIDN'T Work!");
        }
    }
}
