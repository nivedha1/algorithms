package BinaryTree.Hackerearth;
import java.util.*;


//https://www.hackerearth.com/practice/data-structures/trees/binary-and-nary-trees/practice-problems/algorithm/gandhi-tree-march/description/
//2
//        -1 a(c(f(.h(..))b(g(..).))e(.d(..)))
//        3 b(c(..)a(..))
class ConstructTreeFromBracketString {
    static HashMap<Integer,ArrayList<Character>> map = new HashMap<Integer,ArrayList<Character>>();
    static int pos=0;

    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int tc = s.nextInt();
        String[] ans = new String[tc];
        for(int k=0;k<tc;k++){
            int q = s.nextInt();
            String str=s.next();
            char[] c = str.toCharArray();
            pos=0;
            map=new HashMap<Integer,ArrayList<Character>>();
            constructTree(0,c);
            if(map.containsKey(q)) {
                ArrayList<Character> ansArr=map.get(q);
                Collections.sort(ansArr);
                String output="";
                for(char a:ansArr)
                    output+=a;
                ans[k]=output;
            }
            else
                ans[k]="Common Gandhijee!";
        }
        for(String string:ans){
            System.out.println(string);
         }
    }
    static void constructTree(int i,char[] c){
        if(c[pos]!='.'){
            if(map.containsKey(i)){
                ArrayList<Character> list = map.get(i);
                list.add(c[pos]);
                map.put(i,list);
            }
            else{
                ArrayList<Character> list = new ArrayList<Character>();
                list.add(c[pos]);
                map.put(i,list);
            }
            pos=pos+2;
            constructTree(i-1,c);
            constructTree(i+1,c);
        }
        pos++;
    }
}

