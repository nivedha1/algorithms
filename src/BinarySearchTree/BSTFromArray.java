package BinarySearchTree;
import java.util.*;
public class BSTFromArray {
        static BST bst=null;
        public static void main(String args[] ) throws Exception {
            //Scanner
            Scanner s = new Scanner(System.in);
            int[] arr = { 1,6,7,8,2,3,5,4};
            for(int i:arr) {
                constructTreeFromUnSortedArray(bst,i);
            }
            Arrays.sort(arr);

            constructTreeFromSortedArray(arr,0,arr.length-1,bst);
        }
        // 1 2 3 4 5 mid 2
        static BST constructTreeFromSortedArray(int[] arr,int start,int end,BST bst){

            if(start>end)
                return null;
            int mid=(start+end)/2;
            bst = new BST(arr[mid]);

            bst.left = constructTreeFromSortedArray(arr,start,mid-1,bst);
            bst.right = constructTreeFromSortedArray(arr,mid+1,end,bst);
            return bst;
        }
    static BST constructTreeFromUnSortedArray(BST root,int key){

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new BST(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.data)
            root.left = constructTreeFromUnSortedArray(root.left, key);
        else if (key > root.data)
            root.right = constructTreeFromUnSortedArray(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }
    }
    class BST{
        int data;BST left;
        BST right;
        BST(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }


