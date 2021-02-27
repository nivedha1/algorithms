package BinaryTree.checkingprinting;

import java.util.*;

public class PrintView {

    static Bst n1 = null;static int maxLevel=0;
    public static void main(String args[]){
        PrintView obj = new PrintView();
        obj.constructTree();
        obj.printTopView(n1);
        obj.printVerticalOrder(n1);//bottom view
        obj.printRightView(n1,1);
        maxLevel=0;
        obj.printLeftView(n1,1);
        obj.bottomView(n1);
         }

    public void bottomView(Bst root)
    {
        if (root == null)
            return;
        int hd = 0;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Bst> queue = new LinkedList<Bst>();
        queue.add(root);
        Queue<Integer> horizontalDistance = new LinkedList<>();
horizontalDistance.add(0);
        while (!queue.isEmpty())
        {
            Bst temp = queue.remove();
            hd = horizontalDistance.poll();
            map.put(hd, temp.data);
            if (temp.left != null) {
                horizontalDistance.add(horizontalDistance.poll()-1);
                queue.add(temp.left);
            }
            if (temp.right != null)
            {
                horizontalDistance.add(horizontalDistance.poll()+1);
                queue.add(temp.right);
            }
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();
        while (iterator.hasNext())
        {
            Map.Entry<Integer, Integer> me = iterator.next();
            System.out.print(me.getValue()+" ");
        }
    }
    private void printVerticalOrder(Bst root) {
        Queue<Bst> q = new LinkedList<>();
        Queue<Integer> horizontalDistance = new LinkedList<>();
        q.add(root);horizontalDistance.add(0);
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        while(!q.isEmpty()){
            Bst temp = q.poll();
            int hd = horizontalDistance.poll();
            if(map.containsKey(hd)){
                ArrayList<Integer> list = map.get(hd);
                list.add(temp.data);
                map.put(hd,list);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(temp.data);
                map.put(hd,list);
            }
            if(temp.left!=null)
            {
                q.add(temp.left);
                horizontalDistance.add(hd-1);
            }
            if(temp.right!=null)
            {
                q.add(temp.right);
                horizontalDistance.add(hd+1);
            }
        }
        for(ArrayList<Integer> i:map.values())
        {
            System.out.println(i.toString());
        }
    }

    private void printLeftView(Bst n1, int level) {
        if(n1==null)
            return;
        if(level>maxLevel){
            System.out.println(n1.data);
            maxLevel=level;
        }
        printLeftView(n1.left,level+1);
        printLeftView(n1.right,level+1);
    }

    private void printRightView(Bst n1,int level) {

        if(n1==null)
            return;
        if(level>maxLevel){
            System.out.println(n1.data);
            maxLevel=level;
        }
        printRightView(n1.right,level+1);
        printRightView(n1.left,level+1);
    }

    private void printTopView(Bst root) {

        Queue<Bst> q = new LinkedList<>();
        Queue<Integer> horizontalDistance = new LinkedList<>();
        q.add(root);horizontalDistance.add(0);
        Map<Integer,Integer> map = new HashMap<>();
        while(!q.isEmpty()){
            Bst temp = q.poll();
            int hd = horizontalDistance.poll();
            if(!map.containsKey(hd)){
                map.put(hd,temp.data);
            }
        if(temp.left!=null)
        {
            q.add(temp.left);
            horizontalDistance.add(hd-1);
        }
            if(temp.right!=null)
            {
                q.add(temp.right);
                horizontalDistance.add(hd+1);
            }
        }
        for(Integer i:map.values())
        {
            System.out.println(i);
        }


    }

    private void constructTree() {
        n1 = new Bst(1);
        Bst n2 = new Bst(2);
        Bst n3 = new Bst(3);
        Bst n4 = new Bst(4);
        Bst n5 = new Bst(5);
        Bst n6 = new Bst(6);
        Bst n7 = new Bst(7);

        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n1.left = n2;
        n1.right = n3;
    }
}
