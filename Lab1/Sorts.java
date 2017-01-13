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
        if (first != last) {
            int middle = (first + last) / 2;
            mergeSort(arr, first, middle); 
            mergeSort(arr, middle + 1, last); 
            mergeSortedHalves(arr, first, middle, last);
        }
    }

    private static void mergeSortedHalves(int[] arr, int left, int middle, int right) {
        int[right - left + 1] temp;
        int index1 = left;
        int index2 = middle + 1;
        int index = 0;
        while ((index1 <= middle) && (index2 <= right)) {
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
        while (index2 <= right) {
            temp[index] = arr[index2];
            index++;
            index2++;
        }
    }

    public static void quickSort (int[] arr, int N) {
        quickSort(arr, 0, N - 1);
    }

    private static void quickSort (int[] arr, int first, int last) {
        if (first < last) {
            setPivotToEnd(arr, first, last);
            int pivotIndex = splitList(arr, first, last);
            quickSort(arr, first, pivotIndex);
            quickSort(arr, pivotIndex + 1, last);
        }
    }

    private static void setPivotToEnd(int[] arr, int first, int last) {
        int middle = (first + last) / 2;
        int firstVal = arr[first];
        int lastVal  = arr[last];
        int midVal   = arr[middle];
        int temp;
      
        int pivot = midVal;
        int pivotIndex = middle;

        //Determine pivot and it's index
        if (firstVal < lastVal) {
            if (firstVal > pivot) {
                pivot = firstVal;
                pivotIndex = first;
            }
        }
        else {
            if (lastVal > pivot) {
                pivot = lastVal;
                pivotIndex = last;
            }
        }

        //Switch pivot to the end
        temp = pivot;
        arr[pivotIndex] = lastVal;
        arr[last] = temp;
    }

    private static int splitList(int[] arr, int first, int last) {
        int indexL = first; 
        int indexR = last - 1; 
        int pivotVal = arr[last];
        int temp;
      
        while (arr[indexL] < pivotVal) {
            indexL++;
        }

        while ((arr[indexR] > pivotVal) && (indexR > indexL)) {
            indexR--;
        }

        if (indexL < indexR) {
            temp = arr[indexL]; 
            arr[indexL] = arr[indexR];
            arr[indexR] = temp;
        }
        else {
            temp = arr[indexL]; 
            arr[indexL] = pivotVal;
            arr[last] = temp;
        }
        return indexL;
    }
}

