package BinaryTree.construction;

public class ConstructBSTFromParentTree {

    BST root;
    BST createTree(int[] parent,int n){
        BST[] created = new BST[n];
        for(int i=0;i<n;i++)
            created[i]=null;
        for(int i=0;i<n;i++)
           createNode(parent,i,created);
        int[] parent1 =  {1, 5, 5, 2, 2, -1, 3};
               //5
            //1     2
        //  0     3   4
        //       6

        createNode1(parent1);
        return root;

    }
private void createNode1(int[] input){
    BST t[] = new BST[input.length];

    for(int i = 0; i < input.length; i++) {
        t[i] = new BST(i);
    }

    BST root = null;
    for(int i = 0; i < input.length; i++) {
        int parentIndex = input[i];
        if (parentIndex == -1) {
            root = t[i];
            continue;
        }
        BST parent = t[parentIndex];
        if (parent.left == null) {
            parent.left = t[i];
            System.out.print("**");
        } else {
            parent.right = t[i];
            System.out.print("**");
        }
    }
}
    private void createNode(int[] parent, int i, BST[] created) {
        if(created[i]!=null)
            return;
        created[i] = new BST(i);
        if(parent[i]==-1)
        {
            root=created[i];
            return;
        }
        if(created[parent[i]] == null)
            createNode(parent,parent[i],created);

        BST p = created[parent[i]];
        if(p.left==null)
            p.left=created[i];
        else
            p.right=created[i];
    }

    public static void main(String args[]){
        ConstructBSTFromParentTree obj = new ConstructBSTFromParentTree();
        int[] parent = {-1,0,0,1,1,3,5};
        obj.createTree(parent,parent.length);

        }
}


