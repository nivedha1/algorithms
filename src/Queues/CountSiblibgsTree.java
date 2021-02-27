package Queues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CountSiblibgsTree {

    int data;
    ArrayList<CountSiblibgsTree> list;
    CountSiblibgsTree(int data){
        this.data=data;
        list=new ArrayList<CountSiblibgsTree>();
    }
    void getCountSibling(CountSiblibgsTree tree,int data){
        Queue<CountSiblibgsTree> queue = new LinkedList<CountSiblibgsTree>();
        queue.add(tree);
        while(!queue.isEmpty()){
            CountSiblibgsTree node = queue.poll();
            for(CountSiblibgsTree i:node.list){
                if(i.data==data){
                    System.out.println(node.list.size()-1);
                    return;
                }
                queue.add(i);
            }

        }
    }

    public static void main(String args[]){
        CountSiblibgsTree tree = new CountSiblibgsTree(1);
        tree.list.add(new CountSiblibgsTree(2));
        tree.list.add(new CountSiblibgsTree(3));
        tree.list.add(new CountSiblibgsTree(4));
        tree.list.get(0).list.add(new CountSiblibgsTree(5));
        tree.list.get(0).list.add(new CountSiblibgsTree(6));
        tree.list.get(0).list.add(new CountSiblibgsTree(7));
        tree.list.get(0).list.add(new CountSiblibgsTree(9));
        tree.list.get(0).list.add(new CountSiblibgsTree(10));
        tree.list.get(1).list.add(new CountSiblibgsTree(8));
        tree.list.get(1).list.add(new CountSiblibgsTree(7));
        tree.list.get(1).list.add(new CountSiblibgsTree(10));
        tree.getCountSibling(tree,7);



    }
}
