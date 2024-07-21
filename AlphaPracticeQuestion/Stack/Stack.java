import java.util.*;



public class Stack {

    public static  class Node 
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }

    static class stack{
        static Node head=null;
        static int size=0;

        //IsEmpty
        public static boolean isEmpty()
        {
           return head==null;
        }

        //Push
        public void push(int data)
        {
            Node newNode = new Node(data);
            size++;  
            if(isEmpty())
            {
                head=newNode;
                return;
            }
           
            newNode.next=head;
            head=newNode;
        }

        //Pop
        public int pop()
        {
            if(isEmpty())
            {
                return -1;
            }
            int top = head.data;
            head=head.next;
            return top;
        }

        //peek
        public int peek()
        {
            if(isEmpty())
            {
                return -1;
            }
           return head.data;

        }
    }
    
    static ArrayList <Integer> list = new ArrayList<>();
 
    public static boolean isEmpty()
    {
        return list.size()==0;
    }


    //Push
    public void push(int data)
    {
        list.add(data);
    }

    //Pop
    public int pop()
    {
        if(isEmpty())
        {
            return-1;
        }
        int top = list.get(list.size()-1);
        list.remove(list.size()-1);
        return top;
    }

    //Peek
    public int peek()
    {
       if(isEmpty())
       {
        return -1;
       }
        return list.get(list.size()-1);
    }


    
    public static void main(String[] args) {
        
        /* 
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        while(!isEmpty())
        {
            System.out.println(s.peek());
            s.pop();
        }
        */
        java.util.Stack<Integer> s = new java.util.Stack<> ();
       // stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
       
        while(!isEmpty())
        {
            System.out.print(s.peek()+" ");
            s.pop();
        }
             
        

    }

}
