public class LinearSearch {
    public static void linearSearch(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                System.out.println("Element found at index: " + i);
                return;
            }
        }
    }

    public static void linearSearch(String arr, char target) {
        if(arr.length() == 0) {
            System.out.println("No Valid String Provided");
            return;
        }
        for(int i = 0; i < arr.length(); i++) {
            if(target==arr.charAt(i)) {
                System.out.println("Element found at index: " + i);
                return;
            }
        }

//        For-Each type loop
//        for(char ch: arr.toCharArray()) {
//            if(ch==target) {
//                System.out.println("Element Found!");
//            }
//        }
    }

    public static void linearSearch(String arr, char target, int start, int end) {
        if(arr.length() == 0) {
            System.out.println("No Valid String Provided");
            return;
        }
        for(int i = start; i < end; i++) {
            if(target==arr.charAt(i)) {
                System.out.println("Element found at index: " + i);
                return;
            }
        }
    }
}
