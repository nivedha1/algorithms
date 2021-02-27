package CircularLinkedList;

public class CircularLinkedList {

    int data;
    CircularLinkedList next;

    CircularLinkedList(int data) {
        this.data = data;
        this.next = null;
    }

    CircularLinkedList() {

    }

    public static void main(String args[]) {
        CircularLinkedList obj = new CircularLinkedList();
        CircularLinkedList list = obj.insert(null, 1);
        list = obj.insert(list, 2);
        list = obj.insert(list, 3);
        list = obj.insert(list, 4);
        list = obj.insert(list, 6);
        list = obj.insert(list, 7);
        list = obj.insert(list, 8);
        obj.printList(list);
        list = obj.insertSorted(list, 5);
        list = obj.insertSorted(list, 0);
        list = obj.insertSorted(list, 9);
        obj.checkIfCircular(list);
        obj.printList(list);
        obj.splitTwoHalf(list);
        list = obj.delete(list, 8);
        list = obj.delete(list, 0);
        list = obj.delete(list, 9);
        obj.printList(list);
        obj.exhangeFirstLast(list);
        obj.printList(list);
        obj.leaveOneElementInCircularQueue(list,3);
    }

    CircularLinkedList insert(CircularLinkedList head, int data) {
        CircularLinkedList newNode = new CircularLinkedList(data);
        CircularLinkedList current = head;
        if (head == null) {
            newNode.next = newNode;
            head = newNode;
        } else if (head != null) {
            while (current.next != head)
                current = current.next;

            newNode.next = current.next;
            current.next = newNode;
        }
        return head;
    }

    CircularLinkedList insertSorted(CircularLinkedList head, int valueToInsert) {
        CircularLinkedList newNode = new CircularLinkedList(valueToInsert);
        CircularLinkedList current = head;
        CircularLinkedList prevNode = head;
        if (head == null) {
            newNode.next = newNode;
            head = newNode;
        } else if (current.data > valueToInsert) {
            while (current.next != head)
                current = current.next;
            newNode.next = current.next;
            current.next = newNode;
            head = newNode;
        } else if (current.data < valueToInsert) {
            while (current.data < valueToInsert && current.next != head) {
                prevNode = current;
                current = current.next;
            }
            if (current.data < valueToInsert && current.next == head) {
                prevNode = current;
            }
            newNode.next = prevNode.next;
            prevNode.next = newNode;
        }
        return head;
    }

    void printList(CircularLinkedList listPrint) {
        CircularLinkedList head = listPrint;
        do {
            System.out.print(listPrint.data + "->");
            listPrint = listPrint.next;

        } while (listPrint != head);
        System.out.println("**************");
    }

    CircularLinkedList delete(CircularLinkedList list, int data) {

        CircularLinkedList head = list;
        CircularLinkedList current = list;
        if (head.data == data) {
            while (current.next != list)
                current = current.next;
            current.next = head.next;
            head = head.next;
        } else {
            CircularLinkedList prev = list;
            while (current.data != data) {
                prev = current;
                current = current.next;
            }
            prev.next = current.next;

        }
        return head;

    }

    void splitTwoHalf(CircularLinkedList list) {
        CircularLinkedList fastPtr = list;
        CircularLinkedList slowPtr = list;
        while (fastPtr.next.next != list) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        if (fastPtr.next.next == list) {
            fastPtr = fastPtr.next;
        }
        CircularLinkedList head1 = list;
        CircularLinkedList head2 = slowPtr.next;
        slowPtr.next = head1;
        fastPtr.next = head2;
        printList(head1);
        printList(head2);
    }

    boolean checkIfCircular(CircularLinkedList list) {
        CircularLinkedList head = list;
        while (list.next != head) {
            list = list.next;
        }
        if (list.next == head) {
            System.out.println("true");
            return true;
        }
        return false;

    }

    //Josephs circle

    void leaveOneElementInCircularQueue(CircularLinkedList list,int m){
        CircularLinkedList prev=list;
        CircularLinkedList current=list;
        int count =1;
        while(current.next!=current) {
            while (count != m) {
              prev=current;
              current=current.next;
              count++;
            }
            prev.next=current.next;
            current=current.next;
            count=1;
        }
    }

    CircularLinkedList exhangeFirstLast(CircularLinkedList list){
        CircularLinkedList head=list;
        CircularLinkedList current=list;
        CircularLinkedList prev=list;
        while(current.next.next!=head){
            current=current.next;
        }
        current.next.next=head.next;
        head.next = current.next;
        current.next = head;
        head = head.next;

         // 1 2 3 4 5 6 7
        //  h         c
        //2 3 4 5 6 7  // put 7.next as 2
        //1 7 2 3 4 5 6  // attach 1.next as 7
//6 1 7 2 3 4 5  //7 2 3 4 5 6 1

        //add last elment next to second element
        //put first e;lement next to last element(now list will be 1(h) 7 2 3 4 5 6(c))
        //connect secoond last with first
        //move head ptr

        return head;
    }

}
