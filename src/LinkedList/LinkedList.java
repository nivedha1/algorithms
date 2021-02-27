package LinkedList;


import sun.awt.image.ImageWatched;

public class LinkedList {

    int data;
    LinkedList next;

    LinkedList(int data) {
        this.data=data;
        this.next=null;
    }

    LinkedList(){
    }

    void insertInHead(LinkedList head,int data){
        LinkedList list = new LinkedList(data);
        list.next=head;
        head=list;
        printList(head);
    }

    void insertInEnd(LinkedList head,int data){
        LinkedList init=head;
        LinkedList current=head;
        while(current.next!=null)
            current=current.next;
        LinkedList list = new LinkedList(data);
        list.next=null;
        current.next=list;
        printList(init);
    }

    void insertInMiddle(LinkedList head,int data){
        LinkedList slowPtr=head;
        LinkedList fastPtr=head;
        while(fastPtr.next!=null)
        {
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
        }
        LinkedList node = new LinkedList(data);
        node.next=slowPtr.next;
        slowPtr.next=node;
        printList(head);
    }

    void reverseList(LinkedList reverse){

        LinkedList next=null;
        LinkedList current=reverse;
        LinkedList prev=null;

        while(current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }

        printList(prev);

    }

void delete(LinkedList list,int data){
LinkedList head=list;
        while(list.next!=null) {
            if (list.next.data == data) {

                list.next = list.next.next;
                break;
            }list=list.next;
        }
        printList(head);
}

    void printList(LinkedList list){
        while(list!=null) {
            System.out.print(list.data+"->");
            list = list.next;
        }
        System.out.println("********");
    }

    public static void main(String args[]){
        LinkedList list = new LinkedList(1);
        list.next = new LinkedList(2);
        list.next.next = new LinkedList(3);
        list.next.next.next = new LinkedList(4);
        list.next.next.next.next = new LinkedList(5);
        LinkedList current=list.next.next.next.next.next = new LinkedList(6);
        list.reverseList(list);
        list.insertInHead(current,0);
        list.insertInEnd(current,7);
        list.insertInMiddle(current,8);
list.delete(current,2);
list.delete(current,5);

    }





}
