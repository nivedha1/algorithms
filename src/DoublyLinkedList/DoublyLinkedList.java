package DoublyLinkedList;

public class DoublyLinkedList {

    int data;
    DoublyLinkedList next;
    DoublyLinkedList prev;

    DoublyLinkedList(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    DoublyLinkedList() {

    }

    public static void main(String args[]) {
        DoublyLinkedList obj = new DoublyLinkedList();
        DoublyLinkedList list = obj.insertFirst(null, 1);
        list = obj.insertFirst(list, 0);
        list = obj.insertLast(list, 2);
        list = obj.insertLast(list, 3);

        list = obj.insertBefore(list, -2, 2);
        list = obj.insertBefore(list, 7, 3);
        obj.printList(list);
        list = obj.insertAfter(list, 8, 3);
        list = obj.insertAfter(list, 4, 7);
        obj.printList(list);
    }

    void printList(DoublyLinkedList list) {
        while (list != null) {
            System.out.print(list.data + "->");
            list = list.next;
        }
        System.out.println("*******************");
    }

    DoublyLinkedList insertAfter(DoublyLinkedList list, int data, int afterkey) {
        DoublyLinkedList current = list;
        DoublyLinkedList head = list;
        DoublyLinkedList prev = list;
        DoublyLinkedList newNode = new DoublyLinkedList(data);
        while (current != null && current.data != afterkey) {
            current = current.next;
            next = current.next;
        }

        if (next == null) {
            current.next = newNode;
            newNode.prev = current;
        } else {
            newNode.next = next;
            current.next = newNode;
            newNode.prev = current;
            next.prev = newNode;
        }
        return head;
    }

    DoublyLinkedList insertBefore(DoublyLinkedList list, int data, int beforekey) {
        DoublyLinkedList current = list;
        DoublyLinkedList head = list;
        DoublyLinkedList prev = list;
        DoublyLinkedList newNode = new DoublyLinkedList(data);

        if (head.data == beforekey) {
            newNode.next = head;
            head.prev = newNode;
        } else {
            while (current.data != beforekey) {
                prev = current;
                current = current.next;
            }
            newNode.next = current;
            prev.next = newNode;
            newNode.prev = prev;
            current.prev = newNode;
        }
        return head;
    }

    DoublyLinkedList insertFirst(DoublyLinkedList head, int data) {
        DoublyLinkedList newNode = new DoublyLinkedList(data);
        if (head == null) {
            newNode.prev = newNode.next = null;
        } else if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        return head;
    }

    DoublyLinkedList insertLast(DoublyLinkedList head, int data) {
        DoublyLinkedList current = head;
        DoublyLinkedList newNode = new DoublyLinkedList(data);
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
        return head;
    }
}