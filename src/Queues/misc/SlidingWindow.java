package Queues.misc;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {


    public static void main(String args[]) {
        int[] arr = {12, 1, 78, 90, 57, 89, 56};
        maximumInEachSlidingWindow(arr, 3);
        int[] arr1 = {2, 5, -1, 7, -3, -1, -2};
        sumOfminimumAndMaximumofAllSlidingWindow(arr1, 4);
        int arr3[] = {12,-1,-7,8,-15,30,16,28};
        firstNegIntegerInEveryWindowOfSizek(arr3,3);
    }

    private static void firstNegIntegerInEveryWindowOfSizek(int[] arr, int num) {

        Deque<Integer> queue = new LinkedList<>();

        int slidingWindowSize = num;

        int i=0;
        for(i=0;i<num;i++){
            while (!queue.isEmpty() && arr[queue.getLast()]>0) {
                queue.removeLast();
            }
            queue.add(i);
        }

        for(;i<arr.length;i++){
            if(arr[queue.getFirst()]<0)
                System.out.println(arr[queue.peek()]);
            else
                System.out.println(0);
            if(!queue.isEmpty() && queue.getFirst()<=i-num){
                queue.removeFirst();
            }
            while(!queue.isEmpty() && arr[queue.getLast()]>0){
                queue.removeLast();
            }
            queue.add(i);
        }
        if(arr[queue.getFirst()]<0)
            System.out.println(arr[queue.peek()]);
        else
            System.out.println(0);
    }

    private static void sumOfminimumAndMaximumofAllSlidingWindow(int[] arr, int num) {
        Deque<Integer> Max = new LinkedList<>();
        Deque<Integer> Min = new LinkedList<>();
        int slidingWindowSize = num;
        int i = 0;
        for (i = 0; i < num; i++) {
            while (!Max.isEmpty() && arr[i] > arr[Max.getLast()])
                Max.removeLast();
            Max.add(i);
            while (!Min.isEmpty() && arr[i] < arr[Min.getLast()])
                Min.removeLast();
            Min.add(i);
        }
        int sum = 0;
        for (; i < arr.length; i++) {
            sum = sum + arr[Max.peek()] + arr[Min.peek()];
            while (!Max.isEmpty() && Max.getFirst() <= i - num) {
                Max.removeFirst();
            }
            while (!Max.isEmpty() && arr[Max.getLast()] <= arr[i])
                Max.removeLast();
            while (!Min.isEmpty() && Min.getFirst() <= i - num) {
                Min.removeFirst();
            }
            while (!Min.isEmpty() && arr[Min.getLast()] >= arr[i])
                Min.removeLast();
            Min.add(i);
            Max.add(i);
        }
        sum = sum + arr[Max.peekFirst()] + arr[Min.peekFirst()];
        System.out.println(sum);
    }

    //Queue is FIFO if it contains 0,1 getFirst and peek will give 0 and getLAst will give 1 as 1 is the latest element inserted lastly
    private static void maximumInEachSlidingWindow(int[] arr, int num) {
        Deque<Integer> q = new LinkedList<>();
        int i = 0;
        for (i = 0; i < num; i++) {
            while (!q.isEmpty() && arr[i] > arr[q.getLast()]) {//latest element is last so getLast
                q.removeLast();
            }
            q.add(i);
        }

        for (; i < arr.length; i++) {
            System.out.println(arr[q.peek()]);//peek in queue and peekfirst in deque are same peek is used because rest all will be removed

            while (!q.isEmpty() && q.getFirst() <= i - num)
                q.removeFirst();

            while (!q.isEmpty() && arr[i] > arr[q.getLast()]) {
                q.removeLast();

            }
            q.add(i);
        }
        System.out.println(arr[q.peek()]);
    }
}
