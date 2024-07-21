import java.util.*;

public class ArrList{

    static class Stack{
        ArrayList<Integer> list = new ArrayList<>();

        public boolean isEmpty(){
            return list.size()==0;
        }

        public void push(int data){
            list.add(data); //Add at end            
        }

        public int pop(){
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        public int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }

        public void print(){
            while (!isEmpty()) {
                System.out.print(peek()+ " -> ");
                pop();                
            }
            System.out.println();
        }
    }    

        public static void main(String[] args) {

        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.print();      

    }

}