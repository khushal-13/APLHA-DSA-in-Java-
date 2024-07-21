//import java.util.*;



public class Sorting {

    public static void CountingSortApna(int a[],int n)
    {
      int largest = Integer.MIN_VALUE;
      for(int i=0;i<n;i++)
      {
        largest = Math.max(largest , a[i]);
      }

      int count [] = new int[largest+1];
      for(int i=0; i<n;i++)
      {
        count[a[i]]++;
      }

      int j=0;
      for(int i=largest;i>=0;i--)
      {
        while(count[i] > 0)
        {
            a[j] = i;
            j++;
            count[i]--;
        }
      }
    }

    public static void CountingSort(int a[], int n)
    {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(a[i] > max)
            {
                max = a[i];
            }
        }
       int k=max;
       int b[] = new int[n];
       int count[] = new int[k+1];

       for(int i=0;i<n;i++)
       {
        ++count[a[i]];
       }

       for(int i=1;i<=k;i++)
       {
          count[i] = count[i] + count[i-1];
       }

       for(int i=n-1;i>=0;i--)
       {
        b[--count[a[i]]] = a[i];
       }
        
       for(int i=0;i<n;i++)
       {
        a[i] = b[i];
       }

    }

   public static void InsertionSort(int a[],int n)
    {
      for(int i=1;i<n;i++)
      {
        int temp= a[i];
        int j=i-1;

        while(j>=0 && a[j] < temp)
        {
            a[j+1] = a[j];
            j--;
        }

        a[j+1] = temp;

      }

    }

   
public static void  SelectionSort(int a[],int n)
{
  for(int i=0;i<n-1;i++)
  {
    int max = i;
    for(int j=i;j<n;j++)
    {
        if(a[j] > a[max])
        {
           max = j;
        }
    }

    if(max != i)
    {
        int temp = a[max];
        a[max] = a[i];
        a[i] = temp;
    }
  }

}


 public static void BubbleSort(int a[],int n) {
        
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(a[j] < a[j+1])
                {
                    int t = a[j];
                    a[j] = a[j+1];
                    a[j+1] = t ;
                }
            }
        }

    }



    
    public static void main(String[] args) {
        int a[]={3,6,2,1,8,7,4,5,3,1};
        int n=a.length;      
       
        //BubbleSort(a,n); 

        // SelectionSort(a,n);

        //InsertionSort(a,n);

        CountingSortApna(a,n);

        //Inbulit function in java that sorts array
       // Arrays.sort(arr);

        
        // Reverse an array 
       // Arrays.sort(arr,0,6,Collections.reverseOrder());
     

       for(int i=0;i<n;i++)
           {
            System.out.print(a[i] +" ");
           }
    }
}





