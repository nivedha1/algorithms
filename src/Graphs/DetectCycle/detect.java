package Graphs.DetectCycle;

import Graphs.Graph;

import java.util.ArrayList;

public class detect {
static int count=0;static int n=0;static boolean[] marked;
    public static void main(String[] args)
    {
        int size=5;
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);

        detect d = new detect();
        if (d.isCyclicUndirected(size,g1))
            System.out.println("Undirected Graph contains cycle");
        else
            System.out.println("Graph doesn't contains cycle");
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if(d.isCyclicDirected(4,graph))
            System.out.println("Directed Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");

        //int[][] matrix=graph.convertGraphToMatrix(graph,4);
        int[][] matrix = {{0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0}};
        marked=new boolean[matrix.length];

            printCycleOfLengthn(matrix);

        System.out.println(count/2);
        String[] colors = new String[4];
        for (int i = 0; i < 4; i++)
        {
            colors[i] = "WHITE";
        }

        for (int i = 0; i < 4; i++)
        {
            if (colors[i] == "WHITE")
            {
                if(d.isCyclicDetectWithColors(i,graph, colors) == true) {
                    System.out.println("Colored Graph contains cycle");
                    break;
                }
            }
        }


    }

    private boolean isCyclicDetectWithColors(int u, Graph g,String[] colors) {
        colors[u]="GRAY";
        for (int v : g.adj.get(u)) {
            if (colors[v].equals("GRAY"))
                return true;
            if (colors[v].equals("WHITE")) {
                if (isCyclicDetectWithColors(v, g, colors) == true)

                    return true;
            }
        }
        colors[u] = "BLACK";
        return false;
    }

    private static void printCycleOfLengthn(int[][] matrix) {

int n=4;
        for(int j=0;j< matrix.length;j++){

            getCycle(matrix,marked,j,j,n-1);
            marked[j]=true;
        }

    }

    private static void getCycle(int[][] matrix, boolean[] marked, int start, int vertex,int n) {

        marked[vertex]=true;
        if(n==0){
            marked[vertex]=false;
            if(matrix[vertex][start]==1) {
                count++;
                return;
            }
            else
                return;
        }
        for(int i=0;i<matrix.length;i++){
            if(!marked[i]&& matrix[vertex][i]==1){//change vertex as i
                getCycle(matrix,marked,start,i,n-1);
            }
        }
        marked[vertex]=false;

    }


    private boolean isCyclicDirected(int size,Graph  g) {
        boolean[] visited=new boolean[size];
        boolean[] recusionStack=new boolean[size];

        for(int i=0;i<size;i++){
            if(!visited[i])
                if(isCycleDirected(i,recusionStack,visited,g))
                    return true;
        }
        return false;
    }

    private boolean isCycleDirected(int src, boolean[] recusionStack,boolean[] visited, Graph g) {

        //setting recursionstack as false after all the check
        //so if its true then the same src is visited from src again
        if(recusionStack[src])
            return true;

        recusionStack[src] = true;
        visited[src]=true;
        for(int j:g.adj.get(src)) {
            if (isCycleDirected(j, recusionStack,visited, g)) {
                return true;
            }
        }
        recusionStack[src]=false;//make the explored src as false
        return false;
    }

    private boolean isCyclicUndirected(int size,Graph  g) {
        boolean[] visited=new boolean[5];
        for(int i=0;i<size;i++){
            if(!visited[i])
            if(isCycle(i,visited,-1,g))
                return true;
        }
        return false;
    }

    private boolean isCycle(int i, boolean[] visited, int parent,Graph g) {
        visited[i]=true;
        for(int j:g.adj.get(i))            //     1--2
        {                                   //      3       // i j parent
            if(!visited[j]){                                // 1 2   -1   visited[1]=true
                                                            // 2 1    1   visited[2]=true
                                                            // 1 2   i=parent
                if(isCycle(j,visited,i,g)){
                    return true;
                }
            }
            else  if(j!=parent)
                return true;
        }
    return false;
    }


}
