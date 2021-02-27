package Strings;


import java.util.Arrays;
import java.util.TreeSet;

public class Subset {
    static TreeSet<String> setRes = new TreeSet<>();
//recursion is faster print a,ab,abc,abcd,abd,ac,acd,ad,b,bc,bcd,bd,c,cd,d
    //abc-a,ab,abc,ac,b,bc,d
    static void permuteRec(String str, int n,
                           int index, String curr) {
        // base case
        if (index == n) {
            return;
        }
        System.out.println(curr);
        for (int i = index + 1; i < n; i++) {
            // cur=a i-1,idx=-1 curr=ab i=1,idx=0 curr=abc i=2,idex=1  //i=3index=2 return
                                                  //curr=ab
                                                    // i=3,idex=1 return
                              //curr=a
                             // curr=ac i=2 idx =0
                                                                 // curr=a
                                                               //ab  i= idx=

            curr += str.charAt(i);
            permuteRec(str, n, i, curr);

            // backtracking
            curr = curr.substring(0, curr.length() - 1);
        }
        return;
    }


    public static void main(String args[]) {

        System.out.println(java.time.LocalTime.now());
        String str = "abc";
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        permuteRec(new String(arr), str.length(), -1, "");
        System.out.println(java.time.LocalTime.now());
        char[] set = {'a', 'b', 'c','d'};
        printSubsets(set);
        for (String s : setRes) {
            System.out.println(s);
        }
        System.out.println(java.time.LocalTime.now());


    }


    // Generates power set in lexicographic
    // order.

    static void printSubsets(char set[]) {
        int n = set.length;
        // Run a loop for printing all 2^n subsets one by one
        for (int i = 0; i < (1 << n); i++) {
            // Print current subset
            //000 //001 a//010 b//011 ba//100 c//101 ca//110 cb//111 abc
            //run through 8 times(i) 3 digits(j) for printing different subsets

            String s = "";
            for (int j = 0; j < n; j++) {
                //System.out.print(" i= "+i+" j= "+j+" 1<<j= ");
                //System.out.print(1 << j);
                //System.out.print(" i & (1 << j)) ");
                //System.out.print((i & (1 << j)));
                if ((i & (1 << j)) > 0)
                    s = s + set[j];
            }
            setRes.add(s);

        }
    }

}