package Graphs.TopologicalSort;

import Graphs.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class TopologicalSort {
static int weight;static int curweight=0;

    public static Stack<Integer> stack = new Stack<>();
    public static void main(String args[]){
        Graph g=new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        TopologicalSort obj = new TopologicalSort();
        obj.topologicalSort(g);

        obj.allTopologicalSort(g);

        stack=new Stack<Integer>();
        obj.getAddMaximumEdges(g);

        Pair pair=new Pair(7);
        pair.addPair(1,2, 3);
        pair.addPair(2,1, 3);

        // second edge 
        pair.addPair(2,3, 4);
        pair.addPair(3,2, 4);

        // third edge 
        pair.addPair(2,6, 2);
        pair.addPair(6,2, 2);

        // fourth edge 
        pair.addPair(4,6, 6);
        pair.addPair(6,4, 6);

        // fifth edge 
        pair.addPair(5,6, 5);
        pair.addPair(6,5, 5);
        getMaxLength(pair.list1,7);
        pair = new Pair(8);

        pair.addPair(0, 1, 5);
        pair.addPair(0, 2, 3);
        pair.addPair(1, 3, 6);
        pair.addPair(1, 2, 2);
        pair.addPair(2, 4, 4);
        pair.addPair(2, 5, 2);
        pair.addPair(2, 3, 7);
        pair.addPair(3, 5, 1);
        pair.addPair(3, 4, -1);
        pair.addPair(4, 5, -2);


        getMAxDistancePath(1,pair.list1,8);
    }

    private static void getMAxDistancePath(int src, ArrayList<ArrayList<Pair>> list1, int size) {
        boolean[] visited = new boolean[size];
        stack=new Stack<>();
        for(int i=0;i<size;i++){
            if(!visited[i]){
                topologicalSortUtilForPair(list1,i,visited);
            }
        }
        int[] distance = new int[size];
        Arrays.fill(distance,Integer.MIN_VALUE);
        distance[src]=0;
        while(!stack.isEmpty()){
            int val=stack.pop();
            for(Pair p:list1.get(val)){
                if(distance[p.dest]<distance[val]+p.weight){
                    distance[p.dest]=distance[val]+p.weight;
                }
            }
        }
        for(int value:distance){
            System.out.println(value);
        }
    }

    private static void topologicalSortUtilForPair(ArrayList<ArrayList<Pair>> list1, int src, boolean[] visited) {
        visited[src]=true;
        for(Pair p:list1.get(src)){
            if(!visited[p.dest]){
                topologicalSortUtilForPair(list1,p.dest,visited);
            }
        }
        stack.push(src);

    }



    private static void getMaxLength(ArrayList<ArrayList<Pair>> list, int size) {

        boolean[] visited=new boolean[size];

        for(int i=0;i<size;i++){
            if(!visited[i])
            getMaxLengthDFSUtil(list,i,visited);
        }


System.out.println(curweight);
    }

    private static void getMaxLengthDFSUtil(ArrayList<ArrayList<Pair>> list, int i, boolean[] visited) {
        visited[i]=true;
        for(Pair p:list.get(i)){
            if(!visited[p.dest]){
                weight=weight+p.weight;
                getMaxLengthDFSUtil(list,p.dest,visited);

            }
        }
        if(weight>curweight){
            curweight=weight;
        }
        weight=0;

    }

    private void getAddMaximumEdges(Graph g) {
        boolean[] visited = new boolean[g.size];
        for(int i=0;i<g.size;i++){
            if(!visited[i]){
                topologicalSortUtil(g,i,visited);
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();

        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        for(int i=0;i<list.size();i++){

            int val = list.get(i);
            boolean[] alreadyvisited = new boolean[g.size];
            for(int vertex:g.adj.get(val)){
                alreadyvisited[vertex]=true;
            }
            for(int j=i+1;j<list.size();j++){
                if(!alreadyvisited[list.get(j)]){
                    System.out.println(val+"-"+list.get(j));
                }
                alreadyvisited[j]=false;
            }



        }
    }

    private void allTopologicalSort(Graph g) {

        boolean[] visited=new boolean[g.size];
        int[] indegree = new int[g.size];
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<g.size;i++)  {
            for(int var:g.adj.get(i))
            indegree[var]++;
        }
        allTopologicalSortUtil(visited,indegree,list,g);
    }

    private void allTopologicalSortUtil(boolean[] visited, int[] indegree, ArrayList<Integer> list,Graph g) {
        boolean flag=false;
        for(int j=0;j<g.size;j++){
            if(!visited[j] && indegree[j]==0){
                list.add(j);
                visited[j]=true;
                for(int k:g.adj.get(j)){
                    indegree[k]--;
                }
                allTopologicalSortUtil(visited,indegree,list,g);
                visited[j]=false;
                if(!list.isEmpty())
                list.remove(list.size()-1);
                for(int k:g.adj.get(j)){
                    indegree[k]++;
                }
                flag=true;
            }
        }
        if(!flag) {
            for(int val:list) {
                System.out.print(val+" ");
            }
            list=new ArrayList<>();
            System.out.println(" ");

        }
    }

    private void topologicalSort(Graph g) {
        boolean[] visited = new boolean[g.size];
        for(int i=0;i<g.size;i++){
            if(!visited[i]){
                topologicalSortUtil(g,i,visited);
            }
        }
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }

    private void topologicalSortUtil(Graph g, int i,boolean[] visited) {
        visited[i]=true;
        for(int v:g.adj.get(i)){
            if(!visited[v])
                topologicalSortUtil(g,v,visited);
        }
        stack.push(i);//the last node which has no adj nodes will be added to stac
    }
}
class Pair{

int src;
int dest;
int weight;
    ArrayList<ArrayList<Pair>> list1 = new ArrayList<ArrayList<Pair>>();

Pair(int size){
    for(int i=0;i<size;i++)
    {
        list1.add(new ArrayList<Pair>());
    }
}
Pair(int dest,int weight){
    this.dest=dest;
    this.weight=weight;
}

void addPair(int src,int dest,int weight){

    list1.get(src).add(new Pair(dest,weight));
}
}