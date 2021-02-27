package BinaryTree.construction;

public class MirrorTree {

    static BST root;
    void constructTree() {
        root = new BST(1);
        root.left = new BST(2);
        root.left.left = new BST(4);
        root.left.right = new BST(5);
        root.right = new BST(3);
        root.right.left = new BST(6);
        root.right.right = new BST(7);

    }
    public static void main(String[] args){
        MirrorTree tree=new MirrorTree();
        tree.constructTree();
        tree.levelOrder(root);

        tree.levelOrder(tree.mirrorTree(root));
    }

    private void levelOrder(BST mirrorTree) {

        int h=height(mirrorTree);
        for(int i=0;i<h;i++){
            printLevel(mirrorTree,i);
            System.out.println("*******");
        }

    }

    private void printLevel(BST mirrorTree,int level) {
        if(level==0) {
            System.out.print(mirrorTree.data);
        }
        else
        {
            printLevel(mirrorTree.left,level-1);
            printLevel(mirrorTree.right,level-1);
        }
    }

    private int height(BST mirrorTree) {

        if(mirrorTree==null)
            return 0;

        int lheight=height(mirrorTree.left);
        int rheight=height(mirrorTree.right);
        if(lheight>rheight)
            return lheight+1;
        else
            return rheight+1;
    }

    private BST mirrorTree(BST root) {

            if (root == null)
                return root;

            /* do the subtrees */
            BST left = mirrorTree(root.left);
            BST right = mirrorTree(root.right);

            /* swap the left and right pointers */
            root.left = right;
            root.right = left;

            return root;

    }

}
