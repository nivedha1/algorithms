package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Reverse {

    public static void main(String args[]){
        int[] arr = {1,2,3,4,5};
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i:arr)
            q.add(i);
        reverse(q);
        Queue<Integer> q1=reverseWithRecursion(q);
        for(Integer i:q1){
            System.out.println(i);
        }
    }

    private static Queue<Integer>  reverseWithRecursion(Queue<Integer> q) {
        if(q.isEmpty())
            return null;
        int data=q.poll();
        reverseWithRecursion(q);
        q.add(data);
        return q;
    }

    private static void reverse(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while(queue.isEmpty()){stack.push(queue.poll());}
        while(!stack.isEmpty()){queue.add(stack.pop());}
        for(Integer i:queue){
            System.out.println(i);
        }

    }
}
