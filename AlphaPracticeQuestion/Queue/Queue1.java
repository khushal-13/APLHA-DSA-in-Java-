public class Queue1 {
   
    /*
    static class Queue
    {
    static int a[];
    static int size;
    static int rear;

    Queue(int n)
    {
        a=new int[n];
        size=n;
        rear=-1;
    }

    public boolean isEmpty()
    {
    return rear==-1;
    }

    //add
    public void add(int data)
    {
        if(rear==size-1)
        {
            System.out.println("Queue is full");
            return ;
        }
        
            rear = rear+1;
            a[rear]=data;
        
    }

    //remove
    public int remove()
    {
        if(isEmpty())
        {
            System.out.println("Empty");
            return -1;
        }

        int front = a[0];
        for(int i=0;i<rear;i++)
        {
            a[i]=a[i+1];
        }
       
        rear=rear-1;
        return front;
    }

    //peek
    public int peek()
    {
        if(isEmpty())
        {
            System.out.println("Queue is empty");
            return -1;
        }

        return a[0];

    }

}


    public static void main(String[] args) {
        
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty())
        {
            System.out.println(q.peek());
            q.remove();
        }
    }

    */


    /* 
    //CIRCULAR QUEUE

    static class cqueue
    {
        static int a[];
        static int size;
        static int front;
        static int rear;

        public cqueue(int n)
        {
            a = new int [n];
            size=n;
            front=rear=-1;
        }

        public boolean isEmpty()
        {
            return rear==-1 && front==-1;
        }

        public boolean isFull()
        {
            return (rear+1)%size==front;
        }

        public void add(int data)
        {
            if(isFull())
            {
                System.out.println("Queue is full");
                return;
            }

            //1 st element
            if(front==-1)
            {
                front=0;
            }
           
           rear=(rear+1)%size;
           a[rear]=data;
        }

        public int remove()
        {
            if(isEmpty())
            {
                System.out.println("Queue is empty");
                return -1;
            }

            int curr=a[front];
            if(rear==front)
            {
                front = rear= -1;
            }
            else{
                front=(front+1)%size;
            }
                    
            return curr;
        }

        public int peek()
        {
            if(isEmpty())
            {
                System.out.println("Empty");
                return -1;
            }
            
            return a[front];
        }
    
    }

    public static void main(String[] args) {
        
        cqueue q = new cqueue(3);
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);

         
        while(!q.isEmpty())
        {
            System.out.println(q.peek() +" ");
            q.remove();
        }  

    }
    */


    /*
    //QUEUE USING LIKED LIST

    static class Node
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }

    static Node head=null;
    static Node tail=null;

    public boolean isEmpty()
    {
        return head==null && tail==null;
    }

    public void add(int data)
    {
        Node newNode = new Node(data);
        if(head==null)
        {
           head=tail=newNode;
           return;
        }
        tail.next=newNode;
        tail=newNode;
    }

    public int remove()
    {
        if(isEmpty())
        {
            System.out.println("Queue is empty");
            return -1;
        }
        int curr=head.data;
        if(tail==head)
        {
            tail=head=null;  
        }
        else
        {
        head=head.next;
        }
        return curr;
    }

    public int peek()
    {
       if(head==null)
       {
        System.out.println("Empty");
        return-1;
       }
       return head.data;
    }

    public static void main(String[] args) {
        
       Queue1 q = new Queue1();
       q.add(1);
       q.add(2);
       q.add(3);
       q.add(4);

       while(!q.isEmpty())
       {
        System.out.println(q.peek());
        q.remove();
       }
        
    }

    */

}
