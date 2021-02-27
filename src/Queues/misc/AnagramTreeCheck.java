package Queues.misc;


import java.util.ArrayList;
import java.util.Collections;

public class AnagramTreeCheck {

    BinaryTree tree;

    BinaryTree constructTree() {
        tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(7);
        tree.left.right = new BinaryTree(6);
        tree.right.left = new BinaryTree(5);
        tree.right.right = new BinaryTree(4);
        return tree;
    }

    BinaryTree constructTree2() {
        tree = new BinaryTree(1);
        tree.left = new BinaryTree(3);
        tree.right = new BinaryTree(2);
        tree.left.left = new BinaryTree(6);
        tree.left.right = new BinaryTree(7);
        tree.right.left = new BinaryTree(4);
        tree.right.right = new BinaryTree(3);
        return tree;
    }

    ArrayList<Integer> levelOne = new ArrayList<Integer>();
    ArrayList<Integer> levelTwo = new ArrayList<Integer>();

    public static void main(String args[]) {
        AnagramTreeCheck chk = new AnagramTreeCheck();
        chk.compare();
    }

    private void compare() {
        AnagramTreeCheck chk = new AnagramTreeCheck();
        BinaryTree one = chk.constructTree();
        BinaryTree two = chk.constructTree2();
        int height1 = chk.Height(one);
        int height2 = chk.Height(two);
        int i = 0;
        if (height2 != height1) {
            System.out.println("Its not an anagram");
        }
        for (i = 0; i < height1; i++) {
            levelOne = new ArrayList<Integer>();
            levelTwo = new ArrayList<Integer>();
            levelOne = chk.checkLevel(one, i, levelOne);
            levelTwo = chk.checkLevel(one, i, levelTwo);
            Collections.sort(levelOne);
            Collections.sort(levelTwo);
            if (!levelOne.equals(levelTwo)) {
                break;
            }
        }
        if (i == height1) {
            System.out.println("Its an anagram");
        } else {
            System.out.println("Its not an anagram");
        }
    }

    private ArrayList<Integer> checkLevel(BinaryTree tree, int lvl, ArrayList<Integer> levelOne) {

        if (lvl == 0) {
            levelOne.add(tree.value);
        } else {
            checkLevel(tree.left, lvl - 1, levelOne);
            checkLevel(tree.right, lvl - 1, levelOne);
        }
        return levelOne;
    }

    private ArrayList<Integer> checkLevel1(BinaryTree tree, int lvl, ArrayList<Integer> levelTwo) {

        if (lvl == 0) {
            levelTwo.add(tree.value);
        } else {
            checkLevel1(tree.left, lvl - 1, levelTwo);
            checkLevel1(tree.right, lvl - 1, levelTwo);
        }
        return levelTwo;
    }

    int lheight = 0;
    int rheight = 0;

    public int Height(BinaryTree tree) {

        if (tree == null)
            return 0;
        lheight = Height(tree.left);
        rheight = Height(tree.right);
        if (lheight > rheight)
            return lheight + 1;
        else
            return rheight + 1;

    }
}

class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int data) {
        this.value = data;
        this.left = null;
        this.right = null;
    }
}