package Stack.misc.paranthesis;

import java.util.ArrayList;
import java.util.Stack;

public class Paranthesis {
String str="";
    public static void main(String args[]){
        Paranthesis obj=new Paranthesis();
        obj.MaxDepth();
        obj.LongestValidSubstring();
        obj.MAxBracketReversals();
        obj.ReplaceUnmatchedWIthMinusOne();
        obj.checkForRedundantBraclketsinExp();
        obj.longestValidSubSequencePrefix();
        String arr = "()]{}{[()()]()}";
        checkValidParanthesis(arr);
        arr="( a(b) (c) (d(e(f)g)h) I (j(k)l)m)";
        findMaximumDepth(arr);
        arr="((()())";
        lengthLongestValidParathesis(arr);
        arr="(a+b)";
        checkRedundantBrackets(arr);
        arr="(((abc))((d)))))";
        identofyAndMarkUnmantchedParanthesis(arr);
        arr="[ABC[23]][89]";
        findIndexOfClosingBracket(arr,0);
        //String balanced paranthesis
        costTobalanace();//2
        evaluateExpression();//7
        findCombinations("abcd",0,"");//9
        findEqualPointInBracket();//10
        swapCount();//11
        printBracketNumber();//16
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        System.out.println(obj.treeToString(root));//18
        int n=3;
        char[] str=new char[n*2];
        _printParenthesis(str,0,n,0,0);


    }
    static void _printParenthesis(char str[], int pos, int n, int open, int close)
    {
        if(close == n)
        {
            // print the possible combinations
            for(int i=0;i<str.length;i++)
                System.out.print(str[i]);
            System.out.println();
            return;
        }
        else
        {
            if(open > close) {
                str[pos] = '}';
                _printParenthesis(str, pos+1, n, open, close+1);
            }
            if(open < n) {
                str[pos] = '{';
                _printParenthesis(str, pos+1, n, open+1, close);
            }
        }
    }
    private static void printBracketNumber() {
        String exp="(a+(b*c))+(d/e)";
        int n=exp.length();
            int left_bnum = 1;
            Stack<Integer> right_bnum =
                    new Stack<Integer>();
            for (int i = 0; i < n; i++)
            {
                if (exp.charAt(i) == '(')
                {
                    System.out.print(left_bnum + " ");
                    right_bnum.push(left_bnum);
                    left_bnum++;
                }
                else if(exp.charAt(i) == ')')
                {
                    System.out.print(right_bnum.peek() + " ");
                    right_bnum.pop();
                }
            }
    }

    private static void swapCount() {
        StringBuffer s=new StringBuffer("[]][][");
            ArrayList<Integer> pos=new ArrayList<Integer>();
            for (int i = 0; i < s.length(); ++i)
                if (s.charAt(i) == '[')
                    pos.add(i);
            int count = 0; // To count number of encountered '['
            int p = 0;  // To track position of next '[' in pos
            long sum = 0; // To store result
            for (int i = 0; i < s.length(); ++i)
            {
                if (s.charAt(i) == '[')
                {
                    ++count;
                    ++p;
                }
                else if (s.charAt(i) == ']')
                    --count;
                if (count < 0)
                {
                    sum += pos.get(p) - i;
                    char temp=s.charAt(i);
                    s.setCharAt(i,s.charAt(pos.get(p)));
                      s.setCharAt(pos.get(p),temp);
                    ++p;
                    count = 1;
                }
            }
            System.out.println(sum);
    }

    private static void findEqualPointInBracket() {
        String str = "(()))(()()())))";
        int len = str.length();
        int open[] = new int[len + 1];
        int close[] = new int[len + 1];
        int index = -1;

        open[0] = 0;
        close[len] = 0;
        if (str.charAt(0) == '(')
            open[1] = 1;
        if (str.charAt(len - 1) == ')')
            close[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            if (str.charAt(i) == '(')
                open[i + 1] = open[i] + 1;
            else
                open[i + 1] = open[i];
        }

        for (int i = len - 2; i >= 0; i--) {
            if (str.charAt(i) == ')')
                close[i] = close[i + 1] + 1;
            else
                close[i] = close[i + 1];
        }
        if (open[len] == 0 || close[0] == 0)
        {
            System.out.println("-1");
            return;
        }
            for (int i=0; i<=len; i++)
                if (open[i] == close[i])
                    index = i;
            System.out.println(index);
    }


    static void findCombinations(String str, int index,
        String out)
        {
            if (index == str.length())
                System.out.println(out);

            for (int i = index; i < str.length(); i++)
                findCombinations(str, i + 1, out +
                        "(" + str.substring(index, i+1) + ")" );

    }

