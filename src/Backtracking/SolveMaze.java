package Backtracking;

public class SolveMaze {

    public static void main(String args[]){
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };
        int sol[][] = new int[maze.length][maze.length];
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze.length;j++){
                sol[i][j]=0;
            }
        }
        solveMaze(maze,0,0,sol);
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze.length;j++){
                System.out.print(sol[i][j]+" ");
            }
            System.out.println("");
        }
    }

    private static boolean solveMaze(int[][] maze, int x, int y,int[][] sol) {

        if(x==maze.length-1&&y==maze.length-1)
        {
            sol[x][y]=1;
            return true;
        }
           if(isSafe(x,y,maze))
            {
                sol[x][y]=1;
                if(solveMaze(maze,x+1,y,sol))
                    return true;
                if(solveMaze(maze,x,y+1,sol))
                    return true;
                sol[x][y]=0;
            }

        return false;
    }


    public static boolean isSafe(int x,int y,int[][] maze){
        if(x>=0&&y>=0&&x<maze.length&&y<maze.length&&maze[x][y]==1)
            return true;
        return false;
    }
}
