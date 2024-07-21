public class RemoveNnodefromBack {

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
    

    public void removeNthNnodeFromBack(int n){
        int size=0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        if(n>size) return ;

        //IMPORTANT EDGE CASE
        if(n == size){
            head = head.next;
            return;
        }

        // (size-n+1) == Index of that node 
        //But we have to be one previous node
        // Therefore reach size-n
        int i=1,idx = size-n;
        Node prev = head;
        while (i<idx) {
            prev = prev.next; 
            i++;           
        }
        //System.out.println(prev.data);
        prev.next = prev.next.next;

    }
    public static void main(String[] args) {
        RemoveNnodefromBack ll = new RemoveNnodefromBack();

        //ll.addFirst(20);
        ll.addFirst(10); 
        // ll.addLast(40);
        // ll.addLast(50);
        // ll.addMiddle(3, 30);
        ll.print();

        ll.removeNthNnodeFromBack(2);
        ll.print();

    }
    
}
