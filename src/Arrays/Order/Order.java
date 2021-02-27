package Arrays.Order;
import java.util.*;

//15,17,19,48
public class Order {
    
    public static void main(String args[]){
        
        printAllElementsThathastwoGreaterElementsThanIt();//9
        MinimumPRoductOfAllPositiveNumbers();//12
        MaxPairCombinationWithCountK();//14
        FindKMaximumNonOverlappingContiguousSumIndexes();//16
        getMinMax();//25
        MaximumDifferenceBEtweenTwoNumbersSuchthatLargestNumberComesAfterSMaller();//26
        maxdiff();//27
        firstMissingPositiveNumber();//33
        findClosestPairInTwoArrays();//38
        deleteElementsWhicharesmallerOrBecomeSmallerAfterDeleteion();//41
        kthLargestSum();//13
        MaxSumNoTwoElementsAdjacent();//24
        zeroFlipping();//44
        countStrictlyIncreasing();//45
    }

    private static void countStrictlyIncreasing() {
        //Given an array of integers, count number of subarrays (of size more than one) that are strictly increasing
        int arr[] = {1, 2, 2, 4};
        int n=arr.length;
        int cnt = 0;
            int len = 1;
            for (int i=0; i < n-1; ++i)
            {
                if (arr[i + 1] > arr[i])
                    len++;

                else
                {
                    cnt += (((len - 1) * len) / 2);
                    len = 1;
                }
            }
            if (len > 1)
                cnt += (((len - 1) * len) / 2);
            System.out.println(cnt);
    }

    static void zeroFlipping()
    {
        //Find zeroes to be flipped so that number of consecutive 1’s is maximized
        int arr[] = new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
        int wL = 0, wR = 0;
        int m=2;
        int bestL = 0, bestWindow = 0;
        int zeroCount = 0;
        while (wR < arr.length)
        {
            if (zeroCount <= m)
            {
                if (arr[wR] == 0)
                    zeroCount++;
                wR++;
            }
            if (zeroCount > m)
            {
                if (arr[wL] == 0)
                    zeroCount--;
                wL++;
            }
            if ((wR-wL > bestWindow) && (zeroCount<=m))
            {
                bestWindow = wR-wL;
                bestL = wL;
            }
        }
        for (int i=0; i<bestWindow; i++)
        {
            if (arr[bestL+i] == 0)
                System.out.print(bestL+i + " ");
        }
    }

    private static void MaxSumNoTwoElementsAdjacent() {
        //Maximum sum such that no two elements are adjacent
        int arr[] = new int[]{5, 5, 10, 100, 10, 5};
        int incl = arr[0];
            int excl = 0;
            int excl_new;
            int i;

            for (i = 1; i < arr.length; i++)
            {
                excl_new = (incl > excl) ? incl : excl;
                incl = excl + arr[i];
                excl = excl_new;
            }
            System.out.println(incl > excl ? incl : excl);
    }

    static void kthLargestSum()

    {//K-th Largest Sum Contiguous Subarray
        int arr[] = new int[]{ 10, -10, 20, -40 };
        int n = arr.length;
        int k = 6;
        int sum[] = new int[n + 1];
        sum[0] = 0;
        sum[1] = arr[0];
        for (int i = 2; i <= n; i++)
            sum[i] = sum[i - 1] + arr[i - 1];
        PriorityQueue<Integer> Q = new PriorityQueue<Integer> ();
        for (int i = 1; i <= n; i++)
        {
            for (int j = i; j <= n; j++)
            {
                int x = sum[j] - sum[i - 1];
                if (Q.size() < k)
                    Q.add(x);

                else
                {
                    if (Q.peek() < x)
                    {
                        Q.poll();
                        Q.add(x);
                    }
                }
            }
        }
        System.out.println(Q.poll());
    }
    static void deleteElementsWhicharesmallerOrBecomeSmallerAfterDeleteion()
    {
       //Delete array elements which are smaller than next or become smaller
        int n = 5, k = 2;
        int arr[] = {20, 10, 25, 30, 40};
        Stack<Integer> s = new Stack<>();
        s.push(arr[0]);
        int count = 0;
        for (int i = 1; i < n; i++) {
            while (!s.empty() && s.peek() < arr[i]
                    && count < k) {
                s.pop();
                count++;
            }
            s.push(arr[i]);
        }
        int m = s.size();
        Integer[] v = new Integer[m];
        while (!s.empty()) {
            v[--m] = s.peek();
            s.pop();
        }
        for (Integer x : v) {
            System.out.print(x + " ");
        };
        System.out.println("");
    }

