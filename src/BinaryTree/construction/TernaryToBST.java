package BinaryTree.construction;

public class TernaryToBST {


    int i=0;

    public static void main(String args[]){
        String ternary="a?b?c:d:e";
        char[] exp = ternary.toCharArray();
        BST bst = null;
        TernaryToBST obj = new TernaryToBST();
        bst=obj.construct(exp,bst);
        System.out.println(bst);
    }

    private BST construct(char[] exp,BST bst) {//i is a global variable
        if(exp.length<i)
            return bst;
        bst = new  BST(exp[i]-'a');
        i++;
        if(exp.length>i) {
            if (exp[i] == '?') {
                i++;
                bst.left = construct(exp, bst);
                i++;
                bst.right = construct(exp, bst);
            }
        }
        return bst;
    }


}
