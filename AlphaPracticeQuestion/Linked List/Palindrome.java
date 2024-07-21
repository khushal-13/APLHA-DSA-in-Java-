public class Palindrome {

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
    

    public Node findMidNode(Node head){
        Node slow=head,fast=head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean palindrome(){

        //BASE CONDITION (Empty or ONE length string)
        if(head == null || head.next == null){
            return true;
        }

        //Step 1 : Middle Node
        Node midNode = findMidNode(head);

        //Step 2 : Reverse 2nd Half
        Node curr,prev,next;
        prev=null; curr=midNode;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; //1 st half head
        Node Left = head; // 2nd half head

        //Step 3 : Check Equal
        while (right != null) {
            if(Left.data != right.data){
                return false;
            }
            Left = Left.next;
            right = right.next;
        }
        return true;
    }
    public static void main(String[] args) {

        Palindrome ll = new Palindrome();

        ll.addFirst(20);
        ll.addFirst(10); 
        ll.addLast(20);
        ll.addLast(10);
        ll.print();
        System.out.println(ll.palindrome());
        
    }
}
