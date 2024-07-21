public class BitManipulation {

    public static int fastExponent(int a, int n){
        // int ans=1;
        // while(n>0){
        //     if((n&1)!=0){
        //       ans = ans*a; 
        //     }
        //     a = a*a;
        //     n=n>>1;
        // }
        // return ans;

        int ans=1;
        while(n>0){
            if((n&1)!=0){
                ans = ans*a;
                a = a*a;
                n = n>>1;
            }
            else{
                ans = ans*1;
                a = a*a;
                n = n>>1;
            }
        }
        return ans;
    }

    public static int setBits(int n){
        // int count=0;
        // while(n>0){
        //     if((n&1)!=0){
        //         count++;
        //     }
        //     n=n>>1;
        // }
        // return count;

        int count=0;
        while(n>0){
            if((n&1)!=0) count++;
            n=n>>1;
        }
        return count;
    }

    public static boolean numberispowerof2(int n){
        return (n&(n-1))==0;
    }

    public static int UpdateI(int n,int i, int value)
    {
        if(value == 0)
        {
            return clearI(n,i);
        }
        else if(value == 1)
        {
            return setI(n,i);
        }

        return -1;
    }

    public static int clearRange(int n, int i, int j){
        int a = -1<<(j+1);
        int b = (1<<i)-1;
        int bitmask = a|b;
        
        return n&bitmask;
    }

    public static int clearLastI(int n, int i)
    {
        int bitmask = -1<<i;
        return n & bitmask;
    }

    public static int clearI(int n, int i)
    {
        int bitmask = ~(1<<i);
        return n & bitmask;

    }

    public static int setI(int n , int i)
    {
        //Left shift makes 1 at i'th position 
        int bitmask = 1<<i;
        // Using OR we change the value
        return (n | bitmask); 
    }

    public static int getI(int n, int i)
    {
        // Left shift makes 1 at i'th position 
        int bitmask = 1<<i;
        // if ZERO then answer is 0
        if((n & bitmask) == 0) return 0;
        // Otherwise it will be greater than 0 (not neccessarily 1)
        else return 1;
    }

    public static void oddEven(int n)
    {
        int bitmask = 1;
        if( (bitmask & 1) == 0)
        {
            //even
         System.out.println("Even");
         }
         else 
         {
            System.err.println("Odd");
         }
    }
    public static void main(String[] args) {
      
      //  System.out.println(5 ^ 6);

       // oddEven(3);
        
      // System.out.println(getI(10,1));  
    
      //System.out.println(setI(10,2));

      //System.out.println(clearI(8,3));

      //System.out.println(UpdateI(10,1,0));

      //System.out.println(clearLastI(15,2));

      //System.out.println(clearRange(10, 2, 4));

      //System.out.println(numberispowerof2(9));
    
      //System.out.println(setBits(16));

      //System.out.println(fastExponent(5, 5));

      System.out.println(32^32);

    }

}
