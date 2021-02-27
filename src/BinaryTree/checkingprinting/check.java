package BinaryTree.checkingprinting;

import java.util.HashSet;

public class check {

    static Bst bst = null;
    static int leafLevel = 0;
    static int depthlevel = 0;
    static HashSet<Integer> set =new HashSet<>();
    static int[] arr= {10,8,5};
    public static void main(String args[]) {
        check obj = new check();
        obj.constructTree();
        System.out.println(obj.check(bst, 0));
        depthlevel = depth(bst);
        //all node have two children and all laeves are at same level
        System.out.println(obj.isPerfectTree(bst, 1));
        //all node have two children for all nodes
        System.out.println(obj.isFullTree(bst));
        System.out.println(obj.hasDuplicates(bst));
        System.out.println(obj.rootToLeafSequenceExists(bst,arr,0));

    }

    private boolean rootToLeafSequenceExists(Bst bst, int[] arr, int index) {

        if(bst==null)
            return false;
        if(bst.left==null&&bst.right==null&&bst.data==arr[index]&&index<arr.length)
            return true;
        return (bst.data==arr[index]&&(index<arr.length-1)&&
                (rootToLeafSequenceExists(bst.left,arr,index+1)||
                rootToLeafSequenceExists(bst.right,arr,index+1)));
    }

    private boolean hasDuplicates(Bst bst) {

        if(bst==null)
            return false;
        if(set.contains(bst.data))
            return true;
        else
            set.add(bst.data);
        return hasDuplicates(bst.left)||hasDuplicates(bst.right);
    }

    private boolean isFullTree(Bst bst) {
        if (bst == null)
            return true;

        if (bst.left == null && bst.right == null)
            return true;

        if (bst.left != null && bst.right != null)

            return isFullTree(bst.left) && isFullTree(bst.right);
        return false;
    }

    private static int depth(Bst bst) {

        if (bst != null) {
            depthlevel++;
            depth(bst.left);
        }
        return depthlevel;
    }


    private boolean isPerfectTree(Bst bst, int level) {
        if (bst == null)
            return true;
        if (bst.left == null && bst.right == null) {

            return level == depthlevel;
        }
        if (bst.left == null || bst.right == null)
            return false;
        return isPerfectTree(bst.left, level + 1) &&
                isPerfectTree(bst.right, level + 1);

    }

    private boolean check(Bst bst, int level) {
        if (bst == null)
            return true;
        if (bst.left == null && bst.right == null) {
            if (leafLevel == 0) {
                leafLevel = level;
                return true;
            }
            return leafLevel == level;
        }

        return check(bst.left, level + 1) &&
                check(bst.right, level + 1);

    }


    private void constructTree() {
        bst = new Bst(10);
        bst.left = new Bst(8);
        bst.right = new Bst(2);
        bst.left.left = new Bst(5);
        bst.left.right = new Bst(3);
        bst.right.left = new Bst(2);
        bst.right.right = new Bst(2);
    }
}