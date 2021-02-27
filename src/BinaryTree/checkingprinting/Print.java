package BinaryTree.checkingprinting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Print {
    
    static Bst n1 = null;static Bst n5=null;static int level=0;static int[] path=new int[100];
    static boolean[] visited = new boolean[100];
    static int pathLen = 0;
    public static void main(String args[]){
        Print obj = new Print();
        obj.constructTree();
        obj.printMiddleLevel(n1,n1);
        level=findLevel(n1,1,n5.data);
        obj.prntCousins(n5,n1,level);//same level but doesnt share same parent
        obj.printRootToLeaf(n1,path,pathLen);
        pathLen=0;
        path=new int[100];
        obj.printDistanceKFromLeaf(n1,path,pathLen,2);
        obj.printRightAndLeftMostNodes(n1);
        obj.printLevel(n1,5);
    }

    private void printDistanceKFromLeaf(Bst root, int[] path, int pathLen,int distance) {
        if(root==null)
            return;
        path[pathLen]=root.data;
        visited[pathLen]=false;
        pathLen++;
        if(root.left==null&&root.right==null&&visited[pathLen-distance]==false&&
        pathLen-distance>0){
            System.out.println(path[pathLen-distance]);
            visited[pathLen-distance]=true;

        }
        printDistanceKFromLeaf(root.left,path,pathLen,distance);
        printDistanceKFromLeaf(root.right,path,pathLen,distance);
    }

    private void printLevel(Bst root, int data) {
        Queue<LevelPair> queue = new LinkedList<LevelPair>();
        queue.add(new LevelPair(root,1));
        while(!queue.isEmpty()){
            LevelPair pair = queue.poll();
            if(pair.bst.data==data){
                System.out.println(pair.level);
                break;
            }
            if(pair.bst.left!=null)
                queue.add(new LevelPair(pair.bst.left,pair.level+1));
            if(pair.bst.right!=null)
                queue.add(new LevelPair(pair.bst.right,pair.level+1));
        }
    }

    private void printRightAndLeftMostNodes(Bst n1) {

        Queue<Bst> queue = new LinkedList<Bst>();
        queue.add(n1);
        while(!queue.isEmpty()){

         int n = queue.size();
         for(int i=0;i<n;i++)   {
             Bst temp=queue.poll();
             if(i==0)
                 System.out.print(temp.data+" ");
             else if(i==n-1)
                 System.out.print(temp.data+" ");

             if(temp.left!=null)
                 queue.add(temp.left);
             if(temp.right!=null)
                 queue.add(temp.right);

         }


        }







    }

    private void printRootToLeaf(Bst root,int[] path ,int pathLen) {

        if(root==null)
            return;
        path[pathLen]=root.data;
        pathLen++;
        if(root.left==null&&root.right==null){
            printPath(path,pathLen);
        }
        printRootToLeaf(root.left,path,pathLen);
        printRootToLeaf(root.right,path,pathLen);

    }

    private void printPath(int[] path, int pathLen) {
        System.out.println(" ");
        for(int i=0;i<pathLen;i++){
            System.out.print(path[i]+" ");
        }

    }

    private void prntCousins(Bst cousin,Bst node,int level) {

        if(node == null)
            return;
        if (level == 2)
        {
            if (node.left == cousin || node.right == cousin)
                return;
            if (node.left != null)
                System.out.print(node.left.data + " ");
            if (node.right != null)
                System.out.print(node.right.data + " ");
        }

        // Recur for left and right subtrees
        else if (level > 2) {

            prntCousins(cousin, node.left,level-1);
            prntCousins(cousin, node.right,level-1);
        }

    }
static int findLevel(Bst bst,int level,int data){
        if(bst==null)
            return 0;
        if(bst.data==data)
            return level;
    // If node is present in left subtree
    int downlevel = findLevel(bst.left, level+1,data);
    if (downlevel != 0)
        return downlevel;

    return findLevel(bst.right,level+1,data);
}
    private void printMiddleLevel(Bst slow, Bst fast) {

        if(fast==null||slow==null)
            return;
        if ((fast.left == null) && (fast.right == null))
        {
            System.out.println( slow.data);
            return;
        }
        printMiddleLevel(slow.left,fast.left.left);
        printMiddleLevel(slow.right,fast.right.right);



    }

    private void constructTree() {

        n1 = new Bst(1);
        Bst n2 = new Bst(2);            //        1
        Bst n3 = new Bst(3);            //     2      3
        Bst n4 = new Bst(4);           //   4    5 6     7
        n5 = new Bst(5);
        Bst n6 = new Bst(6);
        Bst n7 = new Bst(7);

        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n1.left = n2;
        n1.right = n3;
    }
}
class LevelPair{
    Bst bst;
    int level;
    LevelPair(Bst bst,int lvl){
        this.bst=bst;
        this.level=lvl;
    }
}