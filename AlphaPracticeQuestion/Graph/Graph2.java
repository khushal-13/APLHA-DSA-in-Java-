import java.util.*;
import java.util.LinkedList;
import java.util.Stack;

public class Graph2 {
 static class Edge{
     int src,des,wt;
     public Edge(int s, int d, int w){
        this.src=s;
        this.des=d;
        this.wt=w;
     }
 }

 public static void TopoDFS(ArrayList<Edge> graph[]){
    boolean vis[] = new boolean[graph.length];
    Stack<Integer> s = new Stack<>();

    for(int i=0;i<graph.length;i++){
        if(!vis[i]){
            TopoDFSUtil(graph,i,vis,s);
        }
    }

    while(!s.isEmpty()){
        System.out.print(s.pop()+" ");
    }
 }

public static void TopoDFSUtil(ArrayList<Edge> graph[], int curr,boolean vis[],Stack<Integer> s){

    vis[curr]=true;

    for(int i=0;i<graph[curr].size();i++){
        Edge e = graph[curr].get(i);
        if(!vis[e.des]){
            TopoDFSUtil(graph, e.des, vis, s);
        }
    }
    s.push(curr);
}

 public static boolean CycleDirected(ArrayList<Edge> graph[]){
    boolean vis[] = new boolean[graph.length];
    boolean stack[] = new boolean[graph.length];

    for(int i=0;i<graph.length;i++){
        if(!vis[i]){
            if(CycleDirectedUtil(graph,i,vis,stack)){
                return true;
            }
        }
    }
     return false;
 }

 public static boolean CycleDirectedUtil(ArrayList<Edge> [] graph,int curr,boolean vis[],boolean stack[]){
 vis[curr]=true;
 stack[curr]=true;

 for(int i=0;i<graph[curr].size();i++){
    Edge e = graph[curr].get(i);
   
    if(stack[e.des]){ //case-1
        return true;
    }
    else if(!vis[e.des] && CycleDirectedUtil(graph, e.des, vis, stack)){ //case-2
        return true;
    }
    //case-3 : Isn't present in stack and visited is true SO CONTINUE
 }
 stack[curr]=false;
 return false;

}


 public  static boolean isBipartite(ArrayList<Edge> graph[]) {
    int colour[] = new int[graph.length];
    for(int i=0;i<colour.length;i++){
        colour[i]=-1;
    }

    Queue<Integer> q = new LinkedList<>();

    for(int i=0;i<graph.length;i++){
        if(colour[i]==-1){ //BFS for more than one component
            q.add(i); //source element
            colour[i]=0; //setting source color as yellow
            while(!q.isEmpty()){
                int curr = q.remove();
                for(int j=0;j<graph[curr].size();j++){
                    Edge e = graph[curr].get(j);
                    if(colour[e.des]==-1){ //case-3
                        int nextCol = colour[curr]== 0 ? 1 : 0;
                        colour[e.des]=nextCol;
                        q.add(e.des);
                    }
                    else if(colour[e.des]==colour[curr]){  //case-2
                        return false;  // Not Bipartite
                    }
                    //case-1 : Do nothing
                }
            }
        }
    }
         return true;
 }

 public static boolean detectCycle(ArrayList<Edge> graph[]){
    boolean vis[] = new boolean[graph.length];
    for(int i=0;i<graph.length;i++){
        if(!vis[i]){ //until notVisited
        if(detectCycleUtil(graph,vis,i,-1)){//as first parent is -1
            return true;
        }
    }
 }
    return false;
 }

 public static boolean detectCycleUtil(ArrayList<Edge> graph[],boolean vis[], int  curr, int par){
   vis[curr]=true;

   //for neighbours
   for(int i=0;i<graph[curr].size();i++){
    Edge e = graph[curr].get(i);

    //case-3
    if(!vis[e.des]){
        if(detectCycleUtil(graph, vis, e.des, curr)){
            return true;
        }
    }
    //case-1
    else if(vis[e.des] && e.des != par){
         return true;
    }
    //case-2 : thst is to continue
   }
    return false;
 }


public static void Bfs(ArrayList<Edge> graph[]){
boolean vis[] = new boolean[graph.length];
System.out.println(graph.length);
for(int i=0;i<graph.length;i++){
    if(!vis[i]){
        BfsUtil(graph,vis,i);
    }
}
}

 public static void BfsUtil(ArrayList<Edge> graph[],boolean vis[],int source){
    Queue<Integer> q = new LinkedList<>();
    //boolean vis[] = new boolean[graph.length];
    q.add(source);

    while(!q.isEmpty()){
        int curr = q.remove();

        if(!vis[curr]){
        System.out.print(curr+" ");
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            q.add(e.des);
        }
    }
  }
 }

 public static void Dfs(ArrayList<Edge> Graph[], int curr){
     boolean vis[] = new boolean[Graph.length];
     for(int i=0;i<Graph.length;i++){
         if(!vis[i]){
            DfsUtil(Graph, i, vis);
         }
     }
 }

 public static void DfsUtil(ArrayList<Edge> graph[], int curr, boolean vis[]){
     System.out.print(curr+" ");
     vis[curr]=true;

     for(int i=0;i<graph[curr].size();i++){
        Edge e = graph[curr].get(i);
        if(!vis[e.des]){
            DfsUtil(graph, e.des, vis);
         }
     }
 }

 public static void createGraph(ArrayList<Edge> graph[]){
           
    for(int i=0;i<graph.length;i++){
        //List of List i.e. creating arraylist at every node
        graph[i]= new ArrayList<>(); 
    }

    //0 Vertex
    //graph[0].add(new Edge(0, 1, 1));
    graph[0].add(new Edge(0, 2, 1));

    //1 Vertex
    graph[1].add(new Edge(1, 0,1 ));
    //graph[1].add(new Edge(1, 3, 1));

    //2 Vertex
   // graph[2].add(new Edge(2, 0,1 ));
    graph[2].add(new Edge(2, 3,1 ));

    //3 Vertex
    graph[3].add(new Edge(3, 0,1 ));
   // graph[3].add(new Edge(3, 2,1 ));
    //graph[3].add(new Edge(3, 5,1 ));

    //4 Vertex
    //graph[4].add(new Edge(4, 2,1 ));
   // graph[4].add(new Edge(4, 2,1 ));
    //graph[4].add(new Edge(4, 3,1 ));

    //5 Vertex
    //graph[5].add(new Edge(5, 3,1 ));
    //graph[5].add(new Edge(5, 4,1 ));
    //graph[5].add(new Edge(5, 6,1 ));

    //6 Vertex
    //graph[6].add(new Edge(6, 5,1 ));
        
 }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> graph[] = new ArrayList[V]; 
        createGraph(graph);
       
       // Dfs(graph, 0);  
        //System.out.println();
        //Bfs(graph);

       //System.out.println( detectCycle(graph)); 

       //System.out.println(isBipartite(graph));

       System.out.println(CycleDirected(graph));
    } 
}
