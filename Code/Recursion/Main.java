import java.util.ArrayList;
import java.util.HashSet;

public class Main {
//    Tower of Hanoi Problem
    public static void towerOfHanoi(int n, String src, String helper, String dest) {
        if(n==1) {
            System.out.println("Transfer Disk " + n + " from " + src + " to " + dest);
            return;
        }

        towerOfHanoi(n-1, src, dest, helper);
        System.out.println("Transfer Disk " + n + " from " + src + " to " + dest);
        towerOfHanoi(n-1, helper, src, dest);
    }


//    First and last occurence of an element in a String

    public static int first = -1;
    public static int last = -1;

    public static void findOccurance(String str, int idx, char element){
        if(idx==str.length()) {
            System.out.println(first);
            System.out.println(last);
            return;
        }

        char currChar = str.charAt(idx);
        if(currChar==element) {
            if(first==-1) {
                first = idx;
            } else {
                last = idx;
            }
        }

        findOccurance(str, idx+1, element);
    }


//    Reverse the String

    public static void printRevStr(String str, int idx) {
        if(idx==0) {
            System.out.println(str.charAt(idx));
            return;
        }
        System.out.println(str.charAt(idx));
        printRevStr(str, idx-1);
    }


//    Sort the Array

    public static boolean isSorted(int[] arr, int idx) {
        if(idx == arr.length-1) {
            return true;
        }

        if(arr[idx]<arr[idx+1]) {
            return isSorted(arr, idx+1);
        } else {
            return false;
        }
    }


//    Shift all "X" elements to end

    public static void moveAllX(String str, int idx, int count, String newString) {
        if(idx==str.length()) {
            for(int i=0;i<count;i++) {
                newString += 'x';
            }
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx);
        if(currChar=='x') {
            count++;
            moveAllX(str, idx+1, count, newString);
        } else {
            newString += currChar;
            moveAllX(str, idx+1, count, newString);
        }
    }


//    Remove duplicate characters from string

    public static boolean[] map =  new boolean[26];
    public static void removeDuplicates(String str, int idx, String NewString) {
        if(idx==str.length()) {
            System.out.println(NewString);
            return;
        }

        char currChar = str.charAt(idx);
        if(map[currChar-'a']) {
            removeDuplicates(str, idx+1, NewString);
        } else {
            NewString += currChar;
            map[currChar-'a'] = true;
            removeDuplicates(str, idx+1, NewString);
        }
    }


//    Find all Substrings of a given string

    public static void subseq(String str, int idx, String newString) {
        if(idx==str.length()) {
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx);

        subseq(str, idx+1, newString+currChar);

        subseq(str, idx+1, newString);
    }


//    Find all UNIQUE Substrings of a given string

    public static void uniquesubseq(String str, int idx, String newString, HashSet<String> set) {
        if(idx==str.length()) {
            if(set.contains(newString)) {
                return;
            }
            else {
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }

        char currChar = str.charAt(idx);

        uniquesubseq(str, idx+1, newString+currChar, set);

        uniquesubseq(str, idx+1, newString, set);
    }


//    Find different messages using the keymapping of a keypad phone

    public static String[] keyword = {".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void keypad(String str, int idx, String combi) {
        if(idx==str.length()) {
            System.out.println(combi);
            return;
        }

        char currChar = str.charAt(idx);
        String mapping = keyword[currChar-'0'];

        for(int i=0;i<mapping.length();i++) {
            keypad(str, idx+1, combi+mapping.charAt(i));
        }
    }


//    Print permutations of the string

    public static void printPerm(String str, String perm) {
        if (str.length() == 0) {
            System.out.println(perm);
            return;
        }

        for(int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i+1);
            printPerm(newStr, perm+ch);
        }
    }


//    You are given matrix of n x m. You have to return the no. of paths we can reach (n,m) from (i,j).
//    Constraints: you can move downwards or rightwards only.

    public static int countPaths(int i, int j, int n, int m) {
        if(i==n||j==m) {
            return 0;
        }
        if(i==n-1&&j==m-1) {
            return 1;
        }

        int down = countPaths(i+1, j, m, n);
        int right = countPaths(i, j+1, m, n);

        return  down + right;
    }


//    Place tiles of size 1 x m on the floor of n x m. Return the no. of methods tiles can be placed on the floor.

    public static int placeTiles(int n, int m) {
        if(n==m) {
            return 2;
        }
        if(n<m) {
            return 1;
        }

        int vertical = placeTiles(n-m, m);
        int horizontal = placeTiles(n-1, m);
        return vertical+horizontal;
    }


//    No. of ways in which we can invite n people to party, singly or in pairs

    public static int invite(int n) {
        if(n<=1) {
            return 1;
        }
        int way1 = invite(n-1);
        int way2 = (n-1) * invite(n-2);
        return way1 + way2;
    }


//    Find all possible subsets of the given set

    public static void printSubset(ArrayList<Integer> subset) {
        for(int i=0;i<subset.size();i++) {
            System.out.print(subset.get(i)+" ");
        }
        System.out.println();
    }

    public static void findSubset(int n, ArrayList<Integer> subset) {
        if(n==0) {
            printSubset(subset);
            return;
        }

        subset.add(n);
        findSubset(n-1, subset);

        subset.remove(subset.size()-1);
        findSubset(n-1, subset);
    }

    public static void main(String[] args) {
//        int n = 3;
//        towerOfHanoi(n, "S", "H", "D");

//        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        printRevStr(str, str.length()-1);

//        String str = "Abbahdaffaar";
//        findOccurance(str, 0, 'a');

//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int[] arr2 = {1, 2, 3, 4, 4, 6, 7, 8, 10, 10};
//        System.out.println(isSorted(arr, 0));
//        System.out.println(isSorted(arr2, 0));

//        String str = "axhbxdhsfxxyhxd";
//        moveAllX(str, 0, 0, "");

//        String str = "axhbxdhsfxxyhxd";
//        removeDuplicates(str, 0,"");

//        String str = "abc";
//        subseq(str, 0, "");

//        String str = "aaa";
//        HashSet<String> set = new HashSet<>();
//        uniquesubseq(str, 0, "", set);

//        String str="23";
//        keypad(str,0,"");

//        String str = "abc";
//        printPerm(str, "");

//        int n= 3, m=3;
//        System.out.println(countPaths(0,0,n,m));

//        int n=3,m=3;
//        System.out.println(placeTiles(n, m));
//        int n=2,m=3;
//        System.out.println(placeTiles(n, m));
//        int n=4,m=2;
//        System.out.println(placeTiles(n, m));

//        int n=4;
//        System.out.println(invite(n));

        int n = 3;
        ArrayList<Integer> subset = new ArrayList<>();
        findSubset(n, subset);

    }
}