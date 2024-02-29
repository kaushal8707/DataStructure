package ds.stack;

public class StackDemo {
    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            next=null;
        }
    }

    static class Stack{
        Node head=null;
        private void push(int data){
            Node newNode=new Node(data);
            if(head==null)
            {
                head=newNode;
                return;
            }
            newNode.next=head;
            head=newNode;
        }
        private boolean isEmpty(){
            return head==null;
        }
        private int pop(){
            if(isEmpty())
                return -1;
            Node top=head;
            head=head.next;
            return top.data;
        }
        private int peek(){
            if(isEmpty())
                return -1;
            Node top=head;
            return top.data;
        }
    }

    public static void main(String[] args) {
        Stack stack=new Stack();
        stack.push(2);
        stack.push(4);
        stack.push(6);
        while (!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
