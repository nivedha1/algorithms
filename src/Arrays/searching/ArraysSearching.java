package Arrays.searching;

import java.util.*;
//55
//        56
//        58
//        86
//        63
//        70
//        73
public class ArraysSearching {

        public static void main(String args[]){
            deleteInSortedArray();
            searchInSortedArray();
            deleteInUnsortedArray();
            checkPairWithSum();
            searchAdjacentElementsDifferByk();
            findCommonElementsinThreeSortedArray();
            findRepetitiveElement();
            MaxSubArraySum();
            MaxEquilibriumSum();
            printArithmeticProgressionTriplets();
            Point p=countOnlyRepeatedElementInSortedArrayOfConsecutiveNumbers();
            System.out.println("repeating element is "+p.x+" number of times repeating is "+p.y);
            closestResult();
            countPairWithGiivenSum();
            System.out.println(ReplacingOneElementMakeAllElementConsecutive());
            MaximumDifferenceBetweenTwoSubsetsOfGivenElements();
            checkAP();
            findMaximumSumofPairWiseProduct();
            countPairWithMaximumDifference();
            MinimumSumofAbsoluteDIfferenceofElementsinTwoArrays();
            PrintKMissingNaturalNumbers();
            MaximumAbsoluteDiffrencesumbetweenindexandindexvalues();
            MaximumConsectiveSteps();
            printUncommonInTwoArray();
            MaximumSumBetweenTwoSubsetsOfArray();
            FindPAirsXORtoZero();
            MaxElementWhichisAtleatTwiceOfOtherElements();
            LAstDuplicateInSOrtedArray();
            FindArrayElementSuchThatAllOtherElementsAreDivisibleByIt();
        }

    private static void FindArrayElementSuchThatAllOtherElementsAreDivisibleByIt() {
        int min = Integer.MAX_VALUE, i;
        int a[] = {25, 20, 5, 10, 100};
        int n = a.length;
        for (i = 0; i < a.length; i++)
        {
            if (a[i] < min)
                min = a[i];
        }
        for (i = 1; i < n; i++)
            if (a[i] % min >= 1) {
                System.out.println(-1);
                return;
            }
        System.out.println(min);
    }

    private static void LAstDuplicateInSOrtedArray() {
        int arr[] = {1, 5, 5, 6, 6, 7, 9};
        int n = arr.length;
        if (arr == null || n <= 0)
                return;
            for (int i = n - 1; i > 0; i--)
            {
                if (arr[i] == arr[i - 1])
                {
                    System.out.println("Last index:" + i);
                    System.out.println("Last duplicate item: "
                            + arr[i]);
                    return;
                }
            }
            System.out.print("no duplicate found");
    }

    private static void MaxElementWhichisAtleatTwiceOfOtherElements() {
        int[] arr = new int[]{3, 6, 1, 0};
        int maxIndex = 0;
            for (int i = 0; i < arr.length; ++i)
                if (arr[i] > arr[maxIndex])
                    maxIndex = i;
            boolean flag=true;
            // Returns -1 if the max element is not
            // twice of the i-th element.
            for (int i = 0; i < arr.length; ++i)
                if (maxIndex != i && arr[maxIndex] < 2 * arr[i]) {
                    System.out.println("-1");
                    flag=false;
                    break;
                }
            if(flag)
            System.out.println(maxIndex);

    }

    private static void FindPAirsXORtoZero() {
        int a[] = { 1, 2, 1, 2, 4 };
        int n = a.length;
            Arrays.sort(a);
            int count = 1;
            int answer = 0;
            for (int i = 1; i < n; i++)
            {
                if (a[i] == a[i - 1])//same elements XOR to zero
                {
                    count += 1;
                }
                else
                {
                    // Adding the contribution of
                    // the frequency to the answer
                    answer = answer + (count * (count - 1)) / 2;
                    count = 1;
                }
            }
            answer = answer + (count * (count - 1)) / 2;
            System.out.println(answer);
    }

    private static void MaximumSumBetweenTwoSubsetsOfArray() {
        int arr[] = { 1, 2, 3, 4, 5 };
        int n = arr.length;
        int m = 4;
        int max = 0, min = 0;
            Arrays.sort(arr);
            for (int i = 0, j = n - 1;
                 i < m; i++, j--) {
                min += arr[i];
                max += arr[j];
            }
            System.out.println(max - min);
    }

