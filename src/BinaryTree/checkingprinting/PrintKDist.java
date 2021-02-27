package BinaryTree.checkingprinting;

public class PrintKDist {

    static Bst n1 = null;

    public static void main(String args[]) {
        PrintKDist obj = new PrintKDist();
        obj.constructTree();
        obj.printKDistFromRoot(n1,2);

    }

    private void printKDistFromRoot(Bst n1, int k) {

        if(n1==null)
            return;
        if(k==0){
            System.out.println(n1.data);
        }
        printKDistFromRoot(n1.left,k-1);
        printKDistFromRoot(n1.right,k-1);
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