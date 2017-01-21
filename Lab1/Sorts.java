public class Sorts {
    public static void selectionSort (int[] arr, int N) {
        int smallest, temp;
        for (int i = 0; i < N; i++) {
            smallest = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] < arr[smallest]) {
                smallest = j;
                }
            }
            temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp; 
        }
    }

    public static void mergeSort (int[] arr, int N) {
        mergeSort(arr, 0, N - 1);
    }

    private static void mergeSort(int[] arr, int first, int last) {
        if (first < last) {
            int middle = (first + last) / 2;
            mergeSort(arr, first, middle); 
            mergeSort(arr, middle + 1, last); 
            mergeSortedHalves(arr, first, middle, last);
        }
    }

    private static void mergeSortedHalves(int[] arr, int first, int middle, int last) {
        int[] temp = new int[last - first + 1];
        int index1 = first;
        int index2 = middle + 1;
        int index  = 0;
         
        while ((index1 <= middle) && (index2 <= last)) {
            if (arr[index1] < arr[index2]) {
                temp[index] = arr[index1];
                index1++;
            }
            else {
                temp[index] = arr[index2];
                index2++;
            }
            index++;
        }
        while (index1 <= middle) {
            temp[index] = arr[index1];
            index++;
            index1++;
        }
        while (index2 <= last) {
            temp[index] = arr[index2];
            index++;
            index2++;
        }
        for (int i = first; i <= last; i++) {
            arr[i] = temp[i - first];    
        } 
    }

    public static void quickSort (int[] arr, int N) {
        quickSort(arr, 0, N - 1);
    }

    private static void quickSort (int[] arr, int first, int last) {
        if (first < last) {
            setPivotToEnd(arr, first, last);
            int pivotIndex = splitList(arr, first, last);
            System.out.println("QuickSorting");
            quickSort(arr, pivotIndex + 1, last);
            quickSort(arr, first, pivotIndex);
        }
    }

    private static void setPivotToEnd(int[] arr, int first, int last) {
        //int firstVal = arr[first];
        //int lastVal  = arr[last];
        //int lowestIndex = first;
        //int largestIndex = last;
        int temp;
      
        int pivotIndex = (first + last) / 2;
        int pivot = arr[pivotIndex];

        //Determine pivot and it's index
        if (arr[first] < arr[last]) {
            if (arr[first] > pivot) {
                //lowestIndex = pivotIndex;
                //largestIndex = last;
                pivot = arr[first];
                pivotIndex = first;
            }
            else if (arr[last] < pivot) {
                //lowestIndex = first;
                //largestIndex = pivotIndex;
                pivot = arr[last];
                pivotIndex = last;
            }
        }
        else {
            //lowestIndex = last;
            //largestIndex = first;
            if (arr[last] > pivot) {
                //lowestIndex = pivotIndex;
                //largestIndex = first;
                pivot = arr[last];
                pivotIndex = last;
            }
            else if (arr[first] < pivot) {
                //lowestIndex = last;
                //largestIndex = pivotIndex;
                pivot = arr[first];
                pivotIndex = first;
            }
        }

        //Switch pivot to the end
        temp = pivot;
        arr[pivotIndex] = arr[last];
        arr[last] = temp;

        if (arr[first] > arr[(first + last) / 2]) {
            temp = arr[first];
            arr[first] = arr[(first + last) / 2];
            arr[(first + last) / 2] = temp;
        }
    }

    private static int splitList(int[] arr, int first, int last) {
        int indexL     = first; 
        int indexR     = last - 1; 
        int pivotIndex = last;
        int pivotVal   = arr[last];
        int temp;
        
        while (indexL < indexR) {
            while (arr[indexL] < pivotVal) {
                indexL++;
        System.out.println("Hello4");
            }
            while ((arr[indexR] > pivotVal) && (indexR > indexL)) {
                indexR--;
        System.out.println("Hello5");
            }
            if (indexL < indexR) {
                temp = arr[indexL];
                arr[indexL] = arr[indexR];
                arr[indexR] = temp;
            }
        System.out.println("Hello6");
        }
        temp = arr[indexL];
        arr[indexL] = pivotVal;
        arr[last] = temp;
        return indexL;
        

        /*
        // This was the non-standard version that I was trying for. For some reason this crap doesn't work
        while ((indexL < pivotIndex) && (pivotIndex >= 1)) {
            if (arr[indexL] > arr[pivotIndex]) {
                //Swap the offending value with 1 left of pivot
                temp = arr[indexL];
                arr[indexL] = arr[pivotIndex - 1];
                //Now swap pivot with that
                arr[pivotIndex - 1] = arr[last];
                arr[pivotIndex] = temp;
                pivotIndex--;
            }
            else {
                indexL++;
            }
        }
        return pivotIndex;
        */
    }
}

