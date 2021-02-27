package Backtracking;

public class GraphColoring {
    static int V=4;
    static int[] colors=null;




    public static void main(String args[]){

        int graph[][] = {{0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
        };
        int m = 3;
        colors=new int[V];
        for(int i=0;i<V;i++){
            colors[i]=0;
        }
        if(graphColoringUtil(graph,m,colors,0))
        {
            for(int i=0;i<V;i++){
                System.out.println(colors[i]);
            }
        }

    }

    static boolean isSafe(int v,int c,int[] colors,int[][] graph){
        for(int i=0;i<V;i++){
            if(graph[v][i] == 1&&colors[i]==c)
                return false;
        }
        return true;
    }
    private static boolean graphColoringUtil(int[][] graph, int m, int[] colors,int v) {

        if (v == V)
            return true;
        for (int c = 1; c <= m; c++) {
            if (isSafe(v, c, colors, graph)) {
                colors[v] = c;
                if (graphColoringUtil(graph, m, colors, v + 1))
                    return true;
                else
                    colors[v] = 0;
            }
        }
        return false;
    }
}
