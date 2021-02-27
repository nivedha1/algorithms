package Graphs;

import java.util.*;



public class BFS {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> path = new ArrayList<>();
    static Queue<Integer> q = new LinkedList<Integer>();
    static Queue<Integer> levelq = new LinkedList<Integer>();
    static int[] level = null;
    boolean[] visited = null;
    static int count=0;
    BFS(int size) {
        visited = new boolean[size];
        list = new ArrayList<>();
        path = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(new ArrayList<>());
            path.add(new ArrayList<>());

        }
        level = new int[size];
    }

    static void addEdge(int a, int b) {
        list.get(a).add(b);
    }

    public static void main(String args[]) {


        // Create a graph given in the above diagram
        BFS g = new BFS(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.BFS(2);
        list = new ArrayList<>();
        g = new BFS(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        q = new LinkedList<Integer>();
        levelq = new LinkedList<>();
        int curlevel = 2;
        levelq.add(0);
        q.add(0);
        count = 0;
        g.countLevel();
        for (int l : level) {
            if (l == curlevel)
                count++;
        }
        System.out.println(count);

        list = new ArrayList<>();
        g = new BFS(4);
        g.addEdge(0, 3);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);

        ArrayList<Integer> pathList = new ArrayList<>();
        pathList.add(2);
        boolean[] isVisited = new boolean[4];
        //Call recursive utility
        g.printAllPathsUtil(2, 3, isVisited, pathList);
        g = new BFS(4);
        g.addEdge(0, 3);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 0);

        count = 0;
        g.printNumberOfEdgesBetweenTwoVertices(0, 2);
        q = new LinkedList<Integer>();
        int[] parent = { -1, 0, 1, 2, 3 };
        g=new BFS(parent.length+1);
        for(int i=0;i<parent.length;i++){
           int val=parent[i]+1;
            list.get(val).add(i+1);
        }
        g.countHeight();
        g.minimumNumberOfOperationToConvertXtoY(4,7);
        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 5,
                4, 3, 6, 0, 1, 2, 3, 4, 5, 7};
        g.minimumSteosToREachEndOfArray(arr);
        g.findSmallestBinaryDigitMultipleOfN(17);
        g.getStepppingNumbersInRange(0,21);
    }

    private void getStepppingNumbersInRange(int start, int end) {
        for(int i=start;i<=end;i++){
            if(isStepNum(i)){
                System.out.print(i+" ");
            }
        }
    }

    private boolean isStepNum(int num) {
        int prevnum=-1;
        while(num>0){
            int curdigit=num%10;
            if(prevnum!=-1){
                if(Math.abs(prevnum-curdigit)!=1)
                    return false;
            }
            num=num/10;
            prevnum=curdigit;
        }
        return true;
    }

    private void findSmallestBinaryDigitMultipleOfN(int N) {

        HashSet<Integer> hs=new HashSet<>();
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        while(!q.isEmpty()){
            int num=q.poll();
            int rem = num%N;
            if(rem==0){
                System.out.println(num);
                break;
            }
            if(!hs.contains(rem)){
                hs.add(rem);
                q.add(Integer.parseInt(String.valueOf(num)+"1"));
                q.add(Integer.parseInt(String.valueOf(num)+"0"));
            }
        }


    }

    //can move from didgit to digit or 1 step back or 1 step front
    private void minimumSteosToREachEndOfArray(int[] arr) {
        ArrayList<ArrayList<Integer>> samearrIdx=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<arr.length;i++){
            samearrIdx.add(new ArrayList<>());
        }
        for(int i=0;i<arr.length;i++){
            samearrIdx.get(arr[i]).add(i);
        }
        int[] distance=new int[arr.length];
        boolean[] visit=new boolean[arr.length];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        while(!q.isEmpty()){
            int idx=q.poll();
            if(idx==arr.length-1){
                System.out.println(distance[idx]);
                break;
            }
            ArrayList<Integer> d=samearrIdx.get(arr[idx]);
            for(int i=0;i<d.size();i++){
                int nextIdx=d.get(i);
                if(!visit[nextIdx]){
                    visit[nextIdx]=true;
                    q.add(nextIdx);
                    distance[nextIdx]=distance[idx]+1;
                }
            }
            d.clear();
            if(idx+1<arr.length&&!visit[idx+1]){
                q.add(idx+1);
                visit[idx+1]=true;
                distance[idx+1]=distance[idx]+1;
            }
            if(idx-1>=0&&!visit[idx-1]){
                q.add(idx-1);
                visit[idx-1]=true;
                distance[idx-1]=distance[idx]+1;
            }
        }


    }

    class Operation{
        int num;
        int stepCnt;
        Operation(int num,int stepCnt){
            this.num=num;
            this.stepCnt=stepCnt;
        }
    }
    private void minimumNumberOfOperationToConvertXtoY(int src, int destination) {
        Queue<Operation> q = new LinkedList<Operation>();
        q.add(new Operation(src,0));
        while(!q.isEmpty()){
            Operation o = q.poll();
            if(o.num==destination){
                System.out.println("Stepcount is"+o.stepCnt);
                break;
            }
            int mul = o.num * 2;
            int sub = o.num - 1;

            if (mul > 0 && mul < 1000)
            {
                Operation nodeMul = new Operation(mul, o.stepCnt + 1);
                q.add(nodeMul);
            }
            if (sub > 0 && sub < 1000)
            {
                Operation nodeSub = new Operation(sub, o.stepCnt + 1);
                q.add(nodeSub);
            }
        }

    }

    private void countHeight() {
        int height=0;

        q.add(0);
        levelq.add(0);
        while (!q.isEmpty()) {
            int a = q.poll();
            visited[a] = true;
            level[a] = levelq.poll();
            if(level[a]>height){
                height=level[a];

            }
            for (int b : list.get(a)) {
                if (!visited[b]) {
                    q.add(b);
                    levelq.add(level[a] + 1);
                }
            }
        }
        System.out.println("height is"+height);
    }

    private void printNumberOfEdgesBetweenTwoVertices(int src, int dest) {
        int[] distance = new int[list.size()];

        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;
        boolean flag = false;
        while (!q.isEmpty()) {
            src = q.poll();
            for (int i : list.get(src)) {
                if (!visited[i]) {
                    if (i != dest) {
                        distance[i] = distance[src] + 1;
                        visited[i] = true;
                        q.add(i);
                    } else {
                        distance[i] = distance[src] + 1;
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) {
                System.out.println(distance[dest]);
                break;
            }
        }
    }

    void BFS(int src) {
        q.add(src);
        System.out.println(src + " ");
        while (!q.isEmpty()) {
            src = q.poll();
            visited[src] = true;
            for (int i : list.get(src)) {
                if (!visited[i]) {
                    System.out.println(i + " ");
                    q.add(i);

                }
            }
        }
    }


    private void printAllPathsUtil(Integer src, Integer dest,
                                   boolean[] isVisited,
                                   List<Integer> localPathList) {

        // Mark the current node
        isVisited[src] = true;
        if (src.equals(dest)) {
            System.out.println(localPathList);
            // if match found then no need to traverse more till depth
            isVisited[src] = false;
            return;
        }

        // Recur for all the vertices
        // adjacent to current vertex
        for (Integer i : list.get(src)) {
            if (!isVisited[i]) {
                // store current node
                // in path[]
                localPathList.add(i);
                printAllPathsUtil(i, dest, isVisited, localPathList);
                // remove current node
                // in path[]
                localPathList.remove(i);// remove one by one the earlier visited nodes and traverse again to search for different path
            }
        }
        // Mark the current node
        isVisited[src] = false;// is a node is completetly traversed then set it to false to again tarverse it
    }

    private void printPath(ArrayList<ArrayList<Integer>> path) {
        for (ArrayList<Integer> p : path) {
            for (Integer q : p)
                System.out.print(q + "->");
        }
        System.out.println("");
    }

    private void countLevel() {
        while (!q.isEmpty()) {
            int a = q.poll();
            visited[a] = true;
            level[a] = levelq.poll();

            for (int b : list.get(a)) {
                if (!visited[b]) {
                    q.add(b);
                    levelq.add(level[a] + 1);
                }
            }
        }
    }
}
