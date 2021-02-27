package BinaryTree.construction;

public class TreeFromInorderLevelOrder {

    public static void main(String args[]){

        int in[] = new int[] { 20, 25, 35, 50, 60, 75, 80};
        int level[] = new int[] { 50 ,25, 75, 20, 35, 60, 80};


        printInorder(constructTree(in,level,0,in.length-1));
    }

    private static BST constructTree(int[] in, int[] level, int start, int end) {

        if(start>end)
            return null;
        if(start==end)
             return new BST(in[start]);
        int inIdx=search(in,level,start,end);
        BST node = new BST(in[inIdx]);
        node.left=constructTree(in,level,start,inIdx-1);
        node.right=constructTree(in,level,inIdx+1,end);
        return node;
    }

    private static int search(int[] in, int[] level, int start, int end) {

        int idx=0;boolean found=false;
        for(int j=0;j<level.length;j++) {
            found=false;
            for (int i = start; i < end; i++) {
                if (in[i] == level[j]) {
                    found=true;
                    idx = i;
                    break;
                }
            }
            if(found==true)
                break;
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
