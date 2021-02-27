package Backtracking;

public class KnightVisitAll {
    static int N = 8;

 static int movex[] = {2, 1, -1, -2, -2, -1, 1, 2};//order must not change
   //+ve neg neg +ve
    static int movey[] = {1, 2, 2, 1, -1, -2, -2, -1};//opp number first positive next negative
    //fill y first 1 2 2 1
     static void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }
    public static void main(String args[]) {
        int[][] sol = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sol[i][j] = -1;
            }
        }
        if (solveUtil(0, 0, 1, sol))
            System.out.println("YES");
        else
            System.out.println("NO");
        printSolution(sol);
    }

    private static boolean solveUtil(int x, int y, int move, int[][] sol) {
int nextx=0;int nexty=0;
        if (move == N * N)
            return true;
        for (int i = 0; i < N; i++) {
            nextx = x + movex[i];
            nexty = y + movey[i];
            if (isSafe(nextx, nexty, sol)) {
                sol[nextx][nexty] = move;
                if (solveUtil(nextx, nexty, move + 1, sol))
                    return true;
                else {
                    sol[nextx][nexty] = -1;
                }

            }
        }
        return false;
    }
        public static boolean isSafe ( int x, int y, int[][] sol){
            if (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1)
                return true;
            return false;
        }

    }


