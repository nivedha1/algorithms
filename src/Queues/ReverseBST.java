package Queues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class BST {
    int data;
    BST left;
    BST right;

    BST(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
    }
}

public class ReverseBST {
    static BST bst;


    public static void main(String args[]) {

        ReverseBST obj = new ReverseBST();
        int[] arr = {50, 30, 20, 40, 70, 60, 80};

        for (int i : arr) {
            bst = obj.insertTree(bst, i);
        }
        printInorder(bst);
        Queue<Integer> q = new LinkedList<Integer>();
        reversePath(bst, q, 80);
        System.out.println("*********");
        printInorder(bst);
    }

    private static void printInorder(BST bst) {


        if (bst != null) {
            printInorder(bst.left);
            System.out.println(bst.data);
            printInorder(bst.right);
        }
    }

    private static BST reversePath(BST bst, Queue<Integer> q, int key) {

        if (bst == null)
            return null;
        if (bst.data == key) {
            q.add(bst.data);
            if (!q.isEmpty()) {
                bst.data = q.poll();
            }
            return bst;
        } else if (key < bst.data) {
            q.add(bst.data);
            reversePath(bst.left, q, key);

            if (!q.isEmpty()) {//one level top to bst.left will be updated
                bst.data = q.poll();

            }
        } else if (key > bst.data) {
            q.add(bst.data);
            reversePath(bst.right, q, key);

            if (!q.isEmpty()) {//the one level top to bst.right will be updated
                bst.data = q.poll();

            }
        }

        return bst;
    }

    private BST insertTree(BST bst, int key) {
        if (bst == null) {
            bst = new BST(key);
            return bst;
        }
        if (bst.data > key)
            bst.left = insertTree(bst.left, key);
        else
            bst.right = insertTree(bst.right, key);

        return bst;
    }


}
