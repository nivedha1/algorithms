package BinaryTree.summation;

import java.util.HashSet;

public class Summation {
static Bst node = null;static int sum=0;static int maxsum=0;static Bst maxnode=null;static int leftSubTreeSum=0;
static int rightSubTreeSum=0;static int count=0;
static HashSet<Integer> set = new HashSet<>();
public static void main(String arg[]){
    constructTree();
   // System.out.println(findSumofParentofX(4,node));
    //System.out.println(findIfthereisAPairInRoottoLeafWithvalueofRoot(node,node));
    //largestsubtreesum(node);
    //System.out.println("maxsum "+maxsum+" maxnode"+maxnode.data);
    //System.out.println(subtreewithgivensumexists(node,0,11));
    countSubTressWithSumX(node,11);
    System.out.println(count);
}

    private static int countSubTressWithSumX(Bst node, int sum) {

    if(node==null)
        return 0;

    int leftsum=countSubTressWithSumX(node.left,sum);

    int rightsum=countSubTressWithSumX(node.right,sum);

    int currsum=leftsum+rightsum+node.data;
    if(currsum==sum)
        count++;

    return currsum;

    }

    private static boolean subtreewithgivensumexists(Bst node,int cur_sum, int sum) {

        if (node== null){
            cur_sum=0;
            return false;
        }
        leftSubTreeSum = 0;
        boolean leftExist = subtreewithgivensumexists(node.left,leftSubTreeSum, sum);

        rightSubTreeSum = 0;
        boolean rightExist = subtreewithgivensumexists(node.right,rightSubTreeSum, sum);
        cur_sum=leftSubTreeSum+rightSubTreeSum+node.data;
        return ( leftExist || rightExist ||(cur_sum== sum));

    }

    private static int largestsubtreesum(Bst root) {

            if (root == null) {
                return 0;
            }
            int leftR = largestsubtreesum(root.left);
            int rightR = largestsubtreesum(root.right);
            int sum = leftR + rightR + root.data;
            if (sum > maxsum) {
                maxsum = sum;
                maxnode=root;
            }
            return sum;

    }

    private static boolean findIfthereisAPairInRoottoLeafWithvalueofRoot(Bst node,Bst root) {
            if(node==null)
                return false;
            int rem = node.data-root.data;
            if(set.contains(rem)){
                return true;
            }
            set.add(node.data);
            return findIfthereisAPairInRoottoLeafWithvalueofRoot(node.left,root)||
                    findIfthereisAPairInRoottoLeafWithvalueofRoot(node.right,root);



    }

    private static int findSumofParentofX(int x,Bst node) {
    if(node==null)
        return 0;
    if((node.right!=null&&node.right.data==x)||
            (node.left!=null&&node.left.data==x)){
        sum=sum+node.data;

    }findSumofParentofX(x,node.left);
    findSumofParentofX(x,node.right);
    return sum;
    }


    static Bst constructTree()
    {
        node=new Bst(1);
        node.left=new Bst(2);
        node.right=new Bst(3);
        node.left.left=new Bst(4);
        node.left.right=new Bst(5);
        node.right.left=new Bst(6);
        node.right.right=new Bst(2);
        return node;
    }

}
