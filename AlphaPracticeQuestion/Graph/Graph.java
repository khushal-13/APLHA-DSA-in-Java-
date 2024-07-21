import java.util.*;
import java.util.LinkedList;

public class Graph {
    static class Edge{
        int src,dest,wt;
        public Edge(int s, int d, int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean vis[]){

        if(src == dest){
            return true;
        }
        vis[src]=true;

        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            if(!vis[e.dest] && hasPath(graph, e.dest, dest, vis)){
                return true;
            }
        }
      return false;
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr,boolean vis[]){

        System.out.print(curr+" ");
        vis[curr]=true;        

        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph,e.dest,vis);
            }
        }
    }

    public static void bfs(ArrayList<Edge>[] graph){ //O(V+E)
 
       Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[graph.length];
        q.add(0); //adding source of bfs

        while(!q.isEmpty()){
          int curr = q.remove();

          if(!vis[curr]){
            System.out.print(curr+" ");
            vis[curr]=true;
            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                q.add(e.dest);
            }
          }
        }

    }
    
    public static void CreatingGraph(ArrayList<Edge> graph[]){
        //int V=5;
        //ArrayList<Edge>[] graph = new ArrayList[V]; // Initially all is null

        for(int i=0;i<graph.length;i++){
            //List of List i.e. creating arraylist at every node
            graph[i]= new ArrayList<>(); 
        }

        //0 Vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        //1 Vertex
        graph[1].add(new Edge(1, 0,1 ));
        graph[1].add(new Edge(1, 3, 1));

        //2 Vertex
        graph[2].add(new Edge(2, 0,1 ));
        graph[2].add(new Edge(2, 4,1 ));

        //3 Vertex
        graph[3].add(new Edge(3, 1,1 ));
        graph[3].add(new Edge(3, 4,1 ));
        graph[3].add(new Edge(3, 5,1 ));

        //4 Vertex
        graph[4].add(new Edge(4, 2,1 ));
        graph[4].add(new Edge(4, 3,1 ));
        graph[4].add(new Edge(4, 5,1 ));

        //5 Vertex
        graph[5].add(new Edge(5, 3,1 ));
        graph[5].add(new Edge(5, 4,1 ));
        graph[5].add(new Edge(5, 6,1 ));

        //6 Vertex
        graph[6].add(new Edge(6, 5,1 ));

        }
     
       @SuppressWarnings("unchecked")
       public static void main(String[] args) {
        
        int V=7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        CreatingGraph(graph);
       // bfs(graph);
       
       boolean vis[] = new boolean[V];
      // dfs(graph, 0, vis);

      System.out.println(hasPath(graph, 0, 7 ,vis));
    }
}
