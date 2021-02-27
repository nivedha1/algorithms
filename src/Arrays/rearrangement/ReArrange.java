package Arrays.rearrangement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
//40,42
class ReArrange{

    public static void main(String args[]){
        putsZerostoleft();
        putNonZerostoLeft();
        movenegthenpos();
        rearrangeinexarrequalsarrval();
        sort012();
        MinimumSqapsRequiredToBringElementsLessthanKTogether();
        evenPosGreatethanOdd();
        doubleFirstElementIfNextELmentisNotZeroandMoveerosToEnd();
        formLargestElement();
        ReorderArrayByIndex();
        findSortedSubsequenceOfSize3();
        SumOfConsecutiveDifferenceInCircularArray();
        REplaceTwoConsecutiveNumberWithoneGreater();//43
        RearrangeBinaryStringWithXYOccurences();


        GenerateAllPosibleSortedsubsetsAlternatelyArray();//39
        ZeroIndextobeReplacedToGetMaxOneIndex();
        bitoinicSequence();
        MaximumCircularSubArraySum();
        LongestIncreasingSubsequenceLength();
        LongestIncreasingSubsequence();
    }

    private static void LongestIncreasingSubsequence() {

        int arr[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
        int n = arr.length;

        int tailIndices[] = new int[n];
        Arrays.fill(tailIndices, 0);
        int prevIndices[] = new int[n];
        Arrays.fill(prevIndices, -1);
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[tailIndices[0]])
                // new smallest value
                tailIndices[0] = i;
            else if (arr[i] > arr[tailIndices[len - 1]]) {
                // arr[i] wants to extend
                // largest subsequence
                prevIndices[i] = tailIndices[len - 1];
                tailIndices[len++] = i;
            }
            else {
                // arr[i] wants to be a potential condidate of future subsequence
                int pos = GetCeilIndex(arr,
                        tailIndices, -1, len - 1, arr[i]);
                prevIndices[i] = tailIndices[pos - 1];
                tailIndices[pos] = i;
            }
        }

        System.out.println("LIS of given input");

