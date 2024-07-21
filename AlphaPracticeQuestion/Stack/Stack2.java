import java.util.Stack;

public class Stack2 {

    public static int MaxArea(int h[])
    {
        int nsr[] = new int[h.length];
        int nsl[] = new int[h.length];
        java.util.Stack<Integer> s = new java.util.Stack<>();

        //Next Smaller Right
         for(int i=h.length-1;i>=0;i--)
         {
            while(!s.isEmpty() && h[s.peek()]>=h[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                nsr[i]=h.length;
            }
            else
            {
                nsr[i]=s.peek();
            }

            s.push(i);
         }

        
        //Next Smaller Left

        s = new Stack<>();
        for(int i=0;i<h.length;i++)
        {
            while(!s.isEmpty() && h[s.peek()] >= h[i])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                nsl[i]=-1;
            }
            else
            {
                nsl[i]=s.peek();
            }
            s.push(i);
        }


        //Find area=(height * (j-i-1))

        int maxArea=Integer.MIN_VALUE;
       
        for(int i=0;i<h.length;i++)
        {
            int height=h[i];
            int width = nsr[i] - nsl[i] -1 ;
            int area = height*width;
            maxArea=Math.max(area, maxArea);
        }

        return maxArea;
    }

    public static boolean isValid(String str)
    {
        java.util.Stack<Character> s = new java.util.Stack<>();
        
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            if(ch=='(' || ch=='{' || ch=='[')
            {
                s.push(ch);
            }
            else
            {
                //closing
                if(s.isEmpty())
                {
                    return false;
                }

                if((s.peek()=='[' && ch==']')
                || (s.peek()=='{' && ch=='}')
                || (s.peek()=='(' && ch==')'))
                {
                    s.pop();
                }
                else
                {
                    return false; 
                }
            }

        }

        if(s.isEmpty())
        {
            return true;
        }
        else{
            return false;
        }
    }

   public static void nextGreater(int a[])
    {
        java.util.Stack<Integer> s = new java.util.Stack<>();
        int nextG[]=new int[a.length];
        
        for(int i=a.length-1;i>=0;i--)
        {
            //1 while loop
            while(!s.isEmpty() && a[s.peek()]<=a[i])
            {
                 s.pop();
            }

            //2 if else 
            if(s.isEmpty())
            {
                nextG[i]=-1;
            }
            else
            {
                nextG[i]=a[s.peek()];
            }

            //3 push in stack

            s.push(i);
        }

        for(int i=0;i<nextG.length;i++)
        {
            System.out.print(nextG[i]+"  ");
        }
        System.out.println();

    }

    public static void stockSpan(int stock[],int span[])
    {
        java.util.Stack<Integer> s = new java.util.Stack<>();
        span[0]=1;
        s.push(0);

        for(int i=1;i<stock.length;i++)
        {
            int currPrice = stock[i];
            while(!s.isEmpty() && currPrice > stock[s.peek()])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                span[i]=i+1;
            }
            else
            {
                int prevHigh=s.peek();
                span[i]=i-prevHigh;
            }

            s.push(i);
        }
    }

    public static String reverseString(String str)
    {
        java.util.Stack<Character> s = new java.util.Stack<>(); 
        int idx=0;
        while(idx<str.length())
        {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty())
        {
            char curr = s.pop();
            sb.append(curr);
        }
        return sb.toString();
    }

    public static void pushBottom (java.util.Stack<Integer> s , int data)
    {
        if(s.isEmpty())
        {
            s.push(data);
            return;
        }
        int top=s.pop();
        pushBottom(s, data);
        s.push(top);

    }

    public void print(java.util.Stack<Integer> s)
    {
       while(!s.isEmpty())
       {
        System.out.print(s.peek()+" ");
        s.pop();
       }
       System.out.println();
    }

    public void reverseStack(java.util.Stack<Integer> s)
    {
        //base
        if(s.isEmpty())
        {
            return;
        }

        //Kaam
        int top=s.pop();
        reverseStack(s);
        pushBottom(s,top);  

    } 
    public static void main(String[] args) {
       //java.util.Stack <Integer> s = new java.util.Stack<>();
      // Stack2 j = new Stack2();
        /*       
        s.push(1);
        s.push(2);
        s.push(3);
        Stack2 j = new Stack2();
        j.pushBottom(s, 4);
       
        System.out.println(s.isEmpty());

        while(!s.isEmpty())
        {
            System.out.println(s.peek());
            s.pop();
        }
      System.out.println(s.isEmpty());
      */


      // String str =  "abcd";
      //System.out.println(reverseString(str));

  
      /* 
      s.push(1);
      s.push(2);
      s.push(3);
      s.push(4);
     // j.print(s);
      j.reverseStack(s);
      j.print(s);

      */

      /* 
      int stock[] = {100,80,60,70,60,85,100};
      int span[] = new int[stock.length];
      stockSpan(stock,span);

      for(int i=0;i<span.length;i++)
      {
        System.out.println(span[i]);
      }
      */

      //int arr[]={6,8,0,1,3};
      //nextGreater(arr);

        //  String str = "((())[{()}] )";
       // System.out.println(isValid(str));

         int height[] = {2,1,5,6,2,3};
         System.out.println("Maximun area is : "+MaxArea(height));


    }
}