    private static void evaluateExpression() {
        //Given a string consisting of only 0, 1, A, B, C where A = AND  B = OR C = XOR
        StringBuffer s=new StringBuffer("1C1B1B0A0");
            int n = s.length();
            for (int i = 0; i < n; i += 2) {
                if( i + 1 < n && i + 2 < n)
                {
                    if (s.charAt(i + 1) == 'A') {
                        if (s.charAt(i + 2) == '0' ||
                                s.charAt(i) == 0)
                            s.setCharAt(i + 2, '0');
                        else
                            s.setCharAt(i + 2, '1');
                    }
                    else if ((i + 1) < n &&
                            s.charAt(i + 1 ) == 'B') {
                        if (s.charAt(i + 2) == '1' ||
                                s.charAt(i) == '1')
                            s.setCharAt(i + 2, '1');
                        else
                            s.setCharAt(i + 2, '0');
                    }
                    else {
                        if (s.charAt(i + 2) == s.charAt(i))
                            s.setCharAt(i + 2, '0');
                        else
                            s.setCharAt(i + 2 ,'1');
                    }
                }
            }
            System.out.println(s.charAt(n - 1) - '0');
    }

    private static void costTobalanace() {
        String s=")))(((";
        if (s.length() == 0)
            System.out.println(0);
        int ans = 0;
        int o = 0, c = 0;

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
                o++;
            if (s.charAt(i) == ')')
                c++;
        }
        int []a = new int[s.length()];
        if (s.charAt(0) == '(')
            a[0] = 1;
        else
            a[0] = -1;
        if (a[0] < 0)
            ans += Math.abs(a[0]);
        for (int i = 1; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
                a[i] = a[i - 1] + 1;
            else
                a[i] = a[i - 1] - 1;
            if (a[i] < 0)
                ans += Math.abs(a[i]);
        }

