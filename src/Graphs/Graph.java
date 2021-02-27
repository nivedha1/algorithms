package Graphs;

import java.util.ArrayList;

public class Graph {

    public final int size;
    public final ArrayList<ArrayList<Integer>> adj;

    public Graph(int size)
    {
        this.size = size;
        adj = new ArrayList<>(size);

        for (int i = 0; i < size; i++)
            adj.add(new ArrayList<>());
    }
    public void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }
    public void addUnDirectedEdge(int src,int dest){
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }
    public  int[][] convertGraphToMatrix(Graph graph,int size) {
        int[][] matrix = new int[size][size];

        for(int i=0;i<adj.size();i++){
            for(Integer j:adj.get(i)){
                matrix[j][i]=1;
                matrix[i][j]=1;

            }
        }
        return matrix;
    }

}
