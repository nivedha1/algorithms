package Graphs.connectivity;

import Graphs.Graph;

import java.util.Arrays;

public class Bridge {

static Graph g1 = null;static int size=0;static int time=0;

//https://www.youtube.com/watch?v=CsGP_s_3GWg
//https://www.youtube.com/watch?time_continue=88&v=thLQYBlz2DM&feature=emb_logo
public static void main(String args[]){
    size=5;
    g1 = new Graph(size);
    g1.addUnDirectedEdge(1, 0);
    g1.addUnDirectedEdge(0, 2);
    g1.addUnDirectedEdge(2, 1);
    g1.addUnDirectedEdge(0, 3);
    g1.addUnDirectedEdge(3, 4);
    Bridge c = new Bridge();

    c.getBridge();
    size=4;
    g1 = new Graph(size);
    g1.addEdge(0, 2);
    g1.addEdge(1, 2);
    g1.addEdge(2, 3);
    g1.addEdge(2, 0);
    g1.addEdge(2, 1);
    g1.addEdge(3, 2);
    //g1.addEdge(0, 3);
    //g1.addEdge(3, 4);

    time=0;
    c.getArticulationPoint();


}

    private void getArticulationPoint() {
        int[] low= new int[size];
        int[] discovery = new int[size];
        boolean[] visited = new boolean[size];
        int[] parent = new int[size];
        Arrays.fill(parent,-1);
        for(int i=0;i<size;i++) {
            if (!visited[i])
                getArticulationPointUtil(low, discovery, visited,parent, i);
        }
    }

    private void getArticulationPointUtil(int[] low, int[] discovery, boolean[] visited, int[] parent, int u) {
        discovery[u]=low[u]=++time;
        visited[u]=true;
        int children=0;
        for(int v:g1.adj.get(u)){
            if(!visited[v]){
                parent[v]=u;
                children++;
                getArticulationPointUtil(low,discovery,visited,parent,v);
                //if child vertex is connected to any ancestors of parent then low[child]
                // will be lesser than low[parent]
                low[u]=Math.min(low[u],low[v]);
                if(parent[u]==-1 && children>1){
                    System.out.println(u +"is a articulation point");
                }
                //if no back edge
                else if(parent[u]!=-1 && low[v]>=discovery[u]){         // 3 -- 0 -- 2
                    System.out.println(u +"is a articulation point");   // |     |  /
                }                                                       // 4     1     3 and 0 are articulation points
                                                                                        //removing any one of these two nodes will break the graph into two parts
            }                                               //look at node 3-4 u-3 and v-4 when low[4]>disc[3] then u is an articulation point
            else if(v!=parent[u]){
                low[u]=Math.min(discovery[v],low[u]);
            }
        }


    }

    private void getBridge() {
        int[] low= new int[size];
        int[] discovery = new int[size];
        boolean[] visited = new boolean[size];
        int[] parent = new int[size];
        for(int i=0;i<size;i++) {
            if (!visited[i])
                getBridgeUtil(low, discovery, visited,parent, i);
        }
    }

    private void getBridgeUtil(int[] low, int[] discovery, boolean[] visited,int[] parent,int u) {
            visited[u]=true;
            low[u]=discovery[u]=++time;

            for(int v:g1.adj.get(u))
            {
                if(!visited[v]){
                    parent[v]=u;
                    getBridgeUtil(low,discovery,visited,parent,v);

                    //check if this child v is connected to some ancestor of u
                    low[u]=Math.min(low[u],low[v]);
                    //if the edge is bridge then low will be higher than discovery of u that means it is not
                    //connected to any other nodes.
                    if(low[v]>discovery[u]){
                        System.out.println("this bridge is"+u+" "+v);
                    }
                }
                //if the visited edge is again visited by a later node then update the minimum of
                //discovery of already visited node and low of current node
                else if(v!=parent[u]){
                    low[u]=Math.min(low[u],discovery[v]);
                }
            }


    }


}


