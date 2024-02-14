package linkedList;

import java.rmi.UnexpectedException;

public class SinglyLinkedList {
    //head of list
    Node head;
    
    //Node datatype
    class Node{
        int data;
        Node next;
        Node(int val){
            data = val;
            next = null;
        }
    }

    //insertion at the beginning
    private void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //insertion at the end
    private void append(int data){
        Node newNode = new Node(data);
        //if list is empty
        if(head==null){
            head=newNode;
            return;
        }
        Node last = head;
        while (last.next!=null){
            last=last.next;
        }
        last.next=newNode;
    }

    //insertion at the after given value
    private void insertAfterVal(int prevNodeVal, int data){
        Node newNode = new Node(data);
        Node prev = head;
        while(prev.data!=prevNodeVal){
            if(prev.next==null){
                break;
            }
            prev=prev.next;
        }
        if(prev.next==null){
            System.out.println("Node with provided value not found");
        }else{
            newNode.next=prev.next;
            prev.next=newNode;
        }

    }

    //Delete first node
    private void pop(){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        System.out.println("popped: " + head.data);
        head = head.next;
    }

    //Delete last node
    private void popLast(){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        Node last = head;
        if(last.next==null){
            System.out.println("popped: " + last.data);
            head=null;
        }
        while(last.next.next!=null){
            last=last.next;
        }
        System.out.println("popped: "+ last.next.data);
        last.next=null;
    }
    
    //Delete node with provided value
    private void popVal(int data){
        if(head==null){
            System.out.println("list empty");
            return;
        }
        Node prev = head;
        while(prev.next.data!=data){
            if(prev.next.next==null){
                break;
            }
            prev=prev.next;
        }
        if(prev.next.data!=data){
            System.out.println("node with value " + data + " not found");
            return;
        }
        System.out.println("popped value: "+ prev.next.data);
        prev.next=prev.next.next;
    }


    //print singly linked list
    private void print(){
        if(head==null){
            System.out.println("list is empty");
            return;
        }
        Node last = head;
        while(last!=null){
            System.out.print(last.data + " ");
            last = last.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //initialization
        SinglyLinkedList list = new SinglyLinkedList();
        list.print();
        
        //insert at beginning
        list.push(2);
        list.push(1);

        list.print();

        //insert at the end
        list.append(4);
        list.append(5);

        list.print();

        //insert after value
        list.insertAfterVal(6, 3);
        list.insertAfterVal(2, 3);

        //print list
        list.print();

        //delete first
        list.pop();
        list.print();

        //delete last;
        list.popLast();
        list.print();
        
        //delete val
        list.popVal(3);
        list.popVal(10);
        list.print();
    }
}
