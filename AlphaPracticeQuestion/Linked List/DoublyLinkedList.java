public class DoublyLinkedList {
    public static class Node
    {
        int data;
        Node prev,next;

        public Node(int data)
        {
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    public static Node head,tail;
    static int size;

    public void addFirst(int data)
    {
        Node newNode = new Node(data);
        size++;
        if(head==null)
        {
            head=tail=newNode;
            return;
        }
        
        newNode.next=head;
        head.prev=newNode;
        head=newNode;

    }

    public void addlast(int data)
    {
        Node newNode = new Node(data);
        size++;
        if(head==null)
        {
            head=tail=newNode;
        }
      
        newNode.prev=tail;
        tail.next=newNode;
        tail=newNode;


    }

    public int removefirst()
    {
        if(head==null)
        {
            System.out.println("Empty");
            size--;
            return Integer.MIN_VALUE;
        }
        int val = head.data;
        if(head.next==null)
        {
            System.out.println("last element");
            head=tail=null;
            size--;
            return val;
        }

        head=head.next;
        head.prev=null;
        size--;
        return val;
    }

    public int removelast()
    {
        if(head==null)
        {
            System.out.println("List is empty");
            size--;
            return Integer.MIN_VALUE;
        }
        if(head.next==null)
        {
            int val=head.data;
            head=tail=null;
            size--;
            System.out.println("last element");
            return val;
        }

        int val=head.data;
        tail=tail.prev;
        tail.next=null;
        size--;
        return val;
    }

    public void print()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
        System.out.println();
    }

    public void reverse()
    {
        if(head==null)
        {
            System.out.println("List is empty");
        }
        if(head.next==null)
        {
            System.out.println(head.data);
        }

        Node curr,next,prev;
        curr=head;
        prev=null;

        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            
            prev=curr;
            curr=next;
        }

        head=prev;
    }

    public static void main(String[] args) {
        
        DoublyLinkedList ll = new DoublyLinkedList();
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
       // System.out.println(size);
       // ll.print();
       // System.out.println(ll.removefirst());
       // System.out.println(ll.removefirst());
       // ll.print();
       // System.out.println(head.prev);
        //System.out.println(tail.next);

       // System.out.println(ll.removefirst());
       // ll.removefirst();
       
       ll.addlast(5);
       ll.addlast(6);
       ll.print();
       //ll.removelast();
       //ll.removefirst();
       //ll.removelast();
       //ll.removelast();
       //ll.removelast();
       //ll.removelast();
      // ll.print();
         ll.reverse();
         ll.print();
    }
}
