package Arrays.RangeQueries;

import java.util.HashSet;
import java.util.Arrays;
//21 26 27 29 31 35 40
public class RageQueries {
    static int[] preCompute=null;
    public static void main(String args[]) {
        countOfEqualNumbers();
    }

    private static void countOfEqualNumbers() {
        int a[] = { 1, 2, 2, 2, 3, 3, 4, 4, 4 };
        int n = a.length;
        // 22 Number of indexes with equal elements in given range
        countIndex(a, n);
        quertCountIndex(1,8);
        //24 Total numbers with no repeated digits in a range
        countNumbersInRangeWithRepeatedDigits(1,100);
        //25 Difference Array | Range update query in O(1)
        int A[] = { 10, 5, 20, 40 };
        initializeDiffArray(A);
        update(0, 1, 10);
        update(1, 3, 20);
        update(2, 2, 30);
        printArray(A);
        //28 rangeSum 32 mean
        int arr[] = { 1, 2, 3, 4, 5 };
        preComputeRangeSum(arr);
        printRangeSum(2,4);
        //30 Check in binary array the number represented by a subarray is odd or even
        int[] arr1 = {1, 1, 0, 1};
        checkEVENodd (arr1, arr1.length, 1, 3);
        //33 Print modified array after executing the commands of addition and subtraction
        n = 5;
        int arr2[] = new int[n+1];
        Arrays.fill(arr2, 0);
        int q = 0, l = 1, r = 3, k = 2;
        updateQuery(arr2, n, q, l, r, k);
        q = 1 ; l = 3; r = 5; k = 3;
        updateQuery(arr2, n, q, l, r, k);
        q = 0 ; l = 2; r = 5; k = 1;
        updateQuery(arr2, n, q, l, r, k);
        generateArray(arr2, n);
        //34 Queries on probability of even or odd number in given ranges
        int[] arr3 = { 6, 5, 2, 1, 7 };
        n = arr3.length;
        int Q = 2;
        int [][]query = { { 0, 2, 2 },
                { 1, 2, 5 } };
        solveQuery(arr3, n, Q, query);
        //36 Count Primes in Ranges
        countprimeInRanges(5,10);
        countprimeInRanges(1,10);
        //37 binary array after M range toggle operations
        n = 5; int m = 3;
        boolean[] arr4 = new boolean[n + 2];
        command(arr4, 1, 5);
        command(arr4, 2, 5);
        command(arr4, 3, 5);
        process(arr4, n);
        result(arr4, n);
        //41 Print modified array after multiple array range increment operations
        int[] arr5 = { 3, 5, 4, 8, 6, 1 };
        query[] q_arr = new query[5];
        q_arr[0] = new query(0, 3);
        q_arr[1] = new query(4, 5);
        q_arr[2] = new query(1, 4);
        q_arr[3] = new query(0, 1);
        q_arr[4] = new query(2, 5);
        n = arr5.length;
        m = q_arr.length;
        int d = 2;
        System.out.println("Original Array:");
        printArray(arr5, n);
        incrementByD(arr5, q_arr, n, m, d);
        System.out.println("\nModified Array:");
        printArray(arr5, n);
    }

    public static void incrementByD(int[] arr5, query[] q_arr,
                                    int n, int m, int d)
    {
        int[] sum = new int[n];
        for (int i = 0; i < m; i++)
        {
            sum[q_arr[i].start] += d;
            if ((q_arr[i].end + 1) < n)
                sum[q_arr[i].end + 1] -= d;
        }
        arr5[0] += sum[0];
        for (int i = 1; i < n; i++)
        {
            sum[i] += sum[i - 1];
            arr5[i] += sum[i];
        }
    }

