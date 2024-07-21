public class MaxST{

    static int tree[];

    public static void initialization(int n){
        tree = new int[4*n];
    }

    public static void BuildMaxST(int i, int si, int sj,int arr[]){
        if(si==sj){
            tree[i] = arr[si];
            return;
        }
        int mid = (si+sj)/2;
        BuildMaxST(2*i+1, si, mid, arr);
        BuildMaxST(2*i+2, mid+1, sj, arr);

        tree[i] = Math.max(tree[2*i+1], tree[2*i+2]);      

    }
    public static void main(String[] args) {
        int arr[] = {6,8,-1,2,17,1,3,2,4};
        int n=arr.length;
        initialization(n);
        BuildMaxST(0, 0, n-1, arr);

        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+" ");
        }

    }
}