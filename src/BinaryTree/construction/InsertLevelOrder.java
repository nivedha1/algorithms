package BinaryTree.construction;

public class InsertLevelOrder {


    public static void main(String args[])
    {
        InsertLevelOrder obj = new InsertLevelOrder();
        int arr[] = { 1, 2, 3, 4, 5, 6, 6, 6, 6 };
        BST bst = new BST(arr[0]);
        obj.printInorder(obj.insertLevelOrder(arr, bst, 0));

    }

    private void printInorder(BST bst) {
        if(bst!=null){
            printInorder(bst.left);
            System.out.println(bst.data);
            printInorder(bst.right);
        }
    }

    private BST insertLevelOrder(int[] arr, BST bst, int i) {

        if(i<arr.length){
            bst = new BST(arr[i]);
            if(2*i+1<arr.length)
                bst.left=insertLevelOrder(arr,bst,2*i+1);
            if(2*i+2 < arr.length)
                bst.right=insertLevelOrder(arr,bst,2*i+2);
        }
        return bst;
    }
}
