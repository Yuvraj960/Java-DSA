import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter Size of the Array: ");
//        int size = sc.nextInt();
//        int[] arr = new int[size];
//        System.out.println("Enter the Array Elements: ");
//        for(int i = 0; i < size; i++) {
//            arr[i] = sc.nextInt();
//        }
//        System.out.println("Enter the Target Element: ");
//        int target = sc.nextInt();
//        LinearSearch.linearSearch(arr, target);

//        int[] arr = {-2, 0, 3, 6, 8, 10, 23, 98};
//        int target = 23;
//        int ans = BinarySearch.binarySearch(arr, target);
//        System.out.println(ans);


//        2D Array Search
//        int[][] arr= {
//                {10,20,30,40},
//                {15,25,35,45},
//                {28,29,37,49},
//                {33,34,38,50}
//        };
//        System.out.println(Arrays.toString(BinarySearch.binarySearch2D(arr, 49)));


//        Strictly Sorted 2D Array Search
        int[][] arr= {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(Arrays.toString(BinarySearch.SortedMatrixBS(arr, 9)));
    }
}