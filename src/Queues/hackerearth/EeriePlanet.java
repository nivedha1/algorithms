package Queues.hackerearth;
import java.util.*;
import java.io.*;
import java.util.*;
class Node1 {
    int query;

    int timer;
    boolean start;
    int id;
    Node1(int q,int t,boolean s,int id) {
        this.query = q;
        this.timer = t;
        this.start = s;
        this.id = id;
    }
}
class SortNode1 implements Comparator<Node1>
{
    // Used for sorting in ascending order of
    // roll name
    public int compare(Node1 a, Node1 b)
    {
        if(a.timer!=b.timer) {
            return a.timer-b.timer;
        } else
            return a.query-b.query;

    }
}
class Pair implements Comparator<Pair>{
    int height;
    int id;
    Pair(int f,int s){
        this.height=f;
        this.id=s;
    }

    @Override
    public int compare(Pair o1, Pair o2) {
        if(o1.height!=o2.height)
            return o1.height-o2.height;
        else
            return o1.id-o2.id;
    }
}
public class EeriePlanet {
       public static void main(String args[]) throws Exception {
            PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
            boolean[] invalid = new boolean[10005];
            Scanner s = new Scanner(System.in);
            int hoursInDay = s.nextInt();                 // Reading input from STDIN
            int crew = s.nextInt();
            int[] guardHeights = new int[crew];
            int queries = s.nextInt();
            int[] queryHeights = new int[queries];
            boolean[] ans = new boolean[queries];

            ArrayList<Node1> timeSortedQueries = new ArrayList<Node1>();


            for (int i = 0; i < crew; i++) {
                guardHeights[i] = s.nextInt();
                timeSortedQueries.add(new Node1(0, s.nextInt(), true, i));
                timeSortedQueries.add(new Node1(0, s.nextInt(), false, i));

            }

            for (int i = 0; i < queries; i++) {
                queryHeights[i] = s.nextInt();
                timeSortedQueries.add(new Node1(1, s.nextInt(), false, i));
            }
Collections.sort(timeSortedQueries,new SortNode1());
            int max_h = 0;
            Pair curr = null;
            for (Node1 el : timeSortedQueries) {
                if (el.query == 0) {
                    if (el.start)
                        pq.add(new Pair(guardHeights[el.id], el.id));
                    else
                        invalid[el.id] = true;
                } else {
                    max_h = 0;
                    while (!pq.isEmpty()) {
                        curr = pq.peek();
                        if (!invalid[curr.id]) {
                            max_h = curr.height;
                            break;
                        } else
                            pq.remove();
                    }
                    ans[el.id] = (queryHeights[el.id] > max_h);
                }
            }
            for(int i = 0; i < queries; i++)
                System.out.println(ans[i] ? "YES" : "NO");
        }
    }


