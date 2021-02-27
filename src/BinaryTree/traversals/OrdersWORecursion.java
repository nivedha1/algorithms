package BinaryTree.traversals;

import java.util.Stack;

/**
 *
 * @author nivedharajaram
 */
public class OrdersWORecursion {

    Tree root;

    public void insertTree() {
        root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.right = new Tree(8);
        root.right.left = new Tree(7);

    }
//1245378-pre
//4251738-in
//4527831-post

    public static void main(String args[]) {
        OrdersWORecursion l = new OrdersWORecursion();
        l.insertTree();

        //l.PrintInOrder();
        //l.printPreOrder();
        l.postOrder();
    }

    public void PrintInOrder() {
        Stack<Tree> stack = new Stack<Tree>();
        Tree current=root;
        while(!stack.isEmpty()||current!=null) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.println(current.value);
            current = current.right;
        }
    }
    private void postOrder() {

        Stack<Tree> stack = new Stack<Tree>();
        while(true) {
            while(root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }

            // Check for empty stack
            if(stack.empty()) return;
            root = stack.pop();

            if(!stack.empty() && stack.peek() == root) root = root.right;

            else {

                System.out.print(root.value + " "); root = null;
            }
        }

    }



    private void printPreOrder() {
        Stack<Tree> stack = new Stack<Tree>();
        Tree current=root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                System.out.println(current.value);
                stack.add(current);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;
        }
    }

    class Tree {

        int value;
        Tree left;
        Tree right;

        Tree(int a) {
            this.value = a;
            this.left = null;
            this.right = null;
        }
    }
}

