package Stack;
import java.util.Stack;
public class Stockspan {


    public static void main(String args[]){
        int price[] = { 10, 4, 5, 90, 120, 80 };

        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        int[] result = new int[price.length];
        result[0]=1;
        for(int i=1;i<price.length;i++){
            while(!stack.isEmpty()&&price[i]>=price[stack.peek()])//if increasing pop
                stack.pop();
            result[i]=stack.isEmpty()?i+1:(i-stack.peek());
            stack.push(i);

        }
        for(int i:result)
            System.out.println(i);
    }
}