    private static void findClosestPairInTwoArrays() {
        //Find the closest pair from two sorted arrays
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

    private static void firstMissingPositiveNumber() {
//Find the smallest positive number missing from an unsorted array
        Integer[] A = { 0, 10, 2, -10, -20 };
        int n = A.length;
        Arrays.sort(A);
        boolean[] present = new boolean[A[A.length-1]];
        for (int i = 0; i < n; i++) {
          if (A[i] > 0 && A[i] <= n)
              present[A[i]] = true;
          }
          for (int i = 1; i <= n; i++) {
              if (!present[i]) {
                  System.out.println(i);
                  return;
              }
          }
        System.out.println(n+1);
    }

    private static void maxdiff() {
        //Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
        int arr[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
        int n=arr.length;
        int maxDiff;
            int i, j;

            int RMax[] = new int[n];
            int LMin[] = new int[n];
            LMin[0] = arr[0];
            for (i = 1; i < n; ++i)
                LMin[i] = Math.min(arr[i], LMin[i - 1]);
            RMax[n - 1] = arr[n - 1];
            for (j = n - 2; j >= 0; --j)
                RMax[j] = Math.max(arr[j], RMax[j + 1]);
            i = 0; j = 0; maxDiff = -1;
            while (j < n && i < n)
            {
                if (LMin[i] < RMax[j])
                {
                    maxDiff = Math.max(maxDiff, j - i);
                    j = j + 1;
                }
                else
                    i = i + 1;
            }

            System.out.println(maxDiff);

    }

    private static void MaximumDifferenceBEtweenTwoNumbersSuchthatLargestNumberComesAfterSMaller() {
        //Maximum difference between two elements such that larger element appears after the smaller number
        int arr[] = {1, 2, 90, 10, 110};
        int size = arr.length;
        int max_diff = arr[1] - arr[0];
            int min_element = arr[0];
            int i;
            for (i = 1; i < size; i++)
            {
                if (arr[i] - min_element > max_diff)
                    max_diff = arr[i] - min_element;
                if (arr[i] < min_element)
                    min_element = arr[i];
            }
            System.out.println(max_diff);
    }

    private static void getMinMax() {
        //Maximum and minimum of an array using minimum number of comparisons
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int n = 6;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
            if (n == 1) {
                max = arr[0];min = arr[0];
            }
            if (arr[0] > arr[1]) {
                max = arr[0];min = arr[1];
            } else {
                max = arr[1];min = arr[0];
            }
            for (int i = 2; i < n; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                } else if (arr[i] < min) {
                    min = arr[i];
                }
            }
            System.out.println("minimum"+min+"maximum"+max);
    }

    private static void FindKMaximumNonOverlappingContiguousSumIndexes() {
        //K maximum sums of non-overlapping contiguous sub-arrays
        int arr[] = {4, 1, 1, -1, -3, -5,
                6, 2, -6, -2};
        int k = 3;
        int n = arr.length;
        for(int i=0;i<k;i++) {
            int max_sum_so_far = Integer.MIN_VALUE;
            int curr_sum = 0;
            int start = 0;
            int end = 0;int s=0;
            for (int c = 0; c < n; c++) {
                curr_sum = curr_sum + arr[c];
                if (max_sum_so_far < curr_sum) {
                    max_sum_so_far = curr_sum;
                    start=s;
                    end = c;
                }
                if(curr_sum<0){
                    curr_sum = 0;
                    s= c + 1;
                }
            }
            System.out.println(start + " " + end + " " + max_sum_so_far);
            for (int j = start; j <= end; j++) {
                arr[j] = Integer.MIN_VALUE;
            }
        }
    }



    private static void MaxPairCombinationWithCountK() {
        //K maximum sum combinations from two arrays
        //BothArraysAreofSameSize
        int A[] = { 4, 2, 5, 1 };
        int B[] = { 8, 0, 5, 3 };
        int n = A.length;
        int K = 3;
        ArrayList<SumWithPair> pq = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                pq.add(new SumWithPair(A[i] + B[j],new Pair(A[i],B[i])));
        Collections.sort(pq);
        int count = 0;
        while (count < K) {
            System.out.println(pq.get(count).sum+" "+pq.get(count).p.x+" "+pq.get(count).p.y);
            count++;
        }
    }

    private static void MinimumPRoductOfAllPositiveNumbers() {
        //Minimum product of k integers in an array of positive Integers
        int arr[] = {198, 76, 544, 123, 154, 675};
        int k = 2;
        int n = arr.length;
        int count=0;int product =1;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++)
            pq.add(arr[i]);

        while(!pq.isEmpty()&&count<k){
            product=product*pq.peek();
            pq.poll();
            count++;
        }
        System.out.println(product);
    }

    private static void printAllElementsThathastwoGreaterElementsThanIt() {
        //Find all elements in array which have at-least two greater elements
        int arr[] = { 2, -6 ,3 , 5, 1};
        int n=arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++)
            System.out.print(arr[i]+" ");

        System.out.println();
    }
}
class SumWithPair implements Comparable<SumWithPair>{
    int sum;
    Pair p;
    SumWithPair(int sum,Pair p){
        this.sum=sum;
        this.p=p;
    }

    @Override
    public int compareTo(SumWithPair o) {
        if(this.sum<o.sum)
            return 1;
        else
            return -1;

    }
}
class Pair{
    int x;
    int y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}