        System.out.println(ans);
    }

    private static void findIndexOfClosingBracket(String arr, int startIdx) {
        char[] expArr = arr.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0, currmax = 0, max = 0;
        for (i = startIdx; i < expArr.length; i++) {
            if(expArr[i]=='['){
                stack.push(i);
            }
            else if(expArr[i]==']'){
                stack.pop();
                if(stack.isEmpty()){
                    System.out.println("closing paranthesis of "+startIdx+" paranthesis is at "+i);
                    break;
                }
            }
        }


    }

    private static void identofyAndMarkUnmantchedParanthesis(String arr) {
        StringBuffer a = new StringBuffer(arr);
        char[] expArr = arr.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0, max = 0;
        for (i = 0; i < expArr.length; i++) {
            char expression = expArr[i];
            if(expression=='(')
                stack.push(i);
            else if(expression==')')
            {
                if(stack.isEmpty()){
                    a.replace(i,i+1,"-1");
                }
                else {
                    a.replace(i,i+1,"1");
                    a.replace(stack.peek(),stack.peek()+1,"0");
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()){
            a.replace(stack.peek(),stack.peek()+1,"-1");
            stack.pop();
        }
        System.out.println(a.toString());
    }
    private static void checkRedundantBrackets(String arr) {
        char[] expArr = arr.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        int i = 0,  max = 0;
        for (i = 0; i < expArr.length; i++) {
            char expression = expArr[i];
            if(expression==')'){
                Character top = stack.pop();
                boolean result=true;
                while(top!='('){//if no operator is found between(and) opening and closing brackets then its a redundant bracket like ((A)) or ((a+b)) where (a+b) will leave behind () in stack
                    if(top=='+'||top=='-'||top=='*'||top=='/'){
                        result=false;

                    }
                    top=stack.pop();
                }
                if(result) {
                    System.out.println("Found redundant");
                    break;
                }
            }
            else
                stack.push(expression);
        }
        if(i==expArr.length&&stack.isEmpty()){
            System.out.println("Found no redundant");
        }
    }

    private static void lengthLongestValidParathesis(String arr) {
        char[] expArr = arr.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0,  max = 0;
        for (i = 0; i < expArr.length; i++) {
            char expression = expArr[i];
            if(expression=='(')
                stack.push(i);
            else
            {
                if(!stack.isEmpty())
                    max= Math.max(max,i-stack.pop());
                else
                    stack.push(i);
            }
        }
        System.out.println(max+1);

    }

    private static void findMaximumDepth(String arr) {
        char[] expArr = arr.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        int i = 0, currmax = 0, max = 0;
        for (i = 0; i < expArr.length; i++) {
            char expression = expArr[i];
            if (expression == '(') {
                currmax++;
                if (max < currmax) {
                    max = currmax;
                }
            } else if (expression == ')') {
                if (currmax != 0) {
                    currmax--;
                } else {
                    System.out.println(-1);
                    break;
                }
            }
        }
        if(currmax==0){
            System.out.println(max);
        }
        else
            System.out.println(-1);

    }
    private static void checkValidParanthesis(String arr) {
        char[] expr=arr.toCharArray();
        Stack<Character> s=new Stack<Character>();
        for (int i=0; i<expr.length; i++)
        {
            if (expr[i]=='('||expr[i]=='['||expr[i]=='{')
            {
                // Push the element in the stack
                s.push(expr[i]);
                continue;
            }

            // IF current current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (s.empty()) {
                System.out.println("false");
                return;
            }
char x;
            switch (expr[i])
            {
                case ')':
                    x = s.pop();
                    if (x=='{' || x=='[')
                    {
                        System.out.println("false");
                        return;
                    }
                    break;
                case '}':
                    x = s.pop();
                    if (x=='(' || x=='[')
                    {
                        System.out.println("false");
                        return;
                    }
                    break;
                case ']':
                    x = s.pop();
                    if (x =='(' || x == '{')
                    {
                        System.out.println("false");
                        return;
                    }
                    break;
            }
        }
        System.out.println (s.empty());
    }



    private static boolean isMatchingPair(char closing, Character opening) {
        if(opening=='('&&closing==')')
            return true;
        if(opening=='['&&closing==']')
            return true;
        if(opening=='{'&&closing=='}')
            return true;
        return false;

    }



    private void longestValidSubSequencePrefix() {
        String exp = "()((()))((";//((a+b))

        Stack<Character> st = new Stack<>();
        char[] str = exp.toCharArray();
        // Iterate through the given expression
        int sum=0;
        int max=0;
        for (int i=0;i<str.length;i++) {

            char ch = str[i];
            if (ch == '(') {
                sum++;
            } else if (ch == ')') {
                sum--;
            }
            if (sum == 0)
                max = i;
        }
            System.out.println(max+1);

        }
    private void checkForRedundantBraclketsinExp() {
        String exp = "(a+(b)/c)";//((a+b))

        Stack<Character> st = new Stack<>();
        char[] str = exp.toCharArray();
        // Iterate through the given expression
        boolean isRedundant = false;

        for (char ch : str) {
            if (ch == ')') {
                if (!st.isEmpty()&&st.peek() == '(') {
                    isRedundant = true;
                    break;
                } else {
                    while (!st.isEmpty()&&st.peek() != '(') {
                        char top = st.pop();
                        if (top == '+' || top == '-' || top == '-' || top == '/') {
                            isRedundant = true;
                            break;
                        }
                    }
                }
            } else {
                st.push(ch);
            }
        }
        System.out.println(isRedundant);
    }

    private void ReplaceUnmatchedWIthMinusOne() {
        StringBuffer exp = new StringBuffer("((a)");

        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        for (i = 0; i < exp.toString().length(); i++) {
            if(exp.charAt(i)=='('){
                stack.push(i);
            }
            else if(exp.charAt(i)==')'){
                if(stack.isEmpty())
                    exp.replace(i,i+1,"-1");
                else {
                    exp.replace(i, i+1, "1");
                    exp.replace(stack.peek(), stack.peek()+1, "0");
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()){
            exp.replace(stack.peek(), stack.peek()+1,"-1");
        }
        System.out.println(exp.toString());
    }

    private void MAxBracketReversals() {
        String exp = "}{{}}{{{";
        if (exp.length()%2!=0)//is odd then it cant be reversed
            return;

        char[] arr = exp.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        int res = 0;
        int max = 0;
        for (i = 0; i < arr.length; i++) {
            char c = arr[i];
            if(c=='{')
                stack.push('{');
            else if(c=='}')
            {
                if(!stack.isEmpty()&&stack.peek()=='{')
                    stack.pop();
                else
                    stack.push('}');
            }
        }
        int m=0;
        int result=stack.size();
        while (!stack.empty() && stack.peek() == '{')
        {
            stack.pop();
            m++;
        }
        int n=result-m;

        System.out.println(Math.ceil(Double.valueOf(m)/2)+Math.ceil(Double.valueOf(n)/2));

    }

    private void LongestValidSubstring() {
        String exp="(((())";
        char[] arr=exp.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        int i=0;
        int res=0;int max=0;
        for(i=0;i<arr.length;i++) {
            char c = arr[i];
            if (c == '(')
                stack.push(i);
            else if (c == ')') {
                stack.pop();
                res = Math.max(res, i - stack.peek());
            }
        }
            System.out.println(res);

    }

    void MaxDepth(){
        String exp = "(a(b)(c)(d(e(f)g)h)I(j(k)l)m)";
        char[] arr=exp.toCharArray();
        int i=0;
        int res=0;int max=0;
        for(i=0;i<arr.length;i++){
            char c= arr[i];
            if(c=='(') {
                res++;
                if(res>max)
                    max=res;
            }
            else if(c==')'){
                res--;
                if(res==-1)
                    break;
            }
        }
        if(i!=arr.length)
            System.out.println(-1);
        else
            System.out.println(max);
    }
     String treeToString(Node root)
    {
        if (root == null)
            return "";
        str += (Character.valueOf((char)
                (root.data + '0')));
        if (root.left == null && root.right == null)
            return "";
        str += ('(');
        treeToString(root.left);
        str += (')');
        if (root.right != null)
        {
            str += ('(');
            treeToString(root.right);
            str += (')');
        }
        return str;
    }
}
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}