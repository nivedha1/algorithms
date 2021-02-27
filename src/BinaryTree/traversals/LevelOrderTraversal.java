package BinaryTree.traversals;

public class LevelOrderTraversal {

    Node root;

    public static void main(String args[]){
        LevelOrderTraversal obj=new LevelOrderTraversal();
        obj.constructTree();
        obj.levelOrderPrint();
    }
  void levelOrderPrint(){

        int h=calHeight(root);
        for(int i=0;i<=h;i++) {
            printLevel(root, i);
            System.out.println("");
        }
  }

    private void printLevel(Node root,int level) {
        if(root==null)
            return;
        if(level==1)
            System.out.println(root.value);
        else
        {
            printLevel(root.left,level-1);
            printLevel(root.right,level-1);
        }

    }

    int calHeight(Node root){

        if(root==null)
            return 0;

        int lheight=calHeight(root.left);
        int rheight=calHeight(root.right);
        if(lheight>rheight)
            return lheight+1;
        else return rheight+1;

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
    void constructTree() {
        root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);

    }

    //      20
    //    8      22
    //4    12       25
    //   10   14
}
