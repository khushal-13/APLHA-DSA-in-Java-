public class DP3 {

    public static int coinChange(int coins[],int sum){
        int n=coins.length;
        //Creation
        int dp[][] = new int[n+1][sum+1];
     
        //Initialization

        //sum (column) = 0
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
            //kuch manga nhi kuch mila nhi (1 way)
        }
        //coins(row) = 0 
        for(int j=0;j<dp[0].length;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(coins[i-1] <= j){//Valid
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];                    
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

    // O(n^2)
    public static int RodCutting(int length[], int prices[], int totRod){
        int n = prices.length;
        int dp[][] = new int[n+1][totRod+1];
        
        //Base Case
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int l = length[i-1];
                if(l<=j){
                    dp[i][j] = Math.max(prices[i-1]+dp[i][j-l], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][totRod];
    }

    //O(2^n)
    public static int LCSRecursion(String str1, String str2, int n, int m){
        //Base Case
        if(n==0 || m==0){
            return 0;
        }

        //Kaam
        if(str1.charAt(n-1)==str2.charAt(m-1)){  // Same
            return LCSRecursion(str1, str2, n-1, m-1) + 1;
        }
        else{  //Diff
            int ans1=LCSRecursion(str1, str2, n-1, m);
            int ans2=LCSRecursion(str1, str2, n, m-1);
            return Math.max(ans1, ans2);
        }
    }

    //O(n*m)
    public static int LCSMemoization(int dp[][],String str1, String str2, int n, int m){
        //Base
        if(n==0 || m==0){
            return 0;
        }
        //CHECK - if value already exists
        if(dp[n][m] != -1){
            return dp[n][m];
        }

        //Kaam
        if(str1.charAt(n-1) == str2.charAt(m-1)){
            dp[n][m] = LCSMemoization(dp, str1, str2, n-1, m-1)+1;
            return dp[n][m];
        }
        else{
            int ans1 = LCSMemoization(dp, str1, str2, n-1, m);
            int ans2 = LCSMemoization(dp, str1, str2, n, m-1);
            dp[n][m] = Math.max(ans1, ans2);
            return dp[n][m];
        }
    }

    //O(n*m)
    public static int LCSTabulation(String str1, String str2,int n, int m){
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    int ans1 = dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {

        // int length[] = {1,2,3,4,5,6,7,8};
        // int prices[] = {1,5,8,9,10,17,17,20};
        // int totRod = 8;
        //System.out.println(RodCutting(length, prices, totRod)); 
        
        String str1 = "abcdge";
        String str2 = "abedg";
        //System.out.println(LCSRecursion(str1, str2, str1.length(), str2.length()));

       
        //str1 = "ABCD";
        //str2 = "ACEB";
        int n=str1.length(),m=str2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }
        //System.out.println(LCSMemoization(dp, str1, str2, n,m));

        //System.out.println(LCSTabulation(str1, str2, str1.length(), str2.length()));

        int coins[] = {2,5,3,6};
        int sum=10;
        System.out.println(coinChange(coins, sum));

    }
    
}