    private static void printUncommonInTwoArray() {

        int arr1[] = { 10, 20, 30 };
        int arr2[] = { 20, 25, 30, 40, 50 };

        int n1 = arr1.length;
        int n2 = arr2.length;

        int i = 0, j = 0, k = 0;
            while (i < n1 && j < n2) {
                if (arr1[i] < arr2[j]) {
                    System.out.print(arr1[i] + " ");
                    i++;
                    k++;
                }
                else if (arr2[j] < arr1[i]) {
                    System.out.print(arr2[j] + " ");
                    k++;
                    j++;
                }
                // Skip common element
                else {
                    i++;
                    j++;
                }
            }
            while (i < n1) {
                System.out.print(arr1[i] + " ");
                i++;
                k++;
            }
            while (j < n2) {
                System.out.print(arr2[j] + " ");
                j++;
                k++;
            }

    }

    private static void MaximumConsectiveSteps() {
        int arr[] = { 1, 2, 3, 4 };
        int len=arr.length;
        int count = 0;
            int maximum = 0;
            for (int index = 1; index < len; index++) {
                if (arr[index] > arr[index - 1])
                    count++;
                else
                {
                    maximum = Math.max(maximum, count);
                    count = 0;
                }
            }

            System.out.println(Math.max(maximum, count));
        }

    private static void MaximumAbsoluteDiffrencesumbetweenindexandindexvalues() {
        int[] array = { -70, -64, -6, -56, 64,
                61, -57, 16, 48, -98 };
        int max1 = Integer.MIN_VALUE;
            int min1 = Integer.MAX_VALUE;
            int max2 = Integer.MIN_VALUE;
            int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++)
        {
            max1 = Math.max(max1, array[i] + i);
            min1 = Math.min(min1, array[i] + i);
            max2 = Math.max(max2, array[i] - i);
            min2 = Math.min(min2, array[i] - i);
        }

