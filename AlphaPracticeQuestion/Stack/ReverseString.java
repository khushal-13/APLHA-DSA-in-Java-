import java.util.Stack;

public class ReverseString {

    public static String reverseString(Stack<Character> s){
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());            
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {

        Stack<Character> s = new Stack<>();
        String str = "abcd";
        for(int i=0;i<str.length();i++){
            s.push(str.charAt(i));
        }

        System.out.println(reverseString(s));


        
    }
}
