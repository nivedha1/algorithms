package Arrays.searching;
import java.util.*;

import static java.util.Arrays.binarySearch;

public class Searching {

    public static void main(String args[]){
        int arr[] = {5, 20, 3, 2, 50, 80};
        searchinPair(arr,3);
        findFirstanSecondSmallestElement(arr);//can be extendedd to three numbers to find sum of triplets
        findMaximumandMinimum(arr);//can also be used for finding largest pair sum
        int a[] = {1, 2, 4, 5, 6};
        getMissingNo(a);
        int[] c = {7, 3, 4, 5, 5, 6, 2};//print repeating and missing element
        printTwoElements(c, c.length);
        int[] c1 = {7, 3, 4, 5, 5, 6, 2};
        printTwoElementWhosesumisClosestToZero(c1);
        int arr1[] ={12, 16, 22, 30, 35, 39, 42,
                45, 48, 50, 53, 55, 56};
        printKClossestInSOrtedArray(arr1,35,4);
        int ar1[] = {1, 5, 10, 20, 40, 80};
        int ar2[] = {6, 7, 20, 80, 100};
        int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};
        printCommonElementsInthreeSortedArrays(ar1,ar2,ar3);
        int arr10[] = {5, 2, 8};
        int arr2[] = {10, 7, 12};
        int arr3[] = {9, 14, 6};//three arrays are of same size
        findDifferencceTriplet(arr10,ar2,ar3,3);
        int arrFindTriplets[] = {0, -1, 2, -3, 1};
        arrFindTripletsWithsumZero(arrFindTriplets,arrFindTriplets.length);
        int[] p= {2, 11, 5, 1, 4, 7};
        find3Numbers(p,p.length,19);
        checkPairWhoseSumisequalToSumofRestOfArray(p,p.length-1);
        int A[] = {1, 4, 10};
        int B[] = {2, 15, 20};
        int C[] = {10, 12};
        findThreeClosestElementsInThreeSortedArrays(A, B, C, A.length, B.length, C.length);
        int [] eq = { -2, 5, 3, 1, 2, 6, -4, 2 };
        findEquilibriumSum(eq);
        int maj[] = {1, 2, 3, 3, 3, 3, 10};
        System.out.println("isMajority "+isMajority(maj,arr.length,3));/* check if the element is present more than n/2 times */
        int arrbs[] = {3, 2, 10, 4, 40};
        int n = arr.length;
        int x = 4;
        System.out.println(SearchInAlmostSortedArray(arrbs,0,n-1,x));
        ClosestPAirInTwoSortedArrays();
    }

    private static void ClosestPAirInTwoSortedArrays() {
        int ar1[] = {1, 4, 5, 7};
        int ar2[] = {10, 20, 30, 40};
        int m = ar1.length;
        int n = ar2.length;
        int x = 38;
        int diff = Integer.MAX_VALUE;
            int res_l = 0, res_r = 0;
            int l = 0, r = n-1;
            while (l<m && r>=0)
            {
                if (Math.abs(ar1[l] + ar2[r] - x) < diff)
                {
                    res_l = l;
                    res_r = r;
                    diff = Math.abs(ar1[l] + ar2[r] - x);
                }
                if (ar1[l] + ar2[r] > x)
                    r--;
                else
                    l++;
            }
            System.out.print("The closest pair is [" + ar1[res_l] +
                    ", " + ar2[res_r] + "]");

    }

    private static int SearchInAlmostSortedArray(int arr[], int l, int r, int x) {
            if (r >= l) {
                int mid = l + (r - l) / 2;
                if (arr[mid] == x)
                    return mid;
                if (mid > l && arr[mid - 1] == x)
                    return (mid - 1);
                if (mid < r && arr[mid + 1] == x)
                    return (mid + 1);

                if (arr[mid] > x)
                    return SearchInAlmostSortedArray(arr, l, mid - 2, x);
                return SearchInAlmostSortedArray(arr, mid + 2, r, x);
            }
            return -1;
    }

    static boolean find3Numbers(int A[], int arr_size, int sum)
    {
        int l, r;
        Arrays.sort(A);
        for (int i = 0; i < arr_size - 2; i++) {
            l = i + 1;
            r = arr_size - 1;
            while (l < r) {
                if (A[i] + A[l] + A[r] == sum) {
                    System.out.print("Triplet is " + A[i] + ", " + A[l] + ", " + A[r]);
                    return true;
                } else if (A[i] + A[l] + A[r] < sum)
                    l++;

                else // A[i] + A[l] + A[r] > sum
                    r--;
            }
        }
        return false;
    }
    private static void findEquilibriumSum(int[] eq) {

        int[] prefixsum=new int[eq.length];
        int[] suffixsim=new int[eq.length];
        prefixsum[0]=eq[0];
        for(int i=1;i<eq.length;i++){
            prefixsum[i]=prefixsum[i-1]+eq[i];
        }
        int ans=0;
        int n=eq.length;
        suffixsim[n-1]=eq[n-1];
        if(prefixsum[n-1]==suffixsim[n-1])
            ans=prefixsum[n-1];
        for(int i=n-2;i>0;i--){
            suffixsim[i]=suffixsim[i+1]+eq[i];
            if(suffixsim[i]==prefixsum[i])
                ans = Math.max(ans, prefixsum[i]);
        }
        System.out.println("equilibrium sum is "+ans);

    }

    static boolean isMajority(int arr[], int n, int x)
    {
        int i = binarySearch(arr, 0, n-1, x);
        if (i == -1)
            return false;


        if (((i + n/2) <= (n -1)) && arr[i + n/2] == x)
            return true;
        else
            return false;
    }
    static void findThreeClosestElementsInThreeSortedArrays(int A[], int B[], int C[],
                           int p, int q, int r)
    {
        int diff = Integer.MAX_VALUE;
        int res_i =0, res_j = 0, res_k = 0;
        int i = 0, j = 0, k = 0;
        while (i < p && j < q && k < r)
        {
            int minimum = Math.min(A[i],
                    Math.min(B[j], C[k]));
            int maximum = Math.max(A[i],
                    Math.max(B[j], C[k]));

            if (maximum-minimum < diff)
            {
                res_i = i;
                res_j = j;
                res_k = k;
                diff = maximum - minimum;
            }
            if (diff == 0) break;
            if (A[i] == minimum) i++;
            else if (B[j] == minimum) j++;
            else k++;
        }
        System.out.println(A[res_i] + " " +
                B[res_j] + " " + C[res_k]);
    }
    static boolean checkPairWhoseSumisequalToSumofRestOfArray(int arr[], int n){
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            sum += arr[i];
        }
        if (sum % 2 != 0)
        {
            return false;
        }
        sum = sum / 2;
        HashSet<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < n; i++)
        {
            int val = sum - arr[i];
            if (s.contains(val) &&
                    val == (int) s.toArray()[s.size() - 1])
            {
                System.out.printf("Pair elements are %d and %d\n",
                        arr[i], val);
                return true;
            }
            s.add(arr[i]);
        }
        return false;
    }

    static void arrFindTripletsWithsumZero(int arr[], int n)
    {
        boolean found = false;

        for (int i = 0; i < n - 1; i++)
        {
            HashSet<Integer> s = new HashSet<Integer>();
            for (int j = i + 1; j < n; j++)
            {
                int x = -(arr[i] + arr[j]);
                if (s.contains(x))
                {
                    System.out.printf("%d %d %d\n", x, arr[i], arr[j]);
                    found = true;
                }
                else
                {
                    s.add(arr[j]);
                }
            }
        }

        if (found == false)
        {
            System.out.printf(" No Triplet Found\n");
        }
    }
    static int maximum(int a, int b, int c)
    {
        return Math.max(Math.max(a, b), c);
    }

    // function to find minimum number
    static int minimum(int a, int b, int c)
    {
        return Math.min(Math.min(a, b), c);
    }
    private static void findDifferencceTriplet(int[] arr1, int[] arr2, int[] arr3,int n) {
        int res_min=0, res_max=0, res_mid=0;
        int i = 0, j = 0, k = 0;
        int diff = Integer.MAX_VALUE;

        while (i < n && j < n && k < n) {
            int sum = arr1[i] + arr2[j] + arr3[k];
            int max = maximum(arr1[i], arr2[j], arr3[k]);
            int min = minimum(arr1[i], arr2[j], arr3[k]);
            if (min == arr1[i])
                i++;
            else if (min == arr2[j])
                j++;
            else
                k++;
            if (diff > (max - min)) {
                diff = max - min;
                res_max = max;
                res_mid = sum - (max + min);
                res_min = min;
            }
        }
        System.out.print(res_max + ", " + res_mid
                + ", " + res_min);
    }

    private static void printCommonElementsInthreeSortedArrays(int[] ar1, int[] ar2, int[] ar3) {
        int i=0,j=0,k=0;
        while (i < ar1.length && j < ar2.length && k < ar3.length)
        {
            if (ar1[i] == ar2[j] && ar2[j] == ar3[k])
            {   System.out.println(ar1[i]+" ");   i++; j++; k++; }
            else if (ar1[i] < ar2[j])
                i++;
            else if (ar2[j] < ar3[k])
                j++;
            else
                k++;
        }
    }

    private static void printKClossestInSOrtedArray(int[] arr, int num, int k) {

        int l=findCrossover(arr,num,0,arr.length-1);
        int r = l+1;
        int count = 0;

        // If x is present in arr[], then reduce left index
        // Assumption: all elements in arr[] are distinct
        if (arr[l] == num) l--;

        // Compare elements on left and right of crossover
        // point to find the k closest elements
        while (l >= 0 && r < arr.length && count < k)
        {
            if (num - arr[l] < arr[r] - num)
                System.out.print(arr[l--]+" ");
            else
                System.out.print(arr[r++]+" ");
            count++;
        }

        // If there are no more elements on right side, then
        // print left elements
        while (count < k && l >= 0)
        {
            System.out.print(arr[l--]+" ");
            count++;
        }


        // If there are no more elements on left side, then
        // print right elements
        while (count < k && r < arr.length)
        {
            System.out.print(arr[r++]+" ");
            count++;
        }

    }

    private static int findCrossover(int[] arr, int num, int low, int high) {
        if(arr[low]>=num){//num is smaller thn all
            return low;
        }
        if(arr[high]<=num){//num is greater than all
            return high;
        }
        int mid=(low+high)/2;
        if(arr[mid-1]<num&&arr[mid+1]>num)
            return mid;
        if(arr[mid]<num)
            return findCrossover(arr,num,mid+1,high);
        else
            return findCrossover(arr,num,low,mid-1);



    }

    private static void findMaximumandMinimum(int[] b) {

            int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
            for(int i=0;i<b.length;i++){
                if(b[i]>max){
                    max=b[i];

                }
                if(b[i]<min){
                    min=b[i];
                }
            }
            System.out.println("tha max and min are "+max+","+min);



    }

    private static void printTwoElementWhosesumisClosestToZero(int[] arr) {

        Arrays.sort(arr);
        int left=0;int right=arr.length-1;int min_sum=Integer.MAX_VALUE;
        int min_l=0;int min_r=0;
        while(left<right){
            int sum = arr[left]+arr[right];
            if(Math.abs(sum) < Math.abs(min_sum))
            {
                min_sum = sum;
                min_l = left;
                min_r = right;
            }
            if(sum < 0)
                left++;
            else
                right--;
        }
        System.out.println("the two numbers arr"+arr[min_l]+" "+arr[min_r]);
    }

    static void printTwoElements(int arr[], int size) {
        int i;
        System.out.print("The repeating element is ");

        for (i = 0; i < size; i++) {
            int abs_val = Math.abs(arr[i]);// all the indexes of element is made negative
            if (arr[abs_val - 1] > 0)//-1 beacause array is zero based
                arr[abs_val - 1] = -arr[abs_val - 1];
            else
                System.out.println(abs_val);
        }

        System.out.print("And the missing element is ");
        for (i = 0; i < size; i++) {
            if (arr[i] > 0)
                System.out.println(i + 1);
        }
    }
    private static void getMissingNo(int[] a) {
        int arrsum = 0;
        int totalsum = 0;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            arrsum = arrsum + a[i];
        }
        totalsum = (n + 1) * (n + 2) / 2;
        int missingnum = totalsum - arrsum;
        System.out.println("Missig number is " + missingnum);
     }

    public static void searchinPair(int[] arr,int n) {
        Arrays.sort(arr);
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[j] - arr[i] == n) {
                System.out.println(arr[i] + " " + arr[j]);
                break;
            } else if (arr[j] - arr[i] < n)
                i++;
            else
                j--;
        }
    }

    private static void findFirstanSecondSmallestElement(int[] b) {
        int first=Integer.MAX_VALUE,second=Integer.MAX_VALUE;
        for(int i=0;i<b.length;i++){
            if(b[i]<first){
                second=first;
                first=b[i];
            }
            else if(b[i]<second){
                second=b[i];
            }
        }
        System.out.println(first+","+second);
    }
}
