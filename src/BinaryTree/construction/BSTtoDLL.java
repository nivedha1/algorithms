package BinaryTree.construction;

public class BSTtoDLL {
    static DoublyLinkedList head = null;
    DoublyLinkedList prev = null;
    DoublyLinkedList dll = null;

    public static void main(String args[]) {
        BST tree = new BST(10);
        tree.left = new BST(20);
        tree.right = new BST(12);
        tree.left.left = new BST(15);
        tree.left.right = new BST(25);
        tree.right.left = new BST(30);
        tree.right.right = new BST(36);
        BSTtoDLL obj = new BSTtoDLL();
        // convert to DLL
        obj.BinaryTree2DoubleLinkedList(tree);
        // Print the converted List 
        obj.printList(head);
    }

    private void printList(DoublyLinkedList list) {
        while (list != null) {
            System.out.println(list.data);
            list = list.next;
        }
    }

    private void BinaryTree2DoubleLinkedList(BST tree) {

        if (tree != null) {
            BinaryTree2DoubleLinkedList(tree.left);

            if (dll == null) {
                head = new DoublyLinkedList(tree.data);
                dll = head;
                prev = head;
            } else {

                dll.next = new DoublyLinkedList(tree.data);
                dll.next.prev = prev;
                prev = dll.next;
                dll = dll.next;
            }
            BinaryTree2DoubleLinkedList(tree.right);
        }
    }
}

class DoublyLinkedList {
    int data;
    DoublyLinkedList next;
    DoublyLinkedList prev;

    DoublyLinkedList(int data) {
        this.data = data;
        this.next = this.prev = null;
    }
}
