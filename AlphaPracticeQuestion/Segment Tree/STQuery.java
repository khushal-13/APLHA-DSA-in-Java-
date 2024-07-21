public class STQuery {

    static int tree[],mid;

    public static void initialization(int n){
        tree = new int [4*n];        
    }

    public static int createST(int arr[], int i, int start, int end)
    {
        if(start==end){
            tree[i] = arr[start];
            return arr[start]; 
        }
       
        int mid = (start+end)/2;
        createST(arr, 2*i+1, start, mid);
        createST(arr, 2*i+2, mid+1, end);
        tree[i] = tree[2*i+1]+tree[2*i+2];
        return tree[i];
    }
    
    public static int getSumUtility(int i, int si,int sj, int qi, int qj){
        if(qj<=si || qi>=sj){ // Not Overlap
            return 0;
        }
        else if(qi<=si && qj>=sj){ //Complete Overlap
            return tree[i];
        }
        else{  // Partial Overlap
            int mid=(si+sj)/2;
            int left = getSumUtility(2*i+1, si, mid, qi, qj);
            int right = getSumUtility(2*i+2, mid+1, sj, qi, qj);
            return left+right;
        }
    }
    
    public static int getSum(int arr[],int qi,int qj){
        int n=arr.length;
        return getSumUtility(0,0,n-1,qi,qj);
    }
    public static void main(String[] args) {
        int arr[]={-2, 0, 3, -5, 2, -1};
        int n=arr.length;
        initialization(n);
        createST(arr, 0, 0, (n-1));

        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }

        System.out.println();
        int qi=0,qj=2;
        System.out.println(getSum(arr,qi,qj));
    }
}
