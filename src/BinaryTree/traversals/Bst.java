package BinaryTree.traversals;

public class Bst {
    int data;
    Bst left;
    Bst right;
    Bst(int value){
        this.data=value;
        this.left=null;
        this.right=null;
    }
    Bst(){

    }
    Bst constructTree(Bst node)
    {
        node=new Bst(1);
        node.left=new Bst(2);
        node.right=new Bst(3);
        node.left.left=new Bst(4);
        node.left.right=new Bst(5);
        node.right.left=new Bst(6);
        node.right.right=new Bst(7);
        return node;
    }

}
