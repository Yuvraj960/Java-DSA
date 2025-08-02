public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start +(end-start)/2;
            if(target<arr[mid]) {
                end = mid -1;
            } else if(target>arr[mid]) {
                start = mid+1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int OrderAgousticBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        boolean isAsc = arr[start] < arr[end];

        while (start < end) {
            int mid = start +(end-start)/2;

            if(mid==target) {
                return mid;
            }
            if(isAsc) {
                if(target<arr[mid]) {
                    end = mid -1;
                } else if(target>arr[mid]) {
                    start = mid+1;
                }
            } else {
                if(target>arr[mid]) {
                    end = mid -1;
                } else if(target<arr[mid]) {
                    start = mid+1;
                }
            }
        }
        return -1;
    }

    public static int[] binarySearch2D(int[][] arr, int target) {
        int r=0;
        int c=arr.length-1;

        while(r<arr.length && c>=0) {
            if(arr[r][c] == target) {
                return new int[]{r,c};
            }
            if(arr[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return new int[] {-1,-1};
    }

    public static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
        while(cStart<cEnd) {
            int mid = cStart + (cEnd-cStart)/2;
            if(matrix[row][mid] == target) {
                return new int[]{row,mid};
            }
            if(matrix[row][mid] <target) {
                cStart =mid+1;
            } else {
                cEnd =mid-1;
            }
        }
        return new int[] {-1,-1};
    }

    public static int[] SortedMatrixBS(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        if(rows==1) {
            return binarySearch(matrix, 0, 0, cols-1, target);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols/2;

//        Run the loop till 2 rows are remaining
        while(rStart<(rEnd-1)) { // While this si true it will be having more than 2 rows
            int mid = rStart + (rEnd-rStart)/2;
            if(matrix[mid][cMid]==target) {
                return new int[]{mid, cMid};
            }
            if(matrix[mid][cMid]<target) {
                rStart = mid;
            } else {
                rEnd = mid;
            }
        }

        // Now we have 2 rows
//        Check whether the target in in cols of the 2 rows
        if(matrix[rStart][cMid] == target) {
            return new int[]{rStart, cMid};
        }
        if(matrix[rStart+1][cMid] == target) { //end is start+1 as we have 2 rows only
            return new int[]{rStart+1, cMid};
        }

//        search in 1st half
        if(target<=matrix[rStart][cMid-1]) {
            return binarySearch(matrix, rStart, 0, cMid-1, target);
        }

//        search in 2nd half
        if(target>=matrix[rStart][cMid+1] && target<=matrix[rStart][cols-1]) {
            return binarySearch(matrix, rStart, cMid+1, cols-1, target);
        }

//        search in 3rd half
        if(target<=matrix[rStart+1][cMid-1]) {
            return binarySearch(matrix, rStart+1, 0, cMid-1, target);
        } else {// search in the 4th half
            return binarySearch(matrix, rStart+1, cMid+1, cols-1, target);
        }
    }
}
