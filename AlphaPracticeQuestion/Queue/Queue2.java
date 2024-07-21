
public class Queue2 {

    public static void reverse(java.util.Queue<Integer> q)
    {
        java.util.Stack<Integer> s = new java.util.Stack<>();
        
        while(!q.isEmpty())
        {
            s.push(q.remove());
        }
        while(!s.isEmpty())
        {
            q.add(s.pop());
        }

    }

    public static void Interleave(java.util.Queue<Integer> q)
    {
        java.util.Queue<Integer> FirstHalf = new java.util.LinkedList<>();
        int sz = q.size();

        for(int i=0;i<sz/2;i++)
        {
            FirstHalf.add(q.remove());
        }
        while(!FirstHalf.isEmpty())
        {
            q.add(FirstHalf.remove());
            q.add(q.remove());
        }
    }

    public static void FirstNonRepaeatingLetter(String str)
    {
        int freq[]=new int[26];//a-z lettrs
        java.util.Queue<Character> q = new java.util.LinkedList<>();

        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while(!q.isEmpty() && freq[q.peek()-'a'] > 1)
            {
                q.remove();
            }
            if(q.isEmpty())
            {
                System.out.print(-1+" ");
            }
            else
            {
                System.out.print(q.peek()+" ");
            }
        }

    }

    static class Queueusing2Stacks{

        static java.util.Queue<Integer> q1 = new java.util.LinkedList<>();
        static java.util.Queue<Integer> q2 = new java.util.LinkedList<>();

      public boolean isEmpty()
      {
        return q1.isEmpty() && q2.isEmpty();
      }

      public void push(int data) 
      {
        if(!q1.isEmpty())
        {
            q1.add(data);
        }
        else
        {
            q2.add(data);
        }
      }

      public int pop()
      {
        if(isEmpty())
        {
            return -1;
        }

        int top=-1;
        //case 1 : Elements stored in q1
        if(!q1.isEmpty())
        {
           while(!q1.isEmpty())
           {
             top = q1.remove();
            if(q1.isEmpty())
            {
                break;
            }
            q2.add(top);
           }
        }
        else // case 2 : Elements stored in q2
        {
            while(!q2.isEmpty())
            {
                top = q2.remove();
                if(q2.isEmpty())
                {
                    break;
                }
                q1.add(top);
            }
        }
          return top;
      }

      public int peek()
      {
        if(isEmpty())
        {
            return -1;
        }

        int top=-1;
        //case 1 : Elements stored in q1
        if(!q1.isEmpty())
        {
           while(!q1.isEmpty())
           {
             top = q1.remove();
             q2.add(top);
           }
        }
        else // case 2 : Elements stored in q2
        {
            while(!q2.isEmpty())
            {
                top = q2.remove();
                q1.add(top);
            }
        }
          return top;
      }

      
    }

    static class Queue{

    static java.util.Stack<Integer> s1 = new java.util.Stack<>();
    static java.util.Stack<Integer> s2 = new java.util.Stack<>();

    public boolean isEmpty()
    {
        return s1.isEmpty();
    }

    public void add(int data)
    {
        while(!s1.isEmpty())
        {
            s2.push(s1.pop());
        }

         s1.push(data);

         while(!s2.isEmpty())
         {
           s1.push(s2.pop());
         }

    }

    public int remove()
    {
        if(s1.isEmpty())
        {
            System.out.println("Empty");
            return -1;
        }

        return s1.pop();
    }

    public int peek()
    {    
        if(s1.isEmpty())
        {
            System.out.println("P-Empty");
            return -1;
        }

        return s1.peek();
    }
    
    }


    public static boolean DuplicateParenthesis(String str)
    {

        java.util.Stack<Character> s = new java.util.Stack<>();

        for(int i=0;i<str.length();i++)
        {
            //closing
           char ch = str.charAt(i);
           if(ch==')')
           {
            int count=0;
            while( s.peek() != '(')
            {
                s.pop();//removing operators and operands
                count++;
            }
            if(count<1)//Duplicate
            {
                return true;
            }
            else
            {
                s.pop();//Removing Opening bracket
            }
           }
           else
           {
            //Opening
            s.push(ch);
           }
        }

        return false;
    }
    public static void main(String[] args) {
        
        /* 
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty())
        {
           System.out.println(q.peek());
           q.remove();
        }
            */

            /* 
            Queue q = new Queue();
            q.add(1);
            q.add(2);
            q.add(3);

            while(!q.isEmpty())
            {
                System.out.println(q.peek());
                q.remove();
            }
            */
      
      
      /* 
       String str = "((a+b))";
       String str2 = "(a+b)";
       System.out.println(DuplicateParenthesis(str));//true
       System.out.println(DuplicateParenthesis(str2));//false

       */

      // java.util.Stack<Integer> s = new java.util.Stack<>();

      /* 
       Queueusing2Stacks s = new Queueusing2Stacks();

       s.push(1);
       s.push(2);
       s.push(3);
       while(!s.isEmpty())
       {
        System.out.println(s.peek());
        s.pop();
       }
     */  

     // String str = "aabccxb";
     //FirstNonRepaeatingLetter(str);

     /*
       java.util.Queue<Integer> q = new java.util.LinkedList<>();
       q.add(1);
       q.add(2);
       q.add(3);
       q.add(4);
       q.add(5);
       q.add(6);
       q.add(7);
       q.add(8);
       q.add(9);
       q.add(10);
       Interleave(q);
       while(!q.isEmpty())
       {
        System.out.print(q.peek()+" ");
        q.remove();
       }
     */

     java.util.Queue<Integer> q = new java.util.LinkedList<>();
     q.add(1);
     q.add(2);
     q.add(3);
     q.add(4);
     q.add(5);
     q.add(6);
     q.add(7);
     q.add(8);
     q.add(9);
     q.add(10);

     reverse(q);
     while(!q.isEmpty())
     {
      System.out.print(q.peek()+" ");
      q.remove();
     }
      

    }
}
