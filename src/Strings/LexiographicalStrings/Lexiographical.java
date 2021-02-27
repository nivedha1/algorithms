package Strings.LexiographicalStrings;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Lexiographical {
    //2

    //i.compareto(j) will return 1 when i>j   -1 when j>i
    static TreeSet<String> tset = new TreeSet<>();
    public static void main(String args[]){

        //1 5 are same in subset
        printLexSmallestRotation();//4
        LexSmallesrAfterConcat();//6
        LexMaxSubString();//7
        LexConcatenationOfSubstring();//8
        constructLexSmallestPalindrome();//9
        LexSmallestHammingdistance();//10
        LexNextString();//11
        LexLLargestsubsequenceAllelementsOccuratleastKTimes();//12
        FindNextLexString();//14xx

    }
    static void FindNextLexString()
    {
        String s = "samez";int n=s.length();
        char[] c=s.toCharArray();
        for (int i = n - 1; i >= 0; i--)
        {
            if (c[i] != 'z')
            {
                c[i]=(char)(((int)c[i])+1);
                System.out.print(Arrays.toString(c));
                return;
            }
            c[i] = 'a';
        }
    }

    private static void LexLLargestsubsequenceAllelementsOccuratleastKTimes() {
        //Lexicographically largest subsequence such that every character occurs at least k times
        char s[] = {'b','a','n','a','n','a'};
        int n = s.length;
        int k = 2;
        ArrayList<Character> t = null;
        for(char a='a';a<='z';a++) {
                int last = 0;
                int count = 0;
                for (int i = last; i < s.length; i++) {

                    if (s[i] == a)
                        count++;
                }
                if (count >= k) {
                    int newLast = 0;
                    t = new ArrayList<>();
                    for (int j = last; j < s.length; j++) {
                        if (a == s[j]) {
                            t.add(a);
                            newLast = j;
                        }
                    }
                }
            }
            for(Character q:t){
                System.out.print(q+" ");
            }
    }

    private static void LexNextString() {
        String str = "samez";
        int n=str.length()-1;
        while(n>0&&str.charAt(n)=='z')
            n--;
        if(n==-1)
            return;
        else
            str=str.substring(0,n)+(char)(((int)str.charAt(n))+1)+str.substring(n+1);
        System.out.println(str);
    }

    private static void LexSmallestHammingdistance() {
        //Where the Hamming distance between two strings of equal length is
        // the number of positions at which the corresponding character are different.
        //Lexicographically smallest string whose hamming distance from given string is exactly K
        String str = "pqrs";
        int n = str.length();
        int k = 2;
        int index=0;
        for(int i=0;i<n;i++){
            if(str.charAt(i)!='a') {
                str = str.substring(0, i) + "a" + str.substring(i + 1);
                index++;
                if (index == k)
                    break;
            }
        }
        if (index < k) {
            for (int i = n - 1; i >= 0; i--)
                if (str.charAt(i) == 'a') {
                    str = str.substring(0, i) + "b" + str.substring(i + 1);
                    index++;
                    if (index == k)
                        break;
                }
        }
        System.out.println(str);

    }

    private static void constructLexSmallestPalindrome() {
        char[] str = "bca*xc**b".toCharArray();
        int len = str.length;
        for(int i=0,j=len-1;i<j;i++,j--){
            if(str[i]==str[j]&&str[i]!='*'){
                continue;
            }
            if(str[i]==str[j]&&str[i]=='*'){
                str[i]='a';
                str[j]='a';
                continue;
            }
            if(str[i]=='*'){
                str[i]=str[j];
                continue;
            }
            if(str[j]=='*'){
                str[j]=str[i];
                continue;
            }
        }
        System.out.println(Arrays.toString(str));
    }

    private static void LexConcatenationOfSubstring() {
        String s = "abc";
        int n = s.length();
int index=0;
        String[] result = new String[n * (n + 1) / 2];
        int k = 0;
        for (int i = 0; i < n; i++)
            for (int len = 1; len <= n - i; len++) {
                result[index++] = s.substring(i, i + len);
            }

        Arrays.sort(result);String output="";
            for(String a:result){
                output+=a;
            }
System.out.println(output);
    }

    private static void LexMaxSubString() {
        String str = "ababaa";String max="";
        for(int i=1;i<str.length();i++){
            if(str.substring(i).compareTo(max)>1){
                max=str.substring(i);
            }
        }
        System.out.println(max);
    }

    private static void LexSmallesrAfterConcat() {
        String a[] = {"c", "cb", "cba"};
        int n = 3;
        Arrays.sort(a);
        LexSmallesrAfterConcatUtil(a);
        String result="";
        for(String s:a){
            result+=s;
        }
        System.out.println(result);
    }

    private static void LexSmallesrAfterConcatUtil(String[] a) {

        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if((a[i]+a[j]).compareTo(a[j]+a[i])>0){
                    String temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }

    }

    private static void printLexSmallestRotation() {
String str="GEEKSFORGEEKS";
int n=str.length();
String out=str+str;
ArrayList<String> result=new ArrayList<String>();
for(int i=1;i<n;i++){
    result.add(out.substring(i,i+n));
}
        Collections.sort(result);
System.out.println(result.get(0));


    }
}
