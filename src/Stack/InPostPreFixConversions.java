package Stack;

import java.util.Stack;

public class InPostPreFixConversions {

    public static void main(String args[]){
        InPostPreFixConversions obj = new InPostPreFixConversions();
       // String infix = "a+b*(c^d-e)^(f+g*h)-i";
        //String postfix = "abcd^e-fgh*+^*+i-";
        String postfix = "AB+CD-*";
        String infix  =   "(A+B) * (C-D)";
        String prefix = "*+AB-CD";
       // obj.printPrefixToInfix(prefix);
       // obj.printInfixtoPostFix(infix);
       // obj.printPrefixToPostfix(prefix);//AB+CD-*
        //obj.printPostfixtoPrefix(postfix);
        //obj.printPostfixtoInfix(postfix);
    }
    void printPostfixtoPrefix(String postfix){//remember to go from left to right traverse and add op2 first stack is LIFO
        Stack<String> stack = new Stack<String>();
        for(int i=0;i<postfix.length();i++)
        {
            char exp = postfix.charAt(i);
            if(isOperator(exp)){
                String op1=stack.pop();
                String op2=stack.pop();
                String temp = exp+op2+op1;
                stack.push(temp);
            }
            else
                stack.push(String.valueOf(exp));
        }
        System.out.println(stack.pop());
    }
    void printPostfixtoInfix(String postfix){//remember to go from left to right traverse and add op2 first stack is LIFO
        Stack<String> stack = new Stack<String>();
        for(int i=0;i<postfix.length();i++)
        {
            char exp = postfix.charAt(i);
            if(isOperator(exp)){
                String op1=stack.pop();
                String op2=stack.pop();
                String temp = op2+exp+op1;
                stack.push(temp);
            }
            else
                stack.push(String.valueOf(exp));
        }
        System.out.println(stack.pop());
    }

void printPrefixToPostfix(String prefix){//remember to go from right to left traverse stack is LIFO
        Stack<String> stack = new Stack<String>();
        for(int i=prefix.length()-1;i>=0;i--)
        {
            char exp = prefix.charAt(i);
            if(isOperator(exp)){
                String op1=stack.pop();
                String op2=stack.pop();
                String temp = op1+op2+exp;
                stack.push(temp);
            }
            else
                stack.push(String.valueOf(exp));
        }
        System.out.println(stack.pop());
}
    void printPrefixToInfix(String prefix){//remember to go from right to left traverse stack is LIFO
        Stack<String> stack = new Stack<String>();
        for(int i=prefix.length()-1;i>=0;i--) {
            char c = prefix.charAt(i);
            if (isOperator(c)) {
                String op1 = stack.pop();
                String op2 = stack.pop();
                String temp = "(" + op1 + op2 + c +")";
                stack.push(temp);
            } else {
                stack.push(String.valueOf(c));
            }
        }
            System.out.println(stack.pop());

    }
    boolean isOperator(char c){
        if(c=='+'||c=='-'||c=='*'||c=='/'||c=='^')
            return true;
        return false;
    }
    int precedence(char c){
        if(c=='+'||c=='-')
            return 1;
        else if(c=='+'||c=='-')
            return 1;
        else if(c=='*'||c=='/')
            return 2;
        else if(c=='^')
            return 3;
        else
            return -1;

    }
    void printInfixtoPostFix(String infix)
    {
        String exp=infix;
        String result = "";
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<exp.length();i++)
        {
            char c = exp.charAt(i);
            if(Character.isLetterOrDigit(c))
                result+=c;
            else if(c=='(')
                stack.push(c);
            else if (c==')') {
                while (stack.peek() != '(')
                    result += stack.pop();
                stack.pop();
            }
            else if (isOperator(c)){
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result += stack.pop();
                } stack.push(c);
            }
        }
        while(!stack.isEmpty())
            result+=stack.pop();
        System.out.println(result);
    }




////           stack                c     stack.peek>=c
//                +                 *        no
//                +,*               (        just push
//                +,*,(             ^       no
//                +,*,(,^           -      yes
//                +,*,(,-           )      yes
//                +,*,              ^      no,
//                +,*,^             (      just push
//                +,*,^,(           +      no
//                +,*,^,(,+         *       no
//                +,*,^,(,+,*,      )       yes
//                +,*,^             -       yes

}
