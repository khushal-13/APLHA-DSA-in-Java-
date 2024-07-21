public class LinkedList {
    
    static class Node {
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Stack{

        static Node head;

        public boolean isEmpty(){
            return head == null;
        }

        public void push(int data){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        public int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public int peek(){
            return head.data;
        }

        public void print(){
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data +"->"); 
                temp = temp.next;               
            }
            System.out.print("null");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.print();
        System.out.println(s.pop());
        s.push(4);
        s.print();
    }
}
