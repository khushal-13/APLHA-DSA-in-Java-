public class LinkedList2 {

    public static class Node
    {
        int data;
        Node next;

        
        public Node(int data) {
            this.data=data;
            this.next=null;
        }

    }    

    public static Node head,tail;

    public  void addFirst(int data)
    {
        //Create Newnode
        Node newNode = new Node(data); 
        size++;
        if(head==null)
        {
            head = tail = newNode;
            return;
        }
      
        //Link 
        newNode.next=head;

        //make newNode head
        head=newNode;
    }

    public  void last(int data)
    {
        Node newNode = new Node(data);
        size++;
        if(head == null)
        {
            head = tail = newNode;
        }

        tail.next=newNode;

        tail=newNode;

    }

    public void print()
    {
        if(head==null)
        {
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    
   
    public static int size=0;

    public boolean DetectCycle()
    {
        Node slow=head,fast=head;

        while(fast !=null && fast.next!=null)
        {
           slow = slow.next;  //+1
           fast = fast.next.next;   //+2

           if(slow==fast)
           {
            return true; //cycle exist
           }
        }
        return false;  //cycle doesn't exist
    } 


    public void RemoveCycle()
    {
        //Detect Cycle
        Node slow,fast;
        slow = fast = head;
        boolean cycle = false;
        
        while(fast != null && fast != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow)
            {
                cycle=true;
                break;
            }
        }
        if(cycle==false)
            {
                return;
            }

            //Meeting point
            slow=head;
            Node prev=null;
            while(fast != slow)
            {
                prev=fast;
                slow=slow.next;
                fast=fast.next;
            }

            prev.next=null;
    }

    public Node getMid(Node head)
    {
        Node slow = head;
        Node fast = head.next;

        while(fast!=null && fast.next!=null)
        {
           slow = slow.next;
           fast = fast.next.next;
        }
        return slow;
    }

    public Node merge (Node head1,Node head2)
    {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1!=null && head2!=null)
        {
            if(head1.data<=head2.data)
            {
                temp.next=head1;
                head1=head1.next;
                temp=temp.next;
            }
            else
            {
                temp.next=head2;
                head2=head2.next;
                temp=temp.next;
            }
      }

      while(head1!=null)
      {
        temp.next=head1;
        head1=head1.next;
        temp=temp.next;
      }
      while(head2!=null)
      {
        temp.next=head2;
        head2=head2.next;
        temp=temp.next;
      }

      return mergedLL.next;       

    }

    public Node mergesort(Node head)
    {

        if(head==null || head.next==null)
        {
            return head;
        }

        // 1-Find mid
        Node mid = getMid(head);

        //2-Divide linked list
        //left starts from head
        Node righthead = mid.next;  //right
        mid.next=null;

        //3-Sort using merge function
        Node newLeft = mergesort(head);
        Node newRight =  mergesort(righthead);
       
       return merge(newLeft,newRight);

    }

    public void zigzag()
    {
        //1-Find mid
        Node slow = head;
        Node fast = head.next;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid = slow;

        //2-Divide ll and reverse 2 half
        
        Node next,curr;
        curr=mid.next;
        mid.next=null;
        Node prev=null;
        while(curr!=null)
        {
          next=curr.next;
          curr.next=prev;
          prev=curr;
          curr=next;
        }

        //3-alternate linking of nodes
        Node left=head;
        Node right=prev;

        Node nextL,nextR;
        
        while(left!=null && right!=null)
        {
           nextL=left.next;
           left.next=right;
           nextR=right.next;
           right.next=nextL;

           left=nextL;
           right=nextR;
        }
        
    }
    public static void main(String[] args) {
       
        /* 
        LinkedList2 n = new LinkedList2();
        head.data=1;
        head.next.data=3;
        head.next.next.data=4;
         
        System.out.println(n.DetectCycle());

        */

        LinkedList2 ll = new LinkedList2();
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addFirst(0);
       // ll.print();

      // ll.head = ll.mergesort(ll.head);
      // ll.print();

      //ll.zigzag();
      //ll.print();
       

    }


}
