package Stack.misc;

import java.util.ArrayList;
import java.util.Stack;

public class DFS {

    class Graph {
        int node;
        ArrayList<ArrayList<Integer>> adj;
        int size;
        boolean[] visited;

        Graph(int nodeSize) {
            this.size = nodeSize;
            adj = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < nodeSize; i++)
                adj.add(new ArrayList<Integer>());
            visited = new boolean[size];
        }

        void addEdge(int src, int dest) {
            adj.get(src).add(dest);
        }
    }

    public static void main(String[] args) {

        DFS dfs = new DFS();
        dfs.constructGraph(dfs);
    }

    void constructGraph(DFS dfs) {
        Graph g = new Graph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);


        dfs.printDFS(g,0);

    }

    private void printDFS(Graph g,int src) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        while(!stack.isEmpty()) {

            src = stack.pop();
            if (!g.visited[src]) {
                g.visited[src] = true;

                System.out.println(src);
            }
            for (int i : g.adj.get(src)) {
                if (!g.visited[i]) {

                    stack.push(i);

                }
            }


        }}




}
