package BinaryTree.Hackerearth;


import java.util.Scanner;
//https://www.hackerearth.com/practice/data-structures/trees/binary-and-nary-trees/practice-problems/algorithm/mirror-image-2/
public class FindMirrorOfGivenNode {
    static Node node[];

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        node = new Node[n + 1];

        for (int i = 0; i <= n; i++)
            node[i] = new Node();
        for (int i = 1; i < n; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();
            String type = sc.next();
            if (type.equals("L")) {
                node[parent].left = node[child];
                node[child].value = child;
            } else {
                node[parent].right = node[child];
               node[child].value = child;

            }
        }
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int mirror = findMirror(node[1], sc.nextInt());
            ans[i] = mirror;


        }
        for (int i : ans) {
            System.out.println(i);
        }

    }


    // recursive function to find mirror of Node
    static int findMirrorRec(int target, Node left, Node right) {
	/* if any of the Node is none then Node itself
	and decendent have no mirror, so return
	none, no need to further explore! */
        if (left == null || right == null)
            return 0;

	/* if left Node is target Node, then return
	right's key (that is mirror) and vice
	versa */
        if (left.value == target)
            return right.value;

        if (right.value == target)
            return left.value;

        // first recur external Nodes
        int mirror_val = findMirrorRec(target, left.left, right.right);
        if (mirror_val != 0)
            return mirror_val;

        // if no mirror found, recur internal Nodes
        return findMirrorRec(target, left.right, right.left);
    }

    // interface for mirror search
    static int findMirror(Node root, int target) {
        if (root == null)
            return 0;
        if (root.value == target)
            return target;
        return findMirrorRec(target, root.left, root.right);
    }


}


       class Node
        {
            int value;
            Node left=null;
            Node right=null;
            int parent;
            String type;
            public Node()
            {
                this.left=null;
                this.right=null;
                this.value=-1;
            }

        }
