import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.ArrayList;
class Pair{
    int nbr;
    int wt;
    Pair(){}
    Pair(int nbr,int wt){
        this.nbr=nbr;
        this.wt=wt;
    }
}
class Edge{
    int src;
    int dest;
    int wt;
    Edge(int src,int dest,int wt){
        this.src=src;
        this.dest=dest;
        this.wt=wt;
    }
}
public class Weighted_Graph {
    public static void display(ArrayList<ArrayList<Pair>> graph,int vertex){
        System.out.println("Graph Display");
        System.out.println("----------------------------------");
        int idx=0;
        for(ArrayList<Pair> pair:graph){
            for(Pair p:pair){
                System.out.print(idx+":- ("+p.nbr+","+p.wt+")"+"\t");
            }
            System.out.println();
            idx++;
        }
        System.out.println("----------------------------------");
    }
    public static void pathFinder2(ArrayList<ArrayList<Pair>> graph,boolean[] path,String psf,int wsf,int src,int dest){
        if(src==dest){
            System.out.println(psf+"@"+wsf);
        }
        if(path[src]){
            return ;
        }
        path[src]=true;
        for(Pair pair:graph.get(src)){
            int nbr=pair.nbr;
            int wt=pair.wt;
            if(!path[nbr]){
                pathFinder2(graph,path,psf+Integer.toString(nbr),wsf+wt,nbr,dest);
            }
        }
        //Unmark
        path[src]=false;
    }
    public static void pathFinder(ArrayList<ArrayList<Pair>> graph,int vertex,int src,int dest){
        System.out.println("Path of all path from "+src+" to "+dest);
        System.out.println("----------------------------------");
        boolean[] path=new boolean[vertex];
        pathFinder2(graph,path,Integer.toString(src),0,src,dest);
        System.out.println("----------------------------------");
    }
    static class Dijkstra{
        int node;
        String psf;
        int wsf;
        Dijkstra(int node,String psf,int wsf){
            this.node=node;
            this.psf=psf;
            this.wsf=wsf;
        }
    }
    public static void dijkstra(ArrayList<ArrayList<Pair>> graph,int src,int vertex){
        System.out.println("Dijkstra shortest path to all nodes from source "+src);
        System.out.println("----------------------------------");
        PriorityQueue<Dijkstra> pq=new PriorityQueue<>((a,b)->{
            return a.wsf-b.wsf;
        });
        boolean[] visited=new boolean[vertex];
        pq.add(new Dijkstra(src,""+src,0));
        while(pq.size()>0){
            //Remove
            Dijkstra dijkstra1=pq.remove();
            //Mark
            if(visited[dijkstra1.node]==true){
                continue;
            }
            visited[dijkstra1.node]=true;
            //Work
            System.out.println(dijkstra1.node+"->"+dijkstra1.psf+"@"+dijkstra1.wsf);
            //Visit unvisited nbrs
            for(Pair pair:graph.get(dijkstra1.node)){
                int nbr=pair.nbr;
                int wt=pair.wt;
                if(!visited[nbr]){
                    pq.add(new Dijkstra(nbr,dijkstra1.psf+nbr,dijkstra1.wsf+wt));
                }
            }
        }
        System.out.println("----------------------------------");
    }
    public static void main(String[] graph){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the no.of vertex:- ");
        int vertex=sc.nextInt();
        System.out.print("Enter the no.of edges:- ");
        int no_of_edges=sc.nextInt();
        ArrayList<ArrayList<Pair>> weightedGraph=new ArrayList<>();
        System.out.println("Enter the Edges connection along with weight");
        ArrayList<Edge> edgesOfWeightedGraph=new ArrayList<>();
        for(int i=0;i<no_of_edges;i++){
            int src=sc.nextInt();
            int dest=sc.nextInt();
            int wt=sc.nextInt();
            edgesOfWeightedGraph.add(new Edge(src,dest,wt));
        }
        //Creating Weighted Graph
        for(int i=0;i<no_of_edges;i++){
            weightedGraph.add(new ArrayList<>());
        }
        for(Edge edge:edgesOfWeightedGraph){
            int src=edge.src;
            int dest=edge.dest;
            int wt=edge.wt;
            //Creating undirected graph
            weightedGraph.get(src).add(new Pair(dest,wt));
            weightedGraph.get(dest).add(new Pair(src,wt));
        }
        display(weightedGraph,vertex);
        pathFinder(weightedGraph,vertex,0,6);
        dijkstra(weightedGraph,0,vertex);
    }
}
