package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTraversal {
BinaryTree tree;
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
    BinaryTree constructTree(){
    tree = new BinaryTree(1);
    tree.left = new BinaryTree(2);
    tree.right = new BinaryTree(3);
    tree.left.left = new BinaryTree(7);
    tree.left.right = new BinaryTree(6);
    tree.right.left = new BinaryTree(5);
    tree.right.right = new BinaryTree(4);
        tree.left.left.left = new BinaryTree(8);
        tree.left.left.right = new BinaryTree(9);
        tree.left.right.left = new BinaryTree(10);
        tree.left.right.right = new BinaryTree(11);

        tree.right.left.left = new BinaryTree(12);
        tree.right.left.right = new BinaryTree(13);
       tree.right.right.left = new BinaryTree(14);
        tree.right.right.right = new BinaryTree(15);

        return tree;
}

void printZigZag(){
        Stack<BinaryTree> currStack=new Stack<BinaryTree>();
    Stack<BinaryTree> nextStack=new Stack<BinaryTree>();
    currStack.add(tree);
        boolean reverse = false;

while(!currStack.isEmpty()||!nextStack.isEmpty())
{
            if(!reverse) {
                while(!currStack.isEmpty()) {
                    BinaryTree node = currStack.pop();
                    System.out.println(node.value);
                    if (node.left != null)
                        nextStack.add(node.left);
                    if (node.right != null)
                        nextStack.add(node.right);

                }reverse = !reverse;
            }
            if(reverse) {
                while (!nextStack.isEmpty()) {
                    BinaryTree node = nextStack.pop();
                    System.out.println(node.value);
                    if (node.right != null)
                        currStack.add(node.right);
                    if (node.left != null)
                        currStack.add(node.left);

                }reverse = !reverse;
            }
        }

}
    public static void main(String args[]){
        ZigZagTraversal obj = new ZigZagTraversal();
        obj.constructTree();
        obj.printZigZag();
    }
}
