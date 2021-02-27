package Arrays.sorting;

import javafx.util.Pair;

import java.util.*;

import static java.util.Arrays.binarySearch;

//20 23
//        26
//        29
//        34
//        45

public class ArraySorting {
    
    public static void main(String args[]){
        //********************1-20
        sortAnArrayByAbsoluteDifference();
        sortInWaveForm();
        MergeArrays();
        checkSortedAfterSwap();
        ShortestUnOrderdArray();//length of shortest unordered {neither increasing nor decreasing} sub array in given array
        MinSwapsToSortArray();
        sort012();
        MinimumLengthOfUnsortedArrayTobeSorted();
        //********************20-40
        countPairsWithDifferenceK();
        countTriangles();//for a triangle to e formed the sum of two values must be greater than third value in a triplet
        countDistinctPairsWithDifferenceK();
        probabilityOfHighestFrequencyPair();
        MinimumDearrangementsInAPArray();
        System.out.println(NumberOfWaysOfMinimumProductTriplet());
        System.out.println(checkIfReversingSubarrayMakesItSorted());
        System.out.println(OverlapIntervalOrNot());
        //38 rangeQueries
        MergeInterval();
        minimumSwapsRequiredToSortBinaryArrayOnlyAdjacentElementsCanBESwapped();
        MaximumNumberOfPartitionSortedIndividualy();
        cuttingRopes();
        countPairsWithDifferenceLessThankK();
        MaximumUniquePairsInTwoArrays();
        sumOfMinimumAbsoluteDifference();
        findAllelementsCanbemadeSameUsing3OperationsWithSingleElemenets();//find-whether-possible-make-array-elements-using-one-external-number
        ElementsToBeaddedSuchThatAllElementsArePresent();
        MinimumNumberOfSubrations();//47

    }

    private static void MergeInterval() {
        Interval arr[] = new Interval[4];
        arr[0] = new Interval(6, 8);
        arr[1] = new Interval(1, 9);
        arr[2] = new Interval(2, 4);
        arr[3] = new Interval(4, 7);
        Arrays.sort(arr);

        Stack<Interval> stack = new Stack<Interval>();
        stack.push(arr[0]);
        for (int i = 1; i < 4; i++) {
            {
                if (stack.peek().end < arr[i].start) {
                    stack.push(arr[i]);
                } else if (stack.peek().end < arr[i].end) {
                    Interval j = stack.pop();
                    j.end = arr[i].end;
                    stack.push(j);

                }
            }
        }
            while (!stack.isEmpty()) {
                Interval t = stack.pop();
                System.out.print("[" + t.start + "," + t.end + "] ");
            }

    }

    private static void MinimumNumberOfSubrations() {
        int arr[] = { 1, 1, 2, 3 };
        int N = arr.length;
        int k = 5;

        int noOfSubtraction;
            int res = 0;
            for (int i = 1; i < N; i++) {
                noOfSubtraction = 0;
                if (arr[i] > arr[i - 1]) {
                    noOfSubtraction = (arr[i] - arr[i - 1]) / k;
                    if ((arr[i] - arr[i - 1]) % k != 0)
                        noOfSubtraction++;
                    arr[i] = arr[i] - k * noOfSubtraction;
                }
                res = res + noOfSubtraction;
            }

            System.out.println(res);

    }

    private static void ElementsToBeaddedSuchThatAllElementsArePresent() {

        int arr[] = { 3, 5, 8, 6 };int min=Integer.MAX_VALUE;int max=Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();int count=0;
        for(int i=0;i<arr.length;i++) {
            set.add(arr[i]);
            if (min > arr[i]) {
                min = arr[i];
            }
           else if (max < arr[i]) {
                max = arr[i];
            }
        }
        for(int i=min+1;i<max;i++){
            if(!set.contains(i))
                count++;
        }
        System.out.println(count);
    }

    private static void findAllelementsCanbemadeSameUsing3OperationsWithSingleElemenets() {

        int[]  arr = {55, 52, 52, 49, 52};
        Arrays.sort(arr);
        if(arr.length==1)System.out.println(0);
        else if(arr.length==2)System.out.println(arr[0]-arr[1]);
        else{
            int mid=arr.length/2;
            if(arr[mid]-arr[0]==arr[arr.length-1]-arr[mid]){
                System.out.println(arr[mid]-arr[0]);
            }
        }
    }

