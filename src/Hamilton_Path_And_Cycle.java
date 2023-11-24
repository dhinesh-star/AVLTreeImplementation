import java.util.ArrayList;
import java.util.Scanner;

public class Hamilton_Path_And_Cycle {
    public static void hamiltonPathAndCycleDetection(ArrayList<ArrayList<Integer>> graph, boolean[] path, int src, ArrayList<Integer> psf){
        int n=graph.size();
        //Mark
        if(path[src]){
            return ;
        }
        path[src]=true;
        //Work
        psf.add(src);
        if(psf.size()==n){
            System.out.print(psf);
            int dest=psf.get(psf.size()-1);
            for(int nbr:graph.get(dest)){
                if(nbr==psf.get(0)){
                    System.out.print("Cycle");
                }
            }
            System.out.println();
        }
        //Visit Unvisited nbr
        for(int nbr:graph.get(src)){
            if(!path[nbr]){
                hamiltonPathAndCycleDetection(graph,path,nbr,psf);
            }
        }
        //Unmarked
        path[src]=false;
        psf.remove(psf.size()-1);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of vertex:- ");
        int vertex=sc.nextInt();
        System.out.print("Enter the number of edges:- ");
        int noOfEdges=sc.nextInt();
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        System.out.println("Enter the Egde connection");
        int[][] edges=new int[noOfEdges][2];
        for(int i=0;i<noOfEdges;i++){
            edges[i][0]=sc.nextInt();
            edges[i][1]=sc.nextInt();
        }
        for(int i=0;i<vertex;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            //creating undirected graph
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for(int i=0;i<vertex;i++){
            boolean[] path=new boolean[vertex];
            ArrayList<Integer> psf=new ArrayList<>();
            hamiltonPathAndCycleDetection(graph,path,i,psf);
        }
    }
}
