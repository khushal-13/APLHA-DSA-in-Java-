public class DivideNconquer {

  public static void swap(int a[], int i, int j){
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static int partition2(int a[], int si, int ei){
    int pivot=a[ei];
    int i=si-1;

    for(int j=si;j<ei;j++){ 
      if(a[j]<=pivot){
        i++;
        swap(a,i,j);
      }
    }
    i++;
    swap(a, i, ei);
    return i;
  }

  public static void Quicksort(int a[], int si, int ei){
    if(si>=ei){
      return;
    }
    int pidx = partition2(a, si, ei);
    Quicksort(a, si, pidx-1);
    Quicksort(a, pidx+1, ei);
  }

  public static int partition(int a[], int si, int ei)
  {
    int pivot = a[ei];
    int i=si-1;

    for(int j=si;j<ei;j++)
    {
      if(a[j] < pivot)
      {
        i++;
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
      }

    }
   
    i++;
    int temp = pivot;
        a[ei] = a[i];
        a[i] = temp;

return i;

  }

  public static void quicksort(int a[], int si, int ei)
  {
    if(si>=ei)
    {
      return;
    }

    int pivotIndex = partition(a,si,ei);
    quicksort(a, si,pivotIndex-1);
    quicksort(a, pivotIndex+1, ei);

  }

    public static void merge(int a[], int si, int mid, int ei)
    {
      int i,j,k;
      int t[] = new int[ei-si+1];
      i=si;
      k=0;
      j=mid+1;
    
      while(i<=mid && j<=ei)
      {
 
        if(a[i] <= a[j])
        {
           t[k] = a[i];
           i++; 
        }
        else
        {
            t[k] = a[j];
            j++;
        }

        k++;

      }

      //Left_More_Elements
      while(i<=mid)
      {
        t[k++]=a[i++];
       
      }

      //Right_More_Elements
      while(j<=ei)
      {
        t[k++]=a[j++];
        
      }

      //Copy To Original
      for(k=0,i=si;k<t.length;i++,k++)
      {
          a[i]=t[k];
      }
     
    }

    public static void mergesort(int a[], int si, int ei)
    {
        if(si>=ei)
        {
            return;
        }
        int mid = si + (ei-si)/2;
        
           mergesort(a, si,mid);
           mergesort(a,mid+1,ei);
           
           merge(a,si,mid,ei);
        
    }
    
    public static void main(String[] args) {
        int a[] = {6,10,2 ,8,8,2,5};
        int si=0,ei=a.length-1;
       // mergesort(a,si,ei);

       
       Quicksort(a,si,ei);

       for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i]+" ");
        }
    } 
}

