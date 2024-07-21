import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Graph3 {

    static class pair implements Comparable<pair>{
       int n,path;
       public pair(int n, int p){
        this.n=n;
        this.path=p;
       }

       @Override
       public int compareTo(pair p2){
        return this.path - p2.path;
       }
    }
    
    static class Edge{
        int src,des,wt;
        public Edge(int s, int d, int w){
            this.src=s;
            this.des=d;
            this.wt=w;
        }
    }

    public static void Dijkstra (ArrayList<Edge> graph[], int src){

        int dis[] = new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(i!=src){
                dis[i]= Integer.MAX_VALUE;
            }
        }

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(src, 0));
        
        while(!pq.isEmpty()){
           // pair curr=pq.peek();
            //System.out.println(curr.path);
          pair  curr = pq.remove();
            if(!vis[curr.n]){
                vis[curr.n]=true;

                for(int i=0;i<graph[curr.n].size();i++){
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.des;
                    int wt = e.wt;

                    if(dis[v] > dis[u]+wt){
                        dis[v] = dis[u] + wt;
                        pq.add(new pair(v, dis[v]));
                    }
                }
            }
        }

        for(int i=0;i<dis.length;i++){
            System.out.print(dis[i]+" ");
        }

    }

    public static void SrcToTarget(ArrayList<Edge> graph[],int src, int des,String path){

        if(src==des){
            System.out.print(path+des+" ");
            System.out.println();
            return;
        }

        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            SrcToTarget(graph, e.des, des, path+src);
        }
    }

    public static void calIndeg(ArrayList<Edge> graph[],int indeg[]){
        int v;
      for(int i=0;i<graph.length;i++){
         v=i;
         for(int j=0;j<graph[v].size();j++){
            Edge e = graph[v].get(j);
            indeg[e.des]++;
         }
      }
    }

    public static void TopoBFS(ArrayList<Edge> graph[]){
        int indeg[] = new int[graph.length];
        calIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+" ");

            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                indeg[e.des]--;
                if(indeg[e.des]==0){
                   q.add(e.des);  
                }
            }
        }
        System.out.println();
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3,7 ));
        graph[1].add(new Edge(1, 2,1 ));

        graph[2].add(new Edge(2, 4,3 ));

        graph[3].add(new Edge(3, 5,1 ));

        graph[4].add(new Edge(4, 3,2 ));
        graph[4].add(new Edge(4, 5,5 ));

       // graph[5].add(new Edge(5, 0,1 ));
        //graph[5].add(new Edge(5, 2,1 ));

    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V=6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        //TopoBFS(graph);

       // SrcToTarget(graph, 5, 1, "");

       Dijkstra(graph, 0);
    }
}
