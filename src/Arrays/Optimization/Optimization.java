package Arrays.Optimization;

import java.util.Arrays;
//6,11(prerequisite subse generation)
public class Optimization {
    
    public static void main(String args[]){
        MaximumSubArraySum();
        BuySellWithMaximumProfit();
        findMinimumAverageSubarrayofSizeK();
        findMinimumnDistanceBetweenTwoElements();
        MinimizeMaximumDifferencebyAddinfSubtractingK();
        findMinimumSubArrayWithSumGreaterThanK();
        CountMinimumStepsToGetDesiredArray();//operation allowed are increment one ny one(each
        //one operation) and doubling all elements (one operation)
        findMinimumOperationToMakeAnArrayPalindrome();
        findSmallestElementThatCannotBeRepresentedAsSumOfSubsetofArray();//13
    }

    private static void findSmallestElementThatCannotBeRepresentedAsSumOfSubsetofArray() {
        int arr1[] = {1, 3, 4, 5};
        int n=arr1.length;int res=1;
        for(int i=0;i<n&&res>=arr1[i];i++){
            res=res+arr1[i];
        }
        System.out.println(res);
    }

    private static void findMinimumOperationToMakeAnArrayPalindrome() {
        int arr[] = {1, 4, 5, 9, 1};
        int n=arr.length;int op=0;
        for(int i=0,j=n-1;i<=j;){
            if(arr[i]==arr[j]){
                i++;j--;
            }
            else if(arr[i]>arr[j]){
                j--;
                arr[j]=arr[j]+arr[j+1];op++;
            }
            else{
                i++;
                arr[i]=arr[i]+arr[i-1];op++;
            }
        }
        System.out.println(op);
    }

    private static void CountMinimumStepsToGetDesiredArray() {
        int arr[] = new int[]{16, 16, 16} ;int result=0;
        while(true){
            int zero_count=0;int i=0;
            for(i=0;i<arr.length;i++){
                if(arr[i]%2==1)
                    break;
                if(arr[i]==0)
                    zero_count++;
            }
            if(zero_count==arr.length) {
                System.out.println(result);
                break;
            }
            if(i==arr.length){
                for(int j=0;j<arr.length;j++){
                    arr[j]=arr[j]/2;
                }
                result++;
            }
            else{
                for(int k=i;k<arr.length;k++){
                    if(arr[k]%2==1) {
                        arr[k] = arr[k] - 1;
                        result++;
                    }
                }
            }
        }
    }

    private static void findMinimumSubArrayWithSumGreaterThanK() {
        int arr[] = {- 8, 1, 4, 2, -6};
        int x = 6;int n=arr.length;
        int start=0;int end=0;int curr_sum=0;int min_dist=Integer.MAX_VALUE;
        while(end<n) {
            while(curr_sum<=x&&end<n){
                if(curr_sum <= 0 && x > 0){
                    curr_sum=0;
                    start=end;
                }
                curr_sum=curr_sum+arr[end];
                end++;
            }
            while(curr_sum>x&&start<n){
                if(end-start<min_dist)
                    min_dist=end-start;
                curr_sum=curr_sum-arr[start];
                start++;
            }
        System.out.println(min_dist);
        }
    }

    private static void MinimizeMaximumDifferencebyAddinfSubtractingK() {

        int arr[] = {1, 5, 15, 10};
        int k = 3;int n=arr.length;
        Arrays.sort(arr);
        int ans=arr[n-1]-arr[0];
        int small=arr[0]+k;
        int big=arr[n-1]-k;
        if(small>big){
            int temp=small;
            small=big;
            big=small;
        }
        for(int i=1;i<n-1;i++){
            int subtract=arr[i]-k;
            int add=arr[i]+k;
            //if sorted order consecutively then continue
        if(subtract>=small||add<=big)
            continue;
        //the goal is to minimize maximum difference
        if(big-subtract>=add-small)
            big=add;
        else
            small=subtract;

        }
        System.out.println(Math.min(ans,big-small));


    }

    private static void findMinimumnDistanceBetweenTwoElements() {
        int arr[] = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3};
        int n = arr.length;
        int x = 3;
        int y = 6;int prev=0;int i=0;int dist=0;int min_dis=Integer.MAX_VALUE;
        for(i=0;i<n;i++){
            if(arr[i]==x||arr[i]==y)
            {
                prev=arr[i];
                dist=i;
                break;
            }
        }

        for(int j=i+1;j<n;j++) {
            if (arr[j] == x || arr[j] == y) {
                //if prev is not numbers that means its the second number so find the minimum distance
                if (arr[j] != prev || j - dist < min_dis) {
                    min_dis = j - dist;
                    prev = arr[j];
                    dist=j;
                } else {
                    //else put prev as new positioned index since  it counts for minimum distance
                    prev = arr[j];
                    dist=j;
                }
            }
        }
        System.out.println(min_dis);

    }

    private static void findMinimumAverageSubarrayofSizeK() {

        int arr[] = { 3, 7, 90, 20, 10, 50, 40 };
        int k = 3;int curr_sum=0;int n=arr.length;
        int max_sum=Integer.MIN_VALUE;int result_index=0;
        for(int i=0;i<k;i++){
            curr_sum=curr_sum+arr[i];
        }
        max_sum=curr_sum;
        for(int i=k;i<n;i++){
            curr_sum=curr_sum-arr[i-k]+arr[i];
            if(max_sum<curr_sum) {//for maximum average check max_sum>curr_sum
                max_sum = curr_sum;
                result_index = i - k+1;
            }
        }
        System.out.println(result_index+""+(result_index+k));
    }

    private static void BuySellWithMaximumProfit() {

        int price[] = {2, 30, 15, 10, 8, 25, 80};
        int n=price.length;
        int[] profit = new int[n];
        Arrays.fill(profit,0);
        int max_price=Integer.MIN_VALUE;
        int min_price=Integer.MAX_VALUE;
        //cycle is sell-buy-sell-buy
        //buy sell two times a day
        //max-curr is profit get maximum profit by selling max and buying minimum element difference will be that profit
        //get maximum profit for each element.sell at max price
        for(int i=n-2;i>=0;i--){
            if(price[i]>max_price)
                max_price=price[i];
            profit[i] = Math.max(profit[i+1],max_price-price[i]);
        }
        //subtract the minimum buy sell difference from current profit.compare with previous elements
        // profit get the maximum as current profit
        for(int i=1;i<n;i++){
            if(min_price<price[i])
                min_price=price[i];
            profit[i]=Math.max(profit[i-1],profit[i]-(price[i]-min_price));
        }
        System.out.println(profit[n-1]);
    }

    private static void MaximumSubArraySum() {
        int[] arr ={-2, -3, 4, -1, -2, 1, 5, -3};
        int max_so_far = Integer.MIN_VALUE;int start=0;int end=0;
        int max_ending_here=0;int s=0;
        for(int i=0;i<arr.length;i++){
            max_ending_here=arr[i]+max_ending_here;
            if(max_so_far<max_ending_here){
                max_so_far=max_ending_here;
                start = s;
                end = i;
            }
            if(max_ending_here<0) {
                max_ending_here = 0;
                start=s+1;
              }
        }
        System.out.println(max_so_far);

    }


}
