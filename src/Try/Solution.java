package Try;
import java.util.*;
class Solution {
    public static void main(String args[]){
        Solution s=new Solution();
        s.maxSlidingWindow(new int[]{1,3,1,2,0,5},
        3);
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> output=new ArrayList<Integer>();
        Deque<Integer> q=new LinkedList<Integer>();
        int i=0;
        for(i=0;i<k;i++){
            if(!q.isEmpty()&&q.getLast()<nums[i]){
                q.removeLast();
            }
            q.add(nums[i]);
        }
        output.add(q.peek()); System.out.println(q.getFirst());
        i--;
        while(i<nums.length-1){
            i++;
            while(!q.isEmpty()&&q.size()>=k){
                q.removeFirst();
            }
            if(!q.isEmpty()&&q.getLast()<nums[i]){
                q.removeLast();
            }
            q.add(nums[i]);

            System.out.println(q.getFirst());
            output.add(q.peek());
        }

        int[] out=new int[output.size()];
        for(int m=0;m<output.size();m++){
            out[m]=output.get(m);
        }
        return out;


    }
}


