public class AddLL {

    static Node head;
    static Node tail;
    static int size;

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void addMiddle(int idx, int data){
        size++;
        if(idx==0){
            addFirst(data);
            return;
        }
        else if(idx==size){
            addLast(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int i=0;
        while(i < idx-1){
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;      

    }

    public void print(){
        if(head == null){
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {

        AddLL ll = new AddLL();
        ll.addFirst(20);
        ll.addFirst(10);
        ll.print();   
        ll.addLast(40);
        ll.addLast(50);
        ll.print();
        ll.addMiddle(3, 30);
        ll.print();

    }

}