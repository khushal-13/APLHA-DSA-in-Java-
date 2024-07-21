import java.util.*;

//import Graph3.pair;

public class Graph4 {
    
    static class Edge{
        int src,des,wt;
        public Edge(int s, int d,int w){
           this.src = s;
           this.des = d;
           this.wt = w;
        }
    }

    static class Pair implements Comparable<Pair>{
        int v,cost;
        public Pair(int v,int c){
            this.v = v;
            this.cost = c;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        } 
    }

    public static void MST(ArrayList<Edge> graph[]){

        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));

        int finalcost = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.v]) {
                vis[curr.v]=true;
                finalcost += curr.cost;

                for(int i=0;i<graph[curr.v].size();i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.des, e.wt));
                }
            }
        }
        System.out.println("Final cost is : "+finalcost);
    }

    public static void BellmanFord(ArrayList<Edge> graph,int src,int V)
    {
    int dis[] = new int[V];
    for(int i=0;i<dis.length;i++){
        if(i!=src){
           dis[i] = Integer.MAX_VALUE;
        }
    }

    // TC O(V+E)
    for(int i=0;i<V-1;i++){
        //Edges : TC O(E)
        for(int j=0;j<graph.size();j++){
            Edge e = graph.get(j);
            int u = e.src;
            int v = e.des;
            int wt = e.wt;
            //Relaxation
            if(dis[u] != Integer.MAX_VALUE && dis[v] > dis[u] + wt){
                dis[v] = dis[u] + wt;
            }
        }
    }

    for(int i=0;i<dis.length;i++){
        System.out.print(dis[i]+" ");
    }

}
    public static void createGraph(ArrayList<Edge> graph[]){
      
        
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0,10 ));
        graph[1].add(new Edge(1, 3,40 ));

        graph[2].add(new Edge(2, 0,15 ));
        graph[2].add(new Edge(2, 3,50 ));

        graph[3].add(new Edge(3, 1,40 ));
        graph[3].add(new Edge(3, 2,50 ));

       // graph[4].add(new Edge(4, 1,-1 ));
       // graph[4].add(new Edge(4, 5,5 ));

       // graph[5].add(new Edge(5, 0,1 ));
        //graph[5].add(new Edge(5, 2,1 ));
        

        /* 
        //FOR Bellman Ford
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 4, 4));
        graph.add(new Edge(4, 1, -1));
        */

    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        int V=4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        //BellmanFord
        //BellmanFord(graph, 0,V);

        MST(graph);

        
    }
}
