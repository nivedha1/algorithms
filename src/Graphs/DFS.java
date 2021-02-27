package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class DFS {

    static boolean[] visited = null;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> visitedDegreelist = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> transposeGraph = new ArrayList<>();
    static int[] visitedDegree = null;
    static int[][] tc = null;
    static int size;
    static int count = 0;
    static int result=Integer.MAX_VALUE;

    DFS(int size) {
        this.size = size;
        visited = new boolean[size];
        list = new ArrayList<>();
        transposeGraph=new ArrayList<>();
        visitedDegreelist=new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new ArrayList<>());
            visitedDegreelist.add(new ArrayList<>());
            transposeGraph.add(new ArrayList<>());
        }
        this.tc = new int[size][size];
        visitedDegree = new int[size];
    }

    static void addEdge(int a, int b) {
        list.get(a).add(b);
        visitedDegreelist.get(a).add(b);
        visitedDegreelist.get(b).add(a);
        transposeGraph.get(a).add(b);
    }
    static void addEgdeUndirected(int a,int b){
        list.get(a).add(b);
        list.get(b).add(a);
    }
    public static void main(String args[]) {
        DFS g = new DFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal " +
                "(starting from vertex 2)");

        g.DFS(2);
        g = new DFS(7);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(6, 4);
        g.addEdge(5, 6);
        g.addEdge(5, 2);
        g.addEdge(6, 0);
        visited = new boolean[7];

        g.findMotherVertex();


        visited = new boolean[size];
        g.getTransitiveClosure();
        int k = 3;
        DFS g1 = new DFS(10);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 5);
        g1.addEdge(2, 3);
        g1.addEdge(2, 4);
        g1.addEdge(2, 5);
        g1.addEdge(2, 6);
        g1.addEdge(3, 4);
        g1.addEdge(3, 6);
        g1.addEdge(3, 7);
        g1.addEdge(4, 6);
        g1.addEdge(4, 7);
        g1.addEdge(5, 6);
        g1.addEdge(5, 8);
        g1.addEdge(6, 7);
        g1.addEdge(6, 8);
        g1.printKCores(k);
        g = new DFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        int src = 2, dest = 3;
        g.countPath(src, dest);
        System.out.println("count is" + count);

        g = new DFS(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);

        g.addEdge(3, 4);
        count=0;
        g.countTreesInForest();
        System.out.println("tress in forest "+count);


        g.printBinaryPalindrome(10,5);
        System.out.println("Transposegraph is");
        g = new DFS(5);

        g.addEdge( 0, 1);
        g.addEdge( 0, 4);
        g.addEdge( 0, 3);
        g.addEdge( 2, 0);
        g.addEdge( 3, 2);
        g.addEdge( 4, 1);
        g.addEdge( 4, 3);
        transposeGraph=new ArrayList<>();
        for (int i = 0; i < 5; i++) {
             transposeGraph.add(new ArrayList<>());
        }
        g.transposeGraph(g);
        int vertex[] = {4, 2, 1, 6, 3, 5, 2};
        g = new DFS(7);
        g.addEgdeUndirected( 0, 1);
        g.addEgdeUndirected( 0, 2);
        g.addEgdeUndirected( 0, 3);
        g.addEgdeUndirected( 2, 4);
        g.addEgdeUndirected( 2, 5);
        g.addEgdeUndirected( 3, 6);
        int totalsum=0;
        int[] subtreesum=new int[7];
        for(int i=0;i<vertex.length;i++){
            totalsum=totalsum+vertex[i];
            subtreesum[i]=vertex[i];
        }


        getMinimumSubtreesumDifferencethroughDFS(0,-1,totalsum,subtreesum);//need to check
        System.out.println(result);
    }

    private void countTreesInForest() {
        for(int i=0;i<list.size();i++){
            if(!visited[i]){
                DFS(i);
                count++;
            }
        }
    }

    private static void getMinimumSubtreesumDifferencethroughDFS(int src ,int parent,int totalsum,int[] subtreesum) {
        int sum = subtreesum[src];
        for(int v:list.get(src)){
            if(v!=parent){//undirected grapg visited wont work
                getMinimumSubtreesumDifferencethroughDFS(v,src,totalsum,subtreesum);
                sum=+subtreesum[v];
            }
        }
        subtreesum[src]=sum;
        if(src!=0 && result>Math.abs(totalsum-(2*sum)))
            result=Math.abs(totalsum-(2*sum));
    }

    private void findMotherVertex() {
        int i=0,j=0,v=0;
        for(i=0;i<list.size();i++) {
            if (!visited[i]){
                DFS(i);
                v=i;
            }
        }
        Arrays.fill(visited,false);
        //if there exists a mother vertex then it must be the last node since mother vertex is a vertex which can reach all nodes in a graph
        DFS(v);
        for(j=0;j<list.size();j++){
            if(!visited[j])
                break;
        }
        if(j==list.size()){
            System.out.println("Mother vertex is "+v);
        }
        else{
            System.out.println("There is no mother vertex");
        }
    }

    private void transposeGraph(DFS g) {
        for(int i=0;i<list.size();i++){
            for(int j:list.get(i)){
                transposeGraph.get(j).add(i);
            }
        }
        for(int i=0;i<transposeGraph.size();i++){
            for(int j:transposeGraph.get(i)){
                System.out.print(" "+i+"->"+j);
            }
            System.out.println("");
        }
    }

    private void countPath(int src, int dest) {

        visited[src] = true;
        if (src == dest)
            count++;
        else {
            for (int adj : list.get(src)) {
                if (!visited[adj])
                    countPath(adj, dest);
            }
        }
        visited[src] = false;//set visited of src as false;to iterate gain taking src into consideration


    }

    private void printKCores(int k) {
        int minDegree = Integer.MAX_VALUE;
        int startindex = 0;
        for (int i = 0; i < size; i++) {
            visitedDegree[i] = visitedDegreelist.get(i).size();
        }

        for (int i = 0; i < size; i++) {
            if (!visited[i])
                DFSDegree(i, k);
        }
        for (int i = 0; i < size; i++) {
            if (visitedDegree[i] >= k) {
                System.out.println(i + " ");
                for (int j : visitedDegreelist.get(i)) {
                    if (visitedDegree[j] >= k)
                        System.out.print(j + " ");
                }

            }
        }

    }

    private boolean DFSDegree(int src, int k) {
        visited[src] = true;
        for (int adj : visitedDegreelist.get(src)) {
            if (visitedDegree[src] < k)
                visitedDegree[adj]--;
            if (!visited[adj]) {
                // If degree of adjacent after processing becomes
                // less than k, then reduce degree of v also.
                if (DFSDegree(adj, k))
                    visitedDegree[src]--;
            }
        }
        return visitedDegree[src] < k;
    }

    private void getTransitiveClosure() {
        for (int i = 0; i < size; i++) {
            DFSTC(i, i);
            for (int j = 0; j < size; j++) {
                System.out.print(tc[i][j]);
            }
            System.out.println("   ");
        }

    }

    private void DFSTC(int src, int dest) {
        tc[src][dest] = 1;
        for (int adj : list.get(dest)) {
            if (tc[src][adj] == 0) {// if 1 its already visited so check for 0
                DFSTC(src, adj);
            }
        }

    }

    private void DFS(int src) {
        visited[src] = true;
        System.out.println(src + " ");
        for (int i : list.get(src)) {
            if (!visited[i]) {
                visited[i] = true;
                DFS(i);
            }
        }
    }


    void dfs(int parent, int[] ans, ArrayList<ArrayList<Integer>> connectchars) {
        // set the parent marked
        ans[parent] = 1;

        // if the node has not been visited set it and
        // its children marked
        //if parent of starting and ending of repeated characters are 0 then make it 1 ,parent is 0 when ever repeating character of
        // k of length 4 0123  0 and 3 will be connected and element in 0 and 3 will be made 1
        // k is of length 8 01230123   0 will be connected to 3 3 is connected to 0 so these will positions will be made 1 and others will be left as 0 in ans array
        for (int i = 0; i < connectchars.get(parent).size(); i++) {
            if (ans[connectchars.get(parent).get(i)] != 1)
                dfs(connectchars.get(parent).get(i), ans, connectchars);
        }
    }

    void printBinaryPalindrome(int n, int k) {// n is total digits,k is repeating digits  11011 n is 5 k is 3

        // link which digits must be equal
        int[] arr = new int[n];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i % k;
        ArrayList<ArrayList<Integer>> connectchars = new ArrayList<>();

        for (int i = 0; i <= k; i++) {
            connectchars.add(new ArrayList<>());
        }
        // connect the two indices
        //0 1 2 3 0 1 2 3 will be arr\
        //connectchars will append all 1
        for (int i = 0; i < n / 2; i++) {
            connectchars.get(arr[i]).add(arr[n - i - 1]);
            connectchars.get(arr[n - i - 1]).add(arr[i]);

        }

        // set everything connected to
        // first character as 1
        dfs(0, ans, connectchars);

        for (int i = 0; i < n; i++)
            System.out.println(ans[arr[i]]);
    }
}
