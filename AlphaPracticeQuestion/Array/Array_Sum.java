import java.util.Scanner;

public class Array_Sum {
    static Scanner sc = new Scanner(System.in);

    public static void subarray(int a[]) {
        int tot=0;
        for(int i=0;i<a.length;i++)
        {
            int start=i;
            
            for(int j=i;j<a.length;j++)
            {
                int end=j;
                for(int k=start;k<=end;k++)
                {
                    System.out.print(a[k]+" ");
                }
                tot++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total pairs : " + tot);
    }

    public static void MaxSubArray(int a[]) {
       int currSum=0;
       int maxSum=Integer.MIN_VALUE;

       for(int i=0;i<a.length;i++)
       {
        int start=i;
        for(int j=i;j<a.length;j++)
        {
            int end=j;
            currSum=0;
            for(int k=start;k<=end;k++)
            {
                currSum += a[k];
            }
            System.out.println(currSum);
            if(currSum>maxSum)
            {
                maxSum=currSum;
            }
           
        }
       }
       System.out.println(("Max is : "+maxSum));
    }

    public static void  maxSubarray_prefix(int a[]) {
        int prefix[]=new int[a.length];
        int currSum=0;
        int maxSum = Integer.MIN_VALUE;
        prefix[0]=a[0];
        for(int i=1;i<a.length;i++)
        {
            prefix[i]=prefix[i-1]+a[i];
        }

        for(int i=0;i<a.length;i++)
        {
            int start=i;
            
            for(int j=i;j<a.length;j++)
            {
                int end=j;

               currSum=start ==0 ? prefix[end] : prefix[end]-prefix[start-1]  ;

               if(maxSum < currSum)
               {
                maxSum=currSum;
               }
            }
        }

        System.out.println("Max is : " + maxSum);

    }

    public static void Kadanes(int a[]) {
        
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;

        for(int i=0;i<a.length;i++)
        {
            currSum=currSum + a[i];
            if(currSum < 0)
            {
                currSum=0;
            }
            if(maxSum < currSum)
           {
            maxSum = currSum;
           }

        }
        
        
// if sum of all subarray  comes to zero then 
        if(maxSum==0)
        {
            int temp = a[0];
            for(int i=0;i<a.length;i++)
            {
                if(a[i] > temp)
                {
                    temp=a[i];
                }
            }
            maxSum=temp;
        }

        System.out.println(" Max is " + maxSum);
    }

   

 public static void main(String[] args) {
    int a[]={-2,-3,4,-1,-2,1,5,-3};
    //subarray(a);
     //MaxSubArray(a);
    // maxSubarray_prefix(a);
    Kadanes(a);
    //maxSubarray_prefix(a);

 }   
}
