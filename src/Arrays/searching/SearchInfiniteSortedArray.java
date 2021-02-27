package Arrays.searching;

import java.util.Arrays;

public class SearchInfiniteSortedArray {

    public static void main(String args[]){

        int val=10;
        int[] arr={1,2,3,9,10,20,30};
        int high=1;
        int key=arr[0];
        int low=0;
        while(val>key){
            low=high;
            high=2*high;
            key=arr[high];
        }
        binarySearch(arr,low,high,val);
    }

    private static int binarySearch(int[] arr, int low, int high,int key) {

        if(low>high)
            return -1;
        int mid=(low+high)/2;
        if(arr[mid]==key)System.out.println(mid);
        if(arr[mid]>key)
            return binarySearch(arr,low,mid-1,key);
        return binarySearch(arr,mid+1,high,key);

    }


}
