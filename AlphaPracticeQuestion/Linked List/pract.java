public class pract {
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

    public static void print( Node head){
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
        curr = next = head;
        prev = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev; 
    }   


    public  Node partition(Node head,int x){
        boolean flag = false;
        Node temp,retHead=null;
        Node tempHead = new Node(0);
        temp=head;
        while(temp!=null){
            if(temp.data<x){
                tempHead.next = temp;
                tempHead = temp;
            }
            if(!flag){
                //System.out.println(tempHead.data);
                retHead = tempHead;
                flag = true;
            }
            temp = temp.next;
        }

        System.out.println(tempHead.data);
        // print();
        

        temp = head;
        while(temp != null){
            if(temp.data>=x){
                tempHead.next = temp;
                tempHead = temp;
            }
            temp = temp.next;
        }
        System.out.println("Loop FINISHED ");

        return retHead;
    }

    public static Node addNumbers(Node l1, Node l2){

        Node dummy = new Node(0);
        Node curr = dummy;
        int carry = 0;

        while(l1!=null || l2!=null || carry!=0){

            int digit1 = l1!=null ? l1.data : 0;
            int digit2 = l2!=null ? l2.data : 0;

            int sum = digit1+digit2+carry;
            int digit = sum%10;
            carry = sum/10;

            Node newNode = new Node(digit);
            curr.next = newNode;
            curr = newNode;

            l1 = l1!=null ? l1.next : null;
            l2 = l2!=null ? l2.next : null;
           
        }
        Node res = dummy.next;
        dummy.next = null;
        return res;
    }

    public static Node rotate(Node head,int k){
        Node temp = head; int size=0,i=1;
        while(temp.next!=null){
            size++;
            temp = temp.next;            
        }
        size++;
        temp.next = head;
        k = k%size;
        temp = head;
        while(i<size-k){
            temp = temp.next;   
            i++;                     
        }
        Node ans = temp.next;
        temp.next = null; 
        return ans;
    }


    public static void main(String[] args) {

        // pract l1 = new pract();
        // l1.addLast(1);
        // l1.addLast(4);
        // l1.addLast(3);
        // l1.print();

        Node l1 = new Node(0);
        l1.next = new Node(1);
        l1.next.next = new Node(2);
        //l1.next.next.next = new Node(4);
        //l1.next.next.next.next = new Node(5);
        // l1.next.next.next.next.next = new Node(9);
        // l1.next.next.next.next.next.next = new Node(9);
        print(l1);

        Node ans = rotate(l1,4);
        print(ans);

        // Node l2 = new Node(9);
        // l2.next = new Node(9);
        // l2.next.next = new Node(9);
        // l2.next.next.next = new Node(9);
        // print(l2);

        // Node head = addNumbers(l1,l2);
        // print(head);



        


        pract l2 = new pract();
        l2.addLast(5);
        l2.addLast(4);
        l2.addLast(2);
        


        //head = ll.partition(head, 3);

        



        
    }
}