import java.util.*;
public class DP1{

    public static int fiboRecursion(int n){  // O(2^n)
        if(n==0 || n==1){
            return n;
        }
        return fiboRecursion(n-1) + fiboRecursion(n-2);
    }

    public static int fiboTabulation(int n){  // O(n)
        int dp[] = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static int countWaysRecursion(int n){ //O(2^n)
        if(n==0) return 1;
        
        if(n<0) return 0;

        return countWaysRecursion(n-1)+countWaysRecursion(n-2);
    }


    public static int countWaysMemoization(int n, int ways[]){  // O(n)
        if(n==0) return 1;

        if(n<0) return 0;

        if(ways[n] != -1){
            return ways[n];
        }

        return countWaysMemoization(n-1, ways) + countWaysMemoization(n-2, ways);
        
    }

    public static int countWaysTabulation(int n){
        int dp[] = new int[n+1];
        dp[0]=1;

        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i] = dp[i-1];
            }
            else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args){

       //int n=6;
       //System.out.println(fiboTabulation(n));

       System.out.println(countWaysRecursion(5));


       int n=5;
       int ways[] = new int[n+1];
       Arrays.fill(ways,-1); //Initialization with -1
       System.out.println(countWaysMemoization(n, ways));


       System.out.println(countWaysTabulation(5));
 
    }
}