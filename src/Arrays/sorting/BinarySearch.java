package Arrays.sorting;

public class BinarySearch {

    public static void main(String args[]){
        BinarySearch obj = new BinarySearch();
        int[] sortedArr = { 1,3,5,7,9,11,15};
        obj.search(sortedArr,0,sortedArr.length-1,9);
    }

    private void search(int[] arr, int left, int right,int key) {

        if(left>right){
            System.out.println("Elment not found");
            return;}

        int mid = (left+right)/2;

        if(arr[mid]==key){
            System.out.println("Elment found at index "+mid);
            return;
        }
        else if(arr[mid]>key)
            search(arr,0,mid-1,key);
        else
            search(arr,mid+1,right,key);
        }


}
