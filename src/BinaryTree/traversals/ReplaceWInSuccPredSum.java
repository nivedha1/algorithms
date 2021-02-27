package BinaryTree.traversals;

import java.util.ArrayList;

public class ReplaceWInSuccPredSum {

    static int data = 1;

    static bst root;
    static ArrayList<Integer> arr = new ArrayList<Integer>();
    static int i;

    public static void main(String args[]) {
        ReplaceWInSuccPredSum a = new ReplaceWInSuccPredSum();
        a.insertbst();
        arr.add(0);
        a.constructArr(root);
        arr.add(0);
        a.constructTree(root);
        a.printTree(root);
    }

    public static void constructArr(bst root) {
        if (root != null) {
            constructArr(root.left);
            arr.add(root.value);
            constructArr(root.right);
        }
    }

    public static void printTree(bst root) {
        if (root != null) {
            printTree(root.left);
            System.out.println(root.value);
            printTree(root.right);
        }
    }

    public static void constructTree(bst root) {

        if (root != null) {
            constructTree(root.left);
            root.value = arr.get(data - 1) + arr.get(data + 1);
            data++;
            constructTree(root.right);
        }
    }
    //     1
    //   2     3
    //4    5 6   7
    //  4,2,5,1,6 ,3 ,7
    //0,2,9,3,11,4,13,3,0

    public void insertbst() {
        root = new bst(1);
        root.left = new bst(2);
        root.right = new bst(3);
        root.left.left = new bst(4);
        root.left.right = new bst(5);
        root.right.right = new bst(7);
        root.right.left = new bst(6);
    }

    class bst {

        int value;
        bst left;
        bst right;

        bst(int a) {
            this.value = a;
            this.left = null;
            this.right = null;
        }
    }
}


