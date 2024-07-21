public class Deque {
    static class Stack{

        static java.util.Deque<Integer> dq = new java.util.LinkedList<>();
         
        public void push(int data)
        {
            dq.addFirst(data);
        }

        public int pop()
        {
            return dq.removeFirst();
        }

        public int peek()
        {
            return dq.getFirst();
        }

    }

    static class Queue{

     static java.util.Deque<Integer> dq = new java.util.LinkedList<>();

     public void add(int data)
     {
        dq.addLast(data);
     }

     public int remove()
     {
        return dq.removeFirst();
     }

     public int peek()
     {
        return dq.getFirst();
     }
    }

    public static void main(String[] args) {
         
        Stack s = new Stack();

        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("Stack");
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());


        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println("Queue;");
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());



    }
}
