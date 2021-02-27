package Stack.misc;

import java.util.Stack;

public class Histogram {

    public static void main(String args[]){
        int[] arr = {6,2,8, 3, 5, 4, 5, 1, 6};
        Stack<Integer> stack = new Stack<Integer>();
        int area=0;
        int maxArea=0;int i=0;
        while(i<arr.length)
        {
            if(stack.isEmpty()||arr[stack.peek()]<arr[i]) {//if continuously increasing push and increment
                stack.push(i);
                i++;
            }
           else {
                int pointer = stack.pop();//previous height

                area = arr[pointer] * (stack.isEmpty() ? i : i - stack.peek() - 1);//to calculate length of bar (i-1)is right index s.peek()/previous is left index arr[pointer] is height
                if(area>maxArea)
                    maxArea=area;
            }



        }
        while (stack.empty() == false)
        {
            int pointer = stack.peek();
            stack.pop();
            area = arr[pointer] * (stack.empty() ? i : i - stack.peek() - 1);

            if (area > maxArea)
                maxArea = area;
        }
System.out.println(maxArea);

    }
}
