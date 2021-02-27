package Stack;

import java.util.Arrays;
import java.util.Stack;

public class GreaterSmallerLeftRight {


    public static void main(String args[]){
        int arr[] = {5, 1, 9, 2, 5, 1, 7};
        GreaterSmallerLeftRight obj = new GreaterSmallerLeftRight();
        System.out.println("*****nest grater right*****");
        obj.findNextGreaterRight(arr);
        System.out.println("******net smallet right****");
        obj.findNExtSmallerRight(arr);
        System.out.println("****next greater left******");
        obj.findNextGreaterLeft(arr);
        System.out.println("*****next smallet left*****");
        obj.findNextSmallerLeft(arr);

    }
//right traverse from n-1 to 1
    //left traverse from 0 to n-1
    //for smaller pop when  arr[i] is less han stack peek
    //for greater pop when arr[i] is greater than stack peek
    //stack peek is the next greater or smaller element
    private void findNextGreaterRight(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] next=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i])
                stack.pop();
            if(stack.isEmpty())
                next[i]=-1;
            else
            next[i] = arr[stack.peek()];
            stack.push(i);
        }
        for(int i:next)
            System.out.print(i+" ");

    }
    private void findNExtSmallerRight(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] next=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                stack.pop();
            if(stack.isEmpty())
                next[i]=-1;
            else
                next[i] = arr[stack.peek()];
            stack.push(i);
        }
        for(int i:next)
            System.out.print(i+" ");
    }

    private void findNextGreaterLeft(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] next=new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i])
                stack.pop();
            if(stack.isEmpty())
                next[i]=-1;
            else
                next[i] = arr[stack.peek()];
            stack.push(i);
        }
        for(int i:next)
            System.out.print(i+" ");

    }

    private void findNextSmallerLeft(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] next=new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i])
                stack.pop();
            if(stack.isEmpty())
                next[i]=-1;
            else
                next[i] = arr[stack.peek()];
            stack.push(i);
        }
        for(int i:next)
            System.out.print(i+" ");

    }

}
