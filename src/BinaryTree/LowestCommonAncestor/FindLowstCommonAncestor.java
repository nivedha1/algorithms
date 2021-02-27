package BinaryTree.LowestCommonAncestor;

import java.util.ArrayList;

public class FindLowstCommonAncestor {


    static BST n1 = null;
    ArrayList<BST> path1 = new ArrayList<>();
    BST tree = null;

    ArrayList<BST> path2 = new ArrayList<>();

    public static void main(String args[]) {
        FindLowstCommonAncestor obj = new FindLowstCommonAncestor();
        obj.constructTree();
        obj.findLCA(n1,n1.left.left, n1.left.right);//fot non-bst i.e binary tree
        obj.lowestCommonAncestor(n1,n1.left.left,n1.left.right);//for bst
        obj.constructTreeForLCAPathCommon();
        obj.printCommonPath();
        obj.findAcestorsOfGivenNode(n1, n1.right.left);
        obj.findKthCommonAncestor(n1.left.left, n1.left.right, 2);
    }
    public BST lowestCommonAncestor(BST root, BST p, BST q) {
        int pdata=p.data;
        int qdata=q.data;
        BST node = root;
        while(node!=null){
            int parentdata=node.data;
            if(pdata>parentdata&&qdata>parentdata){
                node=node.right;
            }
            else if(pdata<parentdata&&qdata<parentdata){
                node=node.left;
            }
            else{
                return node;
            }
        }
        return null;
    }
    private void findKthCommonAncestor(BST node1, BST node2, int k) {

        path1 = new ArrayList<>();
        path2 = new ArrayList<>();
        boolean pathisPresent1 = findPath(n1, node1, path1);
        boolean pathisPresent2 = findPath(n1, node2, path2);

        if (pathisPresent1 && pathisPresent2) {
            int i = 0;
            for (i = 0; i < path1.size() && i < path2.size(); i++) {
                if (k != 0) {
                    //iterate all common node if uncommon print the prev common node as LCA
                    if (!path1.get(i).equals(path2.get(i))) {
                        break;
                    } else {
                        k--;
                    }
                } else {
                    break;
                }
            }
            if (k == 0) {

                System.out.print(path1.get(i - 1).data + "   ");

            }
        }
    }

    private void findAcestorsOfGivenNode(BST root, BST node) {
        path1 = new ArrayList<>();
        findPathCommon(root, node.data, path1);
        for (int i = 0; i < path1.size() - 1; i++) {
            System.out.println(path1.get(i).data + " ");
        }

    }

    private void printCommonPath() {

        path1 = new ArrayList<>();
        boolean pathisPresent1 = findPathCommon(tree, 9, path1);
        boolean pathisPresent2 = findPathCommon(tree, 7, path2);

        if (pathisPresent1 && pathisPresent2) {
            int i = 0;
            for (i = 0; i < path1.size() && i < path2.size(); i++) {
                //iterate all common node if uncommon print the prev common node as LCA
                if (!path1.get(i).equals(path2.get(i))) {
                    break;
                } else {
                    System.out.println(path1.get(i).data);
                }
            }
        }
    }

    private boolean findPathCommon(BST root, int data, ArrayList<BST> path) {

        if (root == null)
            return false;
        path.add(root);

        if (root.data == data)
            return true;
        if (root.left != null && findPathCommon(root.left, data, path))
            return true;
        if (root.right != null && findPathCommon(root.right, data, path))
            return true;
        // If not present in subtree rooted with root, remove root from
        // path[] and return false
        path.remove(path.size() - 1);
        return false;
    }

    private void constructTreeForLCAPathCommon() {

        tree = new BST(1);
        tree.left = new BST(2);
        tree.right = new BST(3);
        tree.left.left = new BST(4);
        tree.left.right = new BST(5);
        tree.right.left = new BST(6);
        tree.right.right = new BST(7);
        tree.left.left.left = new BST(8);
        tree.right.left.left = new BST(9);
        tree.right.left.right = new BST(10);


    }

    private BST findLCA(BST root,BST p, BST q) {
            if(root == null)
                return null;
            if(root.data == p.data || root.data == q.data)
                return root;
            BST pancestor = findLCA(root.left, p, q);
            BST qancestor = findLCA(root.right,p,q);

            if(pancestor != null && qancestor != null)
                return root;
            return pancestor != null? pancestor : qancestor;
        }



    private boolean findPath(BST root, BST node, ArrayList<BST> path) {
        if (root == null)
            return false;
        path.add(root);

        if (root.data == node.data)
            return true;
        if (root.left != null && findPath(root.left, node, path))
            return true;
        if (root.right != null && findPath(root.right, node, path))
            return true;
        // If not present in subtree rooted with root, remove root from
        // path[] and return false
        path.remove(path.size() - 1);
        return false;


    }

    private void constructTree() {

        n1 = new BST(1);
        BST n2 = new BST(2);      //      1
        BST n3 = new BST(3);      //    2    3
        BST n4 = new BST(4);      // 4    5 6   7
        BST n5 = new BST(5);
        BST n6 = new BST(6);
        BST n7 = new BST(6);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;


    }
}
