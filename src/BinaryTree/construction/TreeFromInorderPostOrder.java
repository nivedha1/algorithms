package BinaryTree.construction;

public class TreeFromInorderPostOrder {


    public static void main(String args[]){
        int in[] = new int[] { 20, 25, 35, 50, 60, 75, 80};
        int post[] = new int[] { 20,35,25,60,80,75,50 };
        printInorder(constructTree(in,post,0,in.length-1));
    }
    static int postOrderIdx=6;//note this is length of postorder/inorder

    private static BST constructTree(int[] in, int[] post, int start, int end) {

        if(start>end)
            return null;
        BST node = new BST(post[postOrderIdx--]);
        if(start==end)
            return node;
        int inOrderIdx=search(in,start,end,node.data);
        node.right=constructTree(in,post,inOrderIdx+1,end);
        node.left=constructTree(in,post,start,inOrderIdx-1);
        return node;

    }

    private static int search(int[] in, int start, int end, int data) {
        int idx=0;
        for(int i=start;i<end;i++)
        {
            if(in[i]==data)
            {
                idx=i;
                break;
            }
        }
        return idx;
    }

    //           50
    //     25      75
    //   20   35 60    80

    private static void printInorder(BST root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }

    }
}
