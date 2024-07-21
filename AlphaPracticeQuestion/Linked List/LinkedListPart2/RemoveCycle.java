public class RemoveCycle {
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

    public static boolean DetectCyc(){
        Node slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){  // CYCLE detected
                return true;
            }
        }
        return false;
    }    

    public static void RemoveCyc(){
        Node slow = head, fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){  // CYCLE detected
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }
        slow = head;
        Node prev = null;
        while (slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        prev.next = null;      
    }

    

    public static void main(String[] args) {

        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        temp.next = new Node(3);
        temp.next.next = new Node(4);
        temp.next.next.next = temp;

        System.out.println(DetectCyc());
        RemoveCyc();
        System.out.println(DetectCyc());
        
    }
}
