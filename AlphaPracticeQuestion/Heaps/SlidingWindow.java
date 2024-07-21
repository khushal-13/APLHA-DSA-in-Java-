import java.util.PriorityQueue;

public class SlidingWindow {

    static class Pair implements Comparable<Pair>{
        int num,idx;
        public Pair(int n, int i){
            this.num = n;
            this.idx = i;
        }
        @Override
        public int compareTo(Pair p2){
            //Descending Order - MaxHeap
            return p2.num - this.num;
        }
    }
    
    public static void main(String args[]){
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k=3;

        int res[] = new int[arr.length-k+1]; //n-k+1
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(new Pair(arr[i], i));
        }
        res[0] = pq.peek().num; // Here j=0
        int j=1;// Res array index
        for(int i=k;i<arr.length;i++){
            
            while(pq.peek().idx <= i-k){
                pq.remove();
            }            
            pq.add(new Pair(arr[i], i));
            res[j] = pq.peek().num;
            //Instead of j we can use this 
            //res[i-k+1] = pq.peek().num; 
            j++;
        }
        for(int i=0;i<res.length;i++){
            System.out.print(res[i] +" ");
        }
    }
}
