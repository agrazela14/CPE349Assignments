
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

   }
   public static void quickSort (int[] arr, int N) {

   }
}

