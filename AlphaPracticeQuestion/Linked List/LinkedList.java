public class LinkedList {
    public static class Node
    {
        int data;
        Node next;
        public Node(int data) {
            this.data=data;
            this.next=null;
        }
    }

        public static Node head;
        public static Node tail;   
        public static int size;

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
                return;
            }

            tail.next=newNode;

            tail=newNode;

        }

        public void addMiddle(int idx , int data)
        {
            if(idx==0)
            {
                addFirst(data);
            }
            Node newNode = new Node(data);
            size++;
            Node temp = head;
            int i=0;
             while(i<idx-1)
             {
                temp=temp.next;
                i++;
             }

             //temp is on prev
             newNode.next=temp.next;
             temp.next=newNode;

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

        public void removeFirst(){
            if(size==0)
            {
                System.out.println("LL is empty");
            }
            else if(size==1)
            {
                size=0;
                head=tail=null;
            }
            else
            {
                head=head.next;
                size--;
            }
        }

        public void removeLast()
        {
            if(size==0)
            {
                System.out.println("LL is empty");
            }
            else if(size==1)
            {
                size=0;
                head=tail=null;
            }
            else
            {
                Node prev=head;
               for(int i=0;i<size-2;i++)
               {
                  prev=prev.next;
               }

               prev.next=null;
               tail=prev;
               size--;
            }
        }

        public int IterativeSearch(int key)
        {
            Node temp=head;
            int i=0;
            while(temp!=null)
            {
                if(temp.data==key)
                {
                    return i;
                }
              temp=temp.next;
              i++;
            }

            return -1;
        }

        public int helper(Node head,int key)
        {
            //base
            if(head==null)
            {
                return -1;
            }
            if(head.data==key)
            {
               return 0;
            }
            //kaam
            int idx = helper(head.next,key);
            if(idx==-1)
            {
                return -1;
            }
           return idx+1;
        }

        public int RecursiveSearch(int key)
        {
            return  helper(head,key);
        }

        public void reverse()
        {
            Node prev = null;
            Node curr,nxt;
            curr = tail = head;

            while(curr!=null)
            {
                nxt=curr.next;
                curr.next=prev;
                prev=curr;
                curr=nxt;
            }
            head=prev;
        }
    
        public void removeNfromLast(int n)
        {
            int sz=0;
            Node temp = head;
            while(temp!=null)
            {
                temp=temp.next;
                sz++;
            }

            int i=1;
            temp=head;
            int idx=sz-n;
            while(i<idx)
            {
                temp = temp.next;
                i++;
            }

            temp.next=temp.next.next;

        }

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

   private Node MidNode(Node head)
    {
        Node slow=head,fast=head;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next; //+1
            fast=fast.next.next;  //+2
        }
           return slow;
     }

     public boolean checkPalindrome()
     {
        if(head==null || head.next==null)
        {
            return true;
        }

        //find Middle
        Node mid = MidNode(head);
       // System.out.println(mid.data);

        //reverse 2 half
        Node prev=null;
        Node next,curr;
         curr = mid;

        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

       // System.out.println(prev.data);
        Node right = prev;
        Node left = head;

        //check if equal

        while(right!=null)
        {
            if(left.data != right.data)
            {
               return false;
            }

            left=left.next;
            right=right.next;
        }
          
        return true;

     }
    


    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
             
        ll.addFirst(2);
        
        ll.addFirst(1);
        
        ll.last(2);
       
        ll.last(1); 
        
       // ll.addMiddle(2, 9);
       // ll.print();

       // System.out.println(size); 
        
        //ll.removeFirst();
        //ll.print();
        //ll.removeLast();
        //ll.print();

        //System.out.println(size);

        //System.out.println(ll.IterativeSearch(9));
        //System.err.println(ll.IterativeSearch(10));

        //System.out.println(ll.RecursiveSearch(9));
        //System.out.println(ll.RecursiveSearch(10));

        //ll.reverse();
        //ll.print();

        //ll.removeNfromLast(3);
        //ll.print();

        /* 
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;

        ll.print();

        System.out.println(ll.DetectCycle());
        ll.RemoveCycle();
        System.err.println(ll.DetectCycle());

            */

            ll.print();
            System.out.println(ll.checkPalindrome());


    }


    
}