    private static void sumOfMinimumAbsoluteDifference() {
        int arr[] = {5, 10, 1, 4, 8, 7};
        Arrays.sort(arr);
        int n=arr.length;
        int sum=0;sum=sum+Math.abs(arr[0]-arr[1]);
        sum=sum+Math.abs(arr[n-1]-arr[n-2]);
        for(int i=1;i<n-1;i++){
            sum=sum+Math.min(Math.abs(arr[i]-arr[i-1]),Math.abs(arr[i]-arr[i+1]));
        }
        System.out.println(sum);
    }

    private static void MaximumUniquePairsInTwoArrays() {
        int a[] = {10, 15, 20};
        int b[] = {17, 12, 24};
        Arrays.sort(a);
        Arrays.sort(b);
        int k = 3;int ans=0;
        for(int i=0,j=0;i<a.length&&j<b.length;){
            if(Math.abs(a[i]-b[j])<=k){
                i++;j++;ans++;
            }
            else if(a[i]<b[j])
            {
                i++;
            }
            else{
                j++;
            }
        }
        System.out.println(ans);
    }

    private static void countPairsWithDifferenceLessThankK() {
        int a[] =  {1, 10, 4, 2};
        int k = 3;int ans=0;
        Arrays.sort(a);
        for(int i=0;i<a.length;i++){
            int j=i+1;
            while(j<a.length&&a[j]-a[i]<k){
                ans++;
                j++;
            }
        }
        System.out.println(ans);
    }


    private static void cuttingRopes() {
        int[] Ropes = { 5, 1, 1, 2, 3, 5 };
        Arrays.sort(Ropes);int operationCnt=0;
        int cuttingLength=Ropes[0];
        for(int i=1;i<Ropes.length;i++){
            if(Ropes[i]-cuttingLength>0){
                //When rope that is cut is of length greater than 0 then
                //all the ropes after it will be greater than 0 as the array is sorted
                System.out.print(Ropes.length-i+" ");
                cuttingLength=Ropes[i];
                operationCnt++;
            }
        }
        System.out.println(operationCnt);

    }

    private static void MaximumNumberOfPartitionSortedIndividualy() {

        int arr[] = { 1, 0, 2, 3, 4 };int max_so_far=Integer.MIN_VALUE;int ans=0;//{1,0}{2}{3}{4}
        for(int i=0;i<arr.length;i++){
            max_so_far=Math.max(arr[i],max_so_far);
            if(max_so_far==i)
                ans++;
        }
        System.out.println(ans);
    }

    private static void minimumSwapsRequiredToSortBinaryArrayOnlyAdjacentElementsCanBESwapped() {
        int ar[] = { 0, 0, 1, 0, 1, 0, 1, 1 };
        int n=ar.length;
        int[] noOfZeros = new int[ar.length];
        noOfZeros[n-1]=1-ar[n-1];
        for(int i=ar.length-1;i>0;i--) {
            noOfZeros[i] = noOfZeros[i - 1];
            if (ar[i] == 0)
                noOfZeros[i]++;
        }
        int count=0;
        for(int i=0;i<ar.length;i++){
            if (ar[i] == 1)
                count+=noOfZeros[i];
        }
        System.out.println(count);
    }

