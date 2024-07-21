public class MergeSort {

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

    public Node findMid(Node head){
        Node slow,fast;
        slow = head;
        fast = head.next;

        while(fast != null && fast.next !=  null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }    

    private Node merge(Node h1, Node h2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (h1 != null && h2 != null) {
            if(h1.data <= h2.data){
                temp.next = h1;
                h1 = h1.next;
                temp = temp.next;
            }
            else{
                temp.next = h2;
                h2 = h2.next;
                temp = temp.next;
            }
        }

        while (h1 != null) {
            temp.next = h1;
            h1 = h1.next;
            temp = temp.next;
        }

        while (h2 != null) {
            temp.next = h2;
            h2 = h2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }
    
    public Node mergeSort(Node head){

        //Base Condition
        if(head == null || head.next == null){
            return head;
        }

        //Kaam

        //Step-1 : Find MidNode (1st half last node)
        Node mid = findMid(head);

        //Step-2 : Divide LL
        Node right = mid.next; // So it become 1st node of 2nf Half
        mid.next = null;

        //Step-3 : Call For Divided LL & Call merge
        Node newLeft = mergeSort(head); // Divide Left Half
        Node newRight = mergeSort(right); // Divide Right Half
        return merge(newLeft,newRight);   // Merge Two Half

    }    
    public static void main(String[] args) {

        MergeSort ll = new MergeSort();
        ll.addFirst(5);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addFirst(4);
        ll.print();
        head = ll.mergeSort(head);
        ll.print();
        
    }
}
