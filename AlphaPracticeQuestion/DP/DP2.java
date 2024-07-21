public class DP2 {

    //O(2^n)
    public static int KnapsackRecursion(int val[], int wt[], int W, int n){
        //Base case
        if( W==0 || n==0){
            return 0;
        }

        //Kaam
        if(wt[n-1] <= W){ // Valid
            //include
            int ans1 = val[n-1]+KnapsackRecursion(val, wt, W-wt[n-1], n-1);

            //exclude
            int ans2 = KnapsackRecursion(val, wt, W, n-1);

            return Math.max(ans1, ans2);
        }
        else{  // Not Valid
            return KnapsackRecursion(val, wt, W, n-1);
        }
    }


    //O(nW)
    public static int KnapsackMemoization(int val[], int wt[], int W,int n,int dp[][]){

        if( W==0 || n==0){
            return 0;
        }

        if(dp[n][W] != -1){
            return dp[n][W];
        }

        if(wt[n-1] <= W){ //include
            
            int ans1=val[n-1] + KnapsackMemoization(val, wt, W-wt[n-1], n-1, dp);
            int ans2=KnapsackMemoization(val, wt, W, n-1, dp);

            dp[n][W] = Math.max(ans1, ans2);
            return dp[n][W];
        }
        else{ //exclude
            dp[n][W]=KnapsackMemoization(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }

    public static int KnapsackTabulation(int val[], int wt[], int W){
        int n=val.length;
        int dp[][] = new int[n+1][W+1];
        //initialize
        for(int i=0;i<dp.length;i++){  // 0th column
            dp[i][0]=0;
        }
        for(int j=0;j<dp[0].length;j++){  // 0th row
            dp[0][j]=0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int v=val[i-1]; //ith item value
                int w=wt[i-1];  //ith item weight
                if(w<=j){//Valid
                  int includeProfit = v+dp[i-1][j-w];
                  int excludeProfit = dp[i-1][j];
                  dp[i][j] = Math.max(includeProfit, excludeProfit);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];
    }
    

    public static boolean targetSum(int arr[], int sum){
        int n=arr.length, val;
        boolean dp[][] = new boolean[n+1][sum+1];
        //Base case 1
        for(int i=0;i<n+1;i++){
            dp[i][0] = true;
        }
        //Base case 2 : Automatically assign in java (False)
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                val =arr[i-1];
                if(val <= j && dp[i-1][j-val] == true){ //include
                    dp[i][j] = true;
                }
                else if( dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }
        
        printB(dp);
        return dp[n][sum];        

    }

    public static int UnbounedKnapsack(int val[], int wt[], int W){
        int n=val.length;
        int dp[][] = new int[n+1][W+1];
        //Base Case 1
        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }
        //Base Case 1
        for(int j=0;j<W+1;j++){
            dp[0][j] = 0;
        }

        //Kaam 
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                int w=wt[i-1];
                if(w<=j){ //Include
                    dp[i][j] = Math.max(val[i-1]+dp[i][j-w], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
            printI(dp);  
            return dp[n][W];        
    }

    public static void printI(int dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void printB(boolean dp[][]){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W=7;

        //System.out.println(KnapsackRecursion(val, wt, W, val.length));

        int dp[][] = new int[val.length+1][W+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j] = -1;
            }
        }

        //System.out.println(KnapsackMemoization(val, wt, W, val.length, dp));

        //System.out.println(KnapsackTabulation(val, wt, W));


        //int arr[] = {4,2,7,1,3};
        //int targetSum=10;
        //System.out.println(targetSum(arr,targetSum));


        System.out.println(UnbounedKnapsack(val, wt, W));


        
          
    }    
}
