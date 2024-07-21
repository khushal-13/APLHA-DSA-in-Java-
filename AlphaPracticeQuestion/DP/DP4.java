import java.util.*;

public class DP4 {
    
    //O(n*m)
    public static int longestCommonSubstring(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n+1][m+1];
        //Base case
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j] = 0;
        }
        //Kaam
        int ans=0;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    ans = Math.max(ans,dp[i][j]); 
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
         return ans;
    }

    public static int lcs(int arr1[], int arr2[]){
        int n=arr1.length;
        int m=arr2.length;
        int dp[][] = new int[n+1][m+1];

        for(int i=0;i<n+1;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<m+1;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
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

    public static int longestIncreasingSubsequence(int arr[]){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }
        int arr2[] = new int[set.size()];
        int i=0;
        for (int num : set) {
            arr2[i] = num;
            i++;                        
        }
        Arrays.sort(arr2);
        return lcs(arr,arr2);
    }


    //O(n*m)
    public static int editDistance(String str1, String str2){
        int n=str1.length();
        int m=str2.length();
        int dp[][] = new int[n+1][m+1];

        //Base Case
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0){
                    dp[i][j] = j;
                }
                if(j==0){
                    dp[i][j] = i;
                }
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int add=dp[i][j-1]+1;
                    int del=dp[i-1][j]+1;
                    int rep=dp[i-1][j-1]+1;
                    dp[i][j] = Math.min(add, Math.min(del, rep));
                }
            }
        }
        return dp[n][m];
    }

    public static int stringOperations(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int op=lcs(str1,str2,n,m);
        int del = n-op;
        int add = m-op;
        System.out.println(add);
        System.out.println(del);
        return add+del;

    }

    private static int lcs(String str1, String str2,int n,int m) {
        int dp[][] = new int[n+1][m+1];

        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;                    
                }
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    int ans1=dp[i-1][j];
                    int ans2=dp[i][j-1];
                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

public static void main(String[] args) {
        
        //String str1 = "ABCDE";
        //String str2 = "ABGCE";
        //System.out.println(longestCommonSubstring(str1, str2));

        //int arr[] = {50,3,10,7,40,80};
        //System.out.println(longestIncreasingSubsequence(arr));

        // String str1="intention";
        // String str2="execution";
        // System.out.println(editDistance(str1, str2));

        String str1 = "abcdef",str2="aceg";
        System.out.println(stringOperations(str1, str2));
    }
}
