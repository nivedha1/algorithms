package BinaryTree.traversals;

import java.util.LinkedList;
import java.util.Queue;

public class Diagonal {

    public static void main(String args[]) {
        Bst1 root = new Bst1(8);
        root.left = new Bst1(3);
        root.right = new Bst1(10);
        root.left.left = new Bst1(1);
        root.left.right = new Bst1(6);
        root.right.right = new Bst1(14);
        root.right.right.left = new Bst1(13);
        root.left.right.left = new Bst1(4);
        root.left.right.right = new Bst1(7);
        printDiagonal(root);
    }

    private static void printDiagonal(Bst1 root) {
        Queue<Bst1> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Bst1 node = queue.peek();
            queue.remove();
            if (node == null) {
                if (queue.isEmpty())
                    return;
                System.out.println("*****");
                queue.add(null);
            } else {
                while (node != null) {
                    System.out.println(node.data);

                    if (node.left != null)
                        queue.add(node.left);
                    node = node.right;
                }

            }
        }
    }
}
class Bst1 {
    int data;
    Bst1 left;
    Bst1 right;

    Bst1(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
    }
}