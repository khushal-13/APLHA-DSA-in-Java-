//import java.util.*;

public class DP5 {
    //O(n*m) 
    public static boolean wildcardMatching(String s, String p){
        int n=s.length();
        int m=p.length();
        boolean dp[][] = new boolean[n+1][m+1];
        
        //initialize
        dp[0][0] = true; //both s & p are empty

        for(int i=1;i<n+1;i++){ //p empty
            dp[i][0] = false;
        }
        for(int j=1;j<m+1;j++){  //s empty
            if(p.charAt(j-1)=='*'){  //checking if we can use * and make p also empty
                dp[0][j] = dp[0][j-1];
            }else{            // we found element other than *. So p cannot match empty s
                dp[0][j] = false;
            }
        }

        //Bottom Up
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                // First : same character OR
                // Second :  p has ? at jth position which can be interchanged
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    dp[i][j] = dp[i-1][j-1];
                }
                // Special Case
                // First : we aassume * as empty
                // Second : we keep * as it is. So that we can use it further for pattern match
                else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
                // Different character case
                else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    public static int catalanRecursion(int n){
        if(n==0 || n==1){ return 1;}

        int ans=0;
        for(int i=0;i<=n-1;i++){
            ans += catalanRecursion(i)*catalanRecursion(n-i-1);
        }
        return ans;
    }

    public static int catalanMemoization(int n, int dp[]){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int ans=0;
        for(int i=0;i<=n-1;i++){
           ans += catalanMemoization(i, dp)*catalanMemoization(n-i-1, dp);  
        }
        return ans;
    }

    public static int catalanTabulation(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){ // Ci
            for(int j=0;j<i;j++){
                dp[i] += dp[j] * dp[i-j-1]; // Ci += Cj * Ci-j-1
            }
        }
        return dp[n];        
    }

    public static int countBST(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                int left = dp[j];
                int right = dp[i-j-1];
                dp[i] += left*right;
            }
        }
        return dp[n];
    }

     public static int mountainRanges(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<n+1;i++){
            for(int j=0;j<i;j++){
                int inside = dp[j];
                int outside = dp[i-j-1];
                dp[i] += inside*outside;
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {

        // String s = "baaabab";
        // String p = "*****ba******ab";
        // s="abc"; p="**d";
        // System.out.println(wildcardMatching(s, p));


        //System.out.println(catalanRecursion(10));


        // int n=4;
        // int dp[] = new int[n+1];
        // Arrays.fill(dp,-1);
        // System.out.println(catalanMemoization(n, dp));


        //System.out.println(catalanTabulation(15));


        //System.out.println(countBST(5));


        System.out.println(mountainRanges(5));

        
    }
}
