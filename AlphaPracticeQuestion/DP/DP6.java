import java.util.Arrays;

public class DP6 {

    public static int mcmRecursion(int arr[], int i, int j){

        if(i == j){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int cost1 = mcmRecursion(arr, i, k);
            int cost2 = mcmRecursion(arr, k+1, j);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            int finalCost = cost1+cost2+cost3;
            ans = Math.min(ans, finalCost);
        }
        return ans;
    }

     public static int mcmMemoization(int arr[], int i, int j, int dp[][]){

        if(i == j){
            return 0;
        }
        //Check
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int cost1 = mcmRecursion(arr, i, k);
            int cost2 = mcmRecursion(arr, k+1, j);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            int finalCost = cost1+cost2+cost3;
            ans = Math.min(ans, finalCost);
        }
        return dp[i][j] = ans;
    }

    public static int mcmTabulation(int arr[]){
        int n = arr.length;
        int dp[][] = new int[n][n];

        //Intialize
        for(int i=0;i<n;i++){
            dp[i][i] = 0;
        }

        for(int len=2;len<=n-1;len++){
            for(int i=1;i<=n-len;i++){
                int j=i+len-1; //col
                dp[i][j] = Integer.MAX_VALUE;
            for(int k=i;k<=j-1;k++){
                int cost1=dp[i][k];
                int cost2=dp[k+1][j];
                int cost3=arr[i-1]*arr[k]*arr[j];
                dp[i][j] = Math.min(dp[i][j], cost1+cost2+cost3);
            }    
            }
        }
        return dp[1][n-1];
    }

    public static int minPartitioning(int arr[]){
        int n = arr.length; int sum=0;
        //Step-1
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        int W=sum/2;

        //Step-2
        int dp[][] = new int[n+1][W+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int w=arr[i-1];
                if(w<=j){//Valid
                    dp[i][j] = Math.max(arr[i-1]+dp[i-1][j-w], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int Sum1 = dp[n][W];
        int sum2 = sum - Sum1;
        return Math.abs(sum2-Sum1);
    }

    public static int minJumps(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        dp[n-1] = 0;

        for(int i=n-2;i>=0;i--){
            int ans=Integer.MAX_VALUE;
            int steps=arr[i];
            for(int j=i+1;j<=i+steps && j<n;j++){
                if(dp[j] != -1){
                    ans = Math.min(ans, dp[j]+1);
                }
            }
            if(ans != Integer.MAX_VALUE){
                dp[i] = ans;
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {
        
        // int arr[] = {1,2,3,4,3};
        // int n = arr.length;
        // System.out.println(mcmRecursion(arr, 1, n-1));


        // int dp[][] = new int[n][n];
        // Arrays.fill(dp[0],-1);
        // System.out.println(mcmMemoization(arr, 1, n-1, dp));

        //System.out.println(mcmTabulation(arr));


        //int nums[] = {1,6,11,5};
        //System.out.println(minPartitioning(nums));


        int nums[] = {2,3,1,1,4};
        System.out.println(minJumps(nums));
    }
}
