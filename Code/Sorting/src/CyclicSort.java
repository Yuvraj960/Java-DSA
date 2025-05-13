public class CyclicSort {
    public static void cyclic(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1;
            if (arr[i] != arr[correct]) {
                SelectionSort.swap(arr, i, correct);
            } else {
                i++;
            }
        }
    }
}
