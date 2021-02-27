package Graphs.connectivity;


public class CountIslands {


    public static void main(String[] args) throws java.lang.Exception
    {
        int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
                { 0, 1, 0, 0, 1 },
                { 1, 0, 0, 1, 1 },
                { 0, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1 } };
        CountIslands obj = new CountIslands();
        obj.countIslands(M);
    }

    private void countIslands(int[][] m) {
        int count=0;
        boolean[][] visited = new boolean[m.length][m.length];
        for(int row=0;row<m.length;row++){
            for(int col=0;col<m.length;col++){
                if(m[row][col]==1 && !visited[row][col]) {//i and j increament in DFSUtil
                    DFSUtil(row, col, visited, m);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private void DFSUtil(int row, int col, boolean[][] visited,int[][] m) {

        int[] rowNum={-1,-1,-1,0,0,1,1,1};//note this pattern must be followed as its added
        int[] colNum={-1,0,1,-1,1,-1,0,1};//note this pattern must be followed

        visited[row][col]=true;
        for(int k=0;k<8;k++) {
            if (m[row + rowNum[k]][col + colNum[k]] == 1) {
                DFSUtil(row + rowNum[k], col + colNum[k], visited, m);
            }
        }
    }

}
