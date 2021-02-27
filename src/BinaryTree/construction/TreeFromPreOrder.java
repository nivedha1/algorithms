package BinaryTree.construction;

public class TreeFromPreOrder {
static int preOrderIndx=0;
    public static void main(String args[]){
        int pre[] = new int[] { 50,25,20,35,75,60,80};
        //int post[] = new int[] { 20,35,25,60,80,75,50 };
        printInorder(constructTree(pre,0,pre.length-1));
    }
//         50
//   25        75
//20    35   60    80

    // 20 25 35 50 60 75 80
    private static BST constructTree(int[] pre, int start, int end) {

        if(start>end||preOrderIndx>pre.length-1)
            return null;
        BST node = new BST(pre[preOrderIndx]);
        preOrderIndx++;
        if(start==end)
            return node;
        int idx=search(start,end,node.data,pre);
        node.left=constructTree(pre,preOrderIndx,idx-1);//start is root+1
        node.right=constructTree(pre,idx,end);

        return node;


    }
//find first element gretaer than root.

    private static int search(int start, int end, int value,int[] pre) {
        int idx=0;
        for(int i=start;i<=end;i++){
            if(pre[i]>value)
            {
                idx=i;
                break;
            }
        }
        return idx;


    }

    //         50
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
