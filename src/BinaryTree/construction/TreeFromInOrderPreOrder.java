package BinaryTree.construction;

public class TreeFromInOrderPreOrder {

    static int preOrderIndx=0;
public static void main(String args[]){

    int in[] = new int[] { 20, 25, 35, 50, 60, 75, 80};
    int pre[] = new int[] { 50 ,25, 20, 35, 75, 60, 80};


    printInorder(constructTree(in,pre,0,in.length-1));
}

    private static void printInorder(BST root) {
        if (root != null) {
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
        }

    }

    private static BST constructTree(int[] in, int[] pre, int start, int end) {

    if(start>end)//not checking in/pre array length each recursive call must end
        return null;
    BST node = new BST(pre[preOrderIndx++]);//value of preOrderIdx must be incremented here
    if(start==end)
        return node;
    int inOrderIdx = search(start,end,in,node.data);//static preOrderIdx should not be incremented here
    node.left=constructTree(in,pre,start,inOrderIdx-1);
    node.right=constructTree(in,pre,inOrderIdx+1,end);
    return node;

    }



    private static int search(int start, int end, int[] in,int value) {
    int idx=0;
    for(int i=start;i<end;i++){
        if(in[i]==value)
        {
            idx=i;
            break;
        }
    }
    return idx;


    }
    //      50
        //   25     75
        // 20   35 60   80

    //INORDER -   20 25 35 50 60 75 80
    //PREORDER -  50 25 20 35 75 60 80

}
