package QUEUE;

public class MyQueue {
    class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next=null;
        }
    }

    Node tail=null;
    Node head=null;

    public boolean isEmpty(){
        return head==null && tail==null;
    }
    public void add(int data){
        Node newNode=new Node(data);
        if(isEmpty()){
            tail=head=newNode;
            //return;
        }else{
            tail.next=newNode;
            tail=newNode;
        }
    }

    public int remove(){

        if(isEmpty()){
            System.out.println("stack is empty...");
            return -1;
        }
        if(head==tail){
            tail=null;
        }
        int front=head.data;
        head=head.next;
        return front;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("stack is empty...");
            return -1;
        }
        Node front=head;
        return head.data;
    }

    public static void main(String[] args) {
        MyQueue queue=new MyQueue();
        queue.add(111);
        queue.add(222);
        queue.add(333);
        while (!queue.isEmpty()){
            System.out.println(queue.peek());
            queue.remove();
        }
    }
}
