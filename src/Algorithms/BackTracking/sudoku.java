package Algorithms.BackTracking;

public class sudoku {

private int SIZE;
    private int board[][];


    sudoku() {
        board = new int[9][9];
    }

    sudoku(int arr[][]) {
        board = arr;
        SIZE = 9;
    }


    public String toString() {
        String str = "+---+---+---+---+---+---+---+---+---+\n";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (j == 0) {
                    str = str + "| " + String.valueOf(board[i][j]) + " " + "|";
                } else {
                    str = str + " " + String.valueOf(board[i][j]) + " " + "|";
                }

            }
            str = str + "\n";
            str = str + "+---+---+---+---+---+---+---+---+---+\n";
        }

        return str;
    }

    public void solve() {


solveBoard();
           // solveSudoku(board);

        }





    public boolean checkBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    private  boolean isSafe( int row, int col, int num) {
        // Check if the number is already in the row
        for (int x = 0; x < SIZE; x++) {
            if (board[row][x] == num) {
                return false;
            }
        }

        // Check if the number is already in the column
        for (int x = 0; x < this.SIZE; x++) {
            if (board[x][col] == num) {
                return false;
            }
        }

        // Check if the number is already in the 3x3 grid
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }



    private  boolean solveBoard(){
        boolean isEmpty = true;
        int row = -1;
        int column = -1;
        for(int i =0;i<9;i++){
            for(int j =0;j<9;j++){
               if(board[i][j] == 0) {
                   row =i;
                   column =j;
                   isEmpty = false;
                   break;
               }
            }
            if (!isEmpty){
                break;
            }
        }
        if(isEmpty){
            return true;
        }
        for(int i =1;i<10;i++){
            if(isSafe(row,column,i)){
                board[row][column] = i;
                if(solveBoard()){
                    return true;
                }else{
                    board[row][column] =0;
                }
            }
        }
        return false;
    }
    private void canPut(int i, int j) {


        for (int num = 1; num < 10 ; num++) {
            if(isSafe(i,j,num)){
                board[i][j] = num;
                return;
            }
                board[i][j] = 0;



        }




    }

    public static void main(String[] args)
    {
        int arr[][] = {  {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 3, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}};
sudoku game = new sudoku(arr);

        System.out.println(sodukoSolver.solveSudoku(arr) || game.solveBoard());
        System.out.println(game);
        System.out.println(game.checkBoard());


    }


}