    public static void printArray(int[] arr5, int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr5[i] + " ");
    }
    static void command(boolean arr[],
                        int a, int b)
    {
        arr[a] ^= true;
        arr[b + 1] ^= true;
    }

    static void process(boolean arr[], int n)
    {
        for (int k = 1; k <= n; k++)
        {
            arr[k] ^= arr[k - 1];
        }
    }
    static void result(boolean arr[], int n)
    {
        for (int k = 1; k <= n; k++)
        {
            if(arr[k] == true)
                System.out.print("1" + " ");
            else
                System.out.print("0" + " ");
        }
    }
    private static void countprimeInRanges(int L,int R) {

        boolean[] prime=new boolean[10000];
        Arrays.fill(prime,true);
        for(int i=1;i<10000/2;i++){
            if(prime[i]){
                for(int j=2*i;j<10000;j=(j+j)){
                    prime[j]=false;
                }
            }
        }
        preCompute=new int[10000];
        preCompute[0]=0;
        preCompute[1]=0;
        for(int i=2;i<10000;i++){
            if(prime[i])
                preCompute[i]=1;
            preCompute[i]=preCompute[i-1]+preCompute[i];
        }
        System.out.println(preCompute[R]-preCompute[L-1]);
    }

    static void solveQuery(int []arr,
                           int n, int Q, int [][]query)
    {
        int []even = new int[n + 1];
        int []odd = new int[n + 1];
        even[0] = odd[0] = 0;
        for (int i = 1; i < n; i++)
        {
            if ((arr[i] & 1) > 0)
            {
                odd[i ] = odd[i-1] + 1;
                even[i ] = even[i-1];
            }
            else
            {
                even[i ] = even[i-1] + 1;
                odd[i] = odd[i-1];
            }
        }

        // To solve each query
        for (int i = 0; i < Q; i++)
        {
            int r = query[i][2];
            int l = query[i][1];
            int k = query[i][0];
            int q = r - l + 1;
            int p;
            if (k > 0)
                p = odd[r] - odd[l - 1];
            else
                p = even[r] - even[l - 1];
            if (p <= 0)
                System.out.println("0");
            else if (p == q)
                System.out.println("1");
            else
            {
                int g = r-l;
                System.out.println(p / g
                        + " " + q / g);
            }
        }
    }

    private static void generateArray(int[] arr, int n) {
        System.out.println(arr[0]);
        for(int i=1;i<arr.length;i++){
            arr[i]=arr[i-1]+arr[i];
            System.out.println(arr[i]);
        }
    }

    static void updateQuery(int arr[], int n, int q, int l,
                     int r, int k)
    {
        if (q == 0){
            arr[l-1] += k;
            arr[r] += -k;
        } else{
            arr[l-1] += -k;
            arr[r] += k;
        }
        return;
    }
    static void checkEVENodd (int arr[], int n, int l, int r)
    {
        if (arr[r] == 1)
            System.out.println( "odd") ;
        else
            System.out.println ( "even") ;
    }
    private static void printRangeSum(int L,int R) {
        System.out.println(preCompute[R]-preCompute[L-1]);

//for mean divide by R-L-1

    }

    private static void preComputeRangeSum(int[] arr) {
        preCompute=new int[arr.length];
        preCompute[0]=arr[0];
                for(int i=1;i< arr.length;i++){
                    preCompute[i]=arr[i]+preCompute[i-1];
                }
    }

    static void initializeDiffArray(int A[])
    {
        preCompute=new int[A.length+1];
        int n = A.length;
        preCompute[0] = A[0];
        preCompute[n] = 0;
        for (int i = 1; i < n; i++)
            preCompute[i] = A[i] - A[i - 1];
    }

    static void update(int l, int r, int x)
    {
        preCompute[l] += x;
        preCompute[r + 1] -= x;
    }


    static int printArray(int A[])
    {
        for (int i = 0; i < A.length; i++) {
            if (i == 0)
                A[i] = preCompute[i];
            else
                A[i] = preCompute[i] + A[i - 1];
            System.out.print(A[i]+" ");
        }
        return 0;
    }

    private static void countNumbersInRangeWithRepeatedDigits(int L, int R) {


        preCompute=new int[R];
        preCompute[0]=0;
        preCompute[1]=1;
        for(int i=2;i<R;i++) {
            preCompute[i]=preCompute[i-1]+checkNumberHavingRepeatedDigitOrNot(i);
        }
        System.out.println(preCompute[R-1]-preCompute[L]);



    }

    private static int checkNumberHavingRepeatedDigitOrNot(int i) {
        HashSet<Integer> set = new HashSet<>();
        while(i!=0){
            int m=i%10;
            if(set.contains(m)){
                return 0;
            }
            set.add(m);
            i=i/10;
        }
        return 1;

    }

    private static void quertCountIndex(int L, int R) {
        if(L==0)
            System.out.println(preCompute[R-1]);
        System.out.println(preCompute[R-1]-preCompute[L-1]);
    }

    private static void countIndex(int[] a, int n) {
        preCompute=new int[n];

        for(int i=0;i<a.length;i++){
            if(i + 1 < n&&a[i+1]==a[i])
                preCompute[i]=1;
            if(i!=0)
            preCompute[i]+=preCompute[i-1];
        }



    }
}
 class query
{
    int start, end;

    query(int start, int end)
    {
        this.start = start;
        this.end = end;
    }
}