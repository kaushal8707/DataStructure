package linked.list;

public class LinkedList {
    Node head;

    public void insert(int data){
        Node newNode=new Node();
        newNode.data=data;
        newNode.next=null;

        if(head==null){
            head=newNode;
        }else{
            Node n=head;    //this node for traversal
            while(n.next!=null){
                n=n.next;
            }
            n.next=newNode;
        }
    }

    public void insertStart(int data){
        Node newNode=new Node();
        newNode.data=data;
        newNode.next=null;

        newNode.next=head;
        head=newNode;
    }

    public void insertAtPosition(int index, int data){
        Node newNode=new Node();
        newNode.next=null;
        newNode.data=data;

        if(index==0){
            insertStart(data);
        }else{
            Node n=head;            //this node for traversal
            for(int i=0;i<index-1;i++) {         //want to insert at index 2 position(0-1-2-3)
                n=n.next;
            }
            newNode.next=n.next;
            n.next=newNode;
        }
    }

    public void delete(int index){      // delete from 3rd index
        if(index==0){
            head=head.next;
        }else{
            Node n=head;
            Node temp=null;
            for(int i=0;i<index-1;i++){
                n=n.next;
            }
            temp=n.next;
            n.next=temp.next;
            temp=null;
        }
    }
    public void show(){
        Node node=head;    //this node for traversal
        while(node.next!=null){
            System.out.println(node.data);
            node=node.next;
        }
        System.out.println(node.data);
    }
}
