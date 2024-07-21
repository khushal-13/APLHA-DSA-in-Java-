import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph5 {

public static void helper(int images[][], int sr, int sc, int col,boolean vis[][],int orgCol){
   //base condition
   if(sr < 0 || sc < 0 || sr >= images.length || sc >= images[0].length
     || vis[sr][sc] || images[sr][sc] != orgCol ){
        return;
     }
     images[sr][sc] = col;
     //left
     helper(images, sr, sc-1, col, vis, orgCol);
     //right
     helper(images, sr, sc+1, col, vis, orgCol);
     //up
     helper(images, sr+1, sc, col, vis, orgCol);
     //Down
     helper(images, sr-1, sc, col, vis, orgCol);

}



    public  static void floodFill(int images[][], int sr,int sc,int col) {
        boolean vis[][] = new boolean[images.length][images[0].length];
        helper(images,sr,sc,col,vis,images[sr][sc]);
    }

    static int n=4;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init(){
        //Initaialize of parent
        for(int i=0;i<par.length;i++){
            par[i] = i;
        }
    }

    public static int find(int x){
        if(par[x] == x){
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b){
         int parA = find(a);
         int parB = find(b);

         if( rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
         }
         else if(rank[parA] < rank[parB]){
             par[parA] = parB;
         }
         else{
            par[parB] = parA;
         }
    }
    
    static class ed implements Comparable<ed>{
        int dst, cost;
        public ed(int d, int c){
            this.dst=d;
            this.cost=c;
        }
        @Override 
        public int compareTo(ed e2) {
            return this.cost-e2.cost;
        }
    }

    public static int ConnectingCities(int cities[][]){

        PriorityQueue<ed> pq = new PriorityQueue<>();
        boolean vis[] = new boolean[cities.length];

        pq.add(new ed(0, 0));
        int finalcost=0;

        while(!pq.isEmpty()){
            ed curr = pq.remove();
            if(!vis[curr.dst]){
                vis[curr.dst]=true;
                finalcost += curr.cost;

                for(int i=0;i<cities[curr.dst].length;i++){
                    if(cities[curr.dst][i] != 0){
                        pq.add(new ed(i, cities[curr.dst][i]));
                    }
                }
            }
        }
        return finalcost;
    }


    static class Edge implements Comparable<Edge> {
        int src,dest,wt;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
        //Used in Kruskals algorithm
        @Override
        public int compareTo(Edge e2){
            return this.wt - e2.wt;
        }
    }

    //For kruskals algo
    public static void creation(ArrayList<Edge> edges){
        edges.add(new Edge(0,1,10));
        edges.add(new Edge(0,2,15));
        edges.add(new Edge(0,3,30));
        edges.add(new Edge(1,3,40));
        edges.add(new Edge(2,3,50));
    }

    public static void kruskals(ArrayList<Edge> edges , int v){
        init();
        Collections.sort(edges);
        int mstCost=0;
        int count=0;

        for(int i=0;count<v-1;i++){
            Edge e = edges.get(i);

            int parA = find(e.src);
            int parB = find(e.dest);

            if(parA!=parB){
                union(e.src, e.dest);
                mstCost += e.wt;
                count++;
            }
        }
        System.err.println(mstCost);
    }

    public static void createGraph(int flights[][], ArrayList<Edge> graph[]){
  
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<flights.length;i++){
             int src = flights[i][0];
             int dest = flights[i][1];
             int wt = flights[i][2];

             Edge e = new Edge(src, dest, wt);
             graph[src].add(e);
        }

    }  

    static class Info{
        int V,cost,stops;
        public Info(int v, int c, int s){
           this.V = v;
           this.cost = c;
           this.stops = s;
        }
    }

    public static int cheapestFlight(int n, int src, int dest, int k,ArrayList<Edge> graph[]){

        int dist[] = new int[n];
        for(int i=0;i<dist.length;i++){
            if(i!=src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src,0,0));
        
        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stops > k){
                break;
            }

            for(int i=0;i<graph[curr.V].size();i++){
                Edge e = graph[curr.V].get(i);
                //int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(curr.stops<=k && curr.cost + wt <  dist[v])
                 dist[v] = curr.cost + wt;
                 q.add(new Info(v,dist[v], curr.stops+1));
            }
        }

        if(dist[dest] == Integer.MAX_VALUE){
            return -1;
        }
        return dist[dest];
        
    }



    //@SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //int n = 4;
        //ArrayList<Edge> graph[] = new ArrayList[n];
        //int flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
       // createGraph(flights, graph);

        //System.out.println(cheapestFlight(n,0,3,1, graph));

       /*  int cities[][] = {{0,1,2,3,4},
                           {1,0,5,0,7},
                           {2,5,0,6,0},
                           {3,0,6,0,0},
                           {4,7,0,0,0} };
                 */
                // System.out.println(ConnectingCities(cities));  
                
               /*  init();
                System.out.println(find(3));
                union(1, 3);
                System.out.println(find(3));
                union(2, 4);
                union(3, 6);
                union(1, 4);
                System.out.println(find(3));
                System.out.println(find(4));
                union(1, 5);

                */

               /* 
                //For kruskal
                int v=4;
                ArrayList<Edge> edges = new ArrayList<>();
                creation(edges);
                kruskals(edges, v);
                */

                int images[][] = {{1,1,1},
                                  {1,1,0},
                                  {1,0,1}};
                floodFill(images, 1, 1, 2);     
                
                for(int i=0;i<images.length;i++){
                    for(int j=0;j<images[0].length;j++){
                        System.out.print(images[i][j]+" ");
                    }
                    System.out.println();
                }
    }
}
