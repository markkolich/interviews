package com.kolich.interview.other;
import java.util.*;

class SudokuSolver {

    public static void main(String args[]){

        String sBoard[][] = {{"5","3",".",".","7",".",".",".","."},{"6",".",".","1","9","5",".",".","."},{".","9","8",".",".",".",".","6","."},{"8",".",".",".","6",".",".",".","3"},{"4",".",".","8",".","3",".",".","1"},{"7",".",".",".","2",".",".",".","6"},{".","6",".",".",".",".","2","8","."},{".",".",".","4","1","9",".",".","5"},{".",".",".",".","8",".",".","7","9"}};
        int x = 9, y = 9;
        char board[][] = new char[x][y];
        for(int i =0;i<x;i++){
            for(int j = 0;j<y;j++){
                board[i][j]=sBoard[i][j].charAt(0);
            }
        }
        print(board);
        solve(board);

        System.out.println("Solved-------------------------");
        print(board);
  
    }

    public static void print(char board[][]){
        int x = 9, y = 9;
        for(int i =0;i<x;i++){
            for(int j = 0;j<y;j++){
                System.out.print(board[i][j]+ " ");
            }
            System.out.println();
        }
        
    }
    private static void solve(char board[][]){
        solver(board);
    }
    public static boolean solver(char[][]board) {
        for(int i = 0;i<9;i++){
            for (int j =0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char c = '1';c<='9';c++){
                        board[i][j] =c;
                        if(checker(board,i,j,c) && solver(board)){
                            return true;
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checker(char a[][],int row,int col,char val){
        if(val == '.') return true;

        for(int i =0;i<9;i++){
            if(a[row][i] == val && i!=col) return false;
            if(a[i][col] == val && i!=row) return false;
        }

        int boxRow = (row/3)*3;
        int boxCol = (col/3) * 3;
        for(int i = boxRow;i<boxRow+3;i++){
            for(int j = boxCol;j<boxCol+3;j++){
                if(i!=row || j!=col){
                    if(a[i][j] == val) return false;
                }
            }
        }
        return true;
    }
       

}