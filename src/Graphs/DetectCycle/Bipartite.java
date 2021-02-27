package Graphs.DetectCycle;

import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {


    public static void main(String args[]) {
        int G[][] = {{0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}};

        if (containsOdd(G))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean containsOdd(int[][] g) {

        int[] colors = new int[g.length];
        for (int idx = 0; idx < g.length; idx++) {
            colors[idx] = -1;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        //self loop

        while (!q.isEmpty()) {
            int u = q.poll();
            if (g[u][u] == 1)//self loop
                return true;
            for (int v = 0; v < g.length; v++) {
                if (g[u][v] == 1 && colors[v] == -1) {
                    colors[v] = 1 - colors[v];
                    q.add(g[u][v]);
                } else if (g[u][v] == 1 && colors[v] == colors[u])
                    return false;
            }
        }
        return false;
    }
}
