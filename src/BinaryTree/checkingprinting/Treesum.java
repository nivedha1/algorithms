package BinaryTree.checkingprinting;

public class Treesum {

    static Bst bst = null;
    static int n=0;
    public static void main(String args[])
    {
        Treesum obj = new Treesum();
        obj.constructTree();
        System.out.println(obj.isNodeSumofLeftandRightNode(bst));//node data is sum of immediate left and right noode
        System.out.println(obj.isTreeSumTree(bst));//node data is sum of ll left nodes and right nodes
        System.out.println(obj.sumofCoveredEqualssumofUncovered(bst));
        //Uncovered if it appears either on left boundary or right boundary. Rest of the nodes are called covered
        n = count(bst);
        System.out.println(obj.isRemoveEdgeSplitBinaryTreeToTwoHalves(bst));
    }



    private boolean isRemoveEdgeSplitBinaryTreeToTwoHalves(Bst bst) {

        if(bst==null)
            return false;
        if(count(bst) == n-count(bst))
            return true;
        return isRemoveEdgeSplitBinaryTreeToTwoHalves(bst.left)||isRemoveEdgeSplitBinaryTreeToTwoHalves(bst.right);

    }
    private static int count(Bst bst) {
        if(bst==null)
            return 0;
        return count(bst.left)+count(bst.right)+1;


    }
    private boolean sumofCoveredEqualssumofUncovered(Bst bst) {
        System.out.println(sum(bst) +","+ sumofUC(bst));

        if(sumofUC(bst)==(sum(bst)-sumofUC(bst))) {

            return true;
        }
        return false;
    }

    private int sumofUC(Bst bst) {
        return sumofUCLeft(bst.left)+bst.data+sumofUCRight(bst.right);
        
        
    }

    private int sumofUCRight(Bst bstright) {
        if(bstright==null)
            return 0;
        if(bstright.right!=null)
            return bstright.data+sumofUCRight(bstright.right);
        else
            return bstright.data+sumofUCRight(bstright.left);

    }

    private int sumofUCLeft(Bst bstleft) {
        if(bstleft==null)
            return 0;
        if(bstleft.left!=null)
            return bstleft.data+sumofUCLeft(bstleft.left);
        else
            return bstleft.data+sumofUCLeft(bstleft.right);
        
    }


    private int sum(Bst node) {
        if(node==null){
            return 0;
        }
        else {
             return sum(node.left) + node.data + sum(node.right);
        }
    }

    private void constructTree() {
        bst = new Bst(10);
        bst.left = new Bst(8);
        bst .right = new Bst(2);
        bst.left.left = new Bst(5);
        bst.left.right = new Bst(3);
        bst.right.left = new Bst(2);
    }

    private boolean isNodeSumofLeftandRightNode(Bst bst){
        int leftdata=0;
        int rightdata=0;
        if(bst == null||(bst.left==null&&bst.right==null))
            return true;

        if(bst.left!=null)
            leftdata=bst.left.data;
        if(bst.right!=null)
            rightdata=bst.right.data;


        return (bst.data==leftdata+rightdata)&&
                    isNodeSumofLeftandRightNode(bst.left)&&
                isNodeSumofLeftandRightNode(bst.right);

    }
    private boolean isTreeSumTree(Bst bst) {
        int leftdata=0;
        int rightdata=0;
        if(bst==null||(bst.left==null&&bst.right==null))
            return true;
        if(bst.left!=null)
            leftdata=sum(bst.left);
        if(bst.right!=null)
            rightdata=sum(bst.right);
        if(bst.data==leftdata+rightdata&&
                isTreeSumTree(bst.left)&&
                isTreeSumTree(bst.right));
        return false;
    }

}
