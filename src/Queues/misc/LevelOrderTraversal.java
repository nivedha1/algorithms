package Queues.misc;

public class LevelOrderTraversal {
    BinaryTree tree;
    static int sum=0;
    static int avg=0;
    static int count=0;
    static BinaryTree one;
    static BinaryTree two;
    class BinaryTree{
        int value;
        BinaryTree left;
        BinaryTree right;
        BinaryTree(int data){
            this.value=data;
            this.left=null;
            this.right=null;
        }
    }
    BinaryTree constructTree() {
        tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(7);
        tree.left.right = new BinaryTree(6);
        tree.right.left = new BinaryTree(5);
        tree.right.right = new BinaryTree(4);
        return tree;
    }

    int height(BinaryTree node){
        if(node==null)
            return 0;
        int lheight=height(node.left);
        int rheight=height(node.right);
        if(lheight>rheight)
            return lheight+1;
        else
            return rheight+1;
    }
    static void swapEveryKLevelUtil( BinaryTree root, int level, int k)
    {
        // base case
        if (root== null ||
                (root.left==null && root.right==null) )
            return ;
       if ( (level + 1) % k == 0)
        {
            BinaryTree temp=root.left;
            root.left=root.right;
            root.right=temp;
        }

        // Recur for left and right subtrees
        swapEveryKLevelUtil(root.left, level+1, k);
        swapEveryKLevelUtil(root.right, level+1, k);
    }
    public static void main(String args[]){
       LevelOrderTraversal order=new LevelOrderTraversal();
       BinaryTree tree=order.constructTree();
       int height=order.height(tree);
       for(int i=0;i<height;i++) {
           order.printLevelOrder(tree, i);
           System.out.println("****");
       }
       boolean ltr=false;
        for(int i=0;i<height;i++) {
            order.printLevelOrderInSpiralForm(tree, i,ltr);
            ltr=!ltr;
            System.out.println("****");
        }
        int maxsum=0;
        for(int i=0;i<height;i++) {
            sum=order.printLevelOrderMaxSum(tree, i);
            if(maxsum<sum)
                maxsum=sum;
            sum=0;
        }
        System.out.println(maxsum);
        for(int i=0;i<height;i++) {
            System.out.println(order.printAverage(tree, i));
            sum=0;count=0;
            System.out.println("****");
        }
        order.swapEveryKLevelUtil(tree,1,2);
        order.swapLeafNodes(tree,0);
        order.removeShortestPathLengthLessthanK(tree,1,1);
        tree=order.constructTree();
    }

    private BinaryTree removeShortestPathLengthLessthanK(BinaryTree tree,int level, int k) {
         if (tree == null)
                return null;
        tree.left = removeShortestPathLengthLessthanK(tree.left, level + 1, k);
        tree.right = removeShortestPathLengthLessthanK(tree.right, level + 1, k);
            if (tree.left == null && tree.right == null && level < k)
                return null;

            // Return root;
            return tree;
    }

    //https://www.geeksforgeeks.org/pairwise-swap-leaf-nodes-binary-tree/
    private void swapLeafNodes(BinaryTree tree,int count) {

            if (tree==null)
            return;

            // if node is leaf node, increment count
            if(tree.left==null&&tree.right==null)
            {
                two  = tree;
                // increment count
                count++;
                // if count is even, swap first
                // and second pointers
                if (count%2 == 0) {
                    BinaryTree temp = one;
                    one = two;
                    two = temp;
                }
                else
                    // if count is odd, initialize
                    // first pointer by second pointer
                    one  = two;
            }
            if (tree.left!=null)
                swapLeafNodes(tree.left, count);
            if (tree.right!=null)
                swapLeafNodes(tree.right, count);

    }

    private int printAverage(BinaryTree tree, int level) {
        if(level==0) {
            sum = sum + tree.value;
            count++;
        }else{
            printAverage(tree.left, level - 1);
            printAverage(tree.right, level - 1);
        }
        return sum/count;
    }

    private int printLevelOrderMaxSum(BinaryTree tree, int level) {
        if(level==0)
            sum=sum+tree.value;
        else{
               printLevelOrderMaxSum(tree.left, level - 1);
                printLevelOrderMaxSum(tree.right, level - 1);
        }
        return sum;
    }

    private void printLevelOrderInSpiralForm(BinaryTree tree, int level,boolean leftToRight) {
        if(level==0)
            System.out.print(tree.value);
        else{
            if(leftToRight) {
                printLevelOrderInSpiralForm(tree.left, level - 1,leftToRight);
                printLevelOrderInSpiralForm(tree.right, level - 1,leftToRight);
            }
            else{
                printLevelOrderInSpiralForm(tree.right,level-1,leftToRight);
                printLevelOrderInSpiralForm(tree.left,level-1,leftToRight);
            }
        }
    }

    private void printLevelOrder(BinaryTree tree, int level) {
        if(level==0)
            System.out.print(tree.value);
        else{
            printLevelOrder(tree.left,level-1);
            printLevelOrder(tree.right,level-1);
        }
    }
}
