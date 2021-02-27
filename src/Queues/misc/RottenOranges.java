package Queues.misc;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    int arr[][] = { {2, 1, 0, 2, 1},
            {1, 0, 1, 2, 1},
            {1, 0, 0, 2, 1}};
    static int ans=0;
    Queue<Elem> q=new LinkedList<Elem>();
        class Elem{
            int x;
            int y;
            Elem(int x,int y){
                this.x=x;
                this.y=y;
            }
        }
    public static void main(String args[]){
        RottenOranges obj=new RottenOranges();
        obj.getRottenIndex();

        System.out.println(obj.construct());
        System.out.println(obj.check());
    }

    private boolean check() {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length;j++){
                if(arr[i][j]==1)
                    return false;
            }
        }
        return true;
    }

    private int construct() {
        q.add(new Elem(-1,-1));
        for (int i=0; i<3; i++)
        {
            for (int j=0; j<5; j++)
            {
                if (arr[i][j] == 2)
                {

                    q.add(new Elem(i,j));
                }
            }
        }
        while(!q.isEmpty()){
               Elem curr=q.poll();
                if(isValid(curr.x-1,curr.y)&&arr[curr.x-1][curr.y]==1){
                    q.add(new Elem(curr.x-1,curr.y));
                    arr[curr.x-1][curr.y]=2;
                    ans++;
                } if(isValid(curr.x+1,curr.y)&&arr[curr.x+1][curr.y]==1){
                    q.add(new Elem(curr.x+1,curr.y));
                    arr[curr.x+1][curr.y]=2;
                    ans++;
                } if(isValid(curr.x,curr.y-1)&&arr[curr.x][curr.y-1]==1){
                    q.add(new Elem(curr.x,curr.y-1));
                    arr[curr.x][curr.y-1]=2;
                    ans++;
                } if(isValid(curr.x,curr.y+1)&&arr[curr.x][curr.y+1]==1){
                    q.add(new Elem(curr.x,curr.y+1));
                    arr[curr.x][curr.y+1]=2;
                    ans++;
                }
            }
            return ans;
    }

    private boolean isValid(int x, int y) {
            if(x>0&&y>0&&x<3&&y<5)
                return true;
            return false;
    }

    private void getRottenIndex() {

        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length;j++){
                q.add(new Elem(i,j));
            }
        }
    }
}
