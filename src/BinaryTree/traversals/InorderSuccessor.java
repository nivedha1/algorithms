package BinaryTree.traversals;

public class InorderSuccessor {

    static Node root=null;
    static Node next = null;

    static void constructTree(){
        root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right=new Node(7);
    }


    public static void main(String args[])
    {
        constructTree();
        InorderSuccessor(root);
        root=root.left.left;
        while (root != null)
        {
            // -1 is printed if there is no successor
            int print = root.next != null ? root.next.value : -1;
            System.out.println("Next of " + root.value + " is: " + print);
            root = root.next;
        }
    }
    //       1
    //    2     3
    //  4   5  6  7
    //4 2 5 1 6 3 7

    static void InorderSuccessor(Node current) {
        if (current != null) {
            InorderSuccessor(current.right);
            current.next = next;
            next = current;
            InorderSuccessor(current.left);
        }
    }

    static class Node{
        int value;
        Node left;
        Node right;
        Node next=null;
        Node(int value){
            this.value=value;
            this.left=null;
            this.right=null;
            this.next=null;
        }
    }
}
