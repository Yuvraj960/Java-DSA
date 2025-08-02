import java.util.ArrayList;
import java.util.List;

public class Main {
//    PERMUTATIONS OF STRING

    public static void printPerm(String str, String perm, int idx) {
        if(str.isEmpty()) {
            System.out.println(perm);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            printPerm(newStr, perm+ch, idx+1);
        }
    }


//    N-QUEENS PROBLEM

    public static void helper(char[][] board, List<List<String>> allBoards, int col) {
        if(col==board.length) {
            saveBoard(board, allBoards);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if(isSafe(i, col, board)) {
                board[i][col] = 'Q';
                helper(board, allBoards, col+1);
                board[i][col] = '.';
            }
        }
    }

    public static boolean isSafe(int row, int col, char[][] board) {
//        Horizontal Check
        for (int i = 0; i < board.length; i++) {
            if(board[row][i] == 'Q') {
                return false;
            }
        }

//        Vertical Check
        for (int i = 0; i < board[0].length; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

//        Upper Left check
        int r = row;
        for (int c=col; c>=0 && r>=0; c--, r--){
            if(board[r][c] == 'Q') {
                return false;
            }
        }

//        Upper Right Check
        r=row;
        for (int c=col; r>=0 && c<board.length; r--, c++){
            if(board[r][c] == 'Q') {
                return false;
            }
        }

//        Lower Right Check
        r=row;
        for (int c=col; r<board.length && c<board.length; c++, r++){
            if(board[r][c] == 'Q') {
                return false;
            }
        }

//        Lower Left Check
        r=row;
        for (int c=col; c>=0 && r<board.length; r++, c--){
            if(board[r][c] == 'Q') {
                return false;
            }
        }

        return  true;
    }

    public static void saveBoard(char[][] board, List<List<String>> allBoards) {
        String row="";
        List<String> newBoard = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            row = "";
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'Q') {
                    row+="Q";
                } else {
                    row+=".";
                }
            }
            newBoard.add(row);
        }

        allBoards.add(newBoard);

    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];

        helper(board,allBoards,0);
        return allBoards;
    }


//    SUDOKU SOLVER

    public boolean shelper(char[][] board, int row, int col) {
        if(row == board.length) {
            return true;
        }

        int nrow = 0;
        int ncol = 0;

        if(col == board.length-1) {
            nrow = row+1;
            ncol = 0;
        } else {
            nrow = row;
            ncol =col+1;
        }

        if(board[row][col] != '.') {
            if(shelper(board,nrow,ncol)) {
                return true;
            } else {
                for (int i = 1; i<=9; i++){
                    if(isSafes(board, row,col, i)) {
                        board[row][col] = (char)(i+'0');
                        if(shelper(board,nrow,ncol)) {
                            return true;
                        } else {
                            board[row][col] = '.';
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isSafes(char[][] board, int row, int col, int number) {
//        Row and column check
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == (char) (number + '0')) {
                return false;
            }
        }
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == (char)(number + '0')) {
                return false;
            }
        }

//        Grid check
        int sr = (row/3) * 3;
        int sc = (col/3) * 3;

        for(int i = sr; i<sr+3; i++) {
            for (int j = sc; j<sc+3; j++) {
                if (board[i][j] == (char)(number + '0')) {
                    return false;
                }
            }
        }

        return true;
    }

    public void solveSudoku(char[][] board) {
        shelper(board,0,0);
    }

    public static void main(String[] args) {
//        String str = "ABC";
//        printPerm(str, "", 0);

//        int n = 4;
//        System.out.println(solveNQueens(n));
    }
}