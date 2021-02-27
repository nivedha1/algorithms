package BinaryTree.checkingprinting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CompareTwoNodes {



    static Bst bst = null;
    static int n=0;
    static Bst root1=null;
    static Bst root2 =null;
    static ArrayList<Integer> inorder = new ArrayList<>();
    static ArrayList<Integer> preorder = new ArrayList<>();
    public static void main(String args[])
    {
        CompareTwoNodes obj = new CompareTwoNodes();
        obj.constructTree();
        System.out.println(checkIfTwoNodesHaveSameParent(bst.left.left,bst.left.right,bst));
        obj.constructTreeForLeafSame();
        System.out.println(obj.checkSameLeafsTraversal(root1,root2));
        System.out.println(obj.checkTwoTreesAreIdentical(root1,root2));
        System.out.println(obj.checkBinaryTreeisSubtree(root1,root2.right));
    }

    private boolean checkBinaryTreeisSubtree(Bst root1, Bst root2) {
        inorder = new ArrayList<>();
        ArrayList<Integer> in1 = inorder(root1);
        inorder = new ArrayList<>();
        ArrayList<Integer>  in2 = inorder(root2);
        preorder = new ArrayList<>();
        ArrayList<Integer> pre1 = preorder(root1);
        preorder = new ArrayList<>();
        ArrayList<Integer>  pre2 = preorder(root2);
String out1="";String  out2="";
        for(int i:in1){
            out1+=i;}
        for(int i:in2)
            out2+=i;

if(out1.contains(out2))
{
    String out3="";String  out4="";
    for(int i:pre1){
        out3+=i;}
    for( int i:pre2)
        out4+=i;
    if(out3.contains(out4))

        return true;

}
return false;
    }

    private boolean isContains(ArrayList<Integer> one, ArrayList<Integer> two) {

        if(two.size()>one.size()){
            ArrayList<Integer> temp =one;
            one=two;
            two=temp;
        }

        for (int i = 0; i <= one.size()-two.size(); i++) {
            if (one.get(i) == two.get(0)) {
                int j = 0;
                for (; j < two.size(); j++) {
                    if (one.get(i + j) != two.get(j)) {
                        break;
                    }
                }
                if (j == two.size()) {
                    return true;
                }
            }
        }
        return false;
    }


    public static ArrayList<Integer> inorder(Bst in){
        if(in!=null){
            inorder(in.left);
            inorder.add(in.data);
            inorder(in.right);
        }
        return inorder;
    }
    public static ArrayList<Integer> preorder(Bst pre){
        if(pre!=null){
            preorder.add(pre.data);
            preorder(pre.left);
            preorder(pre.right);
        }
        return preorder;
    }
    private boolean checkTwoTreesAreIdentical(Bst root1, Bst root2) {

        Queue<Bst> q1 = new LinkedList<Bst>();
        Queue<Bst>  q2 = new LinkedList<Bst>();
        q1.add(root1);
        q2.add(root2);
        while(!q1.isEmpty()&&!q2.isEmpty()){

            Bst temp1 = q1.poll();
            Bst temp2 = q2.poll();
            if(temp1.data!=temp2.data)
                return false;
            if(temp1.left!=null && temp2.left!=null)
            {
                q1.add(temp1.left);
                q1.add(temp2.left);
            }
            else if(temp1.left==null||temp2.left==null){
                return false;
            }
            if(temp1.right!=null && temp2.right!=null)
            {
                q1.add(temp1.right);
                q1.add(temp2.right);
            }
            else if(temp1.right==null||temp2.right==null){
                return false;
            }

        }
        return true;


    }

    public static boolean isLeaf(Bst a){
        if(a.left==null&&a.right==null)
            return true;
        return false;
    }
    private boolean checkSameLeafsTraversal(Bst root1, Bst root2) {

        Queue<Bst> q1 = new LinkedList<Bst>();
        Queue<Bst>  q2 = new LinkedList<Bst>();
        q1.add(root1);
        q2.add(root2);
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        Bst temp1=null;
        Bst temp2=null;
        while(!q1.isEmpty()){

            temp1 = q1.poll();

            if(isLeaf(temp1))
                arr1.add(temp1.data);
            else{
                if(temp1.left!=null)
                q1.add(temp1.left);
                if(temp1.right!=null)
                    q1.add(temp1.right);
            }

        }
        while(!q2.isEmpty()){

            temp2 = q2.poll();

            if(isLeaf(temp2))
                arr2.add(temp2.data);
            else{
                if(temp2.left!=null)
                    q2.add(temp2.left);
                if(temp2.right!=null)
                    q2.add(temp2.right);
            }

        }
        if(arr1.equals(arr2))
            return true;
        else
            return false;

    }

    private void constructTreeForLeafSame() {

        root1 = new Bst(1);
        root1.left = new Bst(2);
        root1.right = new Bst(3);
        root1.left.left = new Bst(4);
        root1.right.left = new Bst(6);
        root1.right.right = new Bst(7);

        root2 = new Bst(0);
        root2.left = new Bst(1);
        root2.right = new Bst(3);
        root2.left.right = new Bst(4);
        root2.right.left = new Bst(6);
        root2.right.right = new Bst(7);
    }

    private static boolean checkIfTwoNodesHaveSameParent(Bst a, Bst b, Bst bst) {

        if(bst==null)
            return false;
        if((bst.left==a&&bst.right==b)||(bst.left==b&&bst.right==a))
            return true;
        return (checkIfTwoNodesHaveSameParent(a,b,bst.left)||
                checkIfTwoNodesHaveSameParent(a,b,bst.right));

    }

    private void constructTree() {
        bst = new Bst(10);
        bst.left = new Bst(8);
        bst .right = new Bst(2);
        bst.left.left = new Bst(5);
        bst.left.right = new Bst(3);
        bst.right.left = new Bst(2);
    }
}
