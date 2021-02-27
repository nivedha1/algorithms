/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes

*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
package Stack;
import java.util.*;
import java.io.*;
import java.util.*;
class Node1 implements Comparator<Node1>{
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

    @Override
    public int compare(Node1 o1, Node1 o2) {
                if(o1.timer!=o2.timer)
                    return o2.timer-o1.timer;
                else
                    return o2.query-o1.query;
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
            return o2.height-o1.height;
        else
            return o2.id-o1.id;
    }
    }

public class Test {
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
            queryHeights[i] = s.nextInt();
            timeSortedQueries.add(new Node1(0, s.nextInt(), true, i));
            timeSortedQueries.add(new Node1(0, s.nextInt(), false, i));

        }

        for (int i = 0; i < queries; i++) {
            queryHeights[i] = s.nextInt();
            timeSortedQueries.add(new Node1(1, s.nextInt(), false, i));
        }
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
    }
}







