package linkedList;

public class DoublyLinkedList {
    Node head;

    class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    //print Doubly linked list
    private void print(){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        Node last = head;
        while(last!=null){
            System.out.print(last.data + " ");
            last=last.next;
        }
        System.out.println();
    }

    //insert at beginning
    private void push(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        head.prev=newNode;
        newNode.next=head;
        head=newNode;
    }

    //insert at the end
    private void append(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node last = head;
        while(last.next!=null){
            last=last.next;
        }
        last.next=newNode;
        newNode.prev=last;
    }

    //insert After Value
    private void addAfter(int nodeVal, int data){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        Node prevNode = head;
        while(prevNode.data!=nodeVal){
            if(prevNode.next==null){
                break;
            }
            prevNode=prevNode.next;
        }
        if(prevNode.data==nodeVal){
            Node newNode = new Node(data);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next.prev = newNode;
            return;
        }
        System.out.println("couldn't find node with value "+ nodeVal);
    }

    //insert before value
    private void addBefore(int nodeVal, int data){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        Node nextNode = head;
        while(nextNode.data!=nodeVal){
            if(nextNode.next==null) break;
            nextNode = nextNode.next;
        }
        if(nextNode.data==nodeVal){
            Node newNode = new Node(data);
            newNode.prev = nextNode.prev;
            newNode.next = nextNode;
            nextNode.prev = newNode;
            newNode.prev.next = newNode;
            return;
        }
        System.out.println("couldn't find node with value "+ nodeVal);
    }


    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.print();

        //insert at beginning
        list.push(2);
        list.push(1);
        list.print();

        //insert at end
        list.append(7);
        list.append(8);
        list.print();

        //insert after val
        list.addAfter(2, 3);
        list.addAfter(3, 4);
        list.print();

        //insert before value
        list.addBefore(7, 6);
        list.addBefore(6, 5);
        list.print();

        //delete is like singly, just point prev and next properly
    }
}
