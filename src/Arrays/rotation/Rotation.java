package Arrays.rotation;

import java.util.Arrays;

public class Rotation {
    public static void main(String args[])
    {

        Rotation obj=new Rotation();
        obj.rotate();//1
        obj.rotateBySwap();//3
        obj.reverseRotateBySwap();
        obj.findPairSuminSortedRotatedArray();
        obj.iMultipleArriSumallRotationMaximum();//7
        obj.rotateCount();
        obj.multipleLeftRotations();
        obj.hammingDistance();
        obj.searchInRotatedSortedArray();//Find the maximum element in an array which is first increasing and then decreasing
        int[] arr={5,6,1,2,3,4};
        obj.findMinimumInSortedRotatedArray(arr,0,arr.length-1);
    }

    private void findMinimumInSortedRotatedArray(int[] arr,int left,int right) {

            if(left>right) return;
            if(left==right) {
                System.out.println(arr[left]);return;
            }
            int mid=(left+right)/2;
            if(left<mid&&arr[mid-1]>arr[mid])
            {
                System.out.println(arr[mid]);return;
            }
        if(right>mid&&arr[mid+1]<arr[mid])
        {
            System.out.println(arr[mid+1]);return;
        }
        //right is greater than mid then from midall elements are incrsing so smallest element will be before mid
        if (arr[right] > arr[mid])
            findMinimumInSortedRotatedArray(arr,left,mid-1);
        else
            findMinimumInSortedRotatedArray(arr,mid+1,right);


    }

    private void searchInRotatedSortedArray() {
        //can also be Find the maximum element in an array which is first increasing and then decreasing
        int arr[]={5,8,9,10,2,4};
        int  privot = findPivot(arr,0,arr.length-1);




    }

    private int findPivot(int[] arr,int left,int right) {

        if (right < left) return -1;
        if (left == right) return left;
        // 6 7 2 4 5
            // 0 1 2 3 4
            int mid=(left+right)/2;

            //both are same conditions if length is even or odd the gretaer element must be choosen
        //if  continuously increasing mid+1>mid and mid>mid-1
            if (mid < right && arr[mid] > arr[mid + 1])
                return mid;

            if (mid > left && arr[mid] < arr[mid - 1])
                return (mid-1);
        //we are tryng to find the first element that is not continuously increasing

        if(arr[left]>=arr[mid])//if element at left is grater than mid then the element diving
                //will be inbetween low and mid
                // 6 7 1 2 3 4 5
                // if mid is idex of 3 then seperating element 2 is in between 6 and 3
                //we want a element smaller than mid
                findPivot(arr,left,mid-1);
            else
                // 3 4 5 6 7 8 1 2
                // mid is index of 6 which is less than 3 then the pivot(8) will be on right of 6
                findPivot(arr,mid+1,right);

return mid;

    }

    private void hammingDistance() {
        int arr[] = {2, 4, 6, 8};
        int n= arr.length;
        int[] temp = new int[arr.length*2];
        for(int i=0;i<n;i++){
            temp[i]=temp[i+n]=arr[i];
        }
        int hammingDist=0;int maxdist=0;
        for(int i=0;i<n;i++){
            hammingDist=0;
            for(int j=i,k=0;k<n;k++,j++){
                if(temp[j]!=arr[k])
                    hammingDist++;
               }
            if(hammingDist>maxdist)
                maxdist=hammingDist;

        }
        System.out.println("HAmming distance is"+maxdist);

    }


    private void multipleLeftRotations() {
        int arr[] = {1, 3, 5, 7, 9};
        int k=2;
        int n=arr.length;
        int[] temp= new int[2*arr.length];
        //1st method
        for(int i=0;i<n;i++){
            temp[i]=temp[i+n]=arr[i];
        }
        for(int i=k;i<k+n;i++){
            System.out.print(temp[i]);
        }
        //method 2
        System.out.println("****");
        for(int i=k;i<k+n;i++)
        {
            System.out.print(arr[i%n]);
        }
    }

    private void rotateCount() {
        int[] arr ={11,13,15,1,3,6,9};
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>arr[i+1])
            {
                System.out.println("rotate index is"+i);
                break;
            }
        }




    }

    private void iMultipleArriSumallRotationMaximum() {
        //Given an array, only rotation operation is allowed on array.
        // We can rotate the array as many times as we want. Return the maximum possbile of summation of i*arr[i]
        int arr[] = {3,4,7};
        int arrsum=0;int multiplesum=0;int maxsum=0;
        for(int i=0;i<arr.length;i++)
        {
            arrsum=arrsum+arr[i];
            multiplesum=multiplesum+(i*arr[i]);
        }
        //left rotate
        for(int i=1;i<arr.length;i++) {
            multiplesum = multiplesum + arrsum - (arr.length * arr[arr.length - i]);
            if(multiplesum>maxsum)
                maxsum=multiplesum;
        }
        //right rotate
//        for(int i=0;i<arr.length;i++) {
//            multiplesum = multiplesum - arrsum + (arr.length * arr[i]);
//            if(multiplesum>maxsum)
//                maxsum=multiplesum;
//        }


        //arrsum is added because for one time all the numbers are incremented by one time in (i*arr[i])
        //in below case number at last must be removed by 3 times since its in arrsum 1 time and multiplesum 2 times
        //3*0+4*1+7*2 => 7 is two times in multiple sum
        //7*0+3*1+4*2 => 4 is two times in multiple sum
        //which equates to arr.length * arr[arr.length - i].
        // 3 4 7 = 3*0+4*1+7*2=18//arrsum = 14// multiplesum=18
        //18 14
        // 4 7 3 =4*0+7*1+3*2=13 18-14+(3*3)=13
        // 7  3 4 = 13 - 14 +(4*3)=-1+12=11

        //on rotation 7 3 4 = 7*0+3*1+4*2 = 11  = 18+14-(3*7)=11
        //on rotation 4 7 3 = 4*0+7*1+3*2 = 13  = 11+14-(3*4)=13
        System.out.println(maxsum);
    }

    private void findPairSuminSortedRotatedArray() {

        int[] arr ={11,13,15,1,3,6,9};
        int sum=19;
        int l=0;
        int r=0;
        int n=arr.length-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr[i+1]){
              l=i%n;
              r=(i+1)%n;
              break;
            }
        }
        while(l!=r){
            if(arr[l]+arr[r]==sum) {
                System.out.println(arr[l] + "is at index" + l + "is at index r" + r);
                break;
            }
            else if(arr[l]+arr[r]>sum)
            {
                l=(n+l-1)%n;
            }
            else
            {  r=(r+1)%n;

            }
        }
    }

    void rotate(){
        int[] array = {1,2,3,4,5,6};
        int k=2;

        for(int i=0;i<k;i++)
        {
            int temp=array[0];
            int j=0;
            for(j=0;j<array.length-1;j++)
            {
                array[j]=array[j+1];
            }
            array[j]=temp;
        }
        System.out.println(Arrays.toString(array));
    }
    void rotateBySwap(){
        int[] array = {1,2,3,4,5,6};
        int k=2;

        swap(array,0,k-1);//not k is array index based not position based
        swap(array,k,array.length-1);
        swap(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
    private void reverseRotateBySwap() {
        int[] array = {3,4,6,5,2,1};
        int k=2;

        swap(array,0,array.length-1);
        swap(array,k,array.length-1);
        swap(array,0,k-1);//not k is array index based not position based

        System.out.println(Arrays.toString(array));

    }
    private void swap(int[] array, int start, int end) {
        int mid=start+end/2;
        for(int i=start;i<mid;i++) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
