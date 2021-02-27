package BinaryTree.traversals;

import java.util.Arrays;
import java.util.HashSet;

public class BoundaryTraversal {


     static HashSet<Integer> set=new HashSet<>();
     Node root;

    public static void main(String args[]){
        BoundaryTraversal obj=new BoundaryTraversal();
        obj.constructTree();
        obj.printBoundary(obj.root);
        System.out.println(Arrays.toString(set.toArray()));
    }

    static void printLeftBoundary(Node tree){
        if(tree!=null) {
            if (tree.left != null) {
                set.add(tree.left.value);
                tree = tree.left;
                printLeftBoundary(tree);
            } else if (tree.right != null) {
                set.add(tree.right.value);
                tree = tree.right;
                printLeftBoundary(tree);
            }
        }
    }

    static void printRightBoundary(Node tree){
        if(tree!=null) {
            if (tree.right != null) {
                set.add(tree.right.value);
                tree = tree.right;
                printRightBoundary(tree);
            } else if (tree.left != null) {
                set.add(tree.left.value);
                tree = tree.left;
                printRightBoundary(tree);
            }
        }
    }

    static void printLeaf(Node tree){
        if(tree!=null) {

            printLeaf(tree.left);
            if (tree.left == null && tree.right == null) {
                set.add(tree.value);
            }
            printLeaf(tree.right);

            }
        }

    void constructTree() {
          root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);

    }

    void printBoundary(Node root){

        set.add(root.value);
        printLeftBoundary(root);
        printRightBoundary(root);
        printLeaf(root.left);
        printLeaf(root.right );
    }

    static class Node{
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value=value;
            this.left=null;
            this.right=null;
        }
    }
}
