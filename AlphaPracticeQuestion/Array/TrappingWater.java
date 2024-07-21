
public class TrappingWater {

     public static int T_Water(int height[]) {
        int n=height.length;

        //left max boundry
        int leftMax[]=new int[n];
        leftMax[0]=height[0];
        for(int i=1;i<n;i++)
        {
            leftMax[i]= Math.max(height[i] , leftMax[i-1]);
        }
        
        //right max boundry
        int rightMax[] = new int[n];
        rightMax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--)
        {
           rightMax[i]= Math.max(height[i] , rightMax[i+1]);
        }

        //loop
        int TrappedWater = 0;
        for(int i=0;i<n;i++)
        {
            int waterLevel= Math.min(leftMax[i],rightMax[i]);
            TrappedWater += waterLevel - height[i];
        }

        return TrappedWater;
    }  
        
    public static void main(String[] args) {
        
        int height [] =  {4,2,0,6,3,2,5};
        int volume = T_Water(height);
        System.out.println("Volume of trapped water is : " + volume);

    }
    
}
