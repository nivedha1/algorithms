package Backtracking;

public class NQueen {

    public static void main(String args[]){
        int N=4;
        int[][] sol = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sol[i][j]=0;
            }
        }
        solveNQueen(sol,0,N);
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static boolean solveNQueen(int[][] sol,int col,int N) {
        if(col>=N)
            return true;
        for(int i=0;i<N;i++){
            if (isSafe(i, col, sol, N, N)) {
                sol[i][col] = 1;
                if (solveNQueen(sol, col + 1, N)) {
                    return true;
                } else {
                    sol[i][col ] = 0;
                }
            }
        }
        return false;
    }

    public static boolean isSafe(int row,int col,int[][] sol,int rowLen,int colLen ){
        for(int i=0;i<colLen;i++){//row to left
            if(sol[row][i]==1)
                return false;
        }
        for(int i=row,j=col;j>0&&i>0;i--,j--){//upper left diagonal
            if(sol[i][j]==1)
                return false;
        }
        for(int i=row,j=col;j>0&&i<colLen;i++,j--){//lowe left diagonal
            if(sol[i][j]==1)
                return false;
        }
        return true;
    }
}
