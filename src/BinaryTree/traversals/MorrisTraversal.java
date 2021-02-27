package BinaryTree.traversals;

public class MorrisTraversal {


    static Node root;
    static void constructTree(){
        root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

    }
    public static void main(String args[])
    {
        constructTree();
        printMorrisInorderTraversal(root);// 4 2 5 1 6 3 7
        printMorrisPreorderTraversal(root);//1 2 4 5 3 6 7
    }

    private static void printMorrisPreorderTraversal(Node current) {

        while(current!=null){
            if(current.left==null){
                System.out.println(current.value);
                current=current.right;
            }
            else{
                Node pre=current.left;
                while(pre.right!=null&&current!=pre.right)
                    pre=pre.right;
                if(pre.right==null){
                    System.out.println(current.value);
                    pre.right=current;
                    current=current.left;
                }
                else{
                    pre.right=null;
                    current=current.right;
                }
            }
        }









    }
    //       1
    //    2     3
    //  4   5  6  7
    //4 2 5 1 6 3 7

    static void printMorrisInorderTraversal(Node current){
        while(current!=null)
        {
            if(current.left==null)
            {
                System.out.println(current.value);
                current=current.right;
            }
            else{
                Node pre = current.left;
                while(pre.right!=null&&pre.right!=current){
                    pre=pre.right;
                }
                if(pre.right==null){
                    pre.right=current;
                    current=current.left;
                }
                else{
                    pre.right=null;
                    System.out.println(current.value);
                    current=current.right;
                }
            }
        }

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
