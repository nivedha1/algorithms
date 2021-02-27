package BinaryTree.misc;

import java.util.HashMap;

class BST{
    int data;
    BST left;
    BST right;
    BST(int d){
        this.data=d;
    }
}
public class misc {

    public static void main(String args[]){
        BST tree = new BST(10);
        tree.left = new BST(20);
        tree.right = new BST(12);
        tree.left.left = new BST(15);
        tree.left.right = new BST(25);
        tree.right.left = new BST(30);
        tree.right.right = new BST(36);
        swapEveryKLevelUtil(tree,1,2);
        printInorder(tree);
        inorderDuplicates(tree);//81
        T t = new T();
        traverse(tree,t);//80
        deepestOddLevelDepthUtil(tree,0);

    }
    static int deepestOddLevelDepthUtil(BST curr_node, int curr_level)
    {
        // Base case
        // return from here
        if ( curr_node == null)
            return 0;

        // increment current level
        curr_level += 1;
        if ( curr_level % 2 != 0 && (curr_node.left==null&&curr_node.right==null))
            return curr_level;

        return Math.max(deepestOddLevelDepthUtil(curr_node.left,curr_level),
                deepestOddLevelDepthUtil(curr_node.right,curr_level));
    }

    private static void printInorder(BST tree) {
        if(tree!=null){
            printInorder(tree.left);
            System.out.println(tree.data);
            printInorder(tree.right);
        }
    }

    static void swapEveryKLevelUtil( BST root, int level, int k)
    {
        if (root== null ||
                (root.left==null && root.right==null) )
            return ;

        //if current level + 1 is present in swap vector
        //then we swap left & right node
        if ( (level + 1) % k == 0)
        {
        BST    temp=root.left;
            root.left=root.right;
            root.right=temp;
        }

        // Recur for left and right subtrees
        swapEveryKLevelUtil(root.left, level+1, k);
        swapEveryKLevelUtil(root.right, level+1, k);

    }
    static HashMap<String, Integer> m=new HashMap<>();

    static String inorderDuplicates(BST node)
    {
        if (node == null)
            return "";

        String str = "(";
        str += inorderDuplicates(node.left);
        str += Integer.toString(node.data);
        str += inorderDuplicates(node.right);
        str += ")";

        // Subtree already present (Note that we use
        // HashMap instead of HashSet
        // because we want to print multiple duplicates
        // only once, consider example of 4 in above
        // subtree, it should be printed only once.
        if (m.get(str) != null && m.get(str)==1 )
            System.out.print( node.data + " ");

        if (m.containsKey(str))
            m.put(str, m.get(str) + 1);
        else
            m.put(str, 1);


        return str;
    }

    static int traverse(BST root, T t )
    {
        if (root == null)
            return 0;

        // Compute tilts of left and right subtrees
        // and find sums of left and right subtrees
        int left = traverse(root.left, t);
        int right = traverse(root.right, t);

        // Add current tilt to overall
        t.tilt += Math.abs(left - right);

        // Returns sum of nodes under current tree
        return left + right + root.data;
    }
}
class T{
    int tilt;
}