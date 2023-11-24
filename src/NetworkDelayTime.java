import java.util.ArrayList;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.LinkedList;

public class NetworkDelayTime {
    static class Pair{
        int nbr;
        int wt;
        Pair(int nbr,int wt){
            this.nbr=nbr;
            this.wt=wt;
        }
    }
    static class Edge{
        int node;
        int wsf;
        Edge(int node,int wsf){
            this.node=node;
            this.wsf=wsf;
        }
    }
    public static int minTimeToTravelNetwork(ArrayList<ArrayList<Pair>> weightGraph, int src, int vertex){
        boolean[] visited=new boolean[vertex];
        int[] minTime=new int[vertex];
        ArrayList<Integer> minTym=new ArrayList<>();
        for(int i=0;i<vertex;i++){
            minTym.add(0);
        }
        PriorityQueue<Edge> pq=new PriorityQueue<>((a,b)->{
            return a.wsf-b.wsf;
        });
        pq.add(new Edge(src,0));
        while(pq.size()>0){
            //Remove
            Edge curr=pq.remove();
            //Mark
            if(visited[curr.node]==true){
                continue;
            }
            visited[curr.node]=true;
            //Work
            minTime[curr.node]=curr.wsf;
            minTym.set(curr.node,curr.wsf);
            System.out.println("minTime["+curr.node+"]="+minTime[curr.node]);
            System.out.println(minTym.get(curr.node));
            //Visit unvisited node
            for(Pair pair:weightGraph.get(curr.node)){
                int nbr=pair.nbr;
                int wt=pair.wt;
                if(visited[nbr]==false){
                    pq.add(new Edge(nbr,curr.wsf+wt));
                }
            }
        }
        System.out.println("Minimum Time to all nodes are:- "+minTym);
        int minimumTime=0;
        for(int time:minTym){
            minimumTime=Math.max(minimumTime,time);
        }
        return minimumTime;
    }
    public static void displayGraph(ArrayList<ArrayList<Pair>> weightedGraph){
        int idx=0;
        for(ArrayList<Pair> list:weightedGraph){
            System.out.print(idx+++"->");
            for(Pair graphPair:list){
                System.out.print("("+graphPair.nbr+","+graphPair.wt+")\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of vertex:- ");
        int vertex=sc.nextInt();
        System.out.print("Enter the number of edges:- ");
        int noOfEdges=sc.nextInt();
        int[][] edges=new int[noOfEdges][3];
        System.out.println("Enter the edge connection");
        for(int i=0;i<noOfEdges;i++){
            edges[i][0]=sc.nextInt();
            edges[i][1]=sc.nextInt();
            edges[i][2]=sc.nextInt();
        }
        System.out.println("edges");
        for(int i=0;i<edges.length;i++){
            System.out.println(edges[i][0]+" "+edges[i][1]+" "+edges[i][2]);
        }
        ArrayList<ArrayList<Pair>> weightGraph=new ArrayList<>();
        for(int i=0;i<vertex;i++){
            weightGraph.add(new ArrayList<Pair>());
        }
        for(int[] edge:edges){
            int src=edge[0];
            int dest=edge[1];
            int wt=edge[2];
            //Creating directed graph
            weightGraph.get(src).add(new Pair(dest,wt));
        }
        displayGraph(weightGraph);
        int minTime=minTimeToTravelNetwork(weightGraph,10,11);
        System.out.println("Minimum time for signal to reach to all node:- "+minTime);
        System.out.println("Completed Successfully");
    }
}
