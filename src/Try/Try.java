package Try;
import java.util.*;
import java.lang.*;
import java.io.*;
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}
class Try {
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String args[]) {

             ListNode l=new ListNode(1);
             l.next=new ListNode(1);
             l.next.next=new ListNode(2);
        l.next.next.next=new ListNode(2);
        l.next.next.next.next=new ListNode(3);
        l.next.next.next.next.next=new ListNode(3);
             Try t=new Try();
        t.deleteDuplicates(l);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev=new ListNode(-1);
        prev.next=head;
        ListNode curr=head;
        ListNode output=prev;
        // -1 1 1 2 2 3

        while(curr!=null){
            while(curr.next!=null&&curr.val==curr.next.val){
                curr=curr.next;
            }
            if(prev.next==curr){
                prev=prev.next;
            }
            else{
                prev.next=curr.next;
            }
            curr=curr.next;

        }
        return output.next;

    }

            public static void subsetSum(int[] candidates,int target,
                                  ArrayList<Integer> list,int index,int n){

                if(index==n){
                    return;
                }
                int sum=0;
                for(int j=0;j<list.size();j++){
                    sum+=list.get(j);
                }
                if(sum==target){
                    result.add(list);
                }
                for(int i=index+1;i<n;i++){
                    list.add(candidates[i]);
                    subsetSum(candidates,target,list,i,n);
                    list.remove(list.size()-1);
                }
            }

        }

