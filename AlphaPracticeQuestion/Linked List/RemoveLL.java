public class RemoveLL {
    
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

    public static void main(String[] args) {
        
        RemoveLL ll = new RemoveLL();
        ll.addFirst(20);
        ll.addFirst(10);  
        ll.print();
        ll.addLast(30);
        ll.addLast(40);
        ll.print();
        ll.removeLast();
        ll.print();
        ll.removeFirst();
        ll.print();



    }
}
