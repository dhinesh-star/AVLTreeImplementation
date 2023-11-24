import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class TopologicalSort {
    public static void printingIndegree(int[] inDegree){
        System.out.println("The inDegree is");
        System.out.println("------------------------------");
        for(int i=0;i<inDegree.length;i++){
            System.out.println("inDegree["+i+"]="+inDegree[i]);
        }
        System.out.println("------------------------------");
    }
    public static ArrayList<Integer> kahnsAlgorithm2(ArrayList<ArrayList<Integer>> graph,int[] inDegree,int vertex){
        ArrayList<Integer> topo=new ArrayList<>();
        Queue<Integer> que=new LinkedList<>();
        for(int i=0;i<=vertex;i++){
            if(inDegree[i]==0){
                que.add(i);
            }
        }
        while(que.size()>0){
            //Remove
            int curr=que.remove();
            //Mark
            //No marking required
            //Work
            topo.add(curr);
            //Visit unvisited nbrs
            for(int nbr:graph.get(curr)){
                inDegree[nbr]--;
                if(inDegree[nbr]==0){
                    que.add(nbr);
                }
            }
        }
        return topo;
    }
    public static void kahnsAlgorithm(ArrayList<ArrayList<Integer>> graph,int[] inDegree,int vertex){
        ArrayList<Integer> topo=kahnsAlgorithm2(graph,inDegree,vertex);
        if(topo.size()<vertex)
            System.out.println("Topological Sort not possible");
        else
            System.out.println("Topological Sort Order:- "+topo);
    }
    public static void displayGraph(ArrayList<ArrayList<Integer>> graph){
        int idx=0;
        System.out.println("Graph Created is");
        System.out.println("------------------------------");
        for(ArrayList<Integer> list:graph){
            System.out.println(idx+++" -> "+list);
        }
        System.out.println("------------------------------");
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of vertex:- ");
        int vertex=sc.nextInt();
        System.out.print("Enter the number of edges:- ");
        int noOfEdges=sc.nextInt();
        int[][] edges=new int[noOfEdges][2];
        System.out.println("Enter the Connection");
        for(int i=0;i<noOfEdges;i++){
            edges[i][0]=sc.nextInt();
            edges[i][1]=sc.nextInt();
        }
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=vertex;i++){
            graph.add(new ArrayList<>());
        }
        int[] inDegree =new int[vertex+1];
        for(int[] edge:edges){
            int ai=edge[0];
            int bi=edge[1];
            //Create directed graph
            graph.get(ai).add(bi);
            inDegree[bi]++;
        }
        displayGraph(graph);
        printingIndegree(inDegree);
        kahnsAlgorithm(graph,inDegree,vertex);
    }
}