    private static boolean OverlapIntervalOrNot() {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3 ));
        list.add(new Interval(1, 7 ));
        list.add(new Interval(4, 8 ));
        list.add(new Interval(2, 5 ));
        Collections.sort(list);
        for(int i=1;i<list.size();i++){
            if(list.get(i).end<list.get(i-1).end)
                return true;
        }
        return false;
    }

    private static boolean checkIfReversingSubarrayMakesItSorted() {

        int arr[] = {1, 2, 5, 4, 3};
        int[] temp = arr;
        Arrays.sort(temp);
        int front=0;int back=0;
        for(front=0;front<arr.length;front++){
            if(temp[front]!=arr[front])
                break;
        }
        for(back=arr.length-1;back>=0;back--){
            if(temp[back]!=arr[back])
                break;
        }
        if(front>=back)
            return true;

        do{//check subarray is decreasing or not so that reversing makes it sorted
            front++;
            if(arr[front-1]<arr[front])
                return false;
        }while(front!=back);

        return true;
    }

    //https://www.geeksforgeeks.org/count-ways-form-minimum-product-triplets/
    private static int NumberOfWaysOfMinimumProductTriplet() {
        int arr[] = { 1, 3, 3, 4 };int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==arr[2])
                count++;
        }
        if(arr[0]==arr[2])
            return (count-2)*(count-1)*count/6;
        else if(arr[1]==arr[2])
            return (count-1)*count/2;

        //all are different
        return count;
    }


    private static void MinimumDearrangementsInAPArray() {
        int arr[] = {5, 9, 21, 17, 13};
        int n = arr.length;int count1=0;int count2=0;
        Arrays.sort(arr);
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1])
                count1++;
        }
        for(int i=n-1;i>1;i--){
            if(arr[i-1]>arr[i])
                count2++;
        }
        System.out.println(Math.min(count1,count2));
    }

    private static void probabilityOfHighestFrequencyPair() {
        int a[] = { 1, 2, 3 };
        int b[] = { 1, 3, 3 };
        Arrays.sort(a);Arrays.sort(b);int max1=Integer.MIN_VALUE;int max2=Integer.MIN_VALUE;int count1=0;int count2=0;
        for(int i=0;i<a.length;i++){
            if(a[i]>max1){
                max1=a[i];
                count1=1;
            }
            else if(a[i]==max1){
                count1++;
            }
        }
        for(int i=0;i<b.length;i++){
            if(b[i]>max2){
                max2=b[i];
                count2=1;
            }
            else if(b[i]==max2){
                count2++;
            }
        }
        System.out.println((double)count1*count2/(a.length*b.length));



    }

    private static void countDistinctPairsWithDifferenceK() {

        int arr[] = {1, 5, 3, 4, 2};
        Arrays.sort(arr);int k = 3;int count=0;
        for(int i=0;i<arr.length;i++){
            if(Arrays.binarySearch(arr,arr[i]+k)>0)
                count++;
        }
        System.out.println(count);
    }

    private static void countTriangles() {
        int[] A = {4, 3, 5, 7, 6};
        Arrays.sort(A);
        int n=A.length;int count=0;
        for(int i=n-1;i>=1;i--){
            int l=0,r=i-1;
            while (l < r) {
                if (A[l] + A[r] > A[i]) {
                    count += r - l;// if we can form triange using arr[l] and arr[r] then we can obviously form triangles
                    //from a[l+1],a[l+2]…..a[r-1], arr[r] and a[i], because the array is sorted
                    r--;
                } else {
                    l++;
                }
            }
        }
        System.out.println(count);
    }

    private static void countPairsWithDifferenceK() {
        int arr[] = {1, 5, 3, 4, 2};
        int n = arr.length;
        int k = 3;
        Arrays.sort(arr);int paircount=0;
        for(int i=0;i<arr.length-1;i++){
            if(binarySearch(arr,arr[i]+k)>0)
                paircount++;
        }
        System.out.println(paircount);
    }

    private static void MinimumLengthOfUnsortedArrayTobeSorted() {
        int arr[] = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
        int n=arr.length;
        int min=Integer.MAX_VALUE;int max=Integer.MIN_VALUE;
        int i=0;
        int s=0;int e=n-1;
        for( i=0;i<n-1;i++){//icreasing from start
            if(arr[i]>arr[i+1])
                break;
        }
        s=i;
        for( i=n-1;i>0;i--){//decreasing from end
            if(arr[i]<arr[i-1])
                break;
        }
        e=i;
        max = arr[s]; min = arr[s];
        for(i=s+1;i<e;i++){
            if(max<arr[i])
                max=arr[i];
            if(min>arr[i])
                min=arr[i];
        }
        for(i=0;i<s;i++){
            if(min<arr[i])
                break;
        }
        s=i;
        for( i=n-1;i>e+1;i--){
            if(arr[i]<max)
                break;
        }
        e=i;
        System.out.println(s+""+e);

    }

    private static void sort012() {

        int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        int low=0;
        int high= arr.length-1;
        int mid=low;
        while (mid <= high) {//not for loop
            switch(arr[mid]){//switch mid
                case 0:
                    swap(arr,low,mid);
                    low++;
                    mid++;//increment mid only here
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr,mid,high);
                    high--;
                    break;
            }
        }
        System.out.println(Arrays.toString(arr));



    }

    private static void MinSwapsToSortArray() {
        int[] arr = {4, 3, 2, 1};
        int n = arr.length;
        ArrayList<Pair<Integer,Integer>> list= new ArrayList<Pair<Integer, Integer>>();
        for(int i=0;i<arr.length;i++){
            list.add(new Pair(arr[i],i));
        }
        Collections.sort(list, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        boolean[] visited=new boolean[n];int ans=0;
        for(int i=0;i<n;i++) {
            if (visited[i] || list.get(i).getValue() == i)
                continue;
            int j = i;
            int cycle = 0;
            while (!visited[j]) {
                visited[j] = true;
                j = list.get(j).getValue();
                cycle++;
            }
            ans = ans+cycle - 1;
        }
        System.out.println(ans);
    }

    private static void ShortestUnOrderdArray() {

        int ar[] = { 7, 9, 10, 8, 11 };
        int n=ar.length;int in=0;int dec=0;
        for(in=0;in<n-1;in++){
            if(ar[in]>ar[in+1]);
            break;
        }
        for(dec=n-1;dec>1;dec--){
           if(ar[dec]<ar[dec-1])
               break;
        }
        if(in==n-1||dec==1){
            System.out.println(0);
        }
        else{
            System.out.println(3);
        }
    }

    private static void checkSortedAfterSwap() {
        int A[] = { 1, 2, 5, 3, 4, 6 };
        int B[] = { 0, 1, 1, 1, 0 };
        for(int i=0;i<A.length-1;i++){
            if(B[i]==1){
                if(A[i]!=i+1){
                    swap(A,i,i+1);
                }
            }
        }int i=0;
        for(i=0;i<A.length;i++){
            if(A[i]!=i+1)
                break;
        }
        if(i==A.length)
            System.out.println("Its sorted");
        else
            System.out.println("Its not sorted");


    }

    private static void MergeArrays() {
        int mPlusN[] = {2, 8, -1, -1, -1, 13, -1, 15, 20};
        int N[] = {5, 7, 9, 25};
        int n = N.length;
        int m = mPlusN.length - n;
        int count=-1;
        for(int i=0;i<mPlusN.length;i++){
            if(mPlusN[i]==-1){
                count++;
                if(count!=i) {
                    swap(mPlusN, count, i);
                }
            }
        }
        count=count+1;
        int i=0;int j=0;
        while(count<mPlusN.length&&j<n){
            if(mPlusN[count]<N[j]){
                mPlusN[i]=mPlusN[count];
                count++;
            }
            else{
                mPlusN[i]=N[j];
                j++;
            }
            i++;
        }
        while(count<mPlusN.length){
            mPlusN[i]=mPlusN[count];
            i++;
        }while(j<n){
            mPlusN[i]=N[j];
            i++;j++;
        }
        System.out.println(Arrays.toString(mPlusN));
    }

    private static void sortInWaveForm() {
        int arr[] = {10, 90, 49, 2, 1, 5, 23};
        int n = arr.length;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i=i+2){
            swap(arr,i,i+1);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private static void sortAnArrayByAbsoluteDifference() {

        int arr[] = {10, 5, 3, 9 ,2};
        int n = arr.length;
        int x = 7;
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        for(int i=0;i<arr.length;i++){
            int num=Math.abs(x-arr[i]);
            if(map.containsKey(num)){
                ArrayList<Integer> list=map.get(num);
                list.add(arr[i]);
                map.put(num,list);
            }
            else{
                ArrayList<Integer> list=new ArrayList<>();
                list.add(arr[i]);
                map.put(num,list);
            }
        }
        for(ArrayList<Integer> l:map.values()){
            for(int i:l){
                System.out.print(i+" ");
            }
        }
    }
}

 class Interval implements Comparable<Interval> {


    int start;
    int end;
    Interval(int start,int end){
        this.start=start;
        this.end=end;
    }
    @Override
    public int compareTo(Interval o) {

        if(this.start<o.start)
            return -1;
        else if(this.start>this.start)
            return 1;
        else
            return 1;
    }
}


