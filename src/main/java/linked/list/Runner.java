package linked.list;

public class Runner {
    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();
        linkedList.insert(12);
        linkedList.insert(15);
        linkedList.insert(18);
        linkedList.insert(32);
        linkedList.insertAtPosition(2,99);
        linkedList.insertStart(55);
        linkedList.delete(2);
        linkedList.show();
    }
}
