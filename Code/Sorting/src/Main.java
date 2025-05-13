import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
//        BubbleSort.bubble(arr);
//        SelectionSort.selection(arr);
//        InsertionSort.insertion(arr);
        CyclicSort.cyclic(arr);
        System.out.println(Arrays.toString(arr));
    }
}