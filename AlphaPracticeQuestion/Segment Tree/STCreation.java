public class STCreation{

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
    public static void main(String[] args) {
        int arr[]={-2, 0, 3, -5, 2, -1};
        int n=arr.length;
        initialization(n);
        createST(arr, 0, 0, (n-1));

        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }

    }
}