        for (int i = tailIndices[len - 1]; i >= 0;
             i = prevIndices[i])
            System.out.print(arr[i] + " ");
    }
    static int GetCeilIndex(int arr[],
                            int T[], int l,
                            int r, int key)
    {

        while (r - l > 1) {

            int m = l + (r - l) / 2;
            if (arr[T[m]] >= key)
                r = m;
            else
                l = m;
        }

        return r;
    }
    private static void LongestIncreasingSubsequenceLength() {
        int A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
        int n = A.length;
        int[] tailTable = new int[n];
        int len; // always points empty slot

        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];

            else if (A[i] > tailTable[len - 1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];

            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
        }

        System.out.println(len);
    }
    static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (A[m] >= key)
                r = m;
            else
                l = m;
        }

        return r;
    }
    private static void MaximumCircularSubArraySum() {
        int a[] = {11, 10, -20, 5, -3, -5, 8, -13, 10};
        int n=a.length;
        int max_so_far = 0, max_ending_here = 0;
        int i=0;
        for (i = 0; i < n; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_ending_here < 0)
                max_ending_here = 0;
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }
        int max_without_circular=max_so_far;
        int max_wrap = 0;
        for (i = 0; i < n; i++)
        {
            max_wrap += a[i]; // Calculate array-sum
            a[i] = -a[i]; // invert the array (change sign)
        }
        max_so_far = 0; max_ending_here = 0;

        for (i = 0; i < n; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_ending_here < 0)
                max_ending_here = 0;
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
        }
        int max_after_inversion=max_so_far+max_wrap;
        System.out.println(max_after_inversion > max_without_circular? max_after_inversion: max_without_circular);



    }

    private static void bitoinicSequence() {
        int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5,
                13, 3, 11, 7, 15};
        //Input arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
        //Output: 6 (A Longest Bitonic Subsequence of length 6 is 1, 2, 10, 4, 2, 1)

        int n = arr.length;
        int i, j;//lis = longest increasing sequence//lds=longest decreasing requence
            int[] lis = new int[n];
            for (i = 0; i < n; i++)
                lis[i] = 1;
            for (i = 1; i < n; i++)
                for (j = 0; j < i; j++)
                    if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                        lis[i] = lis[j] + 1;
            int[] lds = new int [n];
            for (i = 0; i < n; i++)
                lds[i] = 1;
            for (i = n-2; i >= 0; i--)
                for (j = n-1; j > i; j--)
                    if (arr[i] > arr[j] && lds[i] < lds[j] + 1)
                        lds[i] = lds[j] + 1;
            int max = lis[0] + lds[0] - 1;//two times the current element is added
            for (i = 1; i < n; i++)
                if (lis[i] + lds[i] - 1 > max)
                    max = lis[i] + lds[i] - 1;

            System.out.println(max);

    }

    //https://www.geeksforgeeks.org/find-index-0-replaced-1-get-longest-continuous-sequence-1s-binary-array/
    private static void ZeroIndextobeReplacedToGetMaxOneIndex() {

        int arr[] = {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
        int n = arr.length;
            int max_count = 0;  // for maximum number of 1 around a zero
            int max_index=0;  // for storing result
            int prev_zero = -1;  // index of previous zero
            int prev_prev_zero = -1; // index of previous to previous zero
            for (int curr=0; curr<n; ++curr)
            {
                if (arr[curr] == 0)
                {
                    if (curr - prev_prev_zero > max_count)
                    {
                        max_count = curr - prev_prev_zero;
                        max_index = prev_zero;
                    }
                    prev_prev_zero = prev_zero;
                    prev_zero = curr;
                }
            }

            // Check for the last encountered zero
            if (n-prev_prev_zero > max_count)
                max_index = prev_zero;

            System.out.println(max_index);
    }

    private static void GenerateAllPosibleSortedsubsetsAlternatelyArray() {

        int A[] = {10, 15, 25};
        int B[] = {5, 20, 30};
        int n = A.length;
        int m = B.length;
        int C[]=new int[m+n];
        generate(A,B,C,0,0,m,n,0,true);


    }

    private static void generate(int[] a, int[] b, int[] c, int i, int j, int m, int n, int len, boolean flag) {
        if(flag) {

            if (len != 0) {
                for (int p = 0; p < j + 1; p++) {
                    System.out.print(c[p]+" ");
                }
                System.out.println(" ");
            }
            for (int k = i; k < m; k++) {
                if (len == 0) {
                    c[len] = a[k];
                    generate(a, b, c, k+1, j, m, n, len, !flag);
                } else if (a[k] > c[len])
                    c[len + 1] = a[k];
                    generate(a, b, c, k+1, j, m, n, len + 1, !flag);
                }
            }

        else
        {
        for (int l = j; l < n; l++)
        {
            if (b[l] > c[len])
            {
                c[len + 1] = b[l];
                generate(a, b, c, i, l + 1, m, n, len + 1, !flag);
            }
        }
    }
}

    private static void RearrangeBinaryStringWithXYOccurences() {
        String str = "01101101101101101000000";
        int x = 1;
        int y = 2;
        int count_0=0;
        int count_1=0;
        char[] arr = str.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='0')
                count_0++;
            else if(arr[i]=='1')
                count_1++;
        }

        while (count_0 > 0 || count_1 > 0) {
            for (int j = 0; j < x && count_0 > 0; j++) {
                if (count_0 > 0) {
                    System.out.print("0");
                    count_0--;
                }
            }
            for (int j = 0; j < y && count_1 > 0; j++) {
                if (count_1 > 0) {
                    System.out.print("1");
                    count_1--;
                }
            }
        }

    }

    private static void REplaceTwoConsecutiveNumberWithoneGreater() {
        //Replace two consecutive equal values with one greater
        int arr[] = { 6, 4, 3, 4, 3, 3, 5 };
        int n=arr.length;
        int pos = 0;  // Index in result

        for (int i = 0; i < n; i++) {
            arr[pos++] = arr[i];

            while (pos > 1 && arr[pos - 2] ==
                    arr[pos - 1]) {
                pos--;
                arr[pos - 1]++;
            }
        }

        // to print new array
        for (int i = 0; i < pos; i++)
           System.out.println(arr[i]);
    }

    private static void SumOfConsecutiveDifferenceInCircularArray() {
        int arr[] = { 1, 8,2 ,4 };
        //|1 - 8| + |8 - 2| + |2 - 4| + |4 - 1|
        int n = arr.length;
        Arrays.sort(arr);
int sum=0;
        // Subtracting a1, a2, a3,....., a(n/2)-1,
        // an/2 twice and adding a(n/2)+1, a(n/2)+2,
        // a(n/2)+3,....., an - 1, an twice.
        for (int i = 0; i < n/2; i++)
        {
            sum -= (2 * arr[i]);
            sum += (2 * arr[n - i - 1]);
        }
System.out.println(sum);
    }

    private static void findSortedSubsequenceOfSize3() {

        int arr[] = {12, 11, 10, 5, 6, 2, 30};int n=arr.length;
        int[] smaller=new int[n];
        int[] greater=new int[n];
        smaller[0]=-1;int min=0;
        for(int i=1;i<n;i++){
            if(arr[i]<=arr[min]){
                min=i;
                smaller[i]=-1;
            }
            else{
                smaller[i]=min;
            }
        }
        greater[n-1]=-1;int max=n-1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]>=arr[max]){
                max=i;
                greater[i]=-1;
            }
            else{
                greater[i]=max;
            }
        }
        for(int i=0;i<n;i++){
            if(smaller[i]!=-1&&greater[i]!=-1){
                System.out.println(arr[smaller[i]]+" "+arr[i]+" "+arr[greater[i]]);
            }
        }


    }

    private static void ReorderArrayByIndex() {
        int arr[] = {50, 40, 70, 60, 90};
        int index[] = {3,  0,  4,  1,  2};
        int n = arr.length;
        int temp[] = new int[n];
        for(int i=0;i<n;i++){
            temp[index[i]]=arr[i];
        }
        for(int i=0;i<n;i++){
            arr[i]=temp[i];
        }
System.out.println(Arrays.toString(arr));


    }

    private static void formLargestElement() {
        ArrayList<String> list = new ArrayList<>();
        list.add("9999");
        list.add("123");
        list.add("546");
        list.add("023");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String XY=o1+o2;
                String YX=o2+o1;
                return XY.compareTo(YX) > 0 ? 1: 0;
            }
        });
        for(String str:list){
            System.out.print(str);
        }
    }

    private static void doubleFirstElementIfNextELmentisNotZeroandMoveerosToEnd() {

        int[] arr = {2, 2, 0, 4, 0, 8};

        for(int i=0;i<arr.length-1;i++){
            if(arr[i]!=0&&arr[i+1]!=0)
            {
                arr[i]=2*arr[i];
                arr[i+1]=0;
            }
        }
        int count=-1;
        //move 0's to end
        for(int i=0;i<arr.length;i++){
            if (arr[i] != 0) {
            count++;
            if(count!=i) {
                    int temp = arr[i];
                    arr[i] = arr[count];
                    arr[count] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    private static void evenPosGreatethanOdd() {
        int[] arr = {1,3,5,2,8,4,7};
        Arrays.sort(arr);
        int[] result = new int[arr.length];
        int even=0,odd=arr.length-1;
        for(int i=0;i<arr.length;i++)
        {
            if(i%2!=0)
                result[i]=arr[even++];
            else
                result[i]=arr[odd--];
        }
        System.out.println(Arrays.toString(result));
    }

    private static void sort012() {
        int[] arr = {0,1,2,1,0,2,0,1};
        int high=arr.length-1;
        int low=0;
        int mid=0;
        while(mid<=high){
            int num=arr[mid];
            if(num==0){
                int temp=arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;
                low++;
                mid++;
            }
            else if(num==1){
                mid++;

            } else if(num==2){
                int temp=arr[high];
                arr[high]=arr[mid];
                arr[mid]=temp;
                high--;//dont increment mid

            }
        }
        for(int i:arr){
            System.out.print(i+"  ");
        }
    }

    private static void MinimumSqapsRequiredToBringElementsLessthanKTogether() {
        int k=5;
       int[] arr= {2, 7, 9, 5, 8, 7, 4};
       int count=-1;int swaps=0;
       for(int i=0;i<arr.length;i++){
           if(arr[i]<=k){//what needs to be in left?
               count++;
               if(count!=i) {
                   int temp = arr[i];
                   arr[i] = arr[count];
                   arr[count] = temp;
                   swaps++;
               }

           }

       }
       System.out.println(swaps);
    }

    static void putsZerostoleft() {
    int[] arr = {1, 2, 3, 0, 0, 3, 0, 4, 0, 4, 0, 2, 0, 2};
    int count = -1;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == 0) {//what needs to be in left?
            count++;//since we are incrementing at first count must be set as -1
            if(count!=i) {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
            }
        }
    }
    System.out.println(Arrays.toString(arr));
}
static void putNonZerostoLeft() {
    int[] arr = {2, 2, 3, 0, 0, 3, 0, 4, 0, 4, 0, 2, 0, 2};
    int count = -1;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] > 0) {//what needs to be in left?
            count++;
            if(count!=i) {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
            }

        }
    }
    System.out.println(Arrays.toString(arr));
}
    static void movenegthenpos() {
        int[] arr = {-2, 2, 3, -1, -5, 0, -7, 4, 1, 4, -3, -2, 0, 2};
        int count = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <=0) { //what needs to be in left?
                count++;
                if(count!=i) {
                    int temp = arr[i];
                    arr[i] = arr[count];
                    arr[count] = temp;
                }

            }
        }
        System.out.println(Arrays.toString(arr));
    }
    static void rearrangeinexarrequalsarrval(){//arr[i]=i
        int[] arr={0,1,4,2,3,6,5};
        for(int i=0;i<arr.length;i++)
        {
            while(arr[i]!=i) {//note while loop
                int temp1=arr[arr[i]];
                int temp2=arr[i];
            arr[arr[i]]=temp2;
            arr[i]=temp1;
            }
        }
        System.out.println(Arrays.toString(arr));
        }

    }

