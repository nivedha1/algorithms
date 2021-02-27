package Try;

import java.util.*;

public class Practice {

    public static void main(String args[]) {
        String str = "abcd";
        findCombination(str, "");
        findPermutation(str, -1, str.length(), "");
        isPalindrome(10);
        Practice obj = new Practice();
        isValid("()");
    }
        public static boolean isValid(String str) {

            char[] c = str.toCharArray();
            Stack<Character> s = new Stack<Character>();
            for(int i=1;i<c.length;i++){
                if(c[i]=='}'){
                    if(s.isEmpty())
                        return false;
                    else if (s.peek()!='{')
                        return false;
                    else
                        s.pop();
                }
                else if(c[i]==']'){
                    if(s.isEmpty())
                        return false;
                    else if(s.peek()!='[')
                        return false;
                    else
                        s.pop();
                }
                else if(c[i]==')'){
                    if(s.isEmpty())
                        return false;
                    else if(s.peek()!='(')
                        return false;
                    else
                        s.pop();
                }
                else{
                    s.push(c[i]);
                }
            }
            if(s.size()>0)
                return false;

            return true;

        }


        public static boolean isMatch(String s, String p) {

            if(p.length()==0)
                return true;
            if(p.length()==1&&s.length()==1&&p.charAt(0)=='*')
                return true;
            else if (s.length() > 1 && p.charAt(0) == '*' &&
                    p.length() == 0)
                return false;
            else if(s.charAt(0)==p.charAt(0) || p.charAt(0)=='.' &&
                    (s.length()>1 &&
                            p.length()>1)){
                isMatch(s.substring(1),p.substring(1));
            }

            else if(p.charAt(0)=='*' && s.length()>1)
                return isMatch(s.substring(1),p)||isMatch(s,p.substring(1));

            return false;

        }

            public static boolean isPalindrome(int x) {
                StringBuilder str = new StringBuilder(String.valueOf(x));
                if(str.charAt(0)=='-')
                    return false;
                StringBuilder strNew=new StringBuilder(str.reverse().toString());
                for(int i=0;i<str.length();i++){
                    if(str.charAt(i)!=strNew.charAt(i))
                        return false;
                }
                return true;
            }



    private static void findPermutation(String str, int index, int length,String curr) {

        if(index==length){
            return;
        }
        System.out.println(curr);
        for(int i=index+1;i<length;i++){
            curr=curr+str.charAt(i);
            findPermutation(str,i,length,curr);
            curr=curr.substring(0,curr.length()-1);
        }
    }

    private static void findCombination(String str, String s) {
        if(str.length()==0){
            System.out.println(s);
            return;
        }
        else{
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                String ros=str.substring(0,i)+str.substring(i+1);
                findCombination(ros,s+ch);
            }
        }


    }





}



class BST{
    int data;
    BST left;
    BST right;
}