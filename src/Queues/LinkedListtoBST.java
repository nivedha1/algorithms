package Queues;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListtoBST {
int data;
    LinkedListtoBST next;
    LinkedListtoBST(int data){
        this.data=data;
        this.next=null;
    }
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

    BinaryTree convertList2Binary(LinkedListtoBST list){
        Queue<BinaryTree> queue=new LinkedList<BinaryTree>();
        BinaryTree tree = new BinaryTree(list.data);
        queue.add(tree);
        while(!queue.isEmpty()||list!=null){
            if(list.next==null)
                return tree;
            BinaryTree parent = queue.poll();
            if(list.next!=null) {
                list = list.next;
                parent.left = new BinaryTree(list.data);
                queue.add(parent.left);
            }
            if(list.next!=null) {
                list = list.next;
                parent.right = new BinaryTree(list.data);
                queue.add(parent.right);
            }
        }
        return tree;
    }
    void inorderTraversal(BinaryTree node){
        if(node==null)
            return;
        inorderTraversal(node.left);
        System.out.println(node.value);
        inorderTraversal(node.right);
    }
    public static void main(String args[]){//level order traversal of list in linked list
        LinkedListtoBST list = new LinkedListtoBST(10);
        list.next=new LinkedListtoBST(12);
        list.next.next=new LinkedListtoBST(15);
        list.next.next.next=new LinkedListtoBST(25);
        list.next.next.next.next=new LinkedListtoBST(30);
        list.next.next.next.next.next=new LinkedListtoBST(35);
        BinaryTree node = list.convertList2Binary(list);

        System.out.println("Inorder Traversal of the"+
                " constructed Binary Tree is:");
        list.inorderTraversal(node);
    }
}
