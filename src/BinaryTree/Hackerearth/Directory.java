package BinaryTree.Hackerearth;

import java.util.ArrayList;
import java.util.Scanner;
//https://www.hackerearth.com/practice/data-structures/trees/binary-and-nary-trees/practice-problems/algorithm/directory-deletion-71e793b8/
public class Directory {
    int sum=0;
    //              -1
    //     8       7        4      15
    //   2   3   12  11   10   5   16
    //  13   9  14             6
    //  16
    // -1 8  8   1  4     5   1  1  3  4   7   7     2   12  1   15  parent of idx
    //  1  2  3  4  5     6   7  8   9  10  11  12   13  14  15   16
    //  7
    //  14 7  6  2 13 15 9

    //ans 5   when 7 is deleted 14 needn't be added for deletion seperately as its child of 7
    //when 2 is deleted 13 needn't be added for deletion seperately as its child of 7
    boolean[] toDelete=null;
    ArrayList<ArrayList<Integer>> nodes=null;
    public static void main(String args[] ) throws Exception {
        Directory tc = new Directory();
        tc.createObject();
        System.out.println(tc.dfs(1));
    }
    void createObject(){
        Scanner sc =new  Scanner(System.in);

        int total=sc.nextInt();
        toDelete = new boolean[total];
        nodes=new ArrayList<ArrayList<Integer>>();
        int i=0;
        for( i =0;i<total;i++)
        {
            nodes.add(new ArrayList<Integer>());
        }
        nodes.get(0).add(sc.nextInt());
        for(i =1;i<total;i++)
        {
            nodes.get(sc.nextInt()).add(i+1);
        }
        int num=sc.nextInt();
        for( i=0;i<num;i++)
        {
            toDelete[sc.nextInt()]=true;
        }
//   for(i=0;i<total;i++){
//       for(int j:nodes.get(i)){
//           System.out.println("i="+i+"j="+j);
//       }
//   }
    }
    int dfs(int j)
    {
        if(toDelete[j]==true)
        {
            //System.out.print("j"+j);
            sum++;
            return sum;
        }
        for(int node:nodes.get(j))
        {
            dfs(node);
        }
        return sum;
    }

}
