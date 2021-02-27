package Queues.misc;

import java.util.Stack;

public class StackPermutation {

    public static void main(String args[]){
        int input[] = { 1, 2, 3 };

        // Output Queue
        int output[] = { 2, 1, 3 };
        Stack<Integer> tmpStack = new Stack<Integer>();
        Stack<Integer> iStack = new Stack<Integer>();
        Stack<Integer> oStack = new Stack<Integer>();
        for(int i=0;i<input.length;i++){
            iStack.push(input[i]);
            oStack.push(output[i]);
        }
            while(!iStack.isEmpty()) {
                if (!oStack.isEmpty() && iStack.peek() == oStack.peek()) {
                    oStack.pop();
                    iStack.pop();
                    while (!tmpStack.isEmpty() && !oStack.isEmpty()) {
                        if (tmpStack.peek() == oStack.peek()) {
                            tmpStack.pop();
                            oStack.pop();
                        }
                    }
                } else
                    tmpStack.push(iStack.pop());
            }
        if(!oStack.isEmpty())
            System.out.println("false");
        else
            System.out.println("true");
    }
}
