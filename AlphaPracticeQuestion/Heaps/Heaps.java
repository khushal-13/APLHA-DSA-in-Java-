import java.util.*;

public class Heaps {

    static class student implements Comparable<student>{
       String name ;
       int rank;
       
       public student(String name, int rank)
       {
        this.name = name;
        this.rank = rank;
       }

    @Override
    public int compareTo(student s) {
        return this.rank-s.rank;
    }

    }

    ArrayList<Integer> arr = new ArrayList<>();

    public void add(int data)  //O(logn)
    {
        
        //Add element at last
        arr.add(data);

        //Find parent
        int x = arr.size()-1; // x is child index
        int par = (x-1)/2;  // parent index

        //Fix parent
        while(arr.get(x) < arr.get(par)) //O(logn)
        {
           int temp = arr.get(x);
           arr.set(x,arr.get(par));
           arr.set(par, temp);
           x=par;
           par=(x-1)/2;          
        }
    }

    public int peek()
    {
        return arr.get(0);
    }

    private void heapify(int i)
    {
        
        int left = 2*i+1;
        int right = 2*i+2;
        int min = i;

        if(left<arr.size() && arr.get(min) > arr.get(left)){
               min = left;
        }
        if(right<arr.size() && arr.get(min) > arr.get(right)){
            min = right;
        }

        if(min!=i){
            //swap
            int temp = arr.get(i);
            arr.set(i,arr.get(min));
            arr.set(min,temp);

            heapify(min); 
        }
         
    }

    public int remove()
    {
       //Store 1st Element
       int data = arr.get(0);
       
       //Swap 1 and last
       int temp = arr.get(0);
       arr.set(0,arr.get(arr.size()-1));
       arr.set(arr.size()-1,temp);

       //Remove Last
       arr.remove(arr.size()-1);

       //Call Heapify
       heapify(0);

       return data;
    }

    public boolean isEmpty(){
        return arr.size()==0;
    }
    
    public static void heapify(int arr[], int i,int size){
        int left = 2*i + 1;
        int right = 2*i + 2;
        int max = i;

        if(left < size && arr[left] > arr[max]){
            max = left;
        }
        if(right < size && arr[right] > arr[max]){
            max = right;
        }

        if(max != i){
            //Swap
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;

            heapify(arr, max, size);
        }

    }

    public static void heapsort(int arr[]){

        //Build MaxHeap
        int n=arr.length;
        for(int i=n/2;i>=0;i--){
            heapify(arr,i,n);
        }

        //Push largest at the end
        for(int i=n-1;i>=0;i--){
            //swap
            int temp = arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            heapify(arr,0,i);
        }
    }

    static class point implements Comparable <point>{
        int idx , x,y;
        int distSq;

        public point(int x, int y, int distSq, int idx){
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(point p2){
          return this.distSq - p2.distSq;
        }

    }

    public static void NearbyCars(int a[][], int k){
        PriorityQueue<point> pq = new PriorityQueue<>();

        for(int i=0;i<a.length;i++){
            int distSq = a[i][0]*a[i][0] + a[i][1]*a[i][1];
            pq.add(new point(a[i][0], a[i][1], distSq, i ));
        }

        for(int i=0;i<k;i++){
          System.out.println("C " + pq.remove().idx);
        }
    }

    public static void ConnectNropes(){
        int ropes[] = {2,3,3,4,6};
        //create Priority ropes
        PriorityQueue <Integer> pq = new PriorityQueue<>();
        for(int i=0;i<ropes.length;i++){
            pq.add(ropes[i]);
        }

        int cost = 0;
        while(pq.size()>1){
            int min = pq.remove();
            int min2 = pq.remove();
            cost += min + min2;
            pq.add(min+min2);
        }

        System.out.println("Minimum Cost is : "+cost);
    } 

    static class row implements Comparable<row>{
        int count;
        int idx;
        public row(int count, int idx){
            this.count = count;
            this.idx = idx;
        }

        @Override 
        public int compareTo(row r2){
            if(this.count == r2.count){
                return this.idx - r2.idx;
            }
            return this.count - r2.count;
        }
    }

    static class pair implements Comparable<pair>{
        int val,idx;
        public pair(int val, int idx){
            this.val=val;
            this.idx = idx;
        }
        @Override
        public int compareTo(pair p2){
            //descending
            return p2.val-this.val;
        }
    }
  


    public static void main(String[] args) {
        /*
        PriorityQueue<student> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(new student("A", 4));
        pq.add(new student("B", 7));
        pq.add(new student("C",3));
        pq.add(new student("D", 1));

        while(!pq.isEmpty()){
           System.out.println(pq.peek().name +"->"+pq.peek().rank );
           pq.remove();
        }

        */   

        /* 
        Heaps h = new Heaps();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);
             
        while(!h.isEmpty())
        {
            System.out.print(h.peek()+" ");
            h.remove();
        }
        */

        /*
        int arr[] = {1,2,4,5,3};
        heapsort(arr);
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }

        */

       // int a[][] = {{3,3} , {5,-1}, {-2,4}};
       // int k=2;
       // NearbyCars(a, k);

      // ConnectNropes();


      /*
      Weakest soldier

      int a[][] = { {1,0,0,0},
                    {1,1,1,1},
                    {1,0,0,0},
                    {1,0,0,0}
                  };
      int k=2;

      PriorityQueue<row> pq = new PriorityQueue<>();
      for(int i=0;i<a.length;i++){
        int count=0;
        for(int j=0;j<a[0].length;j++){
            count += a[i][j] == 1 ? 1 : 0;
        }
           pq.add(new row(count, i));
      }
      for(int i=0;i<k;i++){
        System.out.println("R-" + pq.remove().idx);      
      }    
      */
      
      /*
       Sliding Window
       */
      int arr[]={1,3,-1,-3,5,3,6,7};
      int k=3;//window size
      int res[] = new int[arr.length-k+1];

      PriorityQueue<pair> pq = new PriorityQueue<>();

      //1st Window
      for(int i=0;i<k;i++){
         pq.add(new pair(arr[i], i)); 
      } 

      res[0]=pq.peek().val;//greatest value of 1 window

      for(int i=k;i<arr.length;i++){
        while(pq.size() > 0 && pq.peek().idx== (i-k)){
            pq.remove();
        }

        pq.add(new pair(arr[i], i));
        res[i-k+1] = pq.peek().val;

        }

          //print result
          for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        
        }


}
}
