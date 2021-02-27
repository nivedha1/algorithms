package BinaryTree.Hackerearth;
import java.util.*;

//https://www.geeksforgeeks.org/minimum-swap-required-convert-binary-tree-binary-search-tree/
class MinimumSwapsForBinaryTreetoBST {
    static int[] arr = {1, 2, 3, 4, 5, 6, 7 };
    //  1
    // 2   3
    //4 5 6 7
    int size=arr.length+1;
    int[] b = new int[size];
static int k=1;
    void inorder(int x,int[] arr){// convert level order to inorder
        if(2*x<size)
            inorder(2*x,arr);
        b[k++] = arr[x-1];
        if(2*x+1 <size)//this will fail after reaching root
            inorder(2*x+1,arr);
    }

    public static void main(String args[]){
        MinimumSwapsForBinaryTreetoBST obj = new MinimumSwapsForBinaryTreetoBST();
        obj.inorder(1,arr);
        obj.getSwaps(arr);
    }

    private void getSwaps(int[] arr) {
        boolean[] vis = new boolean[size];
        int x=0,y=0,ans=0;
        int[] A = new int[size];

        Arrays.sort(arr);//ideal inorder is sorted array
        for(int i=1;i<size;i++){
            A[arr[i-1]]=i;
        }
        for(int i=1;i<size;i++){
            if(vis[b[i]] == false && arr[i-1]!=b[i])
            {
                x=0;
                y=b[i];
                while(vis[y]==false)
                {
                    vis[y]=true;
                    y=b[A[y]];//can be replaced with b[y]
                    x++;
                }
                ans+=(x-1);
            }
        }
        System.out.println(ans);
    }


}