        // Calculating maximum absolute difference.
        System.out.println(Math.max(max1 - min1, max2 - min2));
    }

    private static void PrintKMissingNaturalNumbers() {
        int arr[] = { 2, 3, 4 };
        int n = arr.length;
        int k = 3;
        Arrays.sort(arr);
        int i = 0;
            while (i < n && arr[i] <= 0)
                i++;
            int count = 0, curr = 1;
            while (count < k && i < n) {
                if (arr[i] != curr) {
                    System.out.println(curr);
                    count++;
                }
                else i++;
                curr++;
            }
            while (count < k) {
                System.out.println(curr);
                curr++;
                count++;
            }
    }

    static long MinimumSumofAbsoluteDIfferenceofElementsinTwoArrays()
    {
        long a[] = {4, 1, 8, 7};
        long b[] = {2, 3, 6, 5};
        int n = a.length;
        Arrays.sort(a);
        Arrays.sort(b);
        long sum = 0 ;
        for (int i = 0; i < n; i++)
            sum = sum + Math.abs(a[i] - b[i]);
        return sum;
    }
    private static void countPairWithMaximumDifference() {
        int a[] = { 3, 2, 1, 1, 3 };
        int n = a.length;

        int mn = Integer.MAX_VALUE;
            int mx = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                mn = Math.min(mn, a[i]);
                mx = Math.max(mx, a[i]);
            }
            int c1 = 0;
            int c2 = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] == mn)
                    c1++;
                if (a[i] == mx)
                    c2++;
            }

            // condition for all elements equal
            if (mn == mx)
                System.out.println(n * (n - 1) / 2);
            else
                System.out.println(c1 * c2);

    }

    static void findMaximumSumofPairWiseProduct() {
        int arr[] = { -1, 9, 4, 5, -4, 7 };
        int n=arr.length;
        long Mod=1000000007;
        long sum = 0;
        Arrays.sort(arr);
        // First multiply negative numbers pairwise
        int i = 0;
        while (i < n && arr[i] < 0) {
            if (i != n - 1 && arr[i + 1] <= 0) {
                sum = (sum + (arr[i] * arr[i + 1]) % Mod) % Mod;
                i += 2;
            } else
                break;
        }

        // Second multiply positive numbers pairwise
        int j = n - 1;
        while (j >= 0 && arr[j] > 0) {
            if (j != 0 && arr[j - 1] > 0) {
                sum = (sum + (arr[j] * arr[j - 1]) % Mod) % Mod;
                j -= 2;
            } else
                break;
        }

        // To handle case if positive and negative
        // numbers both are odd in counts.
        if (j > i)
            sum = (sum + (arr[i] * arr[j]) % Mod) % Mod;
        // If one of them occurs odd times
        else if (i == j)
            sum = (sum + arr[i]) % Mod;

        System.out.println(sum);
    }
        private static boolean checkAP() {
        int arr[] = {0, 12, 4, 8};
        int n=arr.length;
            if (n == 1)
                return true;
            Arrays.sort(arr);
            int d = arr[1] - arr[0];
            for (int i = 2; i < n; i++)
                if (arr[i] - arr[i-1] != d)
                    return false;
            return true;
    }

    private static void MaximumDifferenceBetweenTwoSubsetsOfGivenElements() {
        //Input : arr[] = 1 2 3 4 5
        //m = 4
        //Output : 4
        //The maximum four elements are 2, 3,4 and 5. The minimum four elements are1, 2, 3 and 4.
        // The difference between two sums is (2 + 3 + 4 + 5) - (1 + 2+ 3 + 4) = 4
            int max = 0, min = 0;
            int[] arr={1,2,3,4,5};
            int m=4;int n=arr.length;
            Arrays.sort(arr);
            for (int i = 0, j = n - 1;
                 i < m; i++, j--) {
                min += arr[i];
                max += arr[j];
            }
            System.out.println (max - min);
    }

    private static int ReplacingOneElementMakeAllElementConsecutive() {
        int []arr = new int[]{7, 5, 12, 8} ;
        int n = arr.length;
        Arrays.sort(arr);
            int mismatch_count1 = 0,
                    res = 0;
            int next_element = arr[n - 1] -
                    n + 1;

            for (int i = 0; i < n - 1; i++)
            {
                if (Arrays.binarySearch(arr,
                        next_element) < 0)
                {
                    res = arr[0];
                    mismatch_count1++;
                }
                next_element++;
            }
            if (mismatch_count1 == 1)
                return res;
            if (mismatch_count1 == 0)
                return 0;
            int mismatch_count2 = 0;
            next_element = arr[0] + n - 1;

            for (int i = n - 1; i >= 1; i--)
            {
                if (Arrays.binarySearch(arr,
                        next_element) < 0)
                {
                    res = arr[n - 1];
                    mismatch_count2++;
                }
                next_element--;
            }
            if (mismatch_count2 == 1)
                return res;

            return -1;
    }

    private static void countPairWithGiivenSum() {
        int arr[] = new int[]{1, 5, 7, -1, 5} ;
        int sum=6;
        int n=arr.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
            for (int i=0; i<n; i++){
                if(!hm.containsKey(arr[i]))
                    hm.put(arr[i],0);
                hm.put(arr[i], hm.get(arr[i])+1);
            }
            int twice_count = 0;
            for (int i=0; i<n; i++) {
                if (hm.get(sum - arr[i]) != null)
                    twice_count += hm.get(sum - arr[i]);
                if (sum - arr[i] == arr[i])
                    twice_count--;
            }
            //for sum two numbers consitute a pair
            System.out.println(twice_count/2);

    }

    private static int deleteInUnsortedArray() {
        int[] arr ={11, 15, 6, 8, 9, 10};
        int n=arr.length;
        int x=6;
        if (arr[n-1] == x)
                return (n-1);
            int prev = arr[n-1], i;
            for (i=n-2; i>=0 && arr[i]!=x; i--)
            {
                int curr = arr[i];
                arr[i] = prev;
                prev = curr;
            }
            if (i < 0)
                return 0;
            arr[i] = prev;
            return (n-1);

    }

    static void closestResult()
    {
        Integer[] a = { 2, 5, 6, 1, 8, 9 };
        int[] b = { 2, 1, 0, 5, 4, 9 };
        int n = a.length;
        TreeSet<Integer> vect = new TreeSet<>(Arrays.asList(a));
        Vector<Integer> c = new Vector<>();
        for (int i = 0; i < n; i++)
        {
            Integer up = vect.higher(b[i]);
            if (up == null)
                c.add(-1);
            else
                c.add(up);
        }

        System.out.print("Result = ");
        for (int i : c)
            System.out.print(i + " ");
    }
    private static Point countOnlyRepeatedElementInSortedArrayOfConsecutiveNumbers() {
        Integer a[] = new Integer[]{1, 2, 3, 4, 4, 4, 5, 6};
        if (a.length == 0)
                return new Point(0, 0);
            int s = 0;
            int e = a.length - 1;
            while (s < e)
            {
                int m = (s + e) / 2;
                if (a[m] >= m + a[0])
                    s = m + 1;
                else
                    e = m;
            }
            return new Point(a[s], a.length- (a[a.length - 1] - a[0]));

    }

    private static void printArithmeticProgressionTriplets() {//2 6 4 is Ap since 4+2=6

        int arr[] = { 2, 6, 9, 12, 17,
                22, 31, 32, 35, 42 };
        int n=arr.length;
        for (int i = 1; i < n - 1; i++)
            {
                for (int j = i - 1, k = i + 1; j >= 0 && k < n;)
                {
                    if (arr[j] + arr[k] == 2 * arr[i]) {
                        System.out.println(arr[j] + " " + arr[i]
                                + " " + arr[k]);
                        k++;
                        j--;
                    }
                    else if (arr[j] + arr[k] < 2 * arr[i])
                        k++;
                    else
                        j--;
                }
            }
        }


    private static void MaxEquilibriumSum() {
            int arr[] = {-1, 2, 3, 0, 3, 2, -1};
            int sum=0;int prefixSum=0;int SuffixSum=0;
            for(int i:arr){
                sum=sum+i;
            }
            SuffixSum=sum;
            for(int i=0;i<arr.length;i++){
                prefixSum=prefixSum+arr[i];
                if(prefixSum==SuffixSum)
                    System.out.println("Equilibriem sum is at index"+i);
                SuffixSum=SuffixSum-arr[i];
            }
        }

        private static void MaxSubArraySum() {
            int[] arr1={10,20,30,40,50};
            int[] arr2={30,35,70};int currsum=0;int maxsum=0;
            for(int i:arr2){
                if(search(i,0, arr1.length,arr1)!=-1)
                {
                    currsum=0;
                }
                else{
                    currsum=currsum+i;
                    maxsum=Math.max(currsum,maxsum);
                }

            }
            System.out.println("Max subarray sum is "+maxsum);
        }

        private static void findRepetitiveElement() {
            int[] arr={1,3,4,5,2,4};int sum=0;
            for(int i:arr){
                sum=sum+i;
            }
            int maxsum= arr.length*(arr.length-1)/2;
            System.out.println(sum-maxsum+"is repetative num");
        }

        private static void findCommonElementsinThreeSortedArray() {
            int[] arr1 ={1,5,10,20,40,80};
            int[] arr2={6,7,20,80,100};
            int[] arr3={3,4,15,20,30,70,80};
            int i=0,j=0,k=0;
            while(i< arr1.length&&j<arr2.length&&k<arr3.length){
                if(arr1[i]==arr2[j]&&arr2[j]==arr3[k]) {
                    System.out.println(arr1[i]);
                    i++;j++;k++;

                }
                else if(arr1[i]<arr2[j])
                    i++;
                else if(arr2[j]<arr3[k])
                    j++;
                else
                    k++;//arr1[i]<arr2[j]<arr3[k];
            }
        }

        private static void searchAdjacentElementsDifferByk() {
            int arr[] = {1,3,4,6,7,8,9};
            int k=2;
            int find = 7;int i=0;
            while(i<arr.length)
            {
                if(arr[i]==find) {
                    System.out.println("Found");
                    break;
                }
                else
                    i=i+Math.max(1,(Math.abs(arr[i]-find)/k));
                //if you are at 3 and want to find 7 and element differ by 2
                //then difference between 3 and 7 is 4 which can occur at min 2 positions after 3
                // like 3 ,5,7 or 3,4,5,6,7 or 3,2,5,7 or 3,4,6,7 like so
            }

        }

        private static void checkPairWithSum() {
            int arr[] = {10,20,30,20,40};
            Arrays.sort(arr);
            int sum=50;
            int l=0;
            int r=arr.length-1;
            while(l<r){
                if(arr[l]+arr[r]==sum)
                {
                    System.out.println("index is l and r "+l+","+r);
                    break;
                }
                else if(arr[l]+arr[r]<sum)
                    l++;
                else if(arr[l]+arr[r]>sum)
                    r--;
            }
        }


        private static void searchInSortedArray() {
            int[] arr = {10,20,30,40,50};
            System.out.println("Index found at"+search(30,0,arr.length,arr));
        }

        private static int search(int i,int left,int right,int[] arr) {
            if(left<right){
                int mid=(left+right)/2;
                if(arr[mid]==i)
                    return mid;
                else if(arr[mid]>i)
                    search(i,left,mid-1,arr);
                else if(arr[mid]<i)
                    search(i,mid+1,right,arr);
            }

            return -1;


        }

        private static void deleteInSortedArray() {

            int[] arr = {10,20,30,20,10};
            int key=30;
            int keyIdx=0;
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]==key) {
                    keyIdx = i;
                    break;
                }
            }
            for(int i=keyIdx;i<arr.length-1;i++){
                arr[i]=arr[i+1];
            }
            arr[arr.length-1]=-1;
            System.out.println(Arrays.toString(arr));
        }


    }


class Point {
    int x;
    int y;
    Point(int x,int y) {
        this.x = x;
        this.y = y;
    }
}