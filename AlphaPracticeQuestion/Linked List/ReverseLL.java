public class ReverseLL {

    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static Node head; 
    static Node tail;
    static int size;

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

        if(head == null){
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
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

    public void removeFirst(){
        if(head==null){
            return;            
        }
        else if(head==tail){
            head = tail = null;
            return;
        }

        head = head.next;
    }

    public void removeLast(){
        if(tail==null){
            return;
        }
        else if(head == tail){
            head = tail = null;
            return;
        }

        Node temp = head;
        //Finding SECOND LAST node
        while(temp.next != tail){
            temp = temp.next;                        
        }

        tail = temp;
        temp.next = null;
    }

    public void addMiddle(int idx, int data){
        size++;
        if(idx==0){
            addFirst(data);
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
    
    public void reverse(){
        Node curr,prev,next;
        curr = tail = head;
        prev = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev; 
    }

    public static void main(String[] args) {

        ReverseLL ll = new ReverseLL();

        ll.addFirst(20);
        ll.addFirst(10);
        ll.print();   
        ll.addLast(40);
        ll.addLast(50);
        ll.print();
        ll.addMiddle(3, 30);
        ll.print();

        ll.reverse();
        ll.print();
        
    }
}
