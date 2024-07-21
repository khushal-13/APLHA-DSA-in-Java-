public class Stocks {

    public static int profit(int prices[])
    {
        int n = prices.length;
        int maxProfit = 0;
        int bp = Integer.MAX_VALUE;

        for(int i=0;i<n;i++)
        {
           if(bp < prices[i])
           {
            int profit = prices[i] - bp ;
            maxProfit = Math.max(maxProfit,profit);
            
           }else
           {
            bp=prices[i];
           }
        }

        return maxProfit;

    }
    public static void main(String[] args) {
        
        int prices[] = { 7,1,5,3,6,4};
       int profit =  profit(prices);
       System.out.println("Maximun profit is : " + profit);

    }
    
}
