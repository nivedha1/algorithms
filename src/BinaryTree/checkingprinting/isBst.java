package BinaryTree.checkingprinting;



public class  isBst {

    static Bst bst=null;

    public static  void main(String args[]){

        constructTree();
        System.out.println(isBSTUtil(bst,Integer.MIN_VALUE,Integer.MAX_VALUE));
        System.out.println(isBstcontaindeadend(bst, Integer.MIN_VALUE,Integer.MAX_VALUE));//if a node life   // 4
                                                                                                            // 3    5
        //exist no number greater than 3 can be put on right of 3 as it will become gretaer
        // than  4 which is not a property ofBST

    }

    private static boolean isBstcontaindeadend(Bst root, int min, int max) {

            // if the root is null or the recursion moves
            // after leaf node it will return false
            // i.e no dead end.
            if (root==null)
                return false;

            // if this occurs means dead end is present.
            if (min == max)
                return true;

            // heart of the recursion lies here.
            return isBstcontaindeadend(root.left, min, root.data - 1) ||
                    isBstcontaindeadend(root.right, root.data + 1, max);

    }

    private static void constructTree() {
        bst = new Bst(6);
        bst.left=new Bst(4);
        bst.right = new Bst(8);
        bst.left.left=new Bst(3);
        bst.left.right = new Bst(5);
        bst.right.left=new Bst(7);
        bst.right.right = new Bst(9);
    }

    static boolean isBSTUtil(Bst node, int min, int max)
    {
        /* an empty tree is BST */
        if (node == null)
            return true;

        /* false if this node violates the min/max constraints */
        if (node.data < min || node.data > max)
            return false;

        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.data-1) &&
                isBSTUtil(node.right, node.data+1, max));
    }
}
