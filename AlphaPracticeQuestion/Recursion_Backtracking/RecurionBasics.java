public class RecurionBasics {

    public static int FriendsPairing(int n)
    {
        if(n==1 || n==2)
        {
            return n;
        }

        int fnm1 = FriendsPairing(n-1);
        int fnm2 = FriendsPairing(n-1);
        int pairs = (n-1)*fnm2;

        return fnm1 + pairs;

    }

    public static void RemoveDuplicate(String str, int index, StringBuilder newStr, boolean map[])
    {
        if(index == str.length())
        {   //completed
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(index);
        if(map[currChar-'a']==true)
        {   //duplicate
            RemoveDuplicate(str, index+1, newStr, map);
        }
        else{
            map[currChar - 'a'] = true;
          RemoveDuplicate(str, index+1, newStr.append(currChar), map);
        }
    }

    public static int tilling(int n)
    {
        if(n==1 || n==0)
        {
            return 1;
        }

        int fnm1 = tilling(n-1);

        int fnm2 = tilling(n-2);

        return fnm1 + fnm2 ;
    }  

    public static int optimizedPower(int n , int pow)
    {
        if(pow==0)
        {
            return 1;
        }

        int half = power(n, pow/2);
        int value = half*half;

        //ODD
        if(pow % 2 != 0)
        {
            value = n*value;
        }

        return value;
    }

    public static int power(int n,int pow)
    {
        if(pow==0)
        {
            return 1;
        }

        int value = n*power(n,pow-1);
        return value;
    }

    public static int LastOccurrence(int a[], int i, int key)
    {
        if(i==a.length)
        {
            return -1;
        }

        int isFound = LastOccurrence(a, i+1, key);
        if(isFound == -1 && a[i] == key)
        {
            return i+1;
        }

        return isFound;

    }

    public static int FirstOccurrence(int a[], int i,int key)
    {
       
        if(i==a.length)
        {
            return-1;
        }
      if(a[i]==key)
      {
        return i+1;
      }

     return FirstOccurrence(a, i+1, key);

    }

    public static boolean IsSorted(int a[], int i)
    {
       if(i==a.length-1)
       {
        return true;
       }

       if(a[i] > a[i+1])
       {
         return false;
       }

       return IsSorted(a, i+1);
    }

    public static int fibonacci(int n)
    {
        if( n == 0 || n == 1)
        {
            return n;
        }
        int fib = fibonacci(n-1) + fibonacci(n-2);
        return fib;
    }

    public static void printDec(int n)
    {
        if(n==1)
        {
            System.out.println(n);
            return ;
        }
        System.out.print(n+" ");
        printDec(n-1);
    }

    public static void printInc(int n)
    {
        if(n==1)
        {
            System.out.print(n+" ");
            return ;
        }

        printInc(n-1);
        System.out.print(n + " ");
    }

    public static int Factorial(int n)
    {
        if(n==0)
        {
            return 1;
        }
       int fact = n*Factorial(n-1);
       
       return fact;
    }

    public static int SumNatural(int n)
    {
        int sum=0;
        if(n==1)
        {
            return 1;
        }
         sum = n + SumNatural(n-1);
         return sum;
    }
 public static void main(String[] args) {
   // int n=1;
    //System.out.println(Factorial(n));

   //System.out.println(SumNatural(n));

   //System.out.println(fibonacci(n));

   //int a[] = {1,3,5,2,5,8,3,89,0};
  // System.out.println( IsSorted(a, 0));
  
//System.out.println(FirstOccurrence(a,0,3));
    
//int b[] = {5,5,5,5,5};
//System.out.println(LastOccurrence(b, 0, 5));

//System.out.println(power(2,10));

 //System.out.println(optimizedPower(2,5));

 //System.out.println(tilling(4));

 //String str = "appnnnacollege";
//RemoveDuplicate(str, 0,new StringBuilder ("") , new boolean[26]);


System.out.println(FriendsPairing(3));


 }   
}
