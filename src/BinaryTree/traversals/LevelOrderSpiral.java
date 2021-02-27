package BinaryTree.traversals;

public class LevelOrderSpiral {

        public static void main(String args[])
        {
            Bst2 bst = new Bst2();
            bst = bst.constructTree(bst);
            int h = findHeight(bst);
            boolean rev=false;
            for(int i=0;i<=h;i++){
                if(i%2==0) {
                    rev = !rev;
                    printSpiral(bst, i, rev);
                }
                else{
                    rev = !rev;
                    printSpiral(bst, i, rev);
                }
                System.out.println("******");
            }
        }

    private static void printSpiral(Bst2 bst, int i, boolean rev) {
            if(bst==null)
                return;
            if(i==1)
                System.out.println(bst.data);
            else{
                if(rev)
                {
                    printSpiral(bst.left,i-1,rev);
                    printSpiral(bst.right,i-1,rev);
                }
                else if(!rev)
                {
                    printSpiral(bst.right,i-1,rev);
                    printSpiral(bst.left,i-1,rev);
                }

            }

    }

    private static int findHeight(Bst2 bst) {
            if(bst==null)
                return 0;
            int lheight = findHeight(bst.left);
            int rheight=findHeight(bst.right);
            if(lheight>rheight)
                return lheight+1;
            else
                return rheight+1;
    }


}
class Bst2 {
    int data;
    Bst2 left;
    Bst2 right;

    Bst2(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
    }
    Bst2(){

    }
    Bst2 constructTree(Bst2 node)
    {
        node=new Bst2(1);
        node.left=new Bst2(2);
        node.right=new Bst2(3);
        node.left.left=new Bst2(4);
        node.left.right=new Bst2(5);
        node.right.left=new Bst2(6);
        node.right.right=new Bst2(7);
        return node;
    }
}