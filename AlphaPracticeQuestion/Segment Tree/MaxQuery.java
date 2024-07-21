public class MaxQuery {

    static int tree[],mid;

    public static void initialization(int n){
        tree = new int [4*n];        
    }
/* Same Function but RETURN TYPE VOID
    public static void MTcreat(int arr[], int i, int si, int sj)
    {
        if(si==sj){
            tree[i] = arr[si];
            return; 
        }
       
        int mid = (si+sj)/2;
        MTcreat(arr, 2*i+1, si, mid);
        MTcreat(arr, 2*i+2, mid+1, sj);
        tree[i]=Math.max(tree[2*i+1],tree[2*i+2]);
    }
   */

    public static int MTcreat(int arr[], int i, int si, int sj)
    {
        if(si==sj){
            tree[i] = arr[si];
            return tree[i]; 
        }
       
        int mid = (si+sj)/2;
        int left=MTcreat(arr, 2*i+1, si, mid);
        int right=MTcreat(arr, 2*i+2, mid+1, sj);
        tree[i]=Math.max(left,right);
        return tree[i];
    }

    public static int maxTreeUtil(int i,int si, int sj, int qi ,int qj){
        if(si>qj || qi>sj){
            return Integer.MIN_VALUE;
        }
        else if( si >= qi && sj <= qj){
            return tree[i];
        }
        else{
            int mid=(si+sj)/2;
            int left=maxTreeUtil(2*i+1,si,mid,qi,qj);
            int right=maxTreeUtil(2*i+2,mid+1,sj,qi,qj);
            tree[i] = Math.max(left, right);
            return tree[i];
        }
    }

    public static int maxTree(int arr[],int qi, int qj){
        int n=arr.length;
        return maxTreeUtil(0,0,n-1, qi, qj);
    }


    public static void updateMTUtil(int i, int si, int sj, int idx, int newVal){
        if(si>idx || sj<idx){
            return;
        }
        if(si==sj){
            tree[i]=newVal;
        }
        if(si!=sj){ // NOT LEAF CONDITION
            tree[i] = Math.max(tree[i], newVal);
            int mid=(si+sj)/2;
            updateMTUtil(2*i+1,0,mid,idx,newVal);
            updateMTUtil(2*i+2,mid+1,sj,idx,newVal);
        }
    }

    public static void updateMT(int arr[], int idx, int newVal){
        arr[idx]=newVal;
        int n=arr.length;
        updateMTUtil(0,0,n-1, idx, newVal);
    }
    public static void main(String[] args) {

        int arr[]={6,8,-1,2,17,1,3,2,4};
        initialization(arr.length);
        MTcreat(arr, 0, 0, arr.length-1);
              
        System.out.println(maxTree(arr, 2, 5));   

        //UPDATE
        int newVal=20;
        int idx=2;
        updateMT(arr,idx,newVal);
        
        System.out.println(maxTree(arr, 2,5));
    }
}
