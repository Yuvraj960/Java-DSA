public class InsertionSort {
    public static void insertion(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    SelectionSort.swap(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
    }
}
