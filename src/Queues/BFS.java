package Queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    boolean[] visited = new boolean[4];
    ArrayList<ArrayList<Integer>> adjList =null;
    BFS(){
        adjList =new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=4;i++){
            adjList.add(new ArrayList<Integer>());
        }
    }
    void addEdge(int src,int dest){
        adjList.get(src).add(dest);
    }
    void BFS(){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(2);
        visited[2]=true;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node + "=>");
            for (int i : adjList.get(node)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String args[]){
        BFS g = new BFS();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.BFS();
    }

}
