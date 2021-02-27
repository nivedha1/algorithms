package BinaryTree.construction;

import java.util.Stack;

public class ConvertToSumTree {
    static Node root = null;
    int oldval = 0;
    static int sum=0;
    static Node prev=null;
    static Node head=null;
    public static void main(String args[]) {
        ConvertToSumTree obj = new ConvertToSumTree();
        obj.constructTree();
        obj.convertToSumTree(root);
        obj.printInorder(root);
        obj.constructTree();
        obj.storeLeftSum(root);
        obj.constructTreeLogicalAnd();
        obj.convertLogicalAnd(root);
        obj.printInorder(root);
        obj.constructTree();;
        obj.toSmallersumTree(root);//each node will have sum of all node smaller than it
        obj.printInorder(root);
        obj.constructTree();
        sum=0;
         Node root = new Node(11);
        root.left = new Node(2);
        root.right = new Node(29);
        root.left.left = new Node(1);
        root.left.right = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(40);
        root.right.right.left = new Node(35);

        obj.toGreaterTree(root);//each node will have sum of all node greater than it exclusing iteself
        obj.printInorder(root);
        obj.BinaryTree2DoubleLinkedList(root);

            while (head != null)
            {
                System.out.print(head.data + " ");
                head = head.right;
            }
obj.toSortedLinkList(root);
            obj.closestValueUtil(root,15,Integer.MAX_VALUE);
    }

//flatten  list to pre order
    public void flatten(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node prev = null;
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            if (prev != null) {
                prev.right = node;
            }
            prev = node;
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            node.left = null;
            node.right = null;
        }
    }
    private int closestValueUtil(Node root, double target, int result) {
        if (root == null) {
            return (int)result;
        }
        if (target == root.data) {
            return root.data;
        }
        if (Math.abs(root.data - target) < Math.abs(result - target)) {
            result = root.data;
        }
        if (target < root.data) {
            return closestValueUtil(root.left, target, result);
        } else {
            return closestValueUtil(root.right, target, result);
        }
    }
    public Node toSortedLinkList(Node root){
        if(root == null){
            return null;
        }

        Node left = toSortedLinkList(root.left);
        Node right = toSortedLinkList(root.right);

        root.left = null;
        root.right = null;
        root = merge(left,root);
        return merge(root,right);
    }

    private Node merge(Node head1,Node head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        if(head1.data <= head2.data){
            head1.next = merge(head1.next, head2);
            return head1;
        }else{
            head2.next = merge(head1,head2.next);
            return head2;
        }
    }
    void BinaryTree2DoubleLinkedList(Node root)
    {
        // Base case
        if (root == null)
            return;

        // Recursively convert left subtree
        BinaryTree2DoubleLinkedList(root.left);

        // Now convert this node
        if (prev == null)
            head = root;
        else
        {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        // Finally convert right subtree
        BinaryTree2DoubleLinkedList(root.right);
    }
    //In the below two functions all left sum and right sum of elements in left and right can be got with/without
    // adding current node
    private void toGreaterTree(Node root) {
        //BST construction 6
        if(root==null)
            return;
        toGreaterTree(root.right);
        sum=sum+root.data;
        root.data=sum-root.data;//exclusing itself
        toGreaterTree(root.left);
    }

    private void toSmallersumTree(Node root) {

        if(root==null)
            return;
        toSmallersumTree(root.left);
        sum=sum+root.data;
        root.data=sum;//inclusing itself
        toSmallersumTree(root.right);
    }

    private Node convertLogicalAnd(Node root) {//Postorder traversal since root is updated after left and right

        if (root == null)
            return root;
        else {
            convertLogicalAnd(root.left);
            convertLogicalAnd(root.right);
            if (root.left != null && root.right != null)
                root.data = root.left.data & root.right.data;
        }
        return root;
    }
    //difference bwteen 1st two and this sum
//only left nodes will add up not right nodes

    private int storeLeftSum(Node root) {

        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.data;
        else {
            int leftsum = storeLeftSum(root.left);
            int rightsum = storeLeftSum(root.right);
            root.data = root.data + leftsum;
            return root.data + rightsum;
        }

    }

    private void printInorder(Node root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }
    }

    private int convertToSumTree(Node root) {
        if (root == null)
            return 0;

        int old_val = root.data;

        root.data = convertToSumTree(root.left) + convertToSumTree(root.right);

        return root.data + old_val;

    }

    void constructTree() {
        root = new Node(8);            //        8
        root.left = new Node(5);       //    5       11
        root.left.left = new Node(4);   //4     610     15
        root.left.right = new Node(6);
        root.right = new Node(11);
        root.right.left = new Node(10);
        root.right.right = new Node(15);

    }

    void constructTreeLogicalAnd() {
        root = new Node(0);
        root.left = new Node(1);
        root.left.left = new Node(0);
        root.left.right = new Node(1);
        root.right = new Node(0);
        root.right.left = new Node(1);
        root.right.right = new Node(1);

    }

    static class Node {
        int data;
        Node left;
        Node right;
Node next;
        Node(int value) {
            this.data = value;
            this.left = null;
            this.right = null;
        }
    }
}

