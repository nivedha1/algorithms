package BinaryTree.Hackerearth;

import java.util.ArrayList;
import java.util.Scanner;
//https://www.hackerearth.com/practice/data-structures/trees/binary-and-nary-trees/practice-problems/approximate/largest-cycle-in-a-tree-9113b3ab/description/
//this can be used to print the longest path between two nodes
//largest distance path
//diameter of a tree which is the longest path between two nodes in a tree
public class LargestCycleInTree {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();static boolean[] visited=null;
    static int maxlength=0;
    static int start =0;
    public static void main(String args[]){
        LargestCycleInTree obj = new LargestCycleInTree();
        obj.createTree();
    }

    private void createTree() {

        Scanner s= new Scanner(System.in);
        int tc = s.nextInt();
        visited=new boolean[tc+1];
        for(int i=0;i<=tc;i++){
            list.add(new ArrayList<>());
        }
        for(int i=1;i<tc;i++){
            int a =s.nextInt();int b= s.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }
        dfs(1,0);
        System.out.println(start);
        maxlength=0;visited=new boolean[tc+1];
dfs(start,0);
System.out.println(start);
    }
static void dfs(int i,int len){

        visited[i]=true;
        if(len>maxlength){
            maxlength=len;
            start=i;
        }
        for(int a:list.get(i)){
            if(!visited[a]){
                dfs(a,len+1);
            }
        }

}

}
