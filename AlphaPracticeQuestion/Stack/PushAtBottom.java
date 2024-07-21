import java.util.Stack;

public class PushAtBottom {
    
    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.add(data); // add the DATA at bottom
            return;
        }

        int top = s.pop(); // Store current element
        pushAtBottom(s,data); //Call for next 
        s.add(top); // add the current element in same order

    }

    public static void print(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        //print(s);
        pushAtBottom(s, 4);
        print(s);
    }
